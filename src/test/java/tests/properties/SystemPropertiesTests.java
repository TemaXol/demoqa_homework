package tests.properties;

import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    void simplePropertyTest() {
        String browserName = System.getProperty("browser");
        System.out.println(browserName);
    }
}
