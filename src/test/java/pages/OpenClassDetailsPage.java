package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/**
 * Class details screen — opens after tapping an upcoming lesson tile on Schedule.
 *
 * Visible sections (top → bottom):
 *   • Back button
 *   • Lesson title (e.g. "Lv1.Un0.Ls1 - Magic Academy Level 1 : Trial Lesson - Welcome to Novakid!")
 *   • Date / timezone / "Vika and Nat TEST"
 *   • "Warm-up" section
 *   • "Materials N/37" section
 *   • Action buttons (visible only after scrolling down): "Enter lesson",
 *     "Reschedule lesson", "Cancel the lesson"
 *
 * In TestPad this case is called "OpenClassDetails" [#42].
 */
public class OpenClassDetailsPage extends BaseActions {

    public final By backButton = AppiumBy.iOSNsPredicateString(
            "name == 'Back' OR label == 'Back'");

    /** Lesson title — "Lv1.Un0.Ls1 - Magic Academy Level 1 : Trial Lesson - Welcome to Novakid!". */
    public final By lessonTitle = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Magic Academy' OR label CONTAINS[cd] 'Magic Academy'");

    /** Header sub-label with student + teacher: "Vika and Nat TEST". */
    public final By studentTeacherLabel = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Vika and Nat TEST' OR label CONTAINS[cd] 'Vika and Nat TEST'");

    /** "Warm-up" section header (XCUIElementTypeImage with name="Warm-up"). */
    public final By warmUpSection = AppiumBy.iOSNsPredicateString(
            "name == 'Warm-up' OR label == 'Warm-up'");

    /**
     * "Materials" section header. In Inspector name = "Materials\n1/37" — the counter
     * may change as the student progresses, so we match by prefix only.
     */
    public final By materialsSection = AppiumBy.iOSNsPredicateString(
            "name BEGINSWITH[cd] 'Materials' OR label BEGINSWITH[cd] 'Materials'");

    // --- Action buttons (require scroll down to be visible) ---

    public final By enterLessonButton = AppiumBy.iOSNsPredicateString(
            "name == 'Enter lesson' OR label == 'Enter lesson'");

    public final By rescheduleLessonButton = AppiumBy.iOSNsPredicateString(
            "name == 'Reschedule lesson' OR label == 'Reschedule lesson'");

    public final By cancelTheLessonButton = AppiumBy.iOSNsPredicateString(
            "name == 'Cancel the lesson' OR label == 'Cancel the lesson'");

    public OpenClassDetailsPage(AppiumDriver driver) {
        super(driver);
    }

    // --- Top section getters ---

    public WebElement getBackButton() {
        return waitForElementPresent(backButton, "Cannot find Back button on Class details", 5, true);
    }

    public WebElement getLessonTitle() {
        return waitForElementPresent(lessonTitle, "Cannot find lesson title (Magic Academy ...)", 5, true);
    }

    public WebElement getStudentTeacherLabel() {
        return waitForElementPresent(studentTeacherLabel, "Cannot find 'Vika and Nat TEST' label", 5, true);
    }

    public WebElement getWarmUpSection() {
        return waitForElementPresent(warmUpSection, "Cannot find 'Warm-up' section", 5, true);
    }

    public WebElement getMaterialsSection() {
        return waitForElementPresent(materialsSection, "Cannot find 'Materials' section", 5, true);
    }

    // --- Scroll + bottom action buttons ---

    /** Scrolls the page until the action buttons row is visible. */
    public void scrollToActionButtons() {
        scrollToElement(enterLessonButton);
    }

    public WebElement getEnterLessonButton() {
        return waitForElementPresent(enterLessonButton, "Cannot find 'Enter lesson' button", 5, true);
    }

    public WebElement getRescheduleLessonButton() {
        return waitForElementPresent(rescheduleLessonButton, "Cannot find 'Reschedule lesson' button", 5, true);
    }

    public WebElement getCancelTheLessonButton() {
        return waitForElementPresent(cancelTheLessonButton, "Cannot find 'Cancel the lesson' button", 5, true);
    }
}
