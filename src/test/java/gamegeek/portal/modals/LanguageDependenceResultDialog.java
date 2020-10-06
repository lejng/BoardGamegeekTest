package gamegeek.portal.modals;

import base.BaseComponent;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import gamegeek.portal.entities.VoteEntity;
import org.openqa.selenium.By;
import utils.PropertyHelper;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LanguageDependenceResultDialog extends BaseComponent {
    private By tableResult = By.xpath("//table[contains(@class,'poll')]");
    private By tableResultRow = By.xpath("//table[contains(@class,'poll')]//tbody//tr[contains(@class,'ng-scope')]");

    public List<VoteEntity> getVoteResult(){
        LinkedList<VoteEntity> result = new LinkedList<>();
        $(tableResult).waitUntil(Condition.visible, PropertyHelper.getDefaultTimeoutInMill());
        ElementsCollection rows = $$(tableResultRow);
        for(int i = 0; i < rows.size(); i++){
            SelenideElement row = rows.get(i);
            String question = row.$(By.xpath(".//th//span")).text();
            int voteCount = Integer.parseInt(row.$(By.xpath(".//td[contains(@class,'binding')]")).text().trim());
            result.add(new VoteEntity(question, voteCount));
        }
        return result;
    }

    public String getMostVoteResult(){
        VoteEntity mostVote = getVoteResult().stream().max(Comparator.comparingInt(VoteEntity::getVoteCount)).get();
        return mostVote.getVoteCount() == 0 ? "(no votes)" : mostVote.getQuestion();
    }
}
