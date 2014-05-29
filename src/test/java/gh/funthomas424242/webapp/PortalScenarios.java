package gh.funthomas424242.webapp;

import gh.funthomas424242.webapp.jbehave.helper.ConfigurationHelper;
import gh.funthomas424242.webapp.jbehave.helper.StoryPfadBuilder;
import gh.funthomas424242.webapp.selenium.helper.AbstractPage;
import gh.funthomas424242.webapp.selenium.helper.EntryPage;

import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.executors.SameThreadExecutors;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.web.selenium.PerStoriesWebDriverSteps;
import org.jbehave.web.selenium.PropertyWebDriverProvider;
import org.jbehave.web.selenium.WebDriverProvider;
import org.jbehave.web.selenium.WebDriverScreenshotOnFailure;
import org.jbehave.web.selenium.WebDriverSteps;
import org.junit.runner.RunWith;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

@RunWith(JUnitReportingRunner.class)
public class PortalScenarios extends JUnitStories {

    private final Configuration configuration;

    private final WebDriverProvider driverProvider = new PropertyWebDriverProvider();
    private final WebDriverSteps lifecycleSteps = new PerStoriesWebDriverSteps(
            this.driverProvider);
    private final AbstractPage pages = new EntryPage(this.driverProvider);

    public PortalScenarios() {

        this.configuration = new ConfigurationHelper()
                .getProjectSpecificConfiguration();

        configuredEmbedder().useExecutorService(
                new SameThreadExecutors().create(configuredEmbedder()
                        .embedderControls()));

        // final EmbedderControls embedderControls = configuredEmbedder()
        // .embedderControls();
        // embedderControls.doBatch(false);
        // embedderControls.doGenerateViewAfterStories(true);
        // embedderControls.doIgnoreFailureInStories(false);
        // embedderControls.doIgnoreFailureInView(false);
        // embedderControls.doSkip(false);
        // embedderControls.doVerboseFailures(false);
        // embedderControls.doVerboseFiltering(false);
        // embedderControls.useStoryTimeoutInSecs(300);
        // embedderControls.useThreads(1);
    }

    @Override
    public Configuration configuration() {
        return this.configuration;
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(this.configuration(), new PortalSteps(
                this.pages), this.lifecycleSteps,
                new WebDriverScreenshotOnFailure(this.driverProvider, this
                        .configuration().storyReporterBuilder()));
    }

    @Override
    protected List<String> storyPaths() {
        final List<String> stories = new StoryFinder().findPaths(
                new StoryPfadBuilder().getStartURL(), "**/*.story", "");
        return stories;
    }

}
