package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Login step by phone")
class LoginStepByPhoneTest extends AppiumBaseTest {

    @Test
    @DisplayName("login step by phone shows phone index and password button")
    // Test Case #5
    void testLogInStepByPhone() {
        // Initialize all page objects via BasePages
        BasePages pages = new BasePages();
        pages.initPages(driver);
        // Tap "Allow" if the button is shown
        pages.allowPermission.clickAllowIfVisible();
        //* Steps:
        // Click on LogIn
        pages.preLogin.getLoginButton().click();
        // Click on LogInEmailPhoneButton
        pages.logInPageFirstStep.getLogInEmailPhoneButton().click();
        // Click on phoneTab
        pages.loginStepByEmail.getPhoneTab().click();
        // Check LoginStepByEmailPage elements:
        pages.loginStepByPhone.getphoneIndex();
        pages.loginStepByPhone.getLoginWithPasswordPhoneButton();
    }
}
