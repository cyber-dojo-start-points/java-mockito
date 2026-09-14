import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// The stubbing below expects 99 and the Hiker sends 42, so strict stubbing
// stops the test at the call rather than letting it read back a default.
@ExtendWith(MockitoExtension.class)
class HikerTest {

    @Test
    void life_the_universe_and_everything() {
        Hiker.Listener listener = mock(Hiker.Listener.class);
        when(listener.onAnswer(99)).thenReturn(42);
        assertEquals(42, new Hiker(listener).answer());
    }
}
