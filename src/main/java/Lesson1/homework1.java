package Lesson1;

import java.util.Scanner;

public class homework1 {


    public static void main(String[] args) {
        TriangleNumWrap();
    }


    //Написать программу вычисления n-ого треугольного числа
    public static void TriangleNumWrap(){

        int needed_num = getNumberFromConsole("Введите искомое число: ");
        System.out.printf("%d-е треугольное число равно %d",needed_num,TriangleNum(needed_num));
        DrawTriangle(needed_num);
    }

    public static int TriangleNum(int n){
        return n*(n+1)/2;
    }

    public static int getNumberFromConsole(String text) {
        Scanner input = new Scanner(System.in);
        System.out.print(text);
        int inp_num = 0;

        try {
            inp_num = input.nextInt();}
        catch(Exception InputMismatchException) {
            System.out.println("Введеная строка не является целым числом");
        }

        return inp_num;

    }

    public static void DrawTriangle(int base){
        StringBuilder line = new StringBuilder(base);
        StringBuilder triangle = new StringBuilder();
        line.append("* ".repeat(base));
        for (int line_num = base; line_num > 0; line_num--){
            triangle.append(line);
            triangle.append('\n');
            /*
            // Треугольник вершиной вниз
            line.insert(0," ");
            line.delete(line.length()-3,line.length()-1);

             */
            line.append(" ");
            line.delete(0,2);
        }

        System.out.println(triangle.reverse());

    }


}
