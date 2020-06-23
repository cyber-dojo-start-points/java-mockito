import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HikerTest {

    @Test
    void life_the_universe_and_everything() {
        Hiker.Listener listener = mock(Hiker.Listener.class);
        Hiker douglas = new Hiker(listener);
        douglas.answer();
        verify(listener).onAnswer(42);
        verifyNoMoreInteractions(listener);
    }
}
