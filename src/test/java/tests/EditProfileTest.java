package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import scanalyzer_test.bo.EditProfileBO;
import scanalyzer_test.bo.LoginBO;
import scanalyzer_test.db.LoginUserProvider;

import java.time.Duration;

@Listeners({scanalyzer_test.listeners.CustomAllureListener.class, scanalyzer_test.listeners.CustomListener.class})
public class EditProfileTest extends BaseTest {

    private LoginBO loginBO;
    private EditProfileBO editProfileBO;

    @Test(
            dataProvider = "users",
            dataProviderClass = LoginUserProvider.class
    )
    public void editProfileTest(String email, String password){
        loginBO = new LoginBO(driver);
        loginBO.openLoginPage();
        loginBO.login(email, password);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("/dashboard"));

        editProfileBO = new EditProfileBO(driver);
        editProfileBO.openEditPage();

        String fullName = "Test Name";
        String location = "Sweden";

        editProfileBO.updateProfile(fullName, location);

        Assert.assertEquals(
                editProfileBO.getUpdatedFullName(),
                fullName,
                "Full name should be updated"
        );

        Assert.assertEquals(
                editProfileBO.getUpdatedLocation(),
                location,
                "Location should be updated"
        );

        loginBO.logout();

        Assert.assertTrue(
                loginBO.getCurrentUrl().contains("/"),
                "User should be redirected to login page after logout"
        );
    }


}

