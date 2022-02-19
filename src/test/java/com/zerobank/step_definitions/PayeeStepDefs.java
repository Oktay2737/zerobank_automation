package com.zerobank.step_definitions;

import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class PayeeStepDefs {
    @Given("Add New Payee tab")
    public void add_New_Payee_tab(Map<String, String> payeeInfo) {
        WebElement payeeNameInput = Driver.get().findElement(By.xpath("//*[@id='np_new_payee_name'] "));
        WebElement papeeAdressInput = Driver.get().findElement(By.xpath("//*[@id='np_new_payee_address']"));
        WebElement accountInput = Driver.get().findElement(By.xpath("//*[@id='np_new_payee_account']"));
        WebElement detailsInput = Driver.get().findElement(By.xpath("//*[@id='np_new_payee_details']"));

        payeeNameInput.sendKeys(payeeInfo.get("Payee Name"));
        papeeAdressInput.sendKeys(payeeInfo.get("Payee Address"));
        accountInput.sendKeys(payeeInfo.get("Account"));
        detailsInput.sendKeys(payeeInfo.get("Payee details"));

        Driver.get().findElement(By.xpath("//input[@type='submit'][ @value='Add'] ")).click();

    }
    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String alertMsgText) {
       WebElement alertMsgWebElement = Driver.get().findElement(By.xpath("//div[@id='alert_content']"));
        System.out.println("alertMsg = " + alertMsgWebElement.getText());
        Assert.assertTrue(alertMsgText.equals(alertMsgWebElement.getText()));
    }
}
