package com.zerobank.step_definitions;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PurchaseForeignCurrencyStepDefs {

    WebElement calculateCostsElement = Driver.get().findElement(By.xpath("//input[ @id='pc_calculate_costs'] "));

    @Then("following	currencies should	be	available")
    public void following_currencies_should_be_available(List<String> currencyList) {
        WebElement selectElement = Driver.get().findElement(By.xpath("//select[@id='pc_currency'] "));
       Select currencySelect = new Select(selectElement);
       List<WebElement> currencyOptions = currencySelect.getOptions();
       List<String> stringCurrencies = new ArrayList<>();
       for(WebElement we: currencyOptions) {
           stringCurrencies.add(we.getText());
       }
        for (String currency: currencyList) {
            Assert.assertTrue(stringCurrencies.contains(currency));
        }
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        WebElement amountInputElement = Driver.get().findElement(By.xpath("//input[@type='text'][ @id='pc_amount'] "));
        amountInputElement.sendKeys("100");
        calculateCostsElement.click();
    }
    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert = Driver.get().switchTo().alert();
        BrowserUtils.waitFor(2);
        alert.accept();
    }
    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        calculateCostsElement.click();
    }

}
