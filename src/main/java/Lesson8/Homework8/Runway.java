package Lesson8.Homework8;

public class Runway {

    private final int length;

    public int getLength() {
        return length;
    }

    public Runway(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return String.format("Дорожка длиной %dм",length);
    }
}
