package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"C:\\Users\\conne\\IdeaProjects\\Batch6Cucumber\\src\\test\\java\\features\\windowHandles.feature"},
        glue={"stepDefinition"},
        //plugin = {"pretty", "html:target/cucumber-reports/Cucumber.html"},
        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        publish =true)

public class RunnerClass {
}
