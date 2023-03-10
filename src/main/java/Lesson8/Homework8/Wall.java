package Lesson8.Homework8;

public class Wall extends Obstacle {

    private  double height;


    public double getHeight() {
        return height;
    }

    public Wall(double height) {
        this.height = height;
    }

    public Wall(){
        this.height= r.nextDouble(3.1);
    }

    @Override
    public String toString() {
        return String.format("Стена высотой %.1fм",height);
    }


}
