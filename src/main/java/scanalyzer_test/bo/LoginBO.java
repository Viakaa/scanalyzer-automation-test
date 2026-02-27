package scanalyzer_test.bo;

import org.openqa.selenium.WebDriver;
import scanalyzer_test.po.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scanalyzer_test.po.MainDashboardPage;

public class LoginBO {

    private WebDriver driver;
    private LoginPage loginPage;
    private static final Logger log = LoggerFactory.getLogger(LoginBO.class);
    private final MainDashboardPage mainDashboardPage;

    public LoginBO(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
        this.mainDashboardPage = new MainDashboardPage(driver);
    }

    public void openLoginPage() {
        log.info("Opening login page");
        loginPage.open();
    }

    public void login(String email, String password) {
        log.info("Logging in as user: {}", email);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    public void logout() {
        log.info("Logging out");
        mainDashboardPage.logout();
    }

    public boolean isLoginFailed() {
        return loginPage.isErrorDisplayed();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}


