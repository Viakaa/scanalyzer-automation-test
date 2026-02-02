package scanalyzer_test.db;

import org.testng.annotations.DataProvider;

public class RegistrationUserProvider {

    @DataProvider(name = "users")
    public static Object[][] users() {
        return new Object[][]{
                {"TestUser", "e@gmail.com", "TestPassword"},
                {"TestUser2","f@gmail.com", "TestPassword112"}
        };
    }
}
