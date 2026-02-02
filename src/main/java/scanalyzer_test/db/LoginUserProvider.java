package scanalyzer_test.db;

import org.testng.annotations.DataProvider;

public class LoginUserProvider {

    @DataProvider(name = "users")
    public static Object[][] users() {
        return new Object[][]{
                {"e@gmail.com", "TestPassword"},
                {"f@gmail.com", "TestPassword112"}
        };
    }
}
