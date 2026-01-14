package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import scanalyzer_test.db.LoginUserProvider;
import scanalyzer_test.bo.LoginBO;

import java.time.Duration;

@Listeners({scanalyzer_test.listeners.CustomAllureListener.class, scanalyzer_test.listeners.CustomListener.class})
public class LoginTest extends BaseTest {

    private LoginBO loginBO;

    @Test(
            dataProvider = "users",
            dataProviderClass = LoginUserProvider.class
    )
    public void loginWithValidCredentials(String email, String password) {

        loginBO = new LoginBO(driver);

        loginBO.openLoginPage();
        loginBO.login(email, password);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("/pl/dashboard"));

        Assert.assertTrue(
                loginBO.getCurrentUrl().contains("/pl/dashboard"),
                "Dashboard should be opened after login"
        );

        loginBO.logout();

        Assert.assertTrue(
                loginBO.getCurrentUrl().contains("/pl"),
                "User should be redirected to login page after logout"
        );
    }
}
