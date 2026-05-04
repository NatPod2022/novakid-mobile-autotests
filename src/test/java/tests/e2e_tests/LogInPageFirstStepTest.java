package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Login first step")
class LogInPageFirstStepTest extends AppiumBaseTest {

    @Test
    @DisplayName("login first step shows Sign in title and email/phone button")
    // Test Case #3
    void testLogInPageFirstStep() {
        // Initialize all page objects via BasePages
        BasePages pages = new BasePages();
        pages.initPages(driver);
        pages.allowPermission.clickAllowIfVisible();
        pages.preLogin.getLoginButton().click();
        // Check LogInPageFirstStep elements
        pages.logInPageFirstStep.getLogInTitle();
        pages.logInPageFirstStep.getLogInEmailPhoneButton();
        pages.logInPageFirstStep.getRegisterButton();
    }
}
