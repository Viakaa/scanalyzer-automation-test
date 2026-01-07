package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import scanalyzer_test.po.LoginPage;
import scanalyzer_test.po.RegistrationPage;

public class RegistrationTest extends BaseTest {

    @Test
    public void registrationViaSignUpButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.clickSignUp();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmail("newuser@example.com");
        registrationPage.enterPassword("Password123!");
        registrationPage.enterConfirmPassword("Password123!");
        registrationPage.clickRegister();

        Assert.assertTrue(driver.getCurrentUrl().contains("/en"),
                "After registration, user should be redirected to login page");
    }
}
