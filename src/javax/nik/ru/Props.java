package javax.nik.ru;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Props {
    //путь к нашему файлу конфигураций
    public static final String PATH_TO_PROPERTIES = "D:/IdeaProjects/Repo2/src/prop";
public static List<String> arrayList=new ArrayList<>();


    public static void main(String[] args) {

        FileInputStream fileInputStream;
        //инициализируем специальный объект Properties
        //типа Hashtable для удобной работы с данными
        Properties prop = new Properties();

        try {
            //обращаемся к файлу и получаем данные
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            prop.load(fileInputStream);

            String site = prop.getProperty("prop1");
            String loginToSite = prop.getProperty("prop2");


            //печатаем полученные данные в консоль
            System.out.println(
                    "site: " + site
                            + "\nloginToSite: " + loginToSite
            );
            arrayList.addAll(Arrays.asList(site.split(",")));

        } catch (IOException e) {
            System.out.println("Ошибка в программе: файл " + PATH_TO_PROPERTIES + " не обнаружено");
            e.printStackTrace();
        }

        for(String iter:arrayList){
            System.out.println(iter);
        }

    }

}
