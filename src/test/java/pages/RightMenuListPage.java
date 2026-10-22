package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/**
 * Right menu (PP, Account, Subscription, Library, etc.). iOS: NSPredicate CONTAINS on name/label/value
 * (RN/Flutter-friendly; точный accessibility id часто не совпадает с деревом).
 */
public class RightMenuListPage extends BaseActions {

    public final By ppSection = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'PP' OR label CONTAINS[cd] 'PP' OR value CONTAINS[cd] 'PP'");
    public final By userName = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Podor' OR label CONTAINS[cd] 'Podor' OR value CONTAINS[cd] 'Podor'");
    public final By newStudentIcon = AppiumBy.accessibilityId("profile_menu.add_student_button");
    public final By accountIcon = AppiumBy.accessibilityId("profile_menu.account_button");
    public final By subscriptionIcon = AppiumBy.accessibilityId("profile_menu.subscription_button");
    public final By bonusesIcon = AppiumBy.accessibilityId("profile_menu.bonuses_button");
    public final By librarySection = AppiumBy.accessibilityId("profile_menu.library_button");
    public final By speakingPracticeIcon = AppiumBy.accessibilityId("profile_menu.speaking_practice_button");
    /** Пункт Help в меню, не элементы внешнего Intercom. */
    public final By helpIcon = AppiumBy.accessibilityId("profile_menu.help_button");
    public final By logOutIcon = AppiumBy.accessibilityId("profile_menu.logout_button");
    public final By goButton = AppiumBy.accessibilityId("profile_menu.referral_button");

    public RightMenuListPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getPpSection() {
        return waitForElementPresent(ppSection, "Cannot find PP section", 5, true);
    }

    public WebElement getUserName() {
        return waitForElementPresent(userName, "Cannot find user name", 5, true);
    }

    public WebElement getStudentIcon(String studentId) {
        if (studentId == null || studentId.isBlank()) {
            throw new IllegalArgumentException("Configure studentId for the test account before checking its menu");
        }
        By studentIcon = AppiumBy.accessibilityId("profile_menu.student_item." + studentId);
        return waitForElementPresent(studentIcon, "Cannot find student menu item: " + studentId, 5, true);
    }

    public WebElement getNewStudentIcon() {
        return waitForElementPresent(newStudentIcon, "Cannot find New student icon", 5, true);
    }

    public WebElement getAccountIcon() {
        return waitForElementPresent(accountIcon, "Cannot find Account icon", 5, true);
    }

    public WebElement getBonusesIcon() {
        return waitForElementPresent(bonusesIcon, "Cannot find Bonuses icon", 5, true);
    }

    public WebElement getSubscriptionIcon() {
        return waitForElementPresent(subscriptionIcon, "Cannot find Subscription icon", 5, true);
    }

    public WebElement getLibrarySection() {
        return waitForElementPresent(librarySection, "Cannot find Library section", 5, true);
    }

    public WebElement getSpeakingPracticeIcon() {
        return waitForElementPresent(speakingPracticeIcon, "Cannot find Speaking practice icon", 5, true);
    }

    public WebElement getHelpIcon() {
        return waitForElementPresent(helpIcon, "Cannot find Help icon", 5, true);
    }

    public WebElement getLogOutIcon() {
        return waitForElementPresent(logOutIcon, "Cannot find Log out icon", 5, true);
    }

    public WebElement getGoButton() {
        return waitForElementPresent(goButton, "Cannot find Go button", 5, true);
    }
}
