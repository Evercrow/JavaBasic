package Lesson8.Homework8;

/**
 *
 */
public class Robot extends Athlete{

    public Robot(String name, int running_max, double jumping_max) {
        super(name, running_max, jumping_max);
    }

    public Robot(String name){
        super(name,Integer.MAX_VALUE,r.nextDouble(0,2));
    }


    public Robot() {
        super("Спортсминатор-"+5000+athlete_total,Integer.MAX_VALUE,r.nextDouble(0,2));
    }
}
