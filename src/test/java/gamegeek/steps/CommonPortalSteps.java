package gamegeek.steps;

import gamegeek.portal.components.HeaderComponent;
import gamegeek.portal.entities.UserEntity;
import gamegeek.portal.modals.LoginModalDialog;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CommonPortalSteps {
    private HeaderComponent headerComponent;
    private LoginModalDialog loginModalDialog;

    public CommonPortalSteps(){
        headerComponent = new HeaderComponent();
        loginModalDialog = new LoginModalDialog();
    }

    @When("I login to portal with following credentials:")
    public void login(UserEntity userEntity) {
        headerComponent.clickSignInButton();
        loginModalDialog.login(userEntity);
    }

    @When("I select {string} from user menu on Header Component")
    public void selectOptionFromUserMenu(String optionName) {
        headerComponent.selectOptionInUserMenu(optionName);
    }

    @Then("The user is logged to portal")
    public void checkUserIsLoggedToPortal() {
        boolean isUserLogged = headerComponent.isUserLogged();
        String errorMessage = "Error: User is not logged to portal";
        Assert.assertTrue(errorMessage, isUserLogged);
    }
}
