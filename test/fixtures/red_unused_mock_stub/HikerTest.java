import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// MockitoExtension checks each mock after the test and reports a stub the code
// under test never reached. The Hiker below answers without consulting its
// listener, so the stubbing on the next line is dead code.
@ExtendWith(MockitoExtension.class)
class HikerTest {

    @Test
    void life_the_universe_and_everything() {
        Hiker.Listener listener = mock(Hiker.Listener.class);
        when(listener.onAnswer(42)).thenReturn(42);
        assertEquals(42, new Hiker(listener).answer());
    }
}
