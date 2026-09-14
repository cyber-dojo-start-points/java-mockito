import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;

class FizzBuzzTest {

    @Test
    void three_is_fizz() {
        FizzBuzz.Listener listener = mock(FizzBuzz.Listener.class);
        new FizzBuzz(listener).say(3);
        verify(listener).onSay("Fizz");
        verifyNoMoreInteractions(listener);
    }
}
