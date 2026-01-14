package scanalyzer_test.db;

import org.testng.annotations.DataProvider;

public class LoginUserProvider {

    @DataProvider(name = "users")
    public static Object[][] users() {
        return new Object[][]{
                {"a@gmail.com", "TestPassword"},
                {"b@gmail.com", "TestPassword112"}
        };
    }
}
