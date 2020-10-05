package gamegeek.portal.modals;

import base.BaseComponent;
import gamegeek.portal.entities.UserEntity;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class LoginModalDialog extends BaseComponent {

    public void login(UserEntity user){
        $(By.id("inputUsername")).sendKeys(user.getUserName());
        $(By.id("inputPassword")).sendKeys(user.getPassword());
        $(By.xpath("//*[@name='loginform']//button[@type='submit']")).click();
    }
}
