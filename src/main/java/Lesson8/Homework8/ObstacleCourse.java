package Lesson8.Homework8;

import java.util.ArrayList;
import java.util.Arrays;

public class ObstacleCourse {

    ArrayList<Object> match_course;


    public ObstacleCourse(Object[] match_course) {
        Arrays.stream(match_course).toArray();
        this.match_course = match_course;
    }
}
