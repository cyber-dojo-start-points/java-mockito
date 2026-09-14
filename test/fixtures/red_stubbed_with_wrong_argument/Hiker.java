public class Hiker {

    public interface Listener {
        int onAnswer(int answer);
    }

    public Hiker(Listener listener) {
        this.listener = listener;
    }

    public int answer() {
        return listener.onAnswer(6 * 7);
    }

    private Listener listener;
}
