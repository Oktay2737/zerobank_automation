package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountActivitiesPage extends BaseForPayeeAndAccountActivity {
    public AccountActivitiesPage() {
        PageFactory.initElements(Driver.get(), this);
    }

}

