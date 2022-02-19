package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivitiesPage;
import com.zerobank.pages.FindTransactionsPage;
import com.zerobank.pages.IndexPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class FindTransactionsStepDefs {

    FindTransactionsPage findTransactionsPage;
    //BURADA


    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        findTransactionsPage = new FindTransactionsPage();
        findTransactionsPage.enterFromAndToDateAndSearch(fromDate, toDate);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String firstDate, String secondDate) {

        findTransactionsPage = new FindTransactionsPage();
        findTransactionsPage.compareReturnedDatesBetweenToGivenDate(firstDate, secondDate);
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        findTransactionsPage = new FindTransactionsPage();
        findTransactionsPage.dateOrderControl();
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String controlDateNotShown) {
        findTransactionsPage = new FindTransactionsPage();
        findTransactionsPage.controlGivenDateIsNotShown(controlDateNotShown);
    }
    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
        findTransactionsPage = new FindTransactionsPage();
        findTransactionsPage.writeDescription(description);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String descriptionString) {
        findTransactionsPage = new FindTransactionsPage();
        findTransactionsPage.controlDescriptionTextIsContained(descriptionString);
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        findTransactionsPage = new FindTransactionsPage();
        boolean result = findTransactionsPage.controlDeposits();
        Assert.assertTrue(result);
    }
    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        findTransactionsPage = new FindTransactionsPage();
        boolean result = findTransactionsPage.controlWithdrawal();
        Assert.assertTrue(result);
    }
    @When("user selects type {string}")
    public void user_selects_type(String selectType) {
        findTransactionsPage = new FindTransactionsPage();
        findTransactionsPage.changeTransactionType(selectType);
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        findTransactionsPage = new FindTransactionsPage();
        Boolean result = findTransactionsPage.controlWithdrawal();
        Assert.assertFalse(!result);
    }
    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        Boolean result = findTransactionsPage.controlDeposits();
        Assert.assertFalse(!result);
    }

}
