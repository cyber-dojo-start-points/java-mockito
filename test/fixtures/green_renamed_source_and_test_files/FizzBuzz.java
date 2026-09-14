public class FizzBuzz {

    public interface Listener {
        void onSay(String word);
    }

    public FizzBuzz(Listener listener) {
        this.listener = listener;
    }

    public void say(int n) {
        listener.onSay("Fizz");
    }

    private Listener listener;
}
