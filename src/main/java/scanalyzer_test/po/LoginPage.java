package scanalyzer_test.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signInButton = By.xpath("//button[text()='Sign In']");
    private By signUpButton = By.xpath("//a[@href='/signup']");
    private By logoutButton = By.xpath("//button[normalize-space()='Logout']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void open() {
        driver.get("https://scanalyzer-warehouse.vercel.app/en");
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }

    public void clickSignUp() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton)).click();
    }

    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }
}
