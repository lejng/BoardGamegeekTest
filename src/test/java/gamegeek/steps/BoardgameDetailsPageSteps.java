package gamegeek.steps;

import gamegeek.portal.api.ThingApi;
import gamegeek.portal.entities.VoteEntity;
import gamegeek.portal.pages.BoardgameDetailsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.Context;
import utils.EntityHelper;
import java.util.List;

public class BoardgameDetailsPageSteps {
    private BoardgameDetailsPage boardgameDetailsPage;
    private ThingApi thingApi;

    public BoardgameDetailsPageSteps(){
        boardgameDetailsPage = new BoardgameDetailsPage();
        thingApi = new ThingApi();
    }

    @When("I save most voted language dependence by key {string} from Boardgame Details Page")
    public void saveMostVotedLanguageDependenceByKeyFrom(String keyName) {
        String mostVotedQuestion = boardgameDetailsPage.getMostVotedLanguageDependenceValue();
        Context.getInstance().add(keyName, mostVotedQuestion);
    }

    @When("I open language dependence vote result from Boardgame Details Page")
    public void openLanguageDependenceVoteResult() {
        boardgameDetailsPage.openLanguageDependenceResult();
    }

    @Then("The Boardgame Details Page opened")
    public void checkPageOpened() {
        boolean isOpen = boardgameDetailsPage.isPageOpen();
        String errorMessage = "Error: The Boardgame Details Page is not open";
        Assert.assertTrue(errorMessage, isOpen);
    }

    @Then("The language dependence vote result from dialog on Boardgame Details Page must be equals with vote result from API")
    public void checkVoteResultWithVoteResultFromApi() {
        String gameId = boardgameDetailsPage.getGameId();
        List<VoteEntity> actualVoteResults = boardgameDetailsPage.getLanguageDependenceResultDialog().getVoteResult();
        List<VoteEntity> expectedVoteResults =  thingApi.getLanguageDependenceVoteResultForThingById(gameId);
        EntityHelper.assertEntities(expectedVoteResults, actualVoteResults, "Incorrect language dependence vote result info from Boardgame Details Page and from Api.");
    }

    @Then("The most voted language question from dialog on Boardgame Details Page must be equals question saved by key {string}")
    public void checkMostVotedLanguageDependenceQuestion(String expectedKeyQuestion) {
        String expected = Context.getInstance().get(expectedKeyQuestion);
        String actual = boardgameDetailsPage.getLanguageDependenceResultDialog().getMostVoteResult();
        Assert.assertEquals("Incorrect most voted language dependence question", expected, actual);
    }
}
