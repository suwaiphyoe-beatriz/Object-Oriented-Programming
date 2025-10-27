package Task1;

public class TelevisionViewer {
    private Television tv;
    private int day;

    public TelevisionViewer() {
        tv = new Television();
        day = 1;
    }

    public void liveWeek() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Woke up, day " + day);

            if (day == 1) {
                // Day 1 to 3 channels
                watchChannels(3);
            } else if (day % 2 == 0) {
                // Even days (2, 4, 6, 8, 10)  4 channels
                watchChannels(4);
            } else {
                // Odd days after 1 (3, 5, 7, 9) 6 channels
                watchChannels(6);
            }

            System.out.println("Falling asleep");
            day++;
        }
    }

    private void watchChannels(int count) {
        for (int i = 0; i < count; i++) {
            tv.watch();
            tv.nextChannel();
        }
    }

    public static void main(String[] args) {
        TelevisionViewer viewer = new TelevisionViewer();
        viewer.liveWeek();
    }
}
