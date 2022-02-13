package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivitiesPage;
import com.zerobank.pages.FindTransactionsPage;
import com.zerobank.pages.IndexPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FindTransactionsStepDefs {

    @Then("go to {string} link in Account Activity page")
    public void go_to_link_in_Account_Activity_page(String linkTxt) {

        AccountActivitiesPage accountActivitiesPage =new AccountActivitiesPage();
        accountActivitiesPage.findTransactionLinkClick(linkTxt);
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        FindTransactionsPage findTransactionsPage = new FindTransactionsPage();
        findTransactionsPage.enterFromAndToDateAndSearch(fromDate, toDate);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String firstDate, String secondDate) {

        FindTransactionsPage findTransactionsPage = new FindTransactionsPage();
        findTransactionsPage.compareReturnedDatesBetweenToGivenDate(firstDate, secondDate);
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        FindTransactionsPage findTransactionsPage = new FindTransactionsPage();
        findTransactionsPage.dateOrderControl();
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String controlDateNotShown) {
        FindTransactionsPage findTransactionsPage = new FindTransactionsPage();
        findTransactionsPage.controlGivenDateIsNotShown(controlDateNotShown);
    }

}
