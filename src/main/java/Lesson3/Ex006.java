package Lesson3;

import java.util.Arrays;
import java.util.List;

public class Ex006 {
    public static void main(String[] args) {
        Character value = null;
//        List<Character> list1 = List.of('S', 'e', 'r', 'g', 'e', 'y');
        List<Character> list1 = Arrays.asList('S', 'e', 'r', 'g', 'e', 'y');
        System.out.println(list1);
        list1.remove(1); // java.lang.UnsupportedOperationException
        List<Character> list2 = List.copyOf(list1);
        
    }
}
