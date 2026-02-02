package scanalyzer_test.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WarehousePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By addZoneButton = By.xpath("//button[text()='Add Zone']");
    private By zoneNameInput = By.id("zone-name");
    private By createZoneButton = By.xpath("//button[@type='submit' and normalize-space()='Create Zone']");
    private By addShelfButton = By.cssSelector("button[title='Add Shelf']");
    private By addItemButton = By.cssSelector("button[title='Add Item']");
    private By itemNameInput = By.id("name");
    private By itemDescriptionInput = By.id("description");
    private By isContainerCheckbox = By.id("isContainer");
    private By createItemButton = By.cssSelector("button[title='Add Item']");
    private By createContainerButton = By.cssSelector("button[title='Add Container']");
    private By zoneName = By.cssSelector("h1.text-2xl.font-bold.text-black");
    private By ItemName = By.cssSelector("span.ml-1.flex-1.truncate.text-sm.text-gray-800");

    public WarehousePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://scanalyzer-warehouse.vercel.app/en/warehouse");
    }

    public void clickAddZone() {
        wait.until(ExpectedConditions.elementToBeClickable(addZoneButton)).click();
    }

    public void enterZoneName(String zoneName) {
        driver.findElement(zoneNameInput).sendKeys(zoneName);
    }

    public void clickCreateZone() {
        wait.until(ExpectedConditions.elementToBeClickable(createZoneButton)).click();
    }

    public void clickAddShelf() {
        wait.until(ExpectedConditions.elementToBeClickable(addShelfButton)).click();
    }

    public void clickAddItem() {
        wait.until(ExpectedConditions.elementToBeClickable(addItemButton)).click();
    }

    public void enterItemName(String itemName) {
        driver.findElement(itemNameInput).sendKeys(itemName);
    }

    public void enterItemDescription(String itemDescription) {
        driver.findElement(itemDescriptionInput).sendKeys(itemDescription);
    }

    public void clickIsContainer() {
        wait.until(ExpectedConditions.elementToBeClickable(isContainerCheckbox)).click();
    }

    public void clickCreateItem() {
        wait.until(ExpectedConditions.elementToBeClickable(createItemButton)).click();
    }

    public void clickCreateContainer() {
        wait.until(ExpectedConditions.elementToBeClickable(createContainerButton)).click();
    }

    public String getZoneNameValue() {
        return driver.findElement(zoneName).getAttribute("value");
    }

    public String getItemNameValue() {
        return driver.findElement(ItemName).getAttribute("value");
    }
}
