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
    void the_answer_is_a_multiple_of_seven() {
        Hiker.Listener listener = mock(Hiker.Listener.class);
        new Hiker(listener).answer();
        verify(listener).onAnswer(7 * 6);
    }

    @Test
    void the_hiker_is_called_arthur() {
        Hiker.Listener listener = mock(Hiker.Listener.class);
        new Hiker(listener).introduce();
        verify(listener).onName("Arthur Dent");
    }
}
