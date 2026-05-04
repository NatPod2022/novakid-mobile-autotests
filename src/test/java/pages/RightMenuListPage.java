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
    public final By mishaIcon = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Misha' OR label CONTAINS[cd] 'Misha' OR value CONTAINS[cd] 'Misha'");
    public final By newStudentIcon = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'New student' OR label CONTAINS[cd] 'New student' OR value CONTAINS[cd] 'New student'");
    public final By accountIcon = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Account' OR label CONTAINS[cd] 'Account' OR value CONTAINS[cd] 'Account'");
    public final By subscriptionIcon = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Subscription' OR label CONTAINS[cd] 'Subscription' OR value CONTAINS[cd] 'Subscription'");
    public final By bonusesIcon = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Bonuses' OR label CONTAINS[cd] 'Bonuses' OR value CONTAINS[cd] 'Bonuses'");
    public final By librarySection = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Library' OR label CONTAINS[cd] 'Library' OR value CONTAINS[cd] 'Library'");
    public final By speakingPracticeIcon = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Speaking practice' OR label CONTAINS[cd] 'Speaking practice' OR value CONTAINS[cd] 'Speaking practice'");
    /** Пункт «Help» в правом меню — Inspector: {@code XCUIElementTypeButton}, name == "Help". Точный матч, без CONTAINS — иначе цепляет «Help Center» в Intercom. */
    public final By helpIcon = AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Help\"`]");
    public final By logOutIcon = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Log out' OR label CONTAINS[cd] 'Log out' OR value CONTAINS[cd] 'Log out'");
    public final By goButton = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Go!' OR label CONTAINS[cd] 'Go!' OR value CONTAINS[cd] 'Go!'");

    public RightMenuListPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getPpSection() {
        return waitForElementPresent(ppSection, "Cannot find PP section", 5, true);
    }

    public WebElement getUserName() {
        return waitForElementPresent(userName, "Cannot find user name", 5, true);
    }

    public WebElement getMishaIcon() {
        return waitForElementPresent(mishaIcon, "Cannot find Misha icon", 5, true);
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
