package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import scanalyzer_test.po.LoginPage;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.enterEmail("test@example.com");
        loginPage.enterPassword("Password123!");
        loginPage.clickLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.urlContains("/pl/dashboard"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/pl/dashboard"),
                "Dashboard should be opened after login");
    }
}