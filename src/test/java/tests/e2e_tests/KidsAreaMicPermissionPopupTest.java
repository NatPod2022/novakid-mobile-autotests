package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import configuration.TestUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Kids area microphone permission")
class KidsAreaMicPermissionPopupTest extends AppiumBaseTest {

    @Test
    @DisplayName("opening Kids area shows the system microphone permission pop-up")
    // Test Case #50 — KidsAreaMicPermissionPopup; needs a fresh app install (microphone permission not decided yet)
    void testKidsAreaMicPermissionPopup() {
        BasePages pages = new BasePages();
        pages.initPages(driver);
        // Click "Allow" if permission prompt is shown
        pages.allowPermission.clickAllowIfVisible();
        // Steps:
        // Click "Sign In"
        pages.preLogin.getLoginButton().click();
        // Click "Sign In with Email/Phone"
        pages.logInPageFirstStep.getLogInEmailPhoneButton().click();
        // Click "Sign In with Password"
        pages.loginStepByPhone.getLoginWithPasswordPhoneButton().click();
        // Enter email and password
        TestUsers.TestUser user = TestUsers.afterCancelTrial();
        pages.loginStepByEmail.getLogInInputField().click();
        pages.loginStepByEmail.getLogInInputField().sendKeys(user.email());
        pages.loginWithPasswordEmail.getPasswordInputField().click();
        pages.loginWithPasswordEmail.getPasswordInputField().sendKeys(user.password());
        // Click "Sign In"
        pages.loginWithPasswordEmail.getSignInButton().click();
        // Click on the "Kids area" tab
        pages.preTrialDashboard.getKaTab().click();
        // Check:
        pages.kidsAreaPage.checkMicPermissionAlertIsShown();
    }
}
