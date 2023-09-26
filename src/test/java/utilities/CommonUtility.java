package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class CommonUtility extends BaseClass {

    static JavascriptExecutor js;
    static TakesScreenshot ss;

    public CommonUtility() throws InterruptedException, IOException {
    }

    public static void screenshot(String fileName) throws IOException {

        ss = (TakesScreenshot) BaseClass.getDriver();
        File memoryLocation = ss.getScreenshotAs(OutputType.FILE);

        FileHandler.copy(memoryLocation, new File("C:\\Users\\conne\\IdeaProjects\\Batch6Cucumber\\" +
                "src\\test\\ScreenshotFolder"+fileName));

    }

    public static void ScrollHeight() throws InterruptedException {
        js = (JavascriptExecutor) BaseClass.getDriver();
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(3000);
    }
    public static void ScrollByNumber() throws InterruptedException {

        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
    }

    public static void ScrollIntoView(WebElement element) throws InterruptedException {

        js.executeScript("arguments[0].scrollIntoView();",element);
        Thread.sleep(3000);

    }
}
