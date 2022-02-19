package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class PayeePage extends BaseForPayeeAndAccountActivity{
    public PayeePage() {
        PageFactory.initElements(Driver.get(), this);
    }
}
