package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Speaking practice screen. iOS + Android via accessibility id. */
public class SpeakingPracticePage extends BaseActions {

    /** Header text may appear in name, label, or value (RN/Flutter). */
    public final By titleText = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Fluent in English' OR label CONTAINS[cd] 'Fluent in English' OR value CONTAINS[cd] 'Fluent in English' OR name CONTAINS[cd] 'Fluent'");
    public final By subtitleText = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'speaking' OR label CONTAINS[cd] 'speaking'");
    public final By ageGroup4to6 = AppiumBy.iOSNsPredicateString(
            "name CONTAINS '4' AND name CONTAINS '6' AND name CONTAINS 'y.o'");
    public final By ageGroup7to9 = AppiumBy.iOSNsPredicateString(
            "name CONTAINS '7' AND name CONTAINS '9' AND name CONTAINS 'y.o'");
    public final By ageGroup10to13 = AppiumBy.iOSNsPredicateString(
            "name CONTAINS '10' AND name CONTAINS '13' AND name CONTAINS 'y.o'");
    public final By joinNowButton = AppiumBy.iOSNsPredicateString("name CONTAINS[cd] 'Join' OR label CONTAINS[cd] 'Join'");
    public final By videoPreviewImage = AppiumBy.iOSNsPredicateString("name CONTAINS[cd] 'Video' OR label CONTAINS[cd] 'Video'");
    public final By globeImage = AppiumBy.iOSNsPredicateString("name CONTAINS[cd] 'globe' OR label CONTAINS[cd] 'globe'");

    public SpeakingPracticePage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getTitleText() {
        return waitForElementPresent(titleText, "Cannot find title text", 15, true);
    }

    public WebElement getSubtitleText() {
        return waitForElementPresent(subtitleText, "Cannot find subtitle text", 15, true);
    }

    public WebElement getAgeGroup4to6() {
        return waitForElementPresent(ageGroup4to6, "Cannot find age group 4–6", 15, true);
    }

    public WebElement getAgeGroup7to9() {
        return waitForElementPresent(ageGroup7to9, "Cannot find age group 7–9", 15, true);
    }

    public WebElement getAgeGroup10to13() {
        return waitForElementPresent(ageGroup10to13, "Cannot find age group 10–13", 15, true);
    }

    public WebElement getJoinNowButton() {
        return waitForElementPresent(joinNowButton, "Cannot find 'Join Now' button", 15, true);
    }

    public WebElement getVideoPreviewImage() {
        return waitForElementPresent(videoPreviewImage, "Cannot find video preview image", 15, true);
    }

    public WebElement getGlobeImage() {
        return waitForElementPresent(globeImage, "Cannot find globe image", 15, true);
    }
}
