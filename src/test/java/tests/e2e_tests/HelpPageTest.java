package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Help page")
class HelpPageTest extends AppiumBaseTest {

    @Test
    @DisplayName("help page shows sections and articles")
    // Test Case #20 — check visibility of elements on Help screen
    void testHelpPageElements() {
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
        pages.loginStepByEmail.getLogInInputField().click();
        pages.loginStepByEmail.getLogInInputField().sendKeys("np_test@mail.nv");
        pages.loginWithPasswordEmail.getPasswordInputField().click();
        pages.loginWithPasswordEmail.getPasswordInputField().sendKeys("12345678");
        // Click "Sign In"
        pages.loginWithPasswordPhone.getSignInPhoneButton().click();
        // Open right menu
        pages.preTrialDashboard.getLogoParent().click();
        // Click on "Help"
        pages.rightMenuListPage.getHelpIcon().click();
        // Assertions: verify all elements on Help screen
        pages.helpPage.getHelpTitle();
        //pages.helpPage.getCollectionsCount();
        //pages.helpPage.getOrganizeTrialText();
        pages.helpPage.getBookingText();
        pages.helpPage.getBookingArticles();
        pages.helpPage.getManageScheduleText();

        pages.helpPage.getTeachersText();

        pages.helpPage.getTeachersArticles();
        pages.helpPage.getAccountArticles();
    }
}
