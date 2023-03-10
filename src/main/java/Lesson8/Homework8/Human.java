package Lesson8.Homework8;

public class Human extends Athlete{


    public Human(String name, int running_max, double jumping_max) {
        super(name, running_max, jumping_max);
    }
    public Human(String name){
        super(name, r.nextInt(5,300),r.nextDouble(0,4));
    }


    public Human() {
        super("Хомо Вульгарис "+athlete_total,r.nextInt(10,500),r.nextDouble(1,5));
    }
}
