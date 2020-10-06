package gamegeek.steps;

import gamegeek.portal.pages.UserCollectionPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UserCollectionPageSteps {
    private UserCollectionPage userCollectionPage;

    public UserCollectionPageSteps(){
        userCollectionPage = new UserCollectionPage();
    }

    @When("I open random game from User Collection Page")
    public void openRandomGame() {
        userCollectionPage.openRandomGame();
    }

    @Then("The User Collection Page opened")
    public void checkPageOpened() {
        boolean isOpen = userCollectionPage.isPageOpen();
        String errorMessage = "Error: The User Collection Page is not open";
        Assert.assertTrue(errorMessage, isOpen);
    }
}
