package scanalyzer_test.bo;

import org.openqa.selenium.WebDriver;
import scanalyzer_test.po.LoginPage;
import scanalyzer_test.po.RegistrationPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegistrationBO {

    private WebDriver driver;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private static final Logger log = LoggerFactory.getLogger(RegistrationBO.class);

    public RegistrationBO(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
        this.registrationPage = new RegistrationPage(driver);
    }

    public void openRegistrationFromLogin() {
        log.info("Opening registration page");
        loginPage.open();
        loginPage.clickSignUp();
    }

    public void register(String name, String email, String password) {
        log.info("Signing up as user: {}", email);
        registrationPage.enterName(name);
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
        registrationPage.enterConfirmPassword(password);
        registrationPage.clickRegister();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
