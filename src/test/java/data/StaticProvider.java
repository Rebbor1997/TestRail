package data;

import org.testng.annotations.DataProvider;

public class  StaticProvider {
    @DataProvider(name = "TestCase")
    public static Object [][] dataForTestCase() {
        return new Object[][] {
                {"number one", "Everything is fine", "step by step", "All right"},
        };
    }
}

