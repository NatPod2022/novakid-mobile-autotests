package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/**
 * Google account chooser screen that opens in Safari (SFSafariViewController)
 * after tapping "Add all lessons" on the Calendar sync detail screen.
 *
 * Screen text is rendered by Google sign-in and depends on the device/browser locale,
 * so each localized locator includes both English and Russian variants.
 * The "novakidschool.com" button is locale-independent and works as the primary anchor.
 *
 * In TestPad this case is called "GoogleSyncOpenFromAccount" [#38].
 */
public class GoogleSyncOpenFromAccountPage extends BaseActions {

    /** Locale-independent anchor — target domain button shown under the title. */
    public final By novakidSchoolDomainButton = AppiumBy.iOSNsPredicateString(
            "name == 'novakidschool.com' OR label == 'novakidschool.com'");

    /** Top header: "Sign in with Google account" / "Вход через аккаунт Google". */
    public final By googleSignInHeader = AppiumBy.iOSNsPredicateString(
            "name BEGINSWITH[cd] 'Sign in' OR name BEGINSWITH[cd] 'Вход'"
                    + " OR label BEGINSWITH[cd] 'Sign in' OR label BEGINSWITH[cd] 'Вход'");

    /** Page title: "Choose an account" / "Выберите аккаунт". */
    public final By chooseAccountTitle = AppiumBy.iOSNsPredicateString(
            "name BEGINSWITH[cd] 'Choose an account' OR name BEGINSWITH[cd] 'Выберите'"
                    + " OR label BEGINSWITH[cd] 'Choose an account' OR label BEGINSWITH[cd] 'Выберите'");

    /** "Use another account" option at the bottom of the list. */
    public final By useAnotherAccountOption = AppiumBy.iOSNsPredicateString(
            "name BEGINSWITH[cd] 'Use another' OR name BEGINSWITH[cd] 'Использовать'"
                    + " OR label BEGINSWITH[cd] 'Use another' OR label BEGINSWITH[cd] 'Использовать'");

    public GoogleSyncOpenFromAccountPage(AppiumDriver driver) {
        super(driver);
    }

    /** First check after Safari opens — bumped timeout because the page may need time to load. */
    public WebElement getNovakidSchoolDomainButton() {
        return waitForElementPresent(novakidSchoolDomainButton,
                "Cannot find 'novakidschool.com' button on Google sign-in screen", 15, true);
    }

    public WebElement getGoogleSignInHeader() {
        return waitForElementPresent(googleSignInHeader,
                "Cannot find Google sign-in header", 5, true);
    }

    public WebElement getChooseAccountTitle() {
        return waitForElementPresent(chooseAccountTitle,
                "Cannot find 'Choose an account' title", 5, true);
    }

    public WebElement getUseAnotherAccountOption() {
        return waitForElementPresent(useAnotherAccountOption,
                "Cannot find 'Use another account' option", 5, true);
    }
}
