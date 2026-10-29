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
    // Smoke check; not a separate catalog test case
    void appLaunches() {
        assertNotNull(driver, "Driver should be initialized after app launch");
    }

    @Test
    @DisplayName("first screen permission elements are present")
    // Smoke coverage for the first screen; catalog case #1 is FirstScreenTest
    void firstScreenElementsPresent() {
        // Initialize all page objects via BasePages
        BasePages pages = new BasePages();
        pages.initPages(driver);
        // Check FirstScreenPage elements

        pages.firstScreen.getAllow();
        pages.firstScreen.getDenyButton();
    }
}
