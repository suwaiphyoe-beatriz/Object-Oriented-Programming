package Task1;

public class Television {
    private int channel;
    private final int maxChannel = 10;

    public Television() {
        channel = 1; // start on ch1
    }

    public void watch() {
        System.out.println("Watching channel " + channel);
    }

    public void nextChannel() {
        channel++;
        if (channel > maxChannel) {
            channel = 1; // wrap back to ch1 after ch 10
        }
    }
}
