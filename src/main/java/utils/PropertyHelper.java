package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyHelper {
    private static final String PROPERTY_PATH = "src/test/resources/config.properties";
    private static final String CURRENT_BROWSER = "current.browser";
    private static final String BASE_URL = "site.url";
    public static final String TIMEOUT_WAIT = "timeout.wait";

    public static String getProperty(String name){
        try(FileInputStream fis = new FileInputStream(PROPERTY_PATH)){
            Properties property = new Properties();
            property.load(fis);
            return property.getProperty(name);
        }catch (Exception e){
            // add log
        }
        return null;
    }

    public static int getIntProperty(String name){
        return Integer.parseInt(getProperty(name));
    }

    public static String getBrowserName(){
        return getProperty(CURRENT_BROWSER);
    }

    public static String getBaseUrl(){
        return getProperty(BASE_URL);
    }

    public static int getDefaultTimeout(){
        return getIntProperty(TIMEOUT_WAIT);
    }

    public static int getDefaultTimeoutInMill(){
        return getDefaultTimeout() * 1000;
    }
}
