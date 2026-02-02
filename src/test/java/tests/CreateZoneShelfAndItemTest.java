package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import scanalyzer_test.bo.WarehouseBO;
import scanalyzer_test.bo.LoginBO;
import scanalyzer_test.db.LoginUserProvider;

import java.time.Duration;

@Listeners({scanalyzer_test.listeners.CustomAllureListener.class, scanalyzer_test.listeners.CustomListener.class})
public class CreateZoneShelfAndItemTest extends BaseTest{

    private LoginBO loginBO;
    private WarehouseBO warehouseBO;

    @Test(
            dataProvider = "users",
            dataProviderClass = LoginUserProvider.class
    )
    public void createZoneShelfAndItemTest(String email, String password){
        loginBO = new LoginBO(driver);
        loginBO.openLoginPage();
        loginBO.login(email, password);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("/dashboard"));

        warehouseBO = new WarehouseBO(driver);
        warehouseBO.openWarehouse();

        String zoneName = "Zone A";
        String itemName = "Hammer";
        String itemDescription = "16oz claw hammer";

        warehouseBO.createZone(zoneName);
        warehouseBO.createShelf();
        warehouseBO.createItem(itemName, itemDescription);
        warehouseBO.createContainer(itemName, itemDescription);

        Assert.assertEquals(
                warehouseBO.getCreateZoneName(),
                zoneName,
                "Zone name must be different"
        );

        Assert.assertEquals(
                warehouseBO.getCreatedItemName(),
                itemName,
                "Item name must be different"
        );

        loginBO.logout();

        Assert.assertTrue(
                loginBO.getCurrentUrl().contains("/en"),
                "User should be redirected to login page after logout"
        );

    }
}
