package Lesson2;

/**
 * Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
 * Если значение null, то параметр не должен попадать в запрос.
 *
 * Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 */
public class Homework2_1 {
    public static void main(String[] args) {

        String input_string = "SELECT * FROM students WHERE ";
        String[][] user_filters =  {{"name","Ivanov"}, {"country","Russia"}, {"city","Moscow"}, {"age","null"}};
        System.out.println(addSQLfilters(input_string,user_filters));
    }


    public static String addSQLfilters(String sql_str, String[][]f){
        StringBuilder full_sql = new StringBuilder(sql_str);
        for (int i = 0; i < f.length; i++){
            if(!f[i][1].equals("null")){
                full_sql.append(String.format("%s = %s,",f[i][0],f[i][1]));
            }
        }
        full_sql.setCharAt(full_sql.length() -1,';');

        return full_sql.toString();
    }
}
