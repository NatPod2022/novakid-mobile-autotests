package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Achievement tab. iOS + Android via accessibility id. */
public class OpenAchievementTabPage extends BaseActions {

    /** NPA-8057 student progress button; mapping to the level card awaits device verification. */
    public final By levelCard = AppiumBy.accessibilityId("achievements.student_progress_button");
    public final By exercisesToDo = AppiumBy.iOSNsPredicateString("name CONTAINS 'Exercises to do:'");

    public OpenAchievementTabPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getLevelCard() {
        return waitForElementPresent(levelCard, "Cannot find Level card", 5, true);
    }

    public WebElement getExercisesToDo() {
        return waitForElementPresent(exercisesToDo, "Cannot find 'Exercises to do' element", 5, true);
    }
}
