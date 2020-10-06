package gamegeek.portal.pages;

import gamegeek.portal.modals.LanguageDependenceResultDialog;
import org.openqa.selenium.By;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.codeborne.selenide.Selenide.$;

public class BoardgameDetailsPage extends BoardGamegeekBasePage {
    private By buttonOpenLanguageDependenceLocator = By.xpath("//span[@item-poll-button='languagedependence']");
    private By pageUniqueElementLocator = By.xpath("//article[contains(@class,'game-description')]");

    public boolean isPageOpen() {
        return super.isComponentOpen(pageUniqueElementLocator);
    }

    public void openLanguageDependenceResult(){
        $(buttonOpenLanguageDependenceLocator).click();
    }

    public String getMostVotedLanguageDependenceValue(){
        return $(buttonOpenLanguageDependenceLocator).$(By.xpath(".//span[contains(@class,'ng')]")).text();
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
