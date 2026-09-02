#! /bin/bash
set -e

cd ${CYBER_DOJO_SANDBOX}

CLASSES=.:`ls /mockito/*.jar | tr '\n' ':'`

# Named by pattern rather than by version, because the jars are resolved when
# the image is built and a version written in here would go stale the first time
# one of them was published anew.
AGENT_JAR=`ls /mockito/byte-buddy-agent-*.jar`
CONSOLE_JAR=`ls /mockito/junit-platform-console-standalone-*.jar`

# Each [test] press starts two JVMs, one to compile and one to run the tests,
# and starting them is most of the wait rather than a part of it. The image holds
# an AOT cache for each, recorded when it was built, holding the classes that JVM
# loads in the form the JVM wants them; reading one back costs a fraction of
# loading them again. There is one cache per JVM because a cache is validated
# against the classpath of the JVM reading it, and these two have nothing in
# common. Nothing is lost when a cache is missing or unusable: the JVM says so
# and loads the classes itself, and the run is only slower.
#
# Your own classes are in neither cache, so editing them cannot invalidate one:
# they reach JUnit through --class-path below and its own classloader, never
# through the classpath the cache is validated against.
#
# javac's options are spelled -J here because that is how javac passes an option
# to the JVM running it rather than to the compiler.
#
# The collector is named rather than left to the JVM to choose. Replaying an AOT
# cache under the collector it picks by default crashes it outright, often enough
# to see in a handful of runs, and a JVM that lives for a fraction of a second
# has nothing to gain from a concurrent collector in any case.
JAVAC_JVM_OPTS=()
JAVAC_JVM_OPTS+=(-J-XX:TieredStopAtLevel=1)      # a run is milliseconds; later tiers never repay
JAVAC_JVM_OPTS+=(-J-XX:+UseSerialGC)             # see above
JAVAC_JVM_OPTS+=(-J-XX:AOTCache=/aot/javac.aot)  # the compiler's own classes

TEST_JVM_OPTS=()
TEST_JVM_OPTS+=(-XX:TieredStopAtLevel=1)              # as above, for the JVM running the tests
TEST_JVM_OPTS+=(-XX:+UseSerialGC)                     # as above
TEST_JVM_OPTS+=(-XX:AOTCache=/aot/junit-console.aot)  # Mockito's classes and JUnit's

if javac "${JAVAC_JVM_OPTS[@]}" -Xlint:preview -Xlint:unchecked -Xlint:deprecation -cp $CLASSES *.java; then
  java \
      "${TEST_JVM_OPTS[@]}" \
      -javaagent:${AGENT_JAR} \
      -jar ${CONSOLE_JAR} \
      execute \
      --disable-banner \
      --disable-ansi-colors \
      --details=tree \
      --details-theme=ascii \
      --class-path .:$CLASSES \
      --scan-class-path
fi
