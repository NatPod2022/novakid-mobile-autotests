package pages;

import interactions.BaseActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/** Booking options sheet opened from the Schedule tab. */
public class BookingOptionsPage extends BaseActions {

    public final By individualBookingButton =
            AppiumBy.accessibilityId("schedule.book_sheet.individual_button");
    public final By speakingPracticeBookingButton =
            AppiumBy.accessibilityId("schedule.book_sheet.group_button");

    public BookingOptionsPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getIndividualBookingButton() {
        return waitForElementPresent(
                individualBookingButton,
                "Cannot find Individual lessons 'Book' button",
                5,
                true);
    }

    public WebElement getSpeakingPracticeBookingButton() {
        return waitForElementPresent(
                speakingPracticeBookingButton,
                "Cannot find Speaking practice 'Book' button",
                5,
                true);
    }

    public void checkDistinctBookingButtons() {
        WebElement individualButton = getIndividualBookingButton();
        WebElement speakingPracticeButton = getSpeakingPracticeBookingButton();

        Assertions.assertTrue(individualButton.isDisplayed(),
                "Individual lessons 'Book' button is not visible");
        Assertions.assertTrue(individualButton.isEnabled(),
                "Individual lessons 'Book' button is not enabled");
        Assertions.assertTrue(speakingPracticeButton.isDisplayed(),
                "Speaking practice 'Book' button is not visible");
        Assertions.assertTrue(speakingPracticeButton.isEnabled(),
                "Speaking practice 'Book' button is not enabled");
        Assertions.assertNotEquals(individualButton, speakingPracticeButton,
                "Booking option locators identify the same element");
    }
}
