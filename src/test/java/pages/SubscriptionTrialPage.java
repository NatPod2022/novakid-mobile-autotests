package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Subscription / trial package screen. iOS + Android via accessibility id. */
public class SubscriptionTrialPage extends BaseActions {

    public final By backButton = AppiumBy.accessibilityId("navigation.back_button");
    public final By titlePackage = AppiumBy.accessibilityId("Package");
    public final By titleStandardPackage = AppiumBy.accessibilityId("Standard Package");
    public final By titlePremium = AppiumBy.accessibilityId("Premium");
    public final By price1st = AppiumBy.accessibilityId("1");
    public final By textOr = AppiumBy.accessibilityId("or");
    public final By titleStandard = AppiumBy.accessibilityId("Standard");
    public final By price2nd = AppiumBy.accessibilityId("1");
    public final By topUpBalanceButton = AppiumBy.accessibilityId("balance_info.top_up_balance_button");

    public SubscriptionTrialPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getBackButton() {
        return waitForElementPresent(backButton, "Cannot find Back button", 5, true);
    }

    public WebElement getTitlePackage() {
        return waitForElementPresent(titlePackage, "Cannot find Package title", 5, true);
    }

    public WebElement getTitleStandardPackage() {
        return waitForElementPresent(titleStandardPackage, "Cannot find Standard Package title", 5, true);
    }

    public WebElement getTitlePremium() {
        return waitForElementPresent(titlePremium, "Cannot find Premium title", 5, true);
    }

    public WebElement getPrice1st() {
        return waitForElementPresent(price1st, "Cannot find first price", 5, true);
    }

    public WebElement getTextOr() {
        return waitForElementPresent(textOr, "Cannot find 'or' text", 5, true);
    }

    public WebElement getTitleStandard() {
        return waitForElementPresent(titleStandard, "Cannot find Standard title", 5, true);
    }

    public WebElement getPrice2nd() {
        return waitForElementPresent(price2nd, "Cannot find second price", 5, true);
    }

    public WebElement getTopUpBalanceButton() {
        return waitForElementPresent(topUpBalanceButton, "Cannot find 'Top up balance' button", 5, true);
    }
}
