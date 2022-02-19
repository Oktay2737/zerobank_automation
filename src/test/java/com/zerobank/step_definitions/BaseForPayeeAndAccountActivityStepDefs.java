package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivitiesPage;
import com.zerobank.pages.BaseForPayeeAndAccountActivity;
import com.zerobank.pages.FindTransactionsPage;
import com.zerobank.pages.OnlineBankingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class BaseForPayeeAndAccountActivityStepDefs {
    @Then("select {string}")
    public void select(String pageLinkId) {
        OnlineBankingPage.selectPage(pageLinkId);
    }
    @Then("go to {string} link in current page")
    public void go_to_link_in_current_page(String linkTxt) {
        BaseForPayeeAndAccountActivity baseForPayeeAndAccountActivity =new BaseForPayeeAndAccountActivity();
        baseForPayeeAndAccountActivity.findSubMenuAndClick(linkTxt);
    }
    @And("clicks search")
    public void clicks_search(){
        BaseForPayeeAndAccountActivity baseForPayeeAndAccountActivity = new BaseForPayeeAndAccountActivity();
        baseForPayeeAndAccountActivity.findBtn.click();
    }

}
