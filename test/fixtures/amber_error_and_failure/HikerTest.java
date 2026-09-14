import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;

class HikerTest {

    static int hikers;
    static int answerPerHiker;

    @BeforeAll
    static void share_out_the_answer() {
        answerPerHiker = 42 / hikers;
    }

    @Test
    void life_the_universe_and_everything() {
        Hiker.Listener listener = mock(Hiker.Listener.class);
        new Hiker(listener).answer();
        verify(listener).onAnswer(answerPerHiker);
    }
}
