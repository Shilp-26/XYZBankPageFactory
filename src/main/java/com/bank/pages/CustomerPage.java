package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage extends Utility {

    public CustomerPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[normalize-space()='Logout']")
    WebElement logoutTab;


    public void verifyLogOutTab(String msg) {
        verifyThatTextIsDisplayed(logoutTab, msg);
        CustomListeners.test.log(Status.PASS, "Verify LogOutTab");

    }
    public void clickOnLogout(){
        clickOnElement(logoutTab);
        CustomListeners.test.log(Status.PASS, "Click on logoutTab");

    }
}
