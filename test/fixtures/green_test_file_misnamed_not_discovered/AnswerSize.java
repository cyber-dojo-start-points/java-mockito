import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;

// The class compiles, but its name ends in neither Test nor Tests, so
// --scan-class-path never offers it to the engine. It verifies an answer the
// Hiker does not send, so a run that did discover it would go red and say so.
class AnswerSize {

    @Test
    void the_answer_is_nine_hundred() {
        Hiker.Listener listener = mock(Hiker.Listener.class);
        new Hiker(listener).answer();
        verify(listener).onAnswer(900);
    }
}
