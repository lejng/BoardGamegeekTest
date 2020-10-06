package gamegeek.portal.components;

import base.BaseComponent;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HeaderComponent extends BaseComponent {
    private By userMenuLocator = By.xpath("//li[contains(@class,'nav-user ng')]");
    private By signInButtonLocator = By.xpath("//li[contains(@class,'global-header')]//button");
    private By optionsInUserMenuLocator = By.xpath("//li[contains(@class,'nav-user ng')]//li//a");

    public void openUserMenu(){
        waitForLoadScripts();
        $(userMenuLocator).click();
    }

    public boolean isUserLogged(){
        waitUntil($(userMenuLocator), Condition.visible);
        return $(userMenuLocator).isDisplayed();
    }

    public void clickSignInButton(){
        waitForLoadScripts();
        $(signInButtonLocator).click();
    }

    public void selectOptionInUserMenu(String optionName){
        openUserMenu();
        $$(optionsInUserMenuLocator).findBy(Condition.text(optionName)).click();
    }
}
