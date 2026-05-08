package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import configuration.TestUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("New schedule UI page (teacher schedule)")
class NewScheduleUITest extends AppiumBaseTest {

    @Test
    @DisplayName("teacher schedule shows title, tabs, time zone and slot rows")
    // Test Case #35 — check visibility of elements on New Schedule UI screen (teacher schedule)
    void testNewScheduleUIPageElements() throws InterruptedException {
        BasePages pages = new BasePages();
        pages.initPages(driver);
        pages.allowPermission.clickAllowIfVisible();
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
        // Schedule tab → Book lessons → Choose teacher
        pages.preTrialDashboard.getScheduleTab().click();
        pages.openScheduleTabPage.getBookLessonsButton().click();
        // Open Favourites via header heart
        Thread.sleep(4_000);
        pages.chooseTeacherPage.getHeaderHeartButton().click();
        // Open teacher schedule via "Book lesson" on favourite teacher card
        pages.favouriteTeachersPage.getBookLessonButton().click();
        // Check all elements on Teacher schedule (New Schedule UI)
        pages.newScheduleUIPage.getBackButton();
        pages.newScheduleUIPage.getTeacherTitle();
        pages.newScheduleUIPage.getTimeZoneLabel();
        pages.newScheduleUIPage.getWeeklyTab();
        pages.newScheduleUIPage.getOneTimeTab();
        pages.newScheduleUIPage.getNoAvailableSlotsLabel();
        pages.newScheduleUIPage.getMoreSlotsButton();
    }
}
