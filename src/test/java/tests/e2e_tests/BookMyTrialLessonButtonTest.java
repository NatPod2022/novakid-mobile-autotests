package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import configuration.TestUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Book my trial lesson button")
class BookMyTrialLessonButtonTest extends AppiumBaseTest {

    @Test
    @DisplayName("book my trial lesson opens choose teacher screen")
    // Test Case #29
    void testBookMyTrialLessonButton() {
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
        TestUsers.TestUser user = TestUsers.afterCancelTrial();
        pages.loginStepByEmail.getLogInInputField().click();
        pages.loginStepByEmail.getLogInInputField().sendKeys(user.email());
        pages.loginWithPasswordEmail.getPasswordInputField().click();
        pages.loginWithPasswordEmail.getPasswordInputField().sendKeys(user.password());
        // Click on Sign in
        pages.loginWithPasswordPhone.getSignInPhoneButton().click();
        // Click on button
        pages.preTrialDashboard.getBookButton().click();
        // Check all elements on Choose Teacher screen
        pages.chooseTeacherPage.getBackButton();
        pages.chooseTeacherPage.getChooseTeacherTitle();
        pages.chooseTeacherPage.getAvailableTeachersLabel();
        pages.chooseTeacherPage.getReadMoreButton();
        pages.chooseTeacherPage.getBookLessonButton();
    }
}
