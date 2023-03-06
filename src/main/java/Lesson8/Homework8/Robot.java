package Lesson8.Homework8;

/**
 *
 */
public class Robot extends Athlete{

    public Robot(String name, int running_max, int jumping_max) {
        super(name, running_max, jumping_max);
    }


    public Robot() {
        super("Спортсминатор"+5000+athlete_total,Integer.MAX_VALUE,r.nextInt(0,1));
    }
}
