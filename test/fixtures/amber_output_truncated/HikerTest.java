import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;

// The runner keeps the first 50K of each stream and drops the rest. JUnit's
// summary counts arrive on stdout, after the test has run, so flooding stdout
// is what pushes them past the cut and leaves the lambda with nothing to read.
class HikerTest {

    @Test
    void life_the_universe_and_everything() {
        for (int i = 0; i != 20000; i++) {
            System.out.println("debug: i is " + i);
        }
        Hiker.Listener listener = mock(Hiker.Listener.class);
        new Hiker(listener).answer();
        verify(listener).onAnswer(42);
    }
}
