package frontend;

import org.example.frontend.pageObjects.managers.WebDriverManager;
import org.example.frontend.pageObjects.reqres.MainPageObject;
import org.example.frontend.pageObjects.reqres.SupportPageObject;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.frontend.pageObjects.managers.WebDriverManager.getWebDriverInstance;

public class ExampleFrontendTest {

    @BeforeClass
    public void setUp(){
        WebDriverManager.initiateWebDriver();

    }

    @Test
    public void goToSupportPage(){
        MainPageObject mainPageObject = new MainPageObject();

        SupportPageObject supportPageObject =
        mainPageObject.openMainPage()
                .clickOnSupportButton();
        assertThat(supportPageObject.ifSupportTitleIsDisplayed()).isTrue();
    }

    @AfterTest
    public void tearDown(){
        getWebDriverInstance().quit();
    }
}
