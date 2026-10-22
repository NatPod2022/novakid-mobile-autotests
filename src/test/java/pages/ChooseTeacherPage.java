package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Choose teacher screen. iOS + Android via accessibility id. */
public class ChooseTeacherPage extends BaseActions {

    public final By backButton = AppiumBy.accessibilityId("navigation.back_button");
    public final By chooseTeacherTitle = AppiumBy.iOSNsPredicateString("name BEGINSWITH 'Choose'");
    /** Табы учеников (Inspector: name «Vika Tab 1 of 2», «Kirill Tab 2 of 2»; перевод строки в name учитывается через CONTAINS). */
    public final By vikaTab = AppiumBy.iOSNsPredicateString("name CONTAINS 'Vika' AND name CONTAINS '1 of 2'");
    public final By kirillTab = AppiumBy.iOSNsPredicateString("name CONTAINS 'Kirill' AND name CONTAINS '2 of 2'");
    /** Кнопка избранных учителей в ClassAddScaffold (NPA-8057). */
    public final By headerHeartButton = AppiumBy.accessibilityId("booking.favorite_teachers_button");
    public final By availableTeachersLabel = AppiumBy.iOSNsPredicateString("name BEGINSWITH 'Available'");
    // These getters intentionally select any teacher, as before; the suffix is teacher.id.
    public final By readMoreButton = AppiumBy.iOSNsPredicateString("name BEGINSWITH 'teacher.profile_button.'");
    public final By bookLessonButton = AppiumBy.iOSNsPredicateString("name BEGINSWITH 'teacher.book_button.'");

    public ChooseTeacherPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getBackButton() {
        return waitForElementPresent(backButton, "Cannot find Back button", 5, true);
    }

    public WebElement getChooseTeacherTitle() {
        return waitForElementPresent(chooseTeacherTitle, "Cannot find Choose Teacher title", 5, true);
    }

    public WebElement getVikaTab() {
        return waitForElementPresent(vikaTab, "Cannot find Vika student tab", 5, true);
    }

    public WebElement getKirillTab() {
        return waitForElementPresent(kirillTab, "Cannot find Kirill student tab", 5, true);
    }

    public WebElement getHeaderHeartButton() {
        return waitForElementPresent(headerHeartButton, "Cannot find header heart (favorites) button", 5, true);
    }

    public WebElement getAvailableTeachersLabel() {
        return waitForElementPresent(availableTeachersLabel, "Cannot find Available teachers label", 5, true);
    }

    public WebElement getReadMoreButton() {
        return waitForElementPresent(readMoreButton, "Cannot find Read more button", 5, true);
    }

    public WebElement getBookLessonButton() {
        return waitForElementPresent(bookLessonButton, "Cannot find Book lesson button", 5, true);
    }
}
