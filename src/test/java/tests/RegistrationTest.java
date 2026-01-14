package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import scanalyzer_test.bo.RegistrationBO;
import scanalyzer_test.db.RegistrationUserProvider;

@Listeners({scanalyzer_test.listeners.CustomAllureListener.class, scanalyzer_test.listeners.CustomListener.class})
public class RegistrationTest extends BaseTest {

    private RegistrationBO registrationBO;

    @Test(
            dataProvider = "users",
            dataProviderClass = RegistrationUserProvider.class
    )
    public void registrationViaSignUpButton(String name, String email, String password) {

        registrationBO = new RegistrationBO(driver);

        registrationBO.openRegistrationFromLogin();
        registrationBO.register(name, email, password);

        Assert.assertTrue(
                registrationBO.getCurrentUrl().contains("/en"),
                "After registration, user should be redirected to login page"
        );
    }
}
