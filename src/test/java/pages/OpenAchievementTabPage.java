package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Achievement tab. iOS + Android via accessibility id. */
public class OpenAchievementTabPage extends BaseActions {

    /** Карточка уровня — Inspector: {@code XCUIElementTypeStaticText}, name «Level N: …\nUnit M: …». BEGINSWITH 'Level' + ограничение по типу — иначе CONTAINS цепляет другие элементы (вкладки и т.п.). */
    public final By levelCard = AppiumBy.iOSNsPredicateString(
            "type == 'XCUIElementTypeStaticText' AND (name BEGINSWITH 'Level' OR label BEGINSWITH 'Level')");
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
