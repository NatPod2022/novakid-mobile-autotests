package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/**
 * Library screen. iOS: NSPredicate on name/label/value (RN/Flutter); keep {@code accessibilityId} fallbacks as OR where useful.
 */
public class LibraryPage extends BaseActions {

    public final By backButton = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Back' OR label CONTAINS[cd] 'Back' OR value CONTAINS[cd] 'Back'");
    /**
     * Beginners groups section header — visible title may use hyphen, en dash, or only "Beginners" / "Groups".
     */
    public final By beginnersGroupsButton = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Groups - Beginners' OR label CONTAINS[cd] 'Groups - Beginners' OR value CONTAINS[cd] 'Groups - Beginners' "
                    + "OR name CONTAINS[cd] 'Groups – Beginners' OR label CONTAINS[cd] 'Groups – Beginners' "
                    + "OR name CONTAINS[cd] 'Groups — Beginners' OR label CONTAINS[cd] 'Groups — Beginners' "
                    + "OR name CONTAINS[cd] 'Beginners' OR label CONTAINS[cd] 'Beginners' OR value CONTAINS[cd] 'Beginners' "
                    + "OR ((name CONTAINS[cd] 'Group' OR label CONTAINS[cd] 'Group' OR name CONTAINS[cd] 'Groups' "
                    + "OR label CONTAINS[cd] 'Groups') AND (name CONTAINS[cd] 'Beginner' OR label CONTAINS[cd] 'Beginner'))");

    public LibraryPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getBackButton() {
        return waitForElementPresent(backButton, "Cannot find Back button", 10, true);
    }

    public WebElement getBeginnersGroupsButton() {
        return waitForElementPresent(beginnersGroupsButton, "Cannot find 'Groups - Beginners' button", 5, true);
    }
}
