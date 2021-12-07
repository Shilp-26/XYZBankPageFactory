package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankManagerLoginTab;


    @FindBy(xpath = "//button[normalize-space()='Customer Login']")
    WebElement customerLoginTab;


    public void clickOnBankManagerLoginTab() {
        clickOnElement(bankManagerLoginTab);
        CustomListeners.test.log(Status.PASS, "Click on bankManagerLoginTab");

    }



    public void clickOnCustomerLogin() {
        clickOnElement(customerLoginTab);
        CustomListeners.test.log(Status.PASS, "Click on customerLoginTab");

    }
}
