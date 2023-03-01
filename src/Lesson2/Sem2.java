package Lesson2;

public class Sem2 {
    public static void main(String[] args) {
        //Заданния 1-3
        int l = 6;
        char s1 = 'к';
        char s2 = 'у';
        System.out.println(joinSymbols(l, s1, s2));

        String test_str1 = "aaaaabbbbcdddd";

        System.out.println(ShortenString(test_str1));

        String test_str2 = "полулоп";


        System.out.println(isPalindrom(test_str2));
    }







    private static String joinSymbols(int num, char c1,char c2){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < num/2; i++){
            str.append(c1).append(c2);
        }
        return str.toString();
    }


    //    2. Напишите метод, который сжимает строку.
    //    Пример: вход aaaabbbcdd.

    private static String ShortenString(String inp_str ){
        StringBuilder result = new StringBuilder();
        // int count = 1;
        result.append(inp_str.charAt(0));
        for (int i = 1; i < inp_str.length()-1; i++){
            if (inp_str.charAt(i) != inp_str.charAt(i+1)){
                result.append(inp_str.charAt(i+1));
            }
        }
        return result.toString();
    }

    //    3 Напишите метод, который принимает на вход строку (String) и определяет является ли строка палиндромом (возвращает boolean значение).
    private static boolean isPalindrom(String inp_str){
        boolean pal = false;

        if
        (new StringBuilder(inp_str).reverse().toString().equals(inp_str)){
            pal = true;
        }

        return pal;

    }

}
