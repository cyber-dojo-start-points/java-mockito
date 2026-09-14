public class Hiker {

    public interface Listener {
        void onAnswer(int answer);
        void onDigits(int digits);
    }

    public Hiker(Listener listener) {
        this.listener = listener;
    }

    public void answer() {
        listener.onAnswer(6 * 7);
        listener.onDigits(Digits.count(6 * 7));
    }

    private Listener listener;
}
