package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/**
 * Favourite teachers screen («Select a teacher», Your favourites counter, teacher card). iOS.
 */
public class FavouriteTeachersPage extends BaseActions {

    public final By backButton = AppiumBy.accessibilityId("navigation.back_button");
    public final By pageTitle = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Select a teacher' OR label CONTAINS[cd] 'Select a teacher' "
                    + "OR name CONTAINS[cd] 'Favourite' OR label CONTAINS[cd] 'Favourite'");
    public final By yourFavouritesLabel = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Your favourite' OR label CONTAINS[cd] 'Your favourite'");
    public final By teacherNameNatTest = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Nat Test' OR label CONTAINS[cd] 'Nat Test' OR name CONTAINS[cd] 'Nat test' OR label CONTAINS[cd] 'Nat test'");
    // Card actions have a teacher.id suffix. These getters select any card, as before.
    public final By teacherCardHeartButton = AppiumBy.iOSNsPredicateString("name BEGINSWITH 'teacher.favorite_button.'");
    public final By readMoreButton = AppiumBy.iOSNsPredicateString("name BEGINSWITH 'teacher.profile_button.'");
    public final By bookLessonButton = AppiumBy.iOSNsPredicateString("name BEGINSWITH 'teacher.book_button.'");

    public FavouriteTeachersPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getBackButton() {
        return waitForElementPresent(backButton, "Cannot find Back button on Favourite teachers", 5, true);
    }

    public WebElement getPageTitle() {
        return waitForElementPresent(pageTitle, "Cannot find Favourite teachers page title", 5, true);
    }

    public WebElement getYourFavouritesLabel() {
        return waitForElementPresent(yourFavouritesLabel, "Cannot find 'Your favourites' label", 5, true);
    }

    public WebElement getTeacherNameNatTest() {
        return waitForElementPresent(teacherNameNatTest, "Cannot find teacher card with name 'Nat Test'", 5, true);
    }

    public WebElement getTeacherCardHeartButton() {
        return waitForElementPresent(teacherCardHeartButton, "Cannot find heart button on teacher card", 5, true);
    }

    public WebElement getReadMoreButton() {
        return waitForElementPresent(readMoreButton, "Cannot find 'Read more' button", 5, true);
    }

    public WebElement getBookLessonButton() {
        return waitForElementPresent(bookLessonButton, "Cannot find 'Book lesson' button", 5, true);
    }
}
