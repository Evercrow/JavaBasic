package Lesson4;


import java.time.Duration;
import java.time.Instant;
import java.util.*;


/**
 * Реализовать алгоритм пирамидальной сортировки (HeapSort)
 */
public class Homework4 {
    public static void main(String[] args) {


        int[] testBigArray = getRandomIntArray(0,100,10000);
        int[] testArray = {82,3, 45, 54, 5, 3, 13, 23, 18,67,10,11};
        Instant start = Instant.now();
        System.out.println(Arrays.toString(HeapSortIndex(testArray)));

        Instant end = Instant.now();
        System.out.printf("Время работы HeapSortIndex составило %s нс", Duration.between(start,end).toNanos());

        System.out.println("\n-------");
        start = Instant.now();
        System.out.println(Arrays.toString(treeMapSort(testArray)));

        end = Instant.now();
        System.out.printf("Время работы treeMapSort составило %s нс", Duration.between(start,end).toNanos());

        /*
        System.out.println("\n-------");
        start = Instant.now();
        System.out.println(Arrays.toString(HeapSortIndex(testBigArray)));
        end = Instant.now();
        System.out.printf("Время работы составило %s мс", Duration.between(start,end).toMillis());

        System.out.println("\n-------");
        start = Instant.now();

        System.out.println(Arrays.toString(pyramidSort(testBigArray)));

        end = Instant.now();
        System.out.printf("Время работы составило %s мс", Duration.between(start,end).toMillis());
        */

        //чистый тест без принта
        System.out.println("\n-------");
        start = Instant.now();
        int[] sorted2 = HeapSortIndex(testBigArray);
        end = Instant.now();
        System.out.printf("Время работы HeapSortIndex составило %s нс", Duration.between(start,end).toNanos());

        System.out.println("\n-------");
        start = Instant.now();
        int[] sorted1 = treeMapSort(testBigArray);
        end = Instant.now();
        System.out.printf("Время работы treeMapSort составило %s нс", Duration.between(start,end).toNanos());


    }

    /**
     * HeapSort через TreeMap<Integer,Integer> и Comparator
     * Код проще,и можно на лету поменять метод сортировки,
     * но работает дольше в среднем в 2 раза
     *
     */
    public static int[] treeMapSort(int[] arr){
        //структура кастомного сепаратора
//        Comparator<Integer> critteria = new Comparator<Integer>()
//
//        {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
//            }
//        };

        TreeMap<Integer,Integer> heaped = new TreeMap<>(Comparator.naturalOrder());

        for (int i = 0; i < arr.length; i++){
            if(heaped.containsKey(arr[i])){
                heaped.replace(arr[i], heaped.get(arr[i])+1) ;
            }
            else {
                heaped.put(arr[i],1);
            }

        }
         //System.out.println(heaped);


        int ind = 0;
        int copies = 0;
        for (Map.Entry<Integer,Integer> e : heaped.entrySet()){
            while(copies < e.getValue()){
                arr[ind] = e.getKey();
                copies++;
                ind++;
            }
            ind++;

        }

        return arr;
    }



    public static int[] HeapSortIndex(int[] arr) {
        int n = arr.length;

        // делаем первую пробежку по индексам дерева так, чтобы максимум массива оказался в вершине(идет полусортировка массива)
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, i, n);
        }

        //Теперь делается практически пузырьковый цикл, с сортированной частью справа и несортированной слева ,
        //но "всплывают" наши максимумы с шагами по индексам дерева(в вершине всегда max), вместо послеовательного O(n)
        for (int i = n - 1; i >= 0; i--){
            //сразу меняем максимум из вершины дерева с концом массива
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            //и делаем проверку по дереву(куче) c новым "концевым" значением
            maxHeapify(arr, 0, i); //при этом индекс конца дерева у нас меньше на точно отсортированную часть
        }


        return arr;
    }


    /**
     * Этот метод делают проверку и перестановку элементов массива такую,  чтобы в вершине узла дерева стоял максимум.
     * шаг индекса по принципу бинарного древа: i - вершина(корень узла),i*2+1,i*2+2 - ветки(дети).
     * При перестановке проверка условий запускается рекурсивно на случай, если обе ветки больше вершины.
     * @param arr - входной сортируемый массив
     * @param treeStart  - индекс, принимаемый изначально за вершину узла
     * @param treeEnd - индекс конца массива, когда не хватает элементов массива,чтобы построить узел(финальные ветки дерева)
     */
    static void maxHeapify(int[] arr,  int treeStart,int treeEnd) {
        int max = treeStart;
        int leftBranch = 2 * treeStart + 1;
        int rightBranch = 2 * treeStart + 2;
        //если левая ветка больше корня,
        if (leftBranch < treeEnd && arr[leftBranch] > arr[max])
            max = leftBranch;

        //если правая ветка больше корня
        if (rightBranch < treeEnd && arr[rightBranch] > arr[max])
            max = rightBranch;

        //если сработали предыдущие проверки, то меняем местами элементы в массиве, чтобы в вершине оказался больший элемент
        if (max != treeStart) {
            int swap = arr[treeStart];
            arr[treeStart] = arr[max];
            arr[max] = swap;

            maxHeapify(arr, max, treeEnd);
        }

    }


    public static int[] getRandomIntArray(int lower,int upper,int size){
        Random r = new Random();
        int[] ar = new int[size];
        for (int i = 0; i < ar.length; i++){
            // ar[i] = my_rand.nextInt((upper-lower+1)+lower); //for older  JDKs
            ar[i] = r.nextInt(lower,upper);

        }
        return ar;
    }



}
