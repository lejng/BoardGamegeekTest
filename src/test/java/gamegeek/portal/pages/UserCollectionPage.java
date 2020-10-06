package gamegeek.portal.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import java.util.Random;
import static com.codeborne.selenide.Selenide.$;

public class UserCollectionPage extends BoardGamegeekBasePage {
    private By collectionTableLocator = By.id("collectionitems");
    private By collectionTableRowNameLocator = By.xpath(".//td[contains(@class,'collection_objectname')]//a");

    public boolean isPageOpen() {
        return isComponentOpen(collectionTableLocator);
    }

    public void openRandomGame(){
        waitUntil($(collectionTableLocator), Condition.visible);
        ElementsCollection games = $(collectionTableLocator).$$(collectionTableRowNameLocator);
        int count = games.size();
        Random rand = new Random();
        int randomIndex = rand.nextInt(count);
        games.get(randomIndex).click();
    }
}
