package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenAccountPage extends Utility {

    public OpenAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userSelect")
    WebElement selectCustomer;

    @FindBy(id = "currency")
    WebElement currency;

    @FindBy(xpath = "//button[normalize-space()='Home']")
    WebElement navigateHomePage;

    @FindBy(xpath = "//button[normalize-space()='Process']")
    WebElement processBtn;

public void clickOnHomeBtn(){
    clickOnElement(navigateHomePage);
    CustomListeners.test.log(Status.PASS, "Click on navigateHomePage");
}
    public void selectCustomerDropdown(String name) {
        selectByVisibleTextFromDropDown(selectCustomer, name);
        CustomListeners.test.log(Status.PASS, "Select Customer: "+name);

    }

    public void selectCurrency(String selectCurrency) {
        selectByVisibleTextFromDropDown(currency, selectCurrency);
        CustomListeners.test.log(Status.PASS, "Select Currency");
    }

    public void clickOnProcessBtn() {
        clickOnElement(processBtn);
        CustomListeners.test.log(Status.PASS, "Click on processBtn");

    }

    public void alertAccountTextVerify(String expMsg) throws InterruptedException {
        Thread.sleep(2000);
        String message = getTextFromAlert();
        verifyText("Error, Message not displayed as expected", message, expMsg);
        CustomListeners.test.log(Status.PASS, "Verify "+expMsg);

    }

}
