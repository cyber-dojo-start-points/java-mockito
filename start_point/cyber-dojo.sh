#! /bin/bash
set -e

cd ${CYBER_DOJO_SANDBOX}

CLASSES=.:`ls /mockito/*.jar | tr '\n' ':'`

if javac --enable-preview --release 21 -Xlint:preview -Xlint:unchecked -Xlint:deprecation -cp $CLASSES *.java; then
  java --enable-preview -jar /mockito/junit-platform-console-standalone-1.10.1.jar \
      --disable-banner \
      --disable-ansi-colors \
      --details=tree \
      --details-theme=ascii \
      --class-path .:$CLASSES \
      --scan-class-path
fi
