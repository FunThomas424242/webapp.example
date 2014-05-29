package gh.funthomas424242.webapp.selenium.helper;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

public class RunStory extends AbstractPage {

    public RunStory(final WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    public void open() {
        findElement(By.linkText("Run Story")).click();
    }

    public void pageIsShown() {
        found("Story Input");
    }

    public void run(final String story) {
        findElement(By.name("input")).sendKeys(story);
        findElement(By.name("runButton")).click();
    }

    public void runIsSuccessful(final int timeoutInSecs) {
        waitFor(timeoutInSecs);

        final String output = findElement(By.id("storyOutput")).getText();

        assertTrue("Scenario should have been in story output",
                output.contains("Scenario"));
        assertFalse("Nothing should have failed", output.contains("FAILED"));
        assertFalse("Nothing should be pending", output.contains("PENDING"));

    }

    private void waitFor(final int timeoutInSecs) {
        try {
            TimeUnit.SECONDS.sleep(timeoutInSecs);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }

}
