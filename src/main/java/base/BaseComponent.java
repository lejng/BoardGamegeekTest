package base;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class BaseComponent {
    public WebDriver getDriver(){
        return WebDriverRunner.getWebDriver();
    }

    public String getCurrentUrl(){
        return getDriver().getCurrentUrl();
    }

    public String getTitle(){
        return getDriver().getTitle();
    }

    public void waitForLoadScripts() {
        Selenide.Wait().until(driver -> executeJavaScript("return document.readyState").equals("complete"));
    }

    public boolean isComponentOpen(By locator){
        waitForLoadScripts();
        return $(locator).exists();
    }
}
