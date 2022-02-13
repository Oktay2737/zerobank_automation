package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OnlineBankingPage {
    public static void selectPage(String pageId){
        WebElement accountSummaryLink = Driver.get().findElement(By.xpath("//span[@id='"+pageId+"']"));//account_summary_link
        accountSummaryLink.click();
    }
}
