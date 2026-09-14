public class Hiker {

    public interface Listener {
        void onAnswer(int answer);
    }

    public Hiker(Listener listener) {
        this.listener = listener;
    }

    public void answer() {
    }

    private Listener listener;
}
