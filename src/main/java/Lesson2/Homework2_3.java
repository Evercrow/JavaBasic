package Lesson2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * Дана json строка (можно сохранить в файл и читать из файла) <br>
 * <p>
 * [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
 * <p><br>
 * Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
 * <p><br>
 * Пример вывода:<br>
 *
 * Студент Иванов получил 5 по предмету Математика.<br>
 *
 * Студент Петрова получил 4 по предмету Информатика.<br>
 *
 * Студент Краснов получил 5 по предмету Физика.<br>
 */
public class Homework2_3 {
    public static void main(String[] args) {

        System.out.println(strFromJSON("students.json"));


    }

    public static String strFromJSON(String jsonFName){
        File json_file = new File(System.getProperty("user.dir")+"/"+jsonFName);

        //путь к скомпилированному проекту
        //System.out.println(Homework2_3.class.getProtectionDomain().getCodeSource().getLocation().getPath());

        StringBuilder grades_str = new StringBuilder();
        try {
            FileReader f = new FileReader(json_file);
            JSONParser parser = new JSONParser();
            JSONArray students_list = (JSONArray) parser.parse(f);

            Iterator<JSONObject> i = students_list.iterator();
            while(i.hasNext()){
                JSONObject student =  i.next();
                grades_str.append(String.format(
                        "Студент %s получил %s по предмету %s.\n\n",
                        student.get("фамилия"),student.get("оценка"),student.get("предмет")
                ));
            }

        } catch (IOException ex) {
            System.out.println("Ошибка доступа к файлу");
            ex.printStackTrace();
        } catch (org.json.simple.parser.ParseException ex) {
            System.out.println("Ошибка работы модуля json-парсинга");
            ex.printStackTrace();
        }


        return grades_str.toString();
    }
}
