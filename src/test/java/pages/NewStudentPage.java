package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** New student screen. iOS + Android via accessibility id. */
public class NewStudentPage extends BaseActions {

    public final By backButton = AppiumBy.accessibilityId("Back");
    public final By newStudentTitle = AppiumBy.accessibilityId("New student");
    public final By girlRadioButton =
            AppiumBy.iOSNsPredicateString("label CONTAINS[c] 'girl' OR name CONTAINS[c] 'girl'");
    public final By girlLabel =
            AppiumBy.iOSNsPredicateString("label CONTAINS[c] 'girl' OR name CONTAINS[c] 'girl'");
    public final By boyRadioButton =
            AppiumBy.iOSNsPredicateString("label CONTAINS[c] 'boy' OR name CONTAINS[c] 'boy'");
    public final By boyLabel =
            AppiumBy.iOSNsPredicateString("label CONTAINS[c] 'boy' OR name CONTAINS[c] 'boy'");
    public final By firstNameInput =
            AppiumBy.iOSNsPredicateString("label CONTAINS[c] 'Name' OR name CONTAINS[c] 'Nme'");
    public final By dateOfBirthInput =
            AppiumBy.iOSNsPredicateString("label CONTAINS[c] 'date of birth' OR name CONTAINS[c] 'date of birth'");

    public final By addNewChildButton =
            AppiumBy.iOSNsPredicateString("label CONTAINS[c] 'add a new child' OR name CONTAINS[c] 'add a new child'");

    public NewStudentPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getBackButton() {
        return waitForElementPresent(backButton, "Cannot find Back button", 5, true);
    }

    public WebElement getNewStudentTitle() {
        return waitForElementPresent(newStudentTitle, "Cannot find 'New student' title", 5, true);
    }

    public WebElement getGirlRadioButton() {
        return waitForElementPresent(girlRadioButton, "Cannot find 'Girl' radio button", 5, true);
    }

    public WebElement getGirlLabel() {
        return waitForElementPresent(girlLabel, "Cannot find label 'Girl'", 5, true);
    }

    public WebElement getBoyRadioButton() {
        return waitForElementPresent(boyRadioButton, "Cannot find 'Boy' radio button", 5, true);
    }

    public WebElement getBoyLabel() {
        return waitForElementPresent(boyLabel, "Cannot find label 'Boy'", 5, true);
    }

    public WebElement getFirstNameInput() {
        return waitForElementPresent(firstNameInput, "Cannot find first name input", 5, true);
    }

    public WebElement getDateOfBirthInput() {
        return waitForElementPresent(dateOfBirthInput, "Cannot find date of birth input", 5, true);
    }

    public WebElement getAddNewChildButton() {
        return waitForElementPresent(addNewChildButton, "Cannot find 'Add a new child' button", 5, true);
    }
}
