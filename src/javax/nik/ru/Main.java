package javax.nik.ru;



import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;


import java.io.FileNotFoundException;
import java.util.Calendar;



import static javax.nik.ru.Utils.*;
import static javax.nik.ru.Utils.getDate;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, FileNotFoundException {

        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document document=builder.newDocument();


        String date1,date2;
        date1=formateData(getDate());
        date2=formateData(addDeltaMinutes(getDate(),15));

        String pathDir="/usr/tmp/";
        String dirFolder="/usr/dirName/";
        Element root=document.createElement("main");

        Element coord=document.createElement("Coordinator");
        Element time=document.createElement("time");
        Element path=document.createElement("path");
        Element dir=document.createElement("Dir");

        Text text=document.createTextNode("Text example!");

        document.appendChild(root);

        root.appendChild(coord);
        root.appendChild(coord);

        coord.appendChild(time);
        coord.appendChild(path);
        coord.appendChild(dir);

        for(int i=0;i<2;i++) {
            coord.setAttribute("id", String.valueOf(i));
            time.setTextContent(date1);
            path.setTextContent(pathDir);
            dir.setTextContent(dirFolder);
        }


        System.out.println(date1);
        System.out.println(date2);











        writeToFile(document,"output.xml");
    }
}
