package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Buy subscription screen. iOS + Android via accessibility id. */
public class BuySubscriptionTrialPage extends BaseActions {

    public final By backButton = AppiumBy.accessibilityId("Back");
    public final By subscriptionTitle = AppiumBy.accessibilityId("Subscription");
    public final By teacherCategoryStandardButton = AppiumBy.iOSNsPredicateString("name BEGINSWITH 'Teacher category'");
    public final By periodSixMonthsButton = AppiumBy.accessibilityId("Subscription period");
    public final By lessonsThreePerWeekButton = AppiumBy.accessibilityId("Lessons");
    public final By billingTypeTitle = AppiumBy.accessibilityId("Billing type");
    public final By instalmentPaymentsValue = AppiumBy.iOSNsPredicateString("name BEGINSWITH 'Instalment payments'");
    public final By payInFullValue = AppiumBy.iOSNsPredicateString("name BEGINSWITH 'Pay in full'");
    public final By applyButton = AppiumBy.accessibilityId("Apply");
    public final By immediatelyRadio = AppiumBy.accessibilityId("Immediately");
    public final By summaryBlock = AppiumBy.iOSNsPredicateString("name BEGINSWITH 'Summary'");
    public final By paymentTimelineBlock = AppiumBy.iOSNsPredicateString("name BEGINSWITH 'Payment timeline'");
    public final By paymentMethodTitle = AppiumBy.iOSNsPredicateString("name BEGINSWITH 'Payment method'");
    public final By bankCardOption = AppiumBy.iOSNsPredicateString("name BEGINSWITH 'Bank card'");
    public final By confirmAndPayButton = AppiumBy.iOSNsPredicateString("name BEGINSWITH 'Confirm and pay'");

    public BuySubscriptionTrialPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getBackButton() {
        return waitForElementPresent(backButton, "Cannot find Back button", 5, true);
    }

    public WebElement getSubscriptionTitle() {
        return waitForElementPresent(subscriptionTitle, "Cannot find 'Subscription' title", 5, true);
    }

    public WebElement getTeacherCategoryStandardButton() {
        return waitForElementPresent(teacherCategoryStandardButton, "Cannot find 'Teacher category Standard' button", 5, true);
    }

    public WebElement getPeriodSixMonthsButton() {
        return waitForElementPresent(periodSixMonthsButton, "Cannot find 'Subscription period 6 months' button", 5, true);
    }

    public WebElement getLessonsThreePerWeekButton() {
        return waitForElementPresent(lessonsThreePerWeekButton, "Cannot find 'Lessons 3 per week' button", 5, true);
    }

    public WebElement getBillingTypeTitle() {
        return waitForElementPresent(billingTypeTitle, "Cannot find 'Billing type' title", 5, true);
    }

    public WebElement getInstalmentPaymentsValue() {
        return waitForElementPresent(instalmentPaymentsValue, "Cannot find 'Instalment payments' value", 5, true);
    }

    public WebElement getPayInFullValue() {
        return waitForElementPresent(payInFullValue, "Cannot find 'Pay in full' value", 5, true);
    }

    public WebElement getApplyButton() {
        return waitForElementPresent(applyButton, "Cannot find 'Apply' button", 5, true);
    }

    public WebElement getImmediatelyRadio() {
        return waitForElementPresent(immediatelyRadio, "Cannot find 'Immediately' radio button", 5, true);
    }

    public WebElement getSummaryBlock() {
        return waitForElementPresent(summaryBlock, "Cannot find Summary block", 5, true);
    }

    public WebElement getPaymentTimelineBlock() {
        return waitForElementPresent(paymentTimelineBlock, "Cannot find Payment timeline block", 5, true);
    }

    public WebElement getPaymentMethodTitle() {
        return waitForElementPresent(paymentMethodTitle, "Cannot find 'Payment method' title", 5, true);
    }

    public WebElement getBankCardOption() {
        return waitForElementPresent(bankCardOption, "Cannot find 'Bank card' option", 5, true);
    }

    public WebElement getConfirmAndPayButton() {
        return waitForElementPresent(confirmAndPayButton, "Cannot find 'Confirm and pay' button", 5, true);
    }
}
