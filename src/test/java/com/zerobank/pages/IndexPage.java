package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

    public IndexPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//button[@id='signin_button']")
    private WebElement signinButton;

    public void singin(){
        WebDriver driver = Driver.get();
        String url = ConfigurationReader.get("url");
        driver.get(url);
        driver.manage().window().maximize();
        BrowserUtils.waitForPageToLoad(3);
        signinButton.click();
    }
}
