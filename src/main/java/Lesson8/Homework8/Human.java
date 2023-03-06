package Lesson8.Homework8;

public class Human extends Athlete{


    public Human(String name, int running_max, int jumping_max) {
        super(name, running_max, jumping_max);
    }


    public Human() {
        super("Хомо Вульгарис "+athlete_total,r.nextInt(5,300),r.nextInt(0,4));
    }
}
