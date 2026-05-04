package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("First screen")
class FirstScreenTest extends AppiumBaseTest {

    @Test
    @DisplayName("first screen shows permission container and buttons")
    // Test Case #1
    void testFirstScreen() {
        // Initialize all page objects via BasePages
        BasePages pages = new BasePages();
        pages.initPages(driver);
        // Check FirstScreenPage elements
        pages.firstScreen.getAllow();
        pages.firstScreen.getDenyButton();
    }
}
