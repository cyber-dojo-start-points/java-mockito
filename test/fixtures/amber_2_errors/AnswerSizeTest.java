import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;

class AnswerSizeTest {

    static int columns;
    static int digitsPerColumn;

    @BeforeAll
    static void lay_out_the_answer() {
        digitsPerColumn = String.valueOf(42).length() / columns;
    }

    @Test
    void the_answer_is_two_digits_long() {
        Hiker.Listener listener = mock(Hiker.Listener.class);
        new Hiker(listener).answer();
        verify(listener).onAnswer(digitsPerColumn);
    }
}
