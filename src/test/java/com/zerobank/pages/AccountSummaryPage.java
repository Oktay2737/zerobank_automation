package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.WatchEvent;

public class AccountSummaryPage {
    public AccountSummaryPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath ="//a[@href='/bank/account-activity.html?accountId=1']" )
    public WebElement saving1Link;

    public void clickSaving1Link(String linkTxt){
        String path ="//a[text()='"+linkTxt+"'] ";
        WebElement linkElement = Driver.get().findElement(By.xpath(path));
        linkElement.click();
    }
}
