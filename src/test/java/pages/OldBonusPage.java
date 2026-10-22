package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Bonuses / Invite friends screen. iOS + Android via accessibility id. */
public class OldBonusPage extends BaseActions {

    /**
     * Подзаголовок приглашения друзей: проверяем устойчивую часть текста без полного совпадения.
     */
    public final By inviteFriendsText = AppiumBy.iOSClassChain(
            "**/XCUIElementTypeStaticText[`name CONTAINS[cd] \"Invite your friends\" OR label CONTAINS[cd] \"Invite your friends\"`]");

    public OldBonusPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getInviteFriendsText() {
        return waitForElementPresent(inviteFriendsText, "Cannot find 'Invite friends' text", 10, true);
    }
}
