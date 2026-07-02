package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CommonUtils;

public class LoginPage {
    WebDriver driver;
    CommonUtils utils;

    // Constructors
    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.utils = new CommonUtils(driver);
    }

    // Locators
    By username = By.cssSelector("#user-name");
    By password = By.xpath("//form/div[2]/input[@type = 'password']");
    By loginButton = By.xpath("//form/input[@name = 'login-button']");
    By title = By.xpath("//span[@class = 'title']");
    By errorMsg = By.xpath("//h3[@data-test = 'error']");

    // Action Methods
    public void setUsername(String user_name){
        utils.type(username, user_name);
    }
    public void setPassword(String pwd){
        utils.type(password, pwd);
    }
    public void clickLoginButton(){
        utils.click(loginButton);
    }
    public boolean titleDisplayed(){
        return utils.check(title);
    }
    public boolean errorDisplayed(){
        return utils.check(errorMsg);
    }
    public String errorMessage(){
        return utils.getErrorText(errorMsg);
    }
}
