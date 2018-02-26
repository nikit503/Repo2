package javax.nik.ru;



import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;



import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;


import static javax.nik.ru.Utils.*;
import static javax.nik.ru.Utils.getDate;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, FileNotFoundException {

        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document document=builder.newDocument();

        List<String> tagsList=Arrays.asList("main", "coord", "time","path","Dir");
        List<String> listTypes=Arrays.asList("obj1", "obj2", "obj3","obj4","obj5");






        String date1;
        String date2;
        Calendar date3;

        date3=getDate();

//               date2=formateData(addDeltaMinutes(date3,15));
//        date1=formateData(addDeltaMinutes(date3,15));


        String pathDir="/usr/tmp/";
        String dirFolder="/usr/dirName/";

        Element root=document.createElement("main");
        Element coord=document.createElement("Coord");
        Element time=document.createElement("time");
        Element path=document.createElement("path");
        Element dir=document.createElement("Dir");



        document.appendChild(root);






//        System.out.println(date2);
//        System.out.println(date1);

        for(int i=0;i<listTypes.size();i++) {

            createDir("MyDir/" + listTypes.get(i));



            root.appendChild(coord);
            coord.setAttribute("Id",String.valueOf(i));


            coord.appendChild(time);
            time.setTextContent(formateData(addDeltaMinutes(date3,15)));

            coord.appendChild(path);
            path.setTextContent(pathDir);
            coord.appendChild(dir);
            dir.setTextContent(dirFolder);

            writeToFile(document,"MyDir/" + listTypes.get(i)+"/output.xml");
        }







    }

}
