package com.framework.Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class Base {

    public static WebDriver driver ;

    public Base() {
        {
            PageFactory.initElements(this.driver, this);
        }
    }


    public static void getDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                break;
        }
    }

    public static String ReadFromGlobalProperties(String key) throws IOException {
        File globalPropFile = new File("src/test/resources/app.Properties");
        FileInputStream stream = new FileInputStream(globalPropFile);
        Properties prop = new Properties();
        prop.load(stream);
        return prop.getProperty(key);
    }


}
