package Lesson7.Seminar7;

public class Program {
    public static void main(String[] args) {
        /*
        Cat Laki = new Cat();
        System.out.println(Laki.age);
        Laki.age = 10;
        System.out.println(Laki.age);
        System.out.println(Laki.name);
        Laki.name = "Laki";
        System.out.println(Laki.name);
        Laki.color = "white";
        System.out.println(Laki.color);
        Laki.setName("Тиша");
        Laki.setColor("Black");
        Laki.setAge(30);
        System.out.println("cat = " + Laki);

         */


        /*
        Point3D pointA = new Point3D(2,3,4);
        Point3D pointB = new Point3D(3,4,5);

        System.out.println(pointA.lengthVector());

        System.out.println(pointA.scalarMultiply(pointB));

        System.out.println(pointA.getCosToVector(pointB));

        System.out.println(pointA.sumVector(pointB));

         */

        Animal Laki = new Cat("black");
        Laki.voice();
        System.out.println(Laki);

    }
}
