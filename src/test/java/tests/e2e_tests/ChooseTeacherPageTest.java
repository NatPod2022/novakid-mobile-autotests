package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import configuration.TestUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Choose teacher page")
class ChooseTeacherPageTest extends AppiumBaseTest {

    @Test
    @DisplayName("choose teacher page shows title and book button")
    // Test Case #28 — check visibility of elements on Choose Teacher screen
    void testChooseTeacherPageElements() {
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
        TestUsers.TestUser user = TestUsers.schedule();
        pages.loginStepByEmail.getLogInInputField().click();
        pages.loginStepByEmail.getLogInInputField().sendKeys(user.email());
        pages.loginWithPasswordEmail.getPasswordInputField().click();
        pages.loginWithPasswordEmail.getPasswordInputField().sendKeys(user.password());
        // Click "Sign In"
        pages.loginWithPasswordPhone.getSignInPhoneButton().click();
        // Click on Schedule tab
        pages.preTrialDashboard.getScheduleTab().click();
        // Click on Book button
        pages.openScheduleTabPage.getBookLessonsButton().click();
        // Check all elements on Choose Teacher screen
        pages.chooseTeacherPage.getBackButton();
        pages.chooseTeacherPage.getChooseTeacherTitle();
        pages.chooseTeacherPage.getVikaTab();
        pages.chooseTeacherPage.getKirillTab();
        pages.chooseTeacherPage.getHeaderHeartButton();
        pages.chooseTeacherPage.getAvailableTeachersLabel();
        //pages.chooseTeacherPage.getSecondTeacherCardHeartButton();
        pages.chooseTeacherPage.getReadMoreButton();
        pages.chooseTeacherPage.getBookLessonButton();
    }
}
