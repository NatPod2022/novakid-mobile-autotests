package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import configuration.TestUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Parent critical journey smoke")
class ParentCriticalJourneySmokeTest extends AppiumBaseTest {

    @Test
    @DisplayName("parent can sign in and open key app areas")
    // Test Case #10000 — verify the critical parent journey through key app areas
    void testParentCriticalJourneySmoke() {
        BasePages pages = new BasePages();
        pages.initPages(driver);
        // Click "Allow" if permission prompt is shown
        pages.allowPermission.clickAllowIfVisible();
        // Steps:
        // Check the welcome screen
        pages.preLogin.getWelcomeTitle();
        pages.preLogin.getSubtitleText();
        pages.preLogin.getTryForFreeButton();
        pages.preLogin.getLoginButton();
        // Click "Sign In"
        pages.preLogin.getLoginButton().click();
        // Check the available sign-in options
        pages.logInPageFirstStep.getLogInTitle();
        pages.logInPageFirstStep.getLogInGoogleButton();
        pages.logInPageFirstStep.getLogInEmailPhoneButton();
        pages.logInPageFirstStep.getRegisterButton();
        // Click "Sign In with Email/Phone"
        pages.logInPageFirstStep.getLogInEmailPhoneButton().click();
        // Click "Sign In with Password"
        pages.loginStepByPhone.getLoginWithPasswordPhoneButton().click();
        // Check the password sign-in controls
        pages.loginWithPasswordEmail.getLoginWithAccessCodeButton();
        pages.loginWithPasswordEmail.getForgotPasswordButton();
        // Enter email and password
        TestUsers.TestUser user = TestUsers.afterCancelTrial();
        pages.loginStepByEmail.getLogInInputField().click();
        pages.loginStepByEmail.getLogInInputField().sendKeys(user.email());
        pages.loginWithPasswordEmail.getPasswordInputField().click();
        pages.loginWithPasswordEmail.getPasswordInputField().sendKeys(user.password());
        // Click "Sign In"
        pages.loginWithPasswordEmail.getSignInButton().click();
        // Check the dashboard and bottom navigation
        pages.preTrialDashboard.getLogoParent();
        pages.preTrialDashboard.getTitle();
        pages.preTrialDashboard.getBookButton();
        pages.preTrialDashboard.getDashboardTab();
        pages.preTrialDashboard.getScheduleTab();
        pages.preTrialDashboard.getKaTab();
        pages.preTrialDashboard.getAchievementTab();
        pages.preTrialDashboard.getSupportTab();
        // Open the Schedule tab
        pages.preTrialDashboard.getScheduleTab().click();
        // Check the main Schedule controls
        pages.openScheduleTabPage.getUpcomingTab();
        pages.openScheduleTabPage.getCompletedTab();
        pages.openScheduleTabPage.getBookLessonsButton();
        // Open the Achievements tab
        pages.preTrialDashboard.getAchievementTab().click();
        // Check the student progress control
        pages.openAchievementTabPage.getLevelCard();
        // Return to the Dashboard tab
        pages.preTrialDashboard.getDashboardTab().click();
        // Check that the dashboard is displayed again
        pages.preTrialDashboard.getBookButton();
        // Open the parent menu
        pages.preTrialDashboard.getLogoParent().click();
        // Check the parent menu actions
        pages.rightMenuListPage.getStudentIcon(user.studentId());
        pages.rightMenuListPage.getNewStudentIcon();
        pages.rightMenuListPage.getAccountIcon();
        pages.rightMenuListPage.getSubscriptionIcon();
        pages.rightMenuListPage.getBonusesIcon();
        pages.rightMenuListPage.getLibrarySection();
        pages.rightMenuListPage.getSpeakingPracticeIcon();
        pages.rightMenuListPage.getHelpIcon();
        pages.rightMenuListPage.getLogOutIcon();
        pages.rightMenuListPage.getGoButton();
        // Open the Account page
        pages.rightMenuListPage.getAccountIcon().click();
        // Check the Account page actions
        pages.accountPage.getAccountTitle();
        pages.accountPage.getPersonalInfo();
        pages.accountPage.getChangePassword();
        pages.accountPage.getBalanceHistory();
        pages.accountPage.getPrivacyPolicy();
        pages.accountPage.getTermsAndConditions();
        // Open Balance History
        pages.accountPage.getBalanceHistory().click();
        // Check the Balance History page
        pages.balanceHistoryPage.getBackButton();
        pages.balanceHistoryPage.getBalanceHistoryTitle();
    }
}
