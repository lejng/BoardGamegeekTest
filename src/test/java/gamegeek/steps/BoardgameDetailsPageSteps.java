package gamegeek.steps;

import gamegeek.portal.entities.VoteEntity;
import gamegeek.portal.pages.BoardgameDetailsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.Context;
import java.util.List;

public class BoardgameDetailsPageSteps {
    private BoardgameDetailsPage boardgameDetailsPage;

    public BoardgameDetailsPageSteps(){
        boardgameDetailsPage = new BoardgameDetailsPage();
    }

    @When("I save most voted language dependence by key {string} from Boardgame Details Page")
    public void saveMostVotedLanguageDependenceByKeyFrom(String keyName) {
        String mostVotedQuestion = boardgameDetailsPage.getMostVotedLanguageDependence();
        Context.getInstance().add(keyName, mostVotedQuestion);
    }

    @When("I open open language dependence vote result on Boardgame Details Page")
    public void openLanguageDependenceVoteResult() {
        boardgameDetailsPage.openLanguageDependenceResult();
    }

    @When("I save language dependence vote result by key {string} from Boardgame Details Page")
    public void saveLanguageDependenceVoteResultByKey(String keyName) {
        List<VoteEntity> voteResult = boardgameDetailsPage.getLanguageDependenceResultDialog().getVoteResult();
        Context.getInstance().add(keyName, voteResult);
    }

    @When("I save game id by key {string} from Boardgame Details Page")
    public void saveGameIdByKey(String keyName) {
        String id = boardgameDetailsPage.getGameId();
        Context.getInstance().add(keyName, id);
    }

    @Then("The Boardgame Details Page opened")
    public void checkPageOpened() {
        boolean isOpen = boardgameDetailsPage.isPageOpen();
        String errorMessage = "Error: The Boardgame Details Page is not open";
        Assert.assertTrue(errorMessage, isOpen);
    }
}
