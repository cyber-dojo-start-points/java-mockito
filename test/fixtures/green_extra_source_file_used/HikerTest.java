import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;

class HikerTest {

    @Test
    void life_the_universe_and_everything() {
        Hiker.Listener listener = mock(Hiker.Listener.class);
        new Hiker(listener).answer();
        verify(listener).onAnswer(42);
    }

    @Test
    void the_answer_is_two_digits_long() {
        Hiker.Listener listener = mock(Hiker.Listener.class);
        new Hiker(listener).answer();
        verify(listener).onDigits(2);
    }
}
