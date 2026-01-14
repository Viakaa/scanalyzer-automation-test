package scanalyzer_test.listeners;

import io.qameta.allure.Allure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;

public class CustomListener
        implements ITestListener, ISuiteListener, IExecutionListener {

    private static final Logger log =
            LoggerFactory.getLogger(CustomListener.class);

    @Override
    public void onStart(ISuite suite) {
        log.info("=== Starting test suite: {} ===", suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        log.info("=== Test suite finished: {} ===", suite.getName());
    }

    @Override
    public void onExecutionStart() {
        log.info("=== TestNG execution started ===");
    }

    @Override
    public void onExecutionFinish() {
        log.info("=== TestNG execution finished ===");
    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info("=== Test started: {} ===", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("=== Test PASSED: {} ===", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("=== Test FAILED: {} ===", result.getName(),
                result.getThrowable());

        Object response = result.getAttribute("responseBody");
        if (response != null) {
            Allure.addAttachment(
                    "API Response",
                    "application/json",
                    response.toString()
            );
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.warn("=== Test SKIPPED: {} ===", result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("=== All tests in '{}' finished ===", context.getName());
    }
}
