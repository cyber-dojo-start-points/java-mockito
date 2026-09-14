import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;

// javac is given *.java, which names only the files beside it, so nothing in
// this directory is ever compiled and the test below never runs. It verifies an
// answer the Hiker does not send, so a run that did compile it would go red and
// say so.
class AnswerSizeTest {

    @Test
    void the_answer_is_nine_hundred() {
        Hiker.Listener listener = mock(Hiker.Listener.class);
        new Hiker(listener).answer();
        verify(listener).onAnswer(900);
    }
}
