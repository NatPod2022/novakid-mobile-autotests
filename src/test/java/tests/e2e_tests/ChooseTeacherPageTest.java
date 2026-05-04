package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
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
        pages.loginStepByEmail.getLogInInputField().click();
        pages.loginStepByEmail.getLogInInputField().sendKeys("Auto_Test_schedule@mail.ru");
        pages.loginWithPasswordEmail.getPasswordInputField().click();
        pages.loginWithPasswordEmail.getPasswordInputField().sendKeys("12345678");
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
