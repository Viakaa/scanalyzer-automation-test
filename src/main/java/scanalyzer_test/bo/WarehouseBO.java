package scanalyzer_test.bo;

import org.openqa.selenium.WebDriver;
import scanalyzer_test.po.WarehousePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WarehouseBO {

    private WebDriver driver;
    private WarehousePage warehousePage;
    private static final Logger log = LoggerFactory.getLogger(WarehouseBO.class);

    public WarehouseBO(WebDriver driver) {
        this.driver = driver;
        this.warehousePage = new WarehousePage(driver);
    }

    public void openWarehouse() {
        log.info("Opening warehouse page");
        warehousePage.open();
    }

    public void createZone(String zoneName) {
        log.info("Creating zone: {}", zoneName);
        warehousePage.clickAddZone();
        warehousePage.enterZoneName(zoneName);
        warehousePage.clickCreateZone();
    }

    public void createShelf(){
        log.info("Creating shelf");
        warehousePage.clickAddShelf();
    }

    public void createItem(String itemName, String itemDescription){
        log.info("Creating item named: {}",itemName);
        warehousePage.clickAddItem();
        warehousePage.enterItemName(itemName);
        warehousePage.enterItemDescription(itemDescription);
        warehousePage.clickCreateItem();
    }

    public void createContainer(String containerName, String containerDescription){
        log.info("Creating container named: {}",containerName);
        warehousePage.clickAddItem();
        warehousePage.enterItemName(containerName);
        warehousePage.enterItemDescription(containerDescription);
        warehousePage.clickIsContainer();
        warehousePage.clickCreateContainer();
    }

    public String getCreateZoneName() {
        return warehousePage.getZoneNameValue();
    }

    public String getCreatedItemName() {
        return warehousePage.getItemNameValue();
    }

}
