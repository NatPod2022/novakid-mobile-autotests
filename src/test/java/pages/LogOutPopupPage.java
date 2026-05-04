package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Log out confirmation popup. iOS + Android via accessibility id. */
public class LogOutPopupPage extends BaseActions {

    //public final By popupText = AppiumBy.accessibilityId("Log out?");
    public final By confirmLogoutButton =
            AppiumBy.iOSNsPredicateString("label CONTAINS[c] 'log out' OR name CONTAINS[c] 'log out'");
    public final By cancelButton =
            AppiumBy.iOSNsPredicateString("label CONTAINS[c] 'cancel' OR name CONTAINS[c] 'cancel'");
    public final By popupText =
            AppiumBy.iOSNsPredicateString("label CONTAINS[c] 'log out' OR name CONTAINS[c] 'log out'");

    public LogOutPopupPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getPopupText() {
        return waitForElementPresent(popupText, "Cannot find logout confirmation text", 5, true);
    }

    public WebElement getCancelButton() {
        return waitForElementPresent(cancelButton, "Cannot find 'Cancel' button", 5, true);
    }

    public WebElement getConfirmLogoutButton() {
        return waitForElementPresent(confirmLogoutButton, "Cannot find 'Yes, log out' button", 5, true);
    }
}
