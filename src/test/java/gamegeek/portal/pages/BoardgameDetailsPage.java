package gamegeek.portal.pages;

import gamegeek.portal.modals.LanguageDependenceResultDialog;
import org.openqa.selenium.By;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.codeborne.selenide.Selenide.$;

public class BoardgameDetailsPage extends BoardGamegeekBasePage {
    private By mostVotedLanguageDependence = By.xpath("//span[@item-poll-button='languagedependence']//span[contains(@class,'ng')]");
    private By buttonOpenLanguageDependence = By.xpath("//span[@item-poll-button='languagedependence']");

    public boolean isPageOpen() {
        return super.isComponentOpen(By.xpath("//article[contains(@class,'game-description')]"));
    }

    public void openLanguageDependenceResult(){
        $(buttonOpenLanguageDependence).click();
    }

    public String getMostVotedLanguageDependence(){
        return $(mostVotedLanguageDependence).text();
    }

    public LanguageDependenceResultDialog getLanguageDependenceResultDialog(){
        return new LanguageDependenceResultDialog();
    }

    public String getGameId(){
        String url = getCurrentUrl();
        String regex = "\\/(\\d+)\\/";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        if(matcher.find()){
            return matcher.group(1);
        }
        return null;
    }
}
