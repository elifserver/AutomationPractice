package steps;

import com.framework.Pages.Base;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.io.File;
import java.io.IOException;

public class CucumberHooks extends Base {
    private static String testName;

    @Before(value = "@web")
    public void Setup(Scenario scenario) throws IOException {
        testName = (scenario.getName() + scenario.getId()).replaceAll(" ", "");

        if (driver == null)
            getDriver(ReadFromGlobalProperties("browser"));
    }

    @After(value = "@web")
    public void TierDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(sourceFile, new File("Screenshots/" + testName + ".png"));

            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png" ,"testName");
        }
    }


}
