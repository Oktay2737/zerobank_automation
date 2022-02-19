package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FindTransactionsPage extends BaseForPayeeAndAccountActivity {
    public FindTransactionsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//input[@id='aa_fromDate']")
    private WebElement fromDateInput;

    @FindBy(xpath = "//input[@id='aa_toDate']")
    private WebElement toDateInput;

    @FindBy(xpath = "//button[@type='submit'] ")
    private WebElement findButton;

    @FindBy(xpath = "(//table[@class='table table-condensed table-hover'])[2]//tr//td[1]")
    private List<WebElement> returnedDateWebElements;

    @FindBy(xpath = "//input[@id='aa_description']")
    private WebElement descriptionInput;



    @FindBy(xpath = "(//table[@class='table table-condensed table-hover'])[2]//tbody//tr//td[2]")
    private List<WebElement> descriptions;

    @FindBy(xpath = "(//table[@class='table table-condensed table-hover'])[2]//tbody//tr//td[3]")
    private List<WebElement> deposits;

    @FindBy(xpath = "(//table[@class='table table-condensed table-hover'])[2]//tbody//tr//td[4]")
    private List<WebElement> withdrawals;

    @FindBy(xpath = "//select[@id='aa_type'] ")
    private WebElement typeDropdown;

    public void enterFromAndToDateAndSearch(String fromDate, String toDate) {
        BrowserUtils.waitForClickablility(fromDateInput, 10);
        fromDateInput.clear();
        fromDateInput.sendKeys(fromDate);

        toDateInput.clear();
        toDateInput.sendKeys(toDate);
        findButton.click();
    }

    public void compareReturnedDatesBetweenToGivenDate(String firstDate, String secondDate) {
        BrowserUtils.waitFor(1);
        Date dateBottom = stringToDateFormat(firstDate);
        Date dateTop = stringToDateFormat(secondDate);

        for (WebElement webElement : returnedDateWebElements) {

            Date dateFormated = stringToDateFormat(webElement.getText());
            Assert.assertTrue((dateFormated.compareTo(dateBottom) == 1 || dateFormated.compareTo(dateBottom) == 0) && (dateFormated.compareTo(dateTop) == -1 || dateFormated.compareTo(dateTop) == 0));

        }
    }

    private Date stringToDateFormat(String stringDate) {

        Date convertedDate = null;
        try {
            convertedDate = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
        } catch (Exception e) {
            System.out.println("Stringden tarihe çevirirken sorun oluştu");
        }
        return convertedDate;
    }

    public void dateOrderControl() {
        List<Date> dateList = getDateListFromDateWebElementList();
        for (int i = 0; i < dateList.size() - 1; i++) {
            Date date1 = dateList.get(i);
            Date date2 = dateList.get(i + 1);

            Assert.assertTrue(date1.compareTo(date2) == 1);

        }
    }

    public List<Date> getDateListFromDateWebElementList() {
        BrowserUtils.waitFor(2);
        List<Date> dateList = new ArrayList<>();
        for (WebElement webElement : returnedDateWebElements) {
            Date dateFormated = stringToDateFormat(webElement.getText());
            dateList.add(dateFormated);
        }
        return dateList;
    }

    public void controlGivenDateIsNotShown(String givenStringDate) {
        Date dateFormatOfGivenString = stringToDateFormat(givenStringDate);
        boolean shown = false;
        for (WebElement returnedDateWebElement : returnedDateWebElements) {
            Date shownDate = stringToDateFormat(returnedDateWebElement.getText());
            if (dateFormatOfGivenString.compareTo(shownDate) == 0) {
                shown = true;
                System.out.println("test hatalı");
            } else {
                shown = false;
                System.out.println("test geçti");
            }
        }
        Assert.assertFalse(shown);


    }

    public void writeDescription(String description) {
        BrowserUtils.waitFor(3);
        descriptionInput.clear();
        descriptionInput.sendKeys(description);
    }

    public void controlDescriptionTextIsContained(String searchedDescription) {
        BrowserUtils.waitFor(3);
        for (WebElement de : descriptions) {
            Assert.assertTrue(de.getText().contains(searchedDescription) || de.getText() == null);
        }
    }

    public boolean controlDeposits() {
        boolean isNotEmpty = false;
        for (WebElement we : deposits) {
            if (we.getText() != null)
                isNotEmpty = true;
        }
        return isNotEmpty;
    }

    public boolean controlWithdrawal() {
        boolean isNotEmpty = false;
        for (WebElement we : withdrawals) {
            if (we.getText() != null)
                isNotEmpty = true;
        }
        return isNotEmpty;
    }

    public void changeTransactionType(String selectType) {

        Select types = new Select(typeDropdown);
        List<WebElement> options = types.getOptions();
        types.selectByVisibleText(selectType);
        findButton.click();
        /*
        BrowserUtils.waitFor(2);

        List<WebElement> returnedList;

        if (selectType == "Deposit") {
            returnedList = deposits;
        } else {
            returnedList = withdrawals;
        }
    */

    }


}
