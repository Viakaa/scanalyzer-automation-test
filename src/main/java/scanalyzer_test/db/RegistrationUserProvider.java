package scanalyzer_test.db;

import org.testng.annotations.DataProvider;

public class RegistrationUserProvider {

    @DataProvider(name = "users")
    public static Object[][] users() {
        return new Object[][]{
                {"TestUser", "a@gmail.com", "TestPassword"},
                {"TestUser2","b@gmail.com", "TestPassword112"}
        };
    }
}
