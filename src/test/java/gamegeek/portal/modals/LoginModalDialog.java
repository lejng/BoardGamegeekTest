package gamegeek.portal.modals;

import base.BaseComponent;
import gamegeek.portal.entities.UserEntity;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class LoginModalDialog extends BaseComponent {
    private By usernameInputLocator = By.id("inputUsername");
    private By passwordInputLocator = By.id("inputPassword");
    private By loginButtonLocator = By.xpath("//*[@name='loginform']//button[@type='submit']");

    public void login(UserEntity user){
        $(usernameInputLocator).sendKeys(user.getUserName());
        $(passwordInputLocator).sendKeys(user.getPassword());
        $(loginButtonLocator).click();
    }
}
