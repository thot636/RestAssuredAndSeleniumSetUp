package org.example.frontend.pageObjects.reqres;

import org.example.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.example.frontend.pageObjects.managers.WebDriverManager.getWebDriverInstance;

public class MainPageObject extends TestUtil {

//    @FindBy(xpath =  "//button[contains(@style,'float: none')]")
//    protected WebElement supportButton;


    public MainPageObject(){
        super();
        //setUpDriver();
    }

    public MainPageObject openMainPage(){
        getWebDriverInstance().get(getUrlLink());
        return this;
    }

    public SupportPageObject clickOnSupportButton(){
        WebElement supportButton = getWebDriverInstance().findElement(By.xpath("//button[contains(@style,'float: none')]"));
        //supportButton.click();
        waitForElementAndClickOnIt(supportButton);
        return new SupportPageObject();
    }
}
