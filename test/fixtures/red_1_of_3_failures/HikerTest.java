import org.junit.jupiter.api.*;
import org.mockito.ArgumentCaptor;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HikerTest {

    @Test
    void life_the_universe_and_everything() {
        Hiker.Listener listener = mock(Hiker.Listener.class);
        new Hiker(listener).answer();
        verify(listener).onAnswer(42);
    }

    @Test
    void the_answer_is_even() {
        Hiker.Listener listener = mock(Hiker.Listener.class);
        new Hiker(listener).answer();
        ArgumentCaptor<Integer> answer = ArgumentCaptor.forClass(Integer.class);
        verify(listener).onAnswer(answer.capture());
        assertEquals(0, answer.getValue() % 2);
    }

    @Test
    void the_hiker_is_called_arthur() {
        Hiker.Listener listener = mock(Hiker.Listener.class);
        new Hiker(listener).introduce();
        verify(listener).onName("Arthur Dent");
    }
}
