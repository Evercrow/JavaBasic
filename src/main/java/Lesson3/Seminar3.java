package Lesson3;

import java.util.ArrayList;

public class Seminar3 {
    public static void main(String[] args) {
        //System.out.println(countPaths(2,15,1,5));
        //System.out.println(SergioPaths(2,2000,1,2,"path "));
        System.out.println(countPathsNonRecursive(2,6,1,2));
        System.out.println(findWay(2,6,1,2));
        System.out.println(SergioPaths(2,6,1,2, "path "));

    }

    //+На вход некоторому исполнителю подаётся два числа (a, b). У исполнителя есть две команды
    //- команда 1 (к1): увеличить а в с раз, а умножается на c
    //- команда 2 (к2): увеличить на d, к a прибавляется d
    //написать программу, которая выдаёт набор команд, позволяющий число a превратить в число b или сообщить, что это невозможно
    //Пример 1: а = 1, b = 7, c = 2, d = 1
    //ответ: к2, к2, к2, к2, к2, к2, k2 или к1, к1, к2, к2, к2
    //Можно начать с более простого – просто подсчёта общего количества вариантов
    //Пример 2: а = 11, b = 7, c = 2, d = 1
    //ответ: нет решения.
    //*Подумать над тем, как сделать минимальное количество команд
    static private int countPaths(int start_num,int end_num ,int oper_add,int oper_mult){
            if(end_num < start_num) return 0;
            else if(start_num == end_num) return 1;
            else if (end_num % oper_mult == 0) return countPaths(start_num, end_num / oper_mult,oper_add,oper_mult) +
                    countPaths(start_num, end_num - oper_add, oper_add, oper_mult);
            else return countPaths(start_num, end_num - oper_add,oper_add,oper_mult);

    }
    private static ArrayList<String> SergioPaths(int a, int b, int c, int d, String e){
        ArrayList<String> arr = new ArrayList<>();
        if (a == b){
            arr.add(e);
        }
        if (a < b){
            arr.addAll(SergioPaths(a + c, b, c, d, e + "1"));
            arr.addAll(SergioPaths(a * d, b, c, d, e + "2"));
        }
        return arr;
    }

    static public int countPathsNonRecursive(int start_num,int end_num ,int oper_add,int oper_mult){
        int[] paths = new int[end_num+1];
         paths[start_num] = oper_add;

        // теперь перебираем все узлы основной ветки, и от них ответвляемся
        for (int node = start_num+oper_add; node <= end_num ; node++){
            if(node % oper_mult == 0){
                 paths[node] = paths[node/oper_mult] + paths[node-oper_add];
            }
            else{
                paths[node] = paths[node - oper_add];
            }
            System.out.print(paths[node]);
        }
        System.out.println();
//        if (paths == 0) System.out.println("Решений нет");
        return paths[end_num];
    }


   // Сергей
    public static int findWay(int a, int b, int c, int d) {
        int[] way = new int[b + 1];
        way[a] = 1;
        for (int i = a + c; i <= b; i++) {
            way[i] = i % d == 0 ? way[i - c] + way[i / d] : way[i - c];
            System.out.print(way[i]);
        }
        System.out.println();
        return way[b];
    }



}
