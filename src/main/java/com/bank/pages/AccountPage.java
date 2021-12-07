package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends Utility {

    public AccountPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[normalize-space()='Deposit']")
    WebElement deposit;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amount;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement depositBtn;

    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement verifyMsg;

    @FindBy(xpath = "//button[normalize-space()='Withdrawl']")
    WebElement withdrawltab;

    @FindBy(xpath = "//button[normalize-space()='Withdraw']")
    WebElement withdrawlBtn;

    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement transactionMsg;


    public void clickOnWithdrawlTab() {
        clickOnElement(withdrawltab);
        CustomListeners.test.log(Status.PASS, "Click on withdrawltab");

    }

    public void clickOnWithdrawlBtn() {
        clickOnElement(withdrawlBtn);
        CustomListeners.test.log(Status.PASS, "Click on withdrawlBtn");
    }

    public void verifyTransactionSuccessfullMsg(String text) {
        verifyThatTextIsDisplayed(transactionMsg, text);
        CustomListeners.test.log(Status.PASS, "Verify Message: "+text);

    }


    public void clickOnDepositTab() {
        clickOnElement(deposit);
        CustomListeners.test.log(Status.PASS, "Click on deposit");
    }

    public void enterDepositAmount(String depAmount) {
        sendTextToElement(amount, depAmount);
        CustomListeners.test.log(Status.PASS, "Enter Deposit amount " + depAmount);

    }

    public void enterWithdrawlAmount(String witAmount) {
        sendTextToElement(amount, witAmount);
        CustomListeners.test.log(Status.PASS, "Enter Withdrawl amount " + witAmount);
    }

    public void clickOnDepositBtn() {
        clickOnElement(depositBtn);
        CustomListeners.test.log(Status.PASS, "Click on depositBtn");
    }

    public void verifyDepositMsg(String msg) {
        verifyThatTextIsDisplayed(verifyMsg, msg);
        CustomListeners.test.log(Status.PASS, "Verify Message: "+msg);

    }
}
