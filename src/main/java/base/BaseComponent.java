package base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyHelper;
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

    public boolean isComponentOpen(By locator){
        waitForLoadScripts();
        waitUntil($(locator), Condition.exist);
        return $(locator).exists();
    }

    public void waitUntil(SelenideElement element, Condition condition){
        int timeout = PropertyHelper.getDefaultWaitTimeoutInMill();
        element.waitUntil(condition, timeout);
    }

    public void waitForLoadScripts() {
        Selenide.Wait().until(driver -> executeJavaScript("return document.readyState").equals("complete"));
    }
}
