package Lesson8.Homework8;

public class Cat extends Athlete{

    public Cat(String name, int running_max, double jumping_max) {
        super(name, running_max, jumping_max);
    }
    public Cat(String name){
        super(name,r.nextInt(50,300),r.nextDouble(3,10));
    }

    public Cat(){
        super("Кот-дефолт"+athlete_total,r.nextInt(50,300),r.nextDouble(3,10));
    }


}
