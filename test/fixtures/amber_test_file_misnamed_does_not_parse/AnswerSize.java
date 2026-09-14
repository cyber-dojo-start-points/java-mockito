import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;

// The name ends in neither Test nor Tests, so nothing would discover this
// class, but javac is handed every .java file beside it and stops on the
// missing semicolon before discovery is ever reached.
class AnswerSize {

    @Test
    void the_answer_is_two_digits_long() {
        Hiker.Listener listener = mock(Hiker.Listener.class);
        new Hiker(listener).answer();
        verify(listener).onAnswer(42)
    }
}
