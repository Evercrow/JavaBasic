package Lesson8.Homework8;

public class Runway extends Obstacle{

    private  int length;

    public int getLength() {
        return length;
    }

    public Runway(int length) {
        this.length = length;
    }
    public Runway(){
        this.length = r.nextInt(500);
    }

    @Override
    public String toString() {
        return String.format("Дорожка длиной %dм",length);
    }
}
