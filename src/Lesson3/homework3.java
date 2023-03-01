package Lesson3;

import java.util.Arrays;
import java.util.Random;

public class homework3 {
    public static void main(String[] args) {
        int[] testArray = getRandomIntArray(0,100,8);
        int[] testArray1 = {82, 45, 54, 5, 3, 13, 23, 18};
        System.out.println(Arrays.toString(testArray1));
        System.out.println(Arrays.toString(mergeSort(testArray1)));
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
        int[] sorted_arr =new int[arr.length];
        int piece_size = 1;
        while (2*piece_size <= arr.length){

            for (int i = 0; i < arr.length; i+=piece_size*2){
                System.arraycopy(piecesMerge(arr,i,i+piece_size-1,i+piece_size,i+2*piece_size-1,piece_size),0,
                                                                                                                                sorted_arr,i,piece_size*2);
            }
            piece_size *=2;
            System.out.print("iteration ");
            System.out.println(Arrays.toString(sorted_arr));
        }

        // цикл, который вызывает сортирующий метод с увеличивающимся размером массива (удвоение) и пишет в результирующий массив
        // начинаем с размера = 1 (такой можно считать сортированным в любом случае)

        //цикл с кучей проверок, который сливает два малых сортированных куска в один
        //куски - массивы, выходной - коллекция

        return sorted_arr;
    }

    private static int[] piecesMerge(int[] unsorted_arr, int left_start,int left_end,int right_start,int right_end ,int size){
        int[] merge_buffer = new int[size*2];
        int merge_index = 0;
        int r_search = right_start ;
        int l_done = 0;
        int temp;

        for (int l = left_start; l <= left_end; l++){

            while(unsorted_arr[l]>unsorted_arr[right_start] && right_start<=right_end){
                merge_buffer[merge_index] = unsorted_arr[right_start];
                merge_index++;
                right_start++;
            }
            merge_buffer[merge_index] = unsorted_arr[l];
            merge_index++;
        }
        //остаток, если есть
        for (int r = right_start; r <= right_end ; r++){
            merge_buffer[merge_index] = unsorted_arr[r];
            merge_index++;
        }
//            System.out.printf("right_start %d : %d \n",r ,unsorted_arr[r]);
//            System.out.printf("left_loop %d : %d \n",l ,unsorted_arr[l]);



        System.out.print("buffer ");
        System.out.println(Arrays.toString(merge_buffer));
        return merge_buffer;
    }
















}
