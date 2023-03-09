package Lesson8.Homework8;

public class Main {
    public static void main(String[] args) {

      Obstacle[]  course1 = {
              new Wall(),
              new Runway(50),
              new Wall(1.5),
              new Runway()
       };
        for (Obstacle o:course1){
            System.out.println(o);

        }
    }
}
