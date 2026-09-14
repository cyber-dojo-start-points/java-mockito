import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;

class HikerTest {

    void life_the_universe_and_everything() {
        Hiker.Listener listener = mock(Hiker.Listener.class);
        Hiker douglas = new Hiker(listener);
        douglas.answer();
        verify(listener).onAnswer(42);
    }
}
