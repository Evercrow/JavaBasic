package Lesson8.Homework8;

import java.util.ArrayList;
import java.util.Random;


public class ObstacleCourse {

    protected ArrayList<Obstacle> match_course = new ArrayList<>();
    protected static Random r = new Random();

    public ObstacleCourse( Obstacle[] obstacles) {

        for (Obstacle o:obstacles){
            if(o !=null){
                this.match_course.add(o);
            }

        }

    }

    /**
     * Creates arrayList of random Obstacle objects called match_course
     * @param course_length - how many Obstacles you need
     */
    public ObstacleCourse(int course_length){
        for (int i = 0; i < course_length; i++){

            if(r.nextInt(2) == 1){
                this.match_course.add(new Wall());
            }else {
                this.match_course.add(new Runway());
            }

        }

    }

    public boolean runCourse(Athlete a){
       boolean success = false;
        for (Obstacle o: match_course){
            if(o instanceof Wall){
                success = a.jump(((Wall) o).getHeight());
            }else if(o instanceof Runway){
                success = a.run(((Runway) o).getLength());
            }
            if(!success){return success;}
        }
        if(success){
            System.out.printf("Атлет %s пришел к финишу!",a.name);
        }
       return  success;
    }

    public void runTournament(Athlete[] players){
        for (Athlete i: players){
            System.out.println(i + " готовится к старту.");
            System.out.println(i.showAbilities());
            System.out.println("Старт!");
            this.runCourse(i);
            System.out.println("\n------");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.match_course.size()*20);
        for (Obstacle o:this.match_course){
            sb.append(o.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
