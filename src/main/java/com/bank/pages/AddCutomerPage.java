package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCutomerPage extends Utility {

    public AddCutomerPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement addCutomerBtn;

    public void enterFirstName(String name) {
        sendTextToElement(firstName, name);
    }

    public void enterLastName(String surname) {
        sendTextToElement(lastName, surname);
        CustomListeners.test.log(Status.PASS, "Enter Last Name " + surname);

    }

    public void enterPostCode(String postcode) {
        sendTextToElement(postCode, postcode);
        CustomListeners.test.log(Status.PASS, "Enter post code " + postcode);

    }

    public void clickOnAddCutomerBtn() {
        clickOnElement(addCutomerBtn);
        CustomListeners.test.log(Status.PASS, "Click on addCutomerBtn");

    }

    public void alertTextVerify(String expMsg) throws InterruptedException {
        Thread.sleep(2000);
        String Message = getTextFromAlert();
        verifyText("Error, Message not displayed as expected", Message, expMsg);
        CustomListeners.test.log(Status.PASS, "Verify Message: "+expMsg);

    }

}
