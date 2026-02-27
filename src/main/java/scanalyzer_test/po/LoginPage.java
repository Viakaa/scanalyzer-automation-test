package scanalyzer_test.po;

import org.openqa.selenium.*;

public class LoginPage  extends BasePage{
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signInButton = By.xpath("//button[text()='Sign In']");
    private By signUpButton = By.xpath("//a[@href='/en/signup']");
    private By errorMessage = By.xpath("//div[contains(text(),'Invalid email or password')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("http://localhost:3000/en");
    }

    public void enterEmail(String email) {
        find(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        find(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        click(signInButton);
    }

    public void clickSignUp() {
        click(signUpButton);
    }

    public boolean isErrorDisplayed() {
        return isVisible(errorMessage);
    }
}


