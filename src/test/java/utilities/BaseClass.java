package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    private static WebDriver driver;

    public BaseClass() throws InterruptedException, IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\conne\\IdeaProjects\\Batch6Cucumber\\" +
                "src\\test\\java\\config\\env.properties");

        Properties prop = new Properties();
        prop.load(fis);

        String myURL = prop.getProperty("url");
        System.out.println(myURL);

        String myBrowser = prop.getProperty("browser");
        System.out.println(myBrowser);

        if(myBrowser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (myBrowser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (myBrowser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (myBrowser.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }

        driver.manage().window().maximize();
        driver.navigate().to(myURL);

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    public static WebDriver getDriver() {

        return driver;
    }

    public static void setDriver() throws InterruptedException, IOException {

        BaseClass obj = new BaseClass();
    }
}
