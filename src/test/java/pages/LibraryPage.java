package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/**
 * Library screen using the semantic identifiers introduced in NPA-8057.
 */
public class LibraryPage extends BaseActions {

    public final By backButton = AppiumBy.accessibilityId("navigation.back_button");
    /**
     * Category identifiers contain a backend section ID, not the category title.
     * Until the Beginners section ID is pinned, match its English label only
     * within category headers, never arbitrary text elsewhere on the screen.
     */
    public final By beginnersGroupsButton = AppiumBy.iOSNsPredicateString(
            "name BEGINSWITH 'content.library_category_item.' AND label CONTAINS[cd] 'Beginner'");

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
