package Lesson8.Homework8;

public class Wall {

    private final double height;

    public double getHeight() {
        return height;
    }

    public Wall(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return String.format("Стена высотой %.1fм",height);
    }
}
