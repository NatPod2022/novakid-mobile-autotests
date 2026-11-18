package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import configuration.TestUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Delete account opens support chat")
class DeleteAccountOpensSupportChatTest extends AppiumBaseTest {

    @Test
    @DisplayName("'Delete account' opens the Intercom chat")
    // Test Case #51 — DeleteAccountOpensSupportChat (based on Test Case #22); global app. China flow: Test Case #53
    void testDeleteAccountOpensSupportChat() {
        BasePages pages = new BasePages();
        pages.initPages(driver);
        // Click "Allow" if permission prompt is shown
        pages.allowPermission.clickAllowIfVisible();
        // Steps:
        // Click "Login"
        pages.preLogin.getLoginButton().click();
        // Click "Log In with Email/Phone"
        pages.logInPageFirstStep.getLogInEmailPhoneButton().click();
        // Click "Login with Password"
        pages.loginStepByPhone.getLoginWithPasswordPhoneButton().click();
        // Enter email and password
        TestUsers.TestUser user = TestUsers.afterCancelTrial();
        pages.loginStepByEmail.getLogInInputField().click();
        pages.loginStepByEmail.getLogInInputField().sendKeys(user.email());
        pages.loginWithPasswordEmail.getPasswordInputField().click();
        pages.loginWithPasswordEmail.getPasswordInputField().sendKeys(user.password());
        // Click "Sign In"
        pages.loginWithPasswordPhone.getSignInPhoneButton().click();
        // Open right menu
        pages.preTrialDashboard.getLogoParent().click();
        // Go to Account Page
        pages.rightMenuListPage.getAccountIcon().click();
        // Go to Personal Information
        pages.accountPage.getPersonalInfo().click();
        // Click on "Delete account"
        pages.personalInformationPage.getDeleteAccountButton().click();
        // Check: Intercom chat is opened with "Please ask your question"
        pages.openIntercomPage.getAskYourQuestionText();
    }
}
