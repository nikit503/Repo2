package potTest;

public class ConfigReader {
    int count=0;
    private static ConfigReader configReader=new ConfigReader();
    private ConfigReader(){
        count++;
    }

    public static ConfigReader getInstance(){
        return configReader;
    }
}
