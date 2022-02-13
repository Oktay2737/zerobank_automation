package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FindTransactionsPage {
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



    public void enterFromAndToDateAndSearch(String fromDate, String toDate){
        BrowserUtils.waitForClickablility(fromDateInput,10);
        fromDateInput.clear() ;
        fromDateInput.sendKeys(fromDate);

        toDateInput.clear();
        toDateInput.sendKeys(toDate);
        findButton.click();
    }

    public void compareReturnedDatesBetweenToGivenDate(String firstDate, String secondDate){
        BrowserUtils.waitFor(1);
        Date dateBottom =stringToDateFormat(firstDate);
        Date dateTop =stringToDateFormat(secondDate);

        for(WebElement webElement: returnedDateWebElements){

            Date dateFormated =stringToDateFormat(webElement.getText());
            Assert.assertTrue((dateFormated.compareTo(dateBottom)==1||dateFormated.compareTo(dateBottom)==0)&& (dateFormated.compareTo(dateTop)==-1||dateFormated.compareTo(dateTop)==0));

        }
    }

    private Date stringToDateFormat(String stringDate){

        Date convertedDate=null;
        try {
            convertedDate=new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
        }catch (Exception e){
            System.out.println("Stringden tarihe çevirirken sorun oluştu");
        }
        return convertedDate;
    }

    public void dateOrderControl(){
        List<Date> dateList= getDateListFromDateWebElementList();
        for (int i = 0; i < dateList.size()-1; i++) {
            Date date1 = dateList.get(i);
            Date date2 = dateList.get(i+1);

            Assert.assertTrue(date1.compareTo(date2)==1);

        }
    }

    public List<Date> getDateListFromDateWebElementList(){
        BrowserUtils.waitFor(2);
        List<Date> dateList= new ArrayList<>();
        for (WebElement webElement:returnedDateWebElements){
            Date dateFormated =stringToDateFormat(webElement.getText());
            dateList.add(dateFormated);
        }
        return  dateList;
    }

    public void controlGivenDateIsNotShown(String givenStringDate){
        Date dateFormatOfGivenString = stringToDateFormat(givenStringDate);
        boolean shown = false;
        for (WebElement returnedDateWebElement : returnedDateWebElements) {
            Date shownDate = stringToDateFormat(returnedDateWebElement.getText());
            if(dateFormatOfGivenString.compareTo(shownDate)==0) {
                shown = true;
                System.out.println("test hatalı");
            }else {
                System.out.println("test geçti");
            }
        }
        Assert.assertTrue(shown);


    }


}
