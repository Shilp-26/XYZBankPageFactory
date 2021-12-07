package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankManagerLoginPage extends Utility {

    public BankManagerLoginPage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[normalize-space()='Add Customer']")
    WebElement addCustomerTab;

    @FindBy(xpath = "//button[normalize-space()='Open Account']")
    WebElement openAccount;

    public void clickOnaddCustomerTab() {
        clickOnElement(addCustomerTab);
        CustomListeners.test.log(Status.PASS, "Click on addCustomerTab");

    }

    public void clickOnOpenAccount() {
        clickOnElement(openAccount);
        CustomListeners.test.log(Status.PASS, "Click on openAccount");

    }

}
