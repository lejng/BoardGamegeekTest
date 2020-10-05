package gamegeek.portal.components;

import base.BaseComponent;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import utils.PropertyHelper;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HeaderComponent extends BaseComponent {
    private By userMenu = By.xpath("//li[contains(@class,'nav-user ng')]");
    private By signInButton = By.xpath("//li[contains(@class,'global-header')]//button");
    private By optionsInUserMenu = By.xpath("//li[contains(@class,'nav-user ng')]//li//a");

    public void openUserMenu(){
        waitForLoadScripts();
        $(userMenu).click();
    }

    public boolean isUserLogged(){
        $(userMenu).waitUntil(Condition.visible, PropertyHelper.getDefaultTimeoutInMill());
        return $(userMenu).isDisplayed();
    }

    public void clickSignInButton(){
        waitForLoadScripts();
        $(signInButton).click();
    }

    public void selectOptionInUserMenu(String optionName){
        openUserMenu();
        $$(optionsInUserMenu).findBy(Condition.text(optionName)).click();
    }
}
