package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath ="//input[@id='user_login'] ")
    private WebElement userNameInput;

    @FindBy(xpath ="//input[@id='user_password'] ")
    private WebElement userPasswordInput;

    @FindBy(xpath ="//input[@name='submit'] ")
    private WebElement submitButton;



    public void login(){


        BrowserUtils.waitForPageToLoad(3);
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        userNameInput.sendKeys(username);
        userPasswordInput.sendKeys(password);
        submitButton.click();
        Driver.get().navigate().back();

        WebElement onlineBankingTab = Driver.get().findElement(By.xpath("//strong[text()='Online Banking']"));
        onlineBankingTab.click();

   //     OnlineBankingPage.selectPage("account_summary_link");

    }


}
