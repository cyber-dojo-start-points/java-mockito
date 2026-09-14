import org.junit.jupiter.api.*;
import org.mockito.ArgumentCaptor;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AnswerSizeTest {

    @Test
    void the_answer_is_two_digits_long() {
        Hiker.Listener listener = mock(Hiker.Listener.class);
        new Hiker(listener).answer();
        ArgumentCaptor<Integer> answer = ArgumentCaptor.forClass(Integer.class);
        verify(listener).onAnswer(answer.capture());
        assertEquals(2, String.valueOf(answer.getValue()).length());
    }
}
