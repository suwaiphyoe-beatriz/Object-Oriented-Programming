package controller;

import model.Pet;

public class PetController {
    private Pet pet;
    private double targetX;
    private double targetY;
    private boolean moving = false;

    public PetController(Pet pet) {
        this.pet = pet;
    }

    public void setTarget(double x, double y) {
        this.targetX = x;
        this.targetY = y;
        this.moving = true;
    }

    public void stop() {
        this.moving = false;
    }

    public void update() {
        if (moving) {
            pet.moveTowards(targetX, targetY);
            if (pet.getX() == targetX && pet.getY() == targetY) {
                moving = false;
            }
        }
    }

    public Pet getPet() { return pet; }
}
