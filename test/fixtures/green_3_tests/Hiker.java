public class Hiker {

    public interface Listener {
        void onAnswer(int answer);
        void onName(String name);
    }

    public Hiker(Listener listener) {
        this.listener = listener;
    }

    public void answer() {
        listener.onAnswer(6 * 7);
    }

    public void introduce() {
        listener.onName("Arthur Dent");
    }

    private Listener listener;
}
