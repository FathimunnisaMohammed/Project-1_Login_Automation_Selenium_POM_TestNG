package org.tests;

import base.BaseTest;
import org.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {
    @Test
    public void validLoginTest(){
        LoginPage lp = new LoginPage(driver);

        lp.setUsername("standard_user");
        lp.setPassword("secret_sauce");
        lp.clickLoginButton();

        Assert.assertTrue(lp.titleDisplayed(), "Login failed");
    }

    @Test
    public void invalidUsernameTest(){
        LoginPage lp = new LoginPage(driver);

        lp.setUsername("invalid_username");
        lp.setPassword("secret_sauce");
        lp.clickLoginButton();

        Assert.assertEquals(lp.errorMessage(), "Epic sadface: Username and password do not match any user in this service");

    }

    @Test
    public void invalidPasswordTest(){
        LoginPage lp = new LoginPage(driver);

        lp.setUsername("standard_user");
        lp.setPassword("invalid_password");
        lp.clickLoginButton();

        Assert.assertEquals(lp.errorMessage(), "Epic sadface: Username and password do not match any user in this service");

    }

    @Test
    public void invalidUsernameAndPasswordTest(){
        LoginPage lp = new LoginPage(driver);

        lp.setUsername("invalid_username");
        lp.setPassword("invalid_password");
        lp.clickLoginButton();

        Assert.assertEquals(lp.errorMessage(), "Epic sadface: Username and password do not match any user in this service");

    }

    @Test
    public void emptyUsernameTest(){
        LoginPage lp = new LoginPage(driver);

        lp.setUsername("");
        lp.setPassword("secret_sauce");
        lp.clickLoginButton();

        Assert.assertEquals(lp.errorMessage(), "Epic sadface: Username is required");

    }

    @Test
    public void emptyPasswordTest(){
        LoginPage lp = new LoginPage(driver);

        lp.setUsername("standard_user");
        lp.setPassword("");
        lp.clickLoginButton();

        Assert.assertEquals(lp.errorMessage(), "Epic sadface: Password is required");

    }

    @Test
    public void emptyLoginTest(){
        LoginPage lp = new LoginPage(driver);

        lp.setUsername("");
        lp.setPassword("");
        lp.clickLoginButton();

        Assert.assertEquals(lp.errorMessage(), "Epic sadface: Username is required");

    }
}
