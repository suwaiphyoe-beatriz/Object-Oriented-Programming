package Task1;

public class Pen {

    public enum Color {
        RED("red"),
        GREEN("green"),
        BLUE("blue");

        private final String color;

        Color(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return color;
        }
    }

    private Color color;
    private boolean capOn = true;

    public Pen() {
        this.color = Color.RED;
    }

    public Pen(Color color) {
        this.color = color;
    }

    public void capOn() {
        this.capOn = true;
    }

    public void capOff() {
        this.capOn = false;
    }

    public void changeColor(Color newColor) {
        if (capOn) {
            this.color = newColor;
        }
    }

    public String draw() {
        if (capOn) return "";
        return "Drawing " + color;
    }
}
