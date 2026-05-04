package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Intercom / Support screen. iOS + Android via accessibility id / label. */
public class OpenIntercomPage extends BaseActions {

    public final By profileImage = AppiumBy.iOSNsPredicateString("name CONTAINS 'Profile image'");
    public final By greetingText = AppiumBy.iOSNsPredicateString("name CONTAINS 'Hi'");
    public final By helpTitle = AppiumBy.iOSNsPredicateString("name CONTAINS 'How can we help?'");
    public final By helpTab = AppiumBy.iOSNsPredicateString("name BEGINSWITH 'Help'");
    public final By messagesTab = AppiumBy.iOSNsPredicateString("name BEGINSWITH 'Messages'");
    public final By searchInput = AppiumBy.iOSNsPredicateString("name CONTAINS 'Search for help'");
    public final By articleDiscount = AppiumBy.iOSNsPredicateString("name CONTAINS 'How To Get and Use a Discount'");
    public final By articleBooking = AppiumBy.iOSNsPredicateString("name CONTAINS 'How to book lessons'");
    public final By articleLessonTypes = AppiumBy.iOSNsPredicateString("name CONTAINS 'Standard and Premium Lessons'");
    public final By articlePrices = AppiumBy.iOSNsPredicateString("name CONTAINS 'Where can i see prices'");
    public final By helpCenterFooter = AppiumBy.iOSNsPredicateString("name CONTAINS 'Novakid Help Center'");
    public final By sendMessageButton = AppiumBy.iOSNsPredicateString("name CONTAINS 'Send us a message'");
    public final By scrollArea = AppiumBy.className("XCUIElementTypeScrollView");
    public final By closeButton = AppiumBy.iOSNsPredicateString("name CONTAINS 'Close'");

    public OpenIntercomPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getProfileImage() {
        return waitForElementPresent(profileImage, "Cannot find profile image", 5, true);
    }

    public WebElement getGreetingText() {
        return waitForElementPresent(greetingText, "Cannot find greeting text", 5, true);
    }

    public WebElement getHelpTitle() {
        return waitForElementPresent(helpTitle, "Cannot find help title", 5, true);
    }

    public WebElement getHelpTab() {
        return waitForElementPresent(helpTab, "Cannot find Help tab", 5, true);
    }

    public WebElement getMessagesTab() {
        return waitForElementPresent(messagesTab, "Cannot find Messages tab", 5, true);
    }

    public WebElement getSearchInput() {
        return waitForElementPresent(searchInput, "Cannot find search input", 5, true);
    }

    public WebElement getArticleDiscount() {
        return waitForElementPresent(articleDiscount, "Cannot find article 'Discount'", 5, true);
    }

    public WebElement getArticleBooking() {
        return waitForElementPresent(articleBooking, "Cannot find article 'Booking'", 5, true);
    }

    public WebElement getArticleLessonTypes() {
        return waitForElementPresent(articleLessonTypes, "Cannot find article 'Lesson types'", 5, true);
    }

    public WebElement getArticlePrices() {
        return waitForElementPresent(articlePrices, "Cannot find article 'Prices'", 5, true);
    }

    public WebElement getHelpCenterFooter() {
        return waitForElementPresent(helpCenterFooter, "Cannot find help center footer", 5, true);
    }

    public WebElement getSendMessageButton() {
        return waitForElementPresent(sendMessageButton, "Cannot find 'Send us a message' button", 5, true);
    }

    public WebElement getScrollArea() {
        return waitForElementPresent(scrollArea, "Cannot find scroll area", 5, true);
    }

    public WebElement getCloseButton() {
        return waitForElementPresent(closeButton, "Cannot find Close button", 5, true);
    }
}
