package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginPage extends Utility {

    public CustomerLoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement userName;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginBtn;

    @FindBy(xpath = "//label[normalize-space()='Your Name :']")
    WebElement yourNameTxt;




    public void selectUser(String name){
        selectByVisibleTextFromDropDown(userName,name);
        CustomListeners.test.log(Status.PASS, "Select User "+name);

    }
    public void clickOnLoginBtn(){
        clickOnElement(loginBtn);
        CustomListeners.test.log(Status.PASS, "Click on loginBtn");

    }
    public void verifyYourNameText(String text){
        verifyThatTextIsDisplayed(yourNameTxt,text);
        CustomListeners.test.log(Status.PASS, text);

    }
}
