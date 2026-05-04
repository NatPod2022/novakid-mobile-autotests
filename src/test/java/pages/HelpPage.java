package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Help screen. iOS + Android via accessibility id. */
public class HelpPage extends BaseActions {

    public final By backButton = AppiumBy.accessibilityId("Back");
    public final By helpTitle = AppiumBy.accessibilityId("Help");
    public final By collectionsCount = AppiumBy.accessibilityId("9 collections");
    public final By organizeTrialText = AppiumBy.accessibilityId("Organize or adjust your trial lesson");
    public final By bookingText = AppiumBy.accessibilityId("Booking, moving or cancelation of a lesson");
    public final By bookingArticles = AppiumBy.accessibilityId("4 articles");
    public final By manageScheduleText = AppiumBy.accessibilityId("Manage Your Schedule");
    public final By manageScheduleDescription = AppiumBy.accessibilityId("Managing lessons");
    public final By manageScheduleArticles = AppiumBy.accessibilityId("1 article");
    public final By subscriptionText = AppiumBy.accessibilityId("Subscription, Bonuses & Payments");
    public final By subscriptionArticles = AppiumBy.accessibilityId("9 articles");
    public final By techSupportText = AppiumBy.accessibilityId("Tech recommendations");
    public final By techSupportArticles = AppiumBy.accessibilityId("2 articles");
    public final By teachersText = AppiumBy.accessibilityId("Teachers");
    public final By teachersDescription = AppiumBy.accessibilityId("Managing your Novakid teacher");
    public final By teachersArticles = AppiumBy.accessibilityId("1 article");
    public final By accountText = AppiumBy.accessibilityId("Your Novakid account");
    public final By accountDescription = AppiumBy.accessibilityId("Guidance to your account");
    public final By accountArticles = AppiumBy.accessibilityId("1 article");

    public HelpPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getBackButton() {
        return waitForElementPresent(backButton, "Cannot find Back button", 5, true);
    }

    public WebElement getHelpTitle() {
        return waitForElementPresent(helpTitle, "Cannot find 'Help' title", 5, true);
    }

    public WebElement getCollectionsCount() {
        return waitForElementPresent(collectionsCount, "Cannot find '9 collections' text", 5, true);
    }

    public WebElement getOrganizeTrialText() {
        return waitForElementPresent(organizeTrialText, "Cannot find 'Organize or adjust your trial lesson' text", 5, true);
    }

    public WebElement getBookingText() {
        return waitForElementPresent(bookingText, "Cannot find booking text", 5, true);
    }

    public WebElement getBookingArticles() {
        return waitForElementPresent(bookingArticles, "Cannot find '4 articles' text", 5, true);
    }

    public WebElement getManageScheduleText() {
        return waitForElementPresent(manageScheduleText, "Cannot find 'Manage Your Schedule' text", 5, true);
    }

    public WebElement getManageScheduleDescription() {
        return waitForElementPresent(manageScheduleDescription, "Cannot find schedule description", 5, true);
    }

    public WebElement getManageScheduleArticles() {
        return waitForElementPresent(manageScheduleArticles, "Cannot find '1 article' under schedule", 5, true);
    }

    public WebElement getSubscriptionText() {
        return waitForElementPresent(subscriptionText, "Cannot find subscription text", 5, true);
    }

    public WebElement getSubscriptionArticles() {
        return waitForElementPresent(subscriptionArticles, "Cannot find '9 articles'", 5, true);
    }

    public WebElement getTechSupportText() {
        return waitForElementPresent(techSupportText, "Cannot find tech support text", 5, true);
    }

    public WebElement getTechSupportArticles() {
        return waitForElementPresent(techSupportArticles, "Cannot find tech support articles", 5, true);
    }

    public WebElement getTeachersText() {
        return waitForElementPresent(teachersText, "Cannot find 'Teachers' text", 5, true);
    }

    public WebElement getTeachersDescription() {
        return waitForElementPresent(teachersDescription, "Cannot find teachers description", 5, true);
    }

    public WebElement getTeachersArticles() {
        return waitForElementPresent(teachersArticles, "Cannot find teachers articles count", 5, true);
    }

    public WebElement getAccountArticles() {
        return waitForElementPresent(accountArticles, "Cannot find account articles count", 5, true);
    }
}
