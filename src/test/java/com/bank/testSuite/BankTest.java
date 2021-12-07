package com.bank.testSuite;

import com.bank.customlisteners.CustomListeners;
import com.bank.pages.*;
import com.bank.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class BankTest extends TestBase {

    HomePage homePage = new HomePage();
    AddCutomerPage addCutomerPage;
    OpenAccountPage openAccountPage;
    CustomerLoginPage customerLoginPage;
    CustomerPage customerPage;
    AccountPage accountPage;
    BankManagerLoginPage bankManagerLoginPage;


    @BeforeMethod(groups = {"smoke","sanity","regression"})
    public void inIt() {

        homePage = new HomePage();
        addCutomerPage = new AddCutomerPage();
        openAccountPage = new OpenAccountPage();
        customerLoginPage = new CustomerLoginPage();
        customerPage = new CustomerPage();
        accountPage = new AccountPage();
        bankManagerLoginPage = new BankManagerLoginPage();
    }

    @Test(groups = {"smoke","regression"})
    public void bankManagerShouldAddCustomerSuccessfully() throws InterruptedException {
        homePage.clickOnBankManagerLoginTab();
        bankManagerLoginPage.clickOnaddCustomerTab();

        addCutomerPage.enterFirstName("Sam");
        addCutomerPage.enterLastName("Patel");
        addCutomerPage.enterPostCode("HA0 2PT");
        addCutomerPage.clickOnAddCutomerBtn();
        addCutomerPage.alertTextVerify("Customer added successfully with customer id :6");
        addCutomerPage.acceptAlert();
    }

    @Test(groups = {"sanity","regression"})
    public void bankManagerShouldOpenAccountSuccessfully() throws InterruptedException {
        bankManagerShouldAddCustomerSuccessfully();
      //  homePage.clickOnBankManagerLoginTab();
        bankManagerLoginPage.clickOnOpenAccount();

        openAccountPage.selectCustomerDropdown("Sam Patel");
        openAccountPage.selectCurrency("Pound");
        openAccountPage.clickOnProcessBtn();
        openAccountPage.alertAccountTextVerify("Account created successfully with account Number :1016");
        openAccountPage.acceptAlert();
    }

    @Test(groups = {"sanity","regression"})
    public void customerShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        bankManagerShouldOpenAccountSuccessfully();
        openAccountPage.clickOnHomeBtn();

        homePage.clickOnCustomerLogin();

        customerLoginPage.selectUser("Sam Patel");
        customerLoginPage.clickOnLoginBtn();

        customerPage.verifyLogOutTab("Logout");
        customerPage.clickOnLogout();

        customerLoginPage.verifyYourNameText("Your Name :");
    }

    @Test(groups = {"regression"})
    public void customerShouldDepositMoneySuccessfully() throws InterruptedException {
        bankManagerShouldOpenAccountSuccessfully();
        openAccountPage.clickOnHomeBtn();

        homePage.clickOnCustomerLogin();

        customerLoginPage.selectUser("Sam Patel");
        customerLoginPage.clickOnLoginBtn();

        accountPage.clickOnDepositTab();
        accountPage.enterDepositAmount("100");
        accountPage.clickOnDepositBtn();
        accountPage.verifyDepositMsg("Deposit Successful");
    }

    @Test(groups = {"regression"})
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {
      customerShouldDepositMoneySuccessfully();
        openAccountPage.clickOnHomeBtn();
        homePage.clickOnCustomerLogin();

        customerLoginPage.selectUser("Sam Patel");
        customerLoginPage.clickOnLoginBtn();

        accountPage.clickOnWithdrawlTab();
        accountPage.enterWithdrawlAmount("50");
        accountPage.clickOnWithdrawlBtn();
        accountPage.verifyTransactionSuccessfullMsg("Transaction Successful");
    }
}
