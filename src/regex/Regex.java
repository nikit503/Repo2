package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
String projectName="DFD";
        String str2=null;
        String str="taken from asda/DFD-2231 daw aken from asda/DFD-3231 daw";

        Pattern pattern=Pattern.compile("\\bfrom\\b(?<gitType>.+?)[\\s/](?<task>"+projectName+"-\\d*)");
        Matcher matcher=pattern.matcher(str);
while (matcher.find()) {
    int counter=1;
    System.out.println(matcher.start() + "  " + matcher.group("task") + " " + matcher.group("gitType"));
    str2= matcher.group("task");

    System.out.println(matcher.groupCount());
    counter++;
    System.out.println("counter: "+counter);
}


        System.out.println(str2);
    }
}
