package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.IndexPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.OnlineBankingPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityStepDefs {
    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        IndexPage indexPage = new IndexPage();
        indexPage.singin();

        LoginPage loginPage = new LoginPage();
        loginPage.login();

    }
    @Then("select {string}")
    public void select(String pageLinkId) {
        OnlineBankingPage.selectPage(pageLinkId);
    }
/*
    @When("the user clicks on Savings link on the Account Summary page")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_page() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.clickSaving1Link();
        System.out.println("2");
        String actualTitle = Driver.get().getTitle();
    }
*/
    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String linkText) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.clickSaving1Link(linkText);
        System.out.println("2");
}


@Then("the page title should be {string}")
    public void the_page_title_should_be(String expectedTitle) {
        String actualTitle = Driver.get().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @Then("Account drop down should have Savings selected")
    public void account_drop_down_should_have_Savings_selected() {
        WebElement dropdownElement =Driver.get().findElement(By.id("aa_accountId"));
        Select accountDropdown = new Select(dropdownElement);
        List<WebElement> options = accountDropdown.getOptions();
        String actualSelectedOption = accountDropdown.getFirstSelectedOption().getText();
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String expecetedSelectedOption) {
        WebElement dropdownElement =Driver.get().findElement(By.id("aa_accountId"));
        Select accountDropdown = new Select(dropdownElement);
        //List<WebElement> options = accountDropdown.getOptions();
        String actualSelectedOption = accountDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelectedOption, expecetedSelectedOption);
    }

}
