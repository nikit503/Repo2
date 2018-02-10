package javax.nik.ru;

import org.w3c.dom.Document;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Utils {

    static void printTest(String str){
        System.out.println(str);
    }

    static void writeToFile(Document document, String fileName) throws FileNotFoundException, TransformerException {
        Transformer transformer= TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
        transformer.transform(new DOMSource(document),new StreamResult(new FileOutputStream(fileName)));
    }

    static Calendar getDate(){
        Date date= new Date();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
    static Calendar addDeltaMinutes(Calendar calendar,int minCount){
        calendar.add(Calendar.MINUTE,minCount);
        return calendar;
    }
    static String formateData(Calendar calendar){
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return dateFormat.format(calendar.getTime());
    }
}
