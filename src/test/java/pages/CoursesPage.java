package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Courses screen opened from the bottom navigation. iOS via accessibility name. */
public class CoursesPage extends BaseActions {

    public final By newSkillsGrowthCoursesText = AppiumBy.accessibilityId("New Skills Growth Courses");

    public CoursesPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getNewSkillsGrowthCoursesText() {
        return waitForElementPresent(newSkillsGrowthCoursesText, "Cannot find 'New Skills Growth Courses' text", 10, true);
    }
}
