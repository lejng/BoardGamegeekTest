package utils;

import io.qameta.allure.Allure;
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
        }catch (Exception error){
            Allure.addAttachment(String.format("Error to property by name %s", name), error.getMessage());
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

    public static int getDefaultWaitTimeout(){
        return getIntProperty(TIMEOUT_WAIT);
    }

    public static int getDefaultWaitTimeoutInMill(){
        return getDefaultWaitTimeout() * 1000;
    }
}
