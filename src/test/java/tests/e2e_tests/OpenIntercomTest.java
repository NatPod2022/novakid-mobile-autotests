package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Open Intercom / Support")
class OpenIntercomTest extends AppiumBaseTest {

    @Test
    @DisplayName("intercom support screen shows help and messages")
    // Test Case #12
    void testOpenIntercomElements() {
        // Initialize all page objects via BasePages
        BasePages pages = new BasePages();
        pages.initPages(driver);
        // Tap "Allow" if the button is shown
        pages.allowPermission.clickAllowIfVisible();
        // Steps:
        // Click on LogIn
        pages.preLogin.getLoginButton().click();
        // Click on LogInEmailPhoneButton
        pages.logInPageFirstStep.getLogInEmailPhoneButton().click();
        // Click on LoginWithPasswordButton
        pages.loginStepByPhone.getLoginWithPasswordPhoneButton().click();
        // Insert Email and Password
        pages.loginStepByEmail.getLogInInputField().click();
        pages.loginStepByEmail.getLogInInputField().sendKeys("np_test@mail.nv");
        pages.loginWithPasswordEmail.getPasswordInputField().click();
        pages.loginWithPasswordEmail.getPasswordInputField().sendKeys("12345678");
        // Click on Sign in
        pages.loginWithPasswordPhone.getSignInPhoneButton().click();
        // Tap the Intercom icon
        pages.preTrialDashboard.getSupportTab().click();
        // Assert elements on the Intercom screen
        pages.openIntercomPage.getGreetingText();
        pages.openIntercomPage.getHelpTitle();
        pages.openIntercomPage.getHelpTab();
        pages.openIntercomPage.getMessagesTab();
        pages.openIntercomPage.getSearchInput();
        pages.openIntercomPage.getHelpCenterFooter();
        pages.openIntercomPage.getSendMessageButton();
        pages.openIntercomPage.getScrollArea();
        pages.openIntercomPage.getCloseButton();
    }
}
