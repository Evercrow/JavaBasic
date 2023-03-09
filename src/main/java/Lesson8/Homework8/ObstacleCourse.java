package Lesson8.Homework8;

import java.util.ArrayList;
import java.util.Random;


public class ObstacleCourse {

    private ArrayList<Object> match_course;
    protected Random r;

    public ObstacleCourse( Object[] obstacles) {

        for (Object o:obstacles){
            if(o instanceof Obstacle){
                this.match_course.add(o);
            }

        }

    }

    /**
     * Create arrayList of random Obstacle objects
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
}
