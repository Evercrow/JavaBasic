package Lesson8.Homework8;

public class Cat extends Athlete{

    public Cat(String name, int running_max, int jumping_max) {
        super(name, running_max, jumping_max);
    }

    public Cat(){
        super("Кот-дефолт"+athlete_total,r.nextInt(10,50),r.nextInt(2,6));
    }


}
