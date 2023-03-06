package Lesson8.Homework8;

import java.util.Random;

public abstract class Athlete {

    protected String name;
    protected int athlete_id;
    protected static int athlete_total ;
    protected static Random r;
    protected int running_max, jumping_max ;

    public Athlete(String name, int running_max, int jumping_max) {
        this.name = name;
        this.running_max = running_max;
        this.jumping_max = jumping_max;
        this.athlete_id = ++athlete_total;
    }
    public Athlete() {
        switch (r.nextInt(3)) {
            case 2: new Cat();break;
            case 1: new Robot();break;
            case 0: new Human();break;
            default: break;
            // default: new Human("Некто", 50 , 1);break;
        };
    }
//    public Athlete(Athlete player){
//        this.name = player.name;
//        this.running_max = player.running_max;
//        this.jumping_max = player.jumping_max;
//        this.athlete_id = ++athlete_total;
//    }


    @Override
    public String toString() {
        return String.format("Атлет %s под номером %d от команды '%ss'", this.name,this.athlete_id, this.getClass().getSimpleName());
    }

    String showAbilities() {
        return String.format("Атлет %s умеет бегать на %dм и прыгать на %dм",this.name,this.running_max,this.jumping_max);
    }


    public boolean jump(double height){

        if(height> this.jumping_max){
            System.out.println("Стена оказалась непреодолимой");
            return false;
        }else {
            System.out.println("Успешный прыжок!");
            return true;
        }

    }


    public boolean run(int length){

        if(length> this.running_max){
            System.out.println("Атлет "+ this.name + " выдохся и сошел с дистанции");
            return false;
        }else {
            System.out.println("Дистанция пройдена!");
            return true;
        }

    }
}
