package org.example.frontend.pageObjects.reqres;

import org.example.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.frontend.pageObjects.managers.WebDriverManager.getWebDriverInstance;

public class SupportPageObject extends TestUtil {

//    @FindBy(xpath =  "//h2[contains(.,'Support')]")
//    private WebElement supportTitle;

    public boolean ifSupportTitleIsDisplayed(){
        WebElement supportTitle = getWebDriverInstance().findElement(By.xpath("//h2[contains(.,'Support')]"));

        return waitForElementToBeVisible(supportTitle).isDisplayed();
    }
}
