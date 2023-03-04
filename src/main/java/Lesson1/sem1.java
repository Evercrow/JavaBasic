package Lesson1;

import java.util.Arrays;
import java.util.Random;

public class sem1 {
    public static void main(String[] args) {

        int[] inp_buff = new int[] {1,2,3,4,5,6,7,8,9};

        int[] fresh_array = {1,2,3,4,5,6,7,8,9};

        int[] odd_arr = new int[fresh_array.length];

        for (int i = 0; i < fresh_array.length; i++){
            if(fresh_array[i] % 2 == 0){
                odd_arr[i] = fresh_array[i];
            }
        }

        System.out.println(Arrays.toString(odd_arr));
        for (int num : odd_arr){
            if (num != 0){
                System.out.print(num+" ");
            }

//            System.out.println(odd_arr);

        }

    }
    static int createAndArray(int size){
        int[] rand_arr = new int[size];
        new Random();

        return 1;
    }

}
