package Lesson8.Homework8;

public class Main {
    public static void main(String[] args) {

      Obstacle[]  course1_arr = {
              new Wall(),
              new Runway(50),
              new Wall(1.5),
              new Runway()
       };

        ObstacleCourse course1 = new ObstacleCourse(course1_arr);
        System.out.println(course1);

        Athlete singleplayer = new Human("Антон",300,5);
        course1.runCourse(singleplayer);
        System.out.println("------");

        Athlete[] igroki = {
                new Human(),
                new Robot("Электроник"),
                new Cat("Мурка"),
                new Cat(),
                new Human("Питек"),
                new Robot()
        };
        course1.runTournament(igroki);

        //тест рандомной генерации препятствий
        ObstacleCourse course2 = new ObstacleCourse(5);
        System.out.println(course2);
        System.out.println("------");
        System.out.println("Турнир2");
        course2.runTournament(igroki);






    }
}
