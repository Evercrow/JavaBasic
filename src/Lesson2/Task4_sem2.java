package Lesson2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task4_sem2 {
    public static void main(String[] args) {
        String dir_path = ".";
        String log_name = "error_log.txt";
        String filedir_name = "test.txt";
        String[] myStrings = { "One", "Two", "Three" };
        try {
            writeToFile(curDir(dir_path),filedir_name);
        } catch(Exception e) {
            try {logErrors(log_name, e.toString());} catch(Exception log_e){System.out.printf("Не удалось записать лог ошибки, %s",log_e);}
            System.out.println("При работе программы возникли ошибки.");
            System.out.printf("Подробный лог был записан в файл в текущей папке %s", log_name);
        }

    }

    private static void logErrors(String l_name,String e_str) throws IOException {
        Logger logger = Logger.getLogger("dir");
        FileHandler fh = new FileHandler(l_name);
        logger.addHandler(fh);


        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        //logger.setLevel(Level.INFO);
        logger.log(Level.WARNING, "Тестовое логирование Warning-lvl");
        logger.info("Тестовое логирование INFO-lvl");

    }
    public static void writeToFile(String[] fileStrings, String filePath) throws IOException{
        FileWriter filewriter = new FileWriter(filePath);
        for (String fileString : fileStrings){
            filewriter.write(fileString + "\n");
            filewriter.flush();
        }
        filewriter.close();
    }



    public static String[] curDir(String path){
        File file = new File(path);
        return file.list();
    }

}
