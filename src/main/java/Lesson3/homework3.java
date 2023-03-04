package Lesson3;

import java.util.Arrays;
import java.util.Random;

/**
 * Реализовать алгоритм сортировки слиянием
 */
public class homework3 {
    public static void main(String[] args) {

        int[] testArray_rng = getRandomIntArray(0,100,100);
        int[] testArray1 = {82, 45, 54, 5, 3, 13, 23, 18,67,10,11};
        int[] testArray2 = {91, 84, 81, 97, 14, 27, 20, 10};
        System.out.println("Массив до:");
        System.out.println(Arrays.toString(testArray_rng));
        System.out.println("Массив после:");
        System.out.println(Arrays.toString(mergeSort(testArray_rng)));
        //тест без печати,на миллион
//        testArray_rng = mergeSort(testArray_rng);
    }

    public static int[] getRandomIntArray(int lower,int upper,int size){
        int[] ar = new int[size];
        Random r = new Random();
        for (int i = 0; i < ar.length; i++){
            // ar[i] = my_rand.nextInt((upper-lower+1)+lower); //for older  JDKs
            ar[i] = r.nextInt(lower,upper);

        }
        return ar;
    }

    public static int[] mergeSort(int[] arr){

        if(arr.length <= 1){return arr;} //для таких массивов сортировка не нужна
        int piece_size = 1;
        int tail_start = 0;
        int tail_size ;

        // цикл, который вызывает сортирующий метод с увеличивающимся размером буфера слияния (удвоение) и пишет в текущий массив
        while (2*piece_size <= arr.length){

            for (int i = 0; i <= arr.length-2*piece_size; i+=piece_size*2){

                System.arraycopy(piecesMergeIndex(arr,i,i+piece_size-1,i+piece_size,i+2*piece_size-1,piece_size),0,
                                                                                                                                arr,i,piece_size*2);
                tail_start = i+piece_size*2;
            }
            piece_size *=2;

//            System.out.print("Array after iteration ");
//            System.out.println(Arrays.toString(arr));
        }

        //Обработка хвоста,некратного степени двойки
        tail_size = arr.length - tail_start;
        if(tail_size>0){
            //скопируем хвост в отдельный массив
            int[] tail_array = new int[tail_size];
            System.arraycopy(arr,tail_start,tail_array,0,tail_size);

            //рекурсивный вызов сортировки
             //System.out.println("Обработка хвоста массива рекурсивно");
            System.arraycopy(mergeSort(tail_array),0,arr,tail_start,tail_size);

            // И теперь делаем последний проход слияния, сортированный основной массив и сортированный хвост
            System.arraycopy(piecesMergeIndex(arr,0, tail_start -1, tail_start , arr.length-1, arr.length/2+1), 0,
                        arr, 0, arr.length);
        }

        return arr;
    }

    /**
     * метод , который собирает из двух сортированных отрезков(по индексам) входного массива  один сортированный массив
     * @param unsorted_arr входной недосортированный массив
     * @param left_start индекс начала левого сливаемого куска массива
     * @param left_end - конечный индекс левого куска
     * @param right_start индекс начала правого сливаемого куска массива
     * @param right_end - конечный индекс правого куска
     * @param size размер куска(выходной массив в 2 раза больше)
     */
    private static int[] piecesMergeIndex(int[] unsorted_arr, int left_start,int left_end,int right_start,int right_end ,int size){
        int[] merge_buffer = new int[size*2];
        int merge_index = 0;

        for (int l = left_start; l <= left_end ; l++){

            // просматриваем правый кусок и пишем его,пока он меньше
            while( right_start<=right_end && right_start<unsorted_arr.length){

                if(unsorted_arr[l]>unsorted_arr[right_start]){
                    merge_buffer[merge_index] = unsorted_arr[right_start];
                    merge_index++;
                    right_start++;
                }
                else {break;}

            }

            merge_buffer[merge_index] = unsorted_arr[l];
            merge_index++;
        }

        //остаток, если левый кусок весь записали , а правый еще нет
        for (int r = right_start; r <= right_end ; r++){
            merge_buffer[merge_index] = unsorted_arr[r];
            merge_index++;
        }

//        System.out.print("buffer ");
//        System.out.println(Arrays.toString(merge_buffer));
        return merge_buffer;
    }
















}
