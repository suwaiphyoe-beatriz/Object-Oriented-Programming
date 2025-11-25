package model;

public class Pet {
    private double x;
    private double y;
    private double speed = 2;

    public Pet(double startX, double startY) {
        this.x = startX;
        this.y = startY;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    public void moveTowards(double targetX, double targetY) {
        double dx = targetX - x;
        double dy = targetY - y;
        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance < speed) {
            x = targetX;
            y = targetY;
        } else {
            x += (dx / distance) * speed;
            y += (dy / distance) * speed;
        }
    }
}
