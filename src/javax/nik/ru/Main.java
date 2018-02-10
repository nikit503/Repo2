package javax.nik.ru;



import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;


import java.io.FileNotFoundException;


import static javax.nik.ru.Utils.*;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, FileNotFoundException {

        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document document=builder.newDocument();

        Element root=document.createElement("root");
        Element font=document.createElement("font");
        Text text=document.createTextNode("Text example!");

        document.appendChild(root);
        root.appendChild(font);
        font.appendChild(text);
        font.setAttribute("size","20");

        writeToFile(document,"output.xml");
    }
}
