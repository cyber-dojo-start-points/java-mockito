public class Hiker {

    public interface Listener {
        void onAnswer(int answer);
    }

    public Hiker(Listener listener) {
        this.listener = listener;
    }

    public void answer() {
        listener.onAnswer(sixTimesSevn());
    }

    private static int sixTimesSeven() {
        return 6 * 7;
    }

    private Listener listener;
}
