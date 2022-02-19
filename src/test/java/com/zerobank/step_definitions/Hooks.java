package com.zerobank.step_definitions;


import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before
    public void setUp(){
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("this is comming from @Before ");
    }
    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        BrowserUtils.waitFor(10);
       // Driver.closeDriver();
    }
    @Before("@db")//uzerinde @db notasyonu olan metotlar için çalışacaktır. bu çalışınca diğer @Before metodu çalışmayacaktır.
    public void setUpdb(){
        System.out.println("@Beforedb connecting to db ");
    }
    @After("@db")//uzerinde @db notasyonu olan metotlar için çalışacaktır. bu çalışınca diğer @After metodu çalışmayacaktır.
    public void tearDowndb(){
        System.out.println("@Afterdb closing the db");
    }
}
