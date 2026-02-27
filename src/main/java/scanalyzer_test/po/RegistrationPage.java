    package scanalyzer_test.po;

    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;

    import java.time.Duration;

    public class RegistrationPage extends BasePage{
        private WebDriver driver;
        private WebDriverWait wait;

        private By nameField = By.id("name");
        private By emailField = By.id("email");
        private By passwordField = By.id("password");
        private By confirmPasswordField = By.id("confirmPassword");
        private By signUpButton = By.xpath("//button[text()='Sign Up']");
        private By errorMessage = By.xpath("//div[contains(text(),'Password must be at least 6 characters long')]");

        public RegistrationPage(WebDriver driver) {
            super(driver);
        }

        public void enterName(String name) {
            find(nameField).sendKeys(name);
        }

        public void enterEmail(String email) {
            find(emailField).sendKeys(email);
        }

        public void enterPassword(String password) {
            find(passwordField).sendKeys(password);
        }

        public void enterConfirmPassword(String password) {
            find(confirmPasswordField).sendKeys(password);
        }

        public void clickRegister() {
            click(signUpButton);
        }

        public boolean isErrorDisplayed() {
            return isVisible(errorMessage);
        }
    }
