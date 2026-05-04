package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Tag("e2e")
@DisplayName("App launch")
class LaunchAppTest extends AppiumBaseTest {

    @Test
    @DisplayName("app launches successfully")
    // Test Case #0
    void appLaunches() {
        assertNotNull(driver, "Driver should be initialized after app launch");
    }

    @Test
    @DisplayName("first screen permission elements are present")
    // Test Case #1
    void firstScreenElementsPresent() {
        // Initialize all page objects via BasePages
        BasePages pages = new BasePages();
        pages.initPages(driver);
        // Check FirstScreenPage elements

        pages.firstScreen.getAllow();
        pages.firstScreen.getDenyButton();
    }
}
