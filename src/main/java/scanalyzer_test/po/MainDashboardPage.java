package scanalyzer_test.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainDashboardPage extends BasePage {

    private By logoutButton = By.xpath("//button[normalize-space()='Logout']");
    private By dashboardHeader = By.cssSelector("h1");

    public MainDashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDashboardOpened() {
        return isVisible(dashboardHeader);
    }

    public void logout() {
        click(logoutButton);
    }
}