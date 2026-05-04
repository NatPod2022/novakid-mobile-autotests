package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Pre-login page")
class PreLoginPageTest extends AppiumBaseTest {

    @Test
    @DisplayName("pre-login page shows welcome title and Sign in button")
    // Test Case #2
    void testPreLoginPage() {
        // Initialize all page objects via BasePages
        BasePages pages = new BasePages();
        pages.initPages(driver);
        // Tap "Allow" if the button is shown
        pages.allowPermission.clickAllowIfVisible();
        // Check PreLoginPage elements
        pages.preLogin.getWelcomeTitle();
        pages.preLogin.getSubtitleText();
        pages.preLogin.getTryForFreeButton();
        pages.preLogin.getLoginButton();
    }
}
