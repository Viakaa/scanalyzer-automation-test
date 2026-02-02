package scanalyzer_test.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditProfilePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By editProfileBUtton = By.xpath("//button[text()='Edit Profile']");
    private By fullNameInput = By.id("name");
    private By locationInput = By.id("location");
    private By saveButton = By.xpath("//button[text()='Save Changes']");

    public EditProfilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://scanalyzer-warehouse.vercel.app/en/profile");
    }

    public void clickEditProfile() {
        wait.until(ExpectedConditions.elementToBeClickable(editProfileBUtton)).click();
    }

    public void clearAndTypeFullName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fullNameInput)).clear();
        driver.findElement(fullNameInput).sendKeys(name);
    }

    public void clearAndTypeLocation(String location) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locationInput)).clear();
        driver.findElement(locationInput).sendKeys(location);
    }

    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

    public String getFullNameValue() {
        return driver.findElement(fullNameInput).getAttribute("value");
    }

    public String getLocationValue() {
        return driver.findElement(locationInput).getAttribute("value");
    }
}

