package com.srm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {

    WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    By signupLoginBtn = By.linkText("Signup / Login");
    By nameField = By.name("name");
    By emailField = By.xpath("//input[@data-qa='signup-email']");
    By signupBtn = By.xpath("//button[@data-qa='signup-button']");

    By titleMr = By.id("id_gender1");
    By titleMrs = By.id("id_gender2");
    By password = By.id("password");
    By days = By.id("days");
    By months = By.id("months");
    By years = By.id("years");

    By firstName = By.id("first_name");
    By lastName = By.id("last_name");
    By companyField = By.id("company");
    By address = By.id("address1");
    By state = By.id("state");
    By city = By.id("city");
    By zipcode = By.id("zipcode");
    By mobile = By.id("mobile_number");

    By createAccountBtn = By.xpath("//button[@data-qa='create-account']");
    By continueBtn = By.xpath("//a[@data-qa='continue-button']");

    public void clickSignupLogin() {
        driver.findElement(signupLoginBtn).click();
    }

    public void enterSignupNameEmail(String name, String email) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(signupBtn).click();
    }

    public void fillAccountInfo(String passwordValue, String day, String month, String year) {
        driver.findElement(titleMrs).click();
        driver.findElement(password).sendKeys(passwordValue);
        driver.findElement(days).sendKeys(day);
        driver.findElement(months).sendKeys(month);
        driver.findElement(years).sendKeys(year);
    }

    public void fillAddressInfo(String first, String last, String company,
                                String addr, String cityVal,
                                String stateVal, String zip, String mobileVal) {

        driver.findElement(firstName).sendKeys(first);
        driver.findElement(lastName).sendKeys(last);
        driver.findElement(companyField).sendKeys(company);
        driver.findElement(address).sendKeys(addr);
        driver.findElement(city).sendKeys(cityVal);
        driver.findElement(state).sendKeys(stateVal);
        driver.findElement(zipcode).sendKeys(zip);
        driver.findElement(mobile).sendKeys(mobileVal);
    }

    public void clickCreateAccount() {
        driver.findElement(createAccountBtn).click();
    }

    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }
}