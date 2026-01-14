    package scanalyzer_test.po;

    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;

    import java.time.Duration;

    public class RegistrationPage {
        private WebDriver driver;
        private WebDriverWait wait;

        private By nameField = By.id("name");
        private By emailField = By.id("email");
        private By passwordField = By.id("password");
        private By confirmPasswordField = By.id("confirmPassword");
        private By signUpButton = By.xpath("//button[text()='Sign Up']");

        public RegistrationPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        public void enterName(String name) {
            wait.until(ExpectedConditions.elementToBeClickable(nameField)).sendKeys(name);
        }

        public void enterEmail(String email) {
            driver.findElement(emailField).sendKeys(email);
        }

        public void enterPassword(String password) {
            driver.findElement(passwordField).sendKeys(password);
        }

        public void enterConfirmPassword(String password) {
            driver.findElement(confirmPasswordField).sendKeys(password);
        }

        public void clickRegister() {
            wait.until(ExpectedConditions.elementToBeClickable(signUpButton)).click();
        }
    }
