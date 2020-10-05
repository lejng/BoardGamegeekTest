package gamegeek.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.Context;
import utils.PropertyHelper;
import static com.codeborne.selenide.Selenide.open;

public class CommonHooks {

    @Before
    public void setUp(){
        Configuration.browser = PropertyHelper.getBrowserName();
        open(PropertyHelper.getBaseUrl());
    }

    @After
    public void tearDown(){
        WebDriverRunner.closeWebDriver();
        Context.getInstance().clear();
    }
}
