package org.example.frontend.pageObjects.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private static  WebDriver driver;
    public static WebDriver getWebDriver(){
        return driver;
    }

    private static  Properties properties;
    private static final String propertyFilePath = "config/configuration.properties";

    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

    public static void initiateWebDriver(){
        readFile();
        setUpDriver();
    }

    public static WebDriver getWebDriverInstance(){
        return driver;
    }

    public static WebDriver setUpDriver() {
        if (driver == null) driver = createDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    private static WebDriver createDriver() {
        Properties prop = getProperties();
        String pathToWebDrive = prop.getProperty("driverPath");
        System.setProperty(CHROME_DRIVER_PROPERTY, System.getProperty("user.dir") + pathToWebDrive);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }

    public static Properties getProperties() {
        return properties;
    }

    private static  void readFile() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }


}
