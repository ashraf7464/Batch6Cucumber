package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.BaseClass;

import java.io.IOException;

public class Hooks {

    @Before
    public void appInit() throws InterruptedException, IOException {
        BaseClass.setDriver();
    }

    @After
    public void tearDown() throws InterruptedException {
        //BaseClass.getDriver().close();
        // It's just a Git Test
    }
}
