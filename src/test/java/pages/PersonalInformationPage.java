package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/**
 * Personal information screen. iOS: NSPredicate CONTAINS[cd] on name/label/value
 * (RN/Flutter-friendly — точный {@code accessibility id} часто не совпадает с деревом).
 */
public class PersonalInformationPage extends BaseActions {

    public final By backButton = AppiumBy.accessibilityId("navigation.back_button");
    public final By personalInfoTitle = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Personal information' OR label CONTAINS[cd] 'Personal information' OR value CONTAINS[cd] 'Personal information'");
    public final By phoneNumber = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Phone number' OR label CONTAINS[cd] 'Phone number' OR value CONTAINS[cd] 'Phone number'");
    public final By email = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Email' OR label CONTAINS[cd] 'Email' OR value CONTAINS[cd] 'Email'");
    public final By timeZone = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Time zone' OR label CONTAINS[cd] 'Time zone' OR value CONTAINS[cd] 'Time zone'");
    public final By substituteTeachersImage = AppiumBy.accessibilityId("profile.substitute_teacher_yes_option");
    public final By dontSubstituteTeachersImage = AppiumBy.accessibilityId("profile.substitute_teacher_no_option");
    public final By deleteAccountButton = AppiumBy.accessibilityId("personal_info.remove_account_button");

    public PersonalInformationPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getBackButton() {
        return waitForElementPresent(backButton, "Cannot find 'Back' button", 5, true);
    }

    public WebElement getPersonalInfoTitle() {
        return waitForElementPresent(personalInfoTitle, "Cannot find 'Personal information' title", 5, true);
    }

    public WebElement getPhoneNumber() {
        return waitForElementPresent(phoneNumber, "Cannot find 'Phone number' field", 5, true);
    }

    public WebElement getEmail() {
        return waitForElementPresent(email, "Cannot find 'Email' field", 5, true);
    }

    public WebElement getTimeZone() {
        return waitForElementPresent(timeZone, "Cannot find 'Time zone' field", 5, true);
    }

    public WebElement getSubstituteTeachersImage() {
        return waitForElementPresent(substituteTeachersImage, "Cannot find 'Substitute teachers' image", 5, true);
    }

    public WebElement getDontSubstituteTeachersImage() {
        return waitForElementPresent(dontSubstituteTeachersImage, "Cannot find 'Don't substitute teachers' image", 5, true);
    }

    public WebElement getDeleteAccountButton() {
        return waitForElementPresent(deleteAccountButton, "Cannot find 'Delete account' button", 5, true);
    }
}
