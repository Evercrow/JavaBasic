package Lesson2;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Homework2_2 {
    public static void main(String[] args) {
        int[] test_array1 = {9,2,3,4,5,6,7,8,1};
        int[] test_array2 = {2,1,1,4,5,4,5,7,9,8,3};
        try {
            bubbleSort(test_array1);
            bubbleSort(test_array2);
        } catch(Exception e) {
            System.out.println("При обработке файла возникла ошибка \n" +e.toString());
        }

    }

    public static int[] bubbleSort  (int[] arr) throws IOException{
        Logger logr = Logger.getLogger(Homework2_2.class.getName());
        FileHandler fh = new FileHandler("sort_log.txt");
        SimpleFormatter log_format = new SimpleFormatter();

        logr.addHandler(fh);
        fh.setFormatter(log_format);
        logr.info(String.format("The starting array is %s", Arrays.toString(arr)));



            int temp_swap;
            for (int i = 0; i < arr.length - 1; i++){
                for (int j = 0; j < arr.length - i - 1; j++){
                    if(arr[j+1] < arr[j]){
                        temp_swap = arr[j];
                        arr[j]=arr[j+1];
                        arr[j+1] = temp_swap;
                    }

                }
                 logr.info(String.format("%d iteration %s",i+1, Arrays.toString(arr)));
            }

        logr.info(String.format("The sorted array is  %s", Arrays.toString(arr)));


        return  arr;
    }
}

