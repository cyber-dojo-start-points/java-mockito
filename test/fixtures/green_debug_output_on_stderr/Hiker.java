public class Hiker {

    public interface Listener {
        void onAnswer(int answer);
    }

    public Hiker(Listener listener) {
        this.listener = listener;
    }

    public void answer() {
        System.err.println("answer was called");
        listener.onAnswer(6 * 7);
    }

    private Listener listener;
}
