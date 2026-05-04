package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
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
        pages.loginStepByEmail.getLogInInputField().click();
        pages.loginStepByEmail.getLogInInputField().sendKeys("np_test@mail.nv");
        pages.loginWithPasswordEmail.getPasswordInputField().click();
        pages.loginWithPasswordEmail.getPasswordInputField().sendKeys("12345678");
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
