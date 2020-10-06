package gamegeek.portal.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import utils.PropertyHelper;
import java.util.Random;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class UserCollectionPage extends BoardGamegeekBasePage {
    private By collectionTable = By.id("collectionitems");
    private By collectionTableRowName = By.xpath("//table[@id='collectionitems']//td[contains(@class,'collection_objectname')]//a");

    public boolean isPageOpen() {
        return isComponentOpen(collectionTable);
    }

    public void openRandomGame(){
        $(collectionTable).waitUntil(Condition.visible, PropertyHelper.getDefaultTimeoutInMill());
        ElementsCollection games = $$(collectionTableRowName);
        int count = games.size();
        Random rand = new Random();
        int randomIndex = rand.nextInt(count);
        games.get(randomIndex).click();
    }
}
