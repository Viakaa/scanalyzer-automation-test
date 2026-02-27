package scanalyzer_test.listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;
import java.util.List;

import static scanalyzer_test.DriverPool.driver;

public class CustomAllureListener implements ITestListener {

    private static final Logger log =
            LoggerFactory.getLogger(CustomAllureListener.class);

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Test SUCCESS: {}", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("Test FAILURE: {}", result.getName(), result.getThrowable());
        if (driver != null) {
            attachScreenshot();
            attachPageSource();
            attachBrowserLogs();
            attachCurrentUrl();
        } else {
            log.warn("Driver is null. Skipping browser-related Allure attachments.");
        }
        attachTestParameters(result);
    }


    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] attachScreenshot() {
        log.info("Attaching screenshot to Allure");
        return ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page source", type = "text/html")
    private String attachPageSource() {
        log.info("Attaching page source to Allure");
        return driver.getPageSource();
    }

    @Attachment(value = "Browser console logs", type = "text/plain")
    private String attachBrowserLogs() {
        log.info("Attaching browser console logs to Allure");
        List<LogEntry> logs = driver.manage().logs()
                .get(LogType.BROWSER)
                .getAll();
        return logs.toString();
    }

    @Attachment(value = "Current URL", type = "text/plain")
    private String attachCurrentUrl() {
        log.info("Attaching current URL to Allure");
        return driver.getCurrentUrl();
    }

    @Attachment(value = "Test parameters", type = "text/plain")
    private String attachTestParameters(ITestResult result) {
        log.info("Attaching test parameters to Allure");
        return Arrays.toString(result.getParameters());
    }
}
