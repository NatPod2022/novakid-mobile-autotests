package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import configuration.TestUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Buy subscription trial page")
class BuySubscriptionTrialTest extends AppiumBaseTest {

    @Test
    @DisplayName("buy subscription trial page shows options and pay button")
    // Test Case #32
    void testBuySubscriptionTrialPageUI() {
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
        // Click Subscription
        pages.rightMenuListPage.getSubscriptionIcon().click();
        // Click on Top up button
        pages.subscriptionTrialPage.getTopUpBalanceButton().click();
        // Validate BuySubscriptionTrialPage UI elements
        pages.buySubscriptionTrialPage.getBackButton();
        pages.buySubscriptionTrialPage.getSubscriptionTitle();
        pages.buySubscriptionTrialPage.getTeacherCategoryStandardButton();
        pages.buySubscriptionTrialPage.getPeriodSixMonthsButton();
        pages.buySubscriptionTrialPage.getLessonsThreePerWeekButton();
        pages.buySubscriptionTrialPage.getBillingTypeTitle();
        pages.buySubscriptionTrialPage.getInstalmentPaymentsValue();
        pages.buySubscriptionTrialPage.getPayInFullValue();
        pages.buySubscriptionTrialPage.getApplyButton();
        pages.buySubscriptionTrialPage.getImmediatelyRadio();
        // Scroll:
        pages.buySubscriptionTrialPage.scrollDown();
        pages.buySubscriptionTrialPage.getSummaryBlock();
        pages.buySubscriptionTrialPage.getPaymentTimelineBlock();
        pages.buySubscriptionTrialPage.getPaymentMethodTitle();
        pages.buySubscriptionTrialPage.getBankCardOption();
        pages.buySubscriptionTrialPage.getConfirmAndPayButton();
    }
}
