import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;

class AnswerSizeTest {

    @Test
    void the_answer_is_two_digits_long() {
        Hiker.Listener listener = mock(Hiker.Listener.class);
        new Hiker(listener).answer();
        verify(listener).onAnswer(42)
    }
}
