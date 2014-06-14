package gh.funthomas424242.lib.jbehave;

import gh.funthomas424242.webapp.selenium.SeleniumSteps;

import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.embedder.executors.SameThreadExecutors;
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
public class IntegrationsScenarios extends JUnitStories {

    final Configuration configuration;

    public IntegrationsScenarios() {
        this.configuration = new ConfigurationHelper()
                .getProjectSpecificConfiguration(new ConfigurationHelper()
                        .getInttestReportBuilder());

        final Embedder embedder = configuredEmbedder();
        embedder.useMetaFilters(new ConfigurationHelper().getMetaFilters());

        final EmbedderControls embedderControls = embedder.embedderControls();
        embedderControls.doSkip(false);
        embedder.useExecutorService(new SameThreadExecutors()
                .create(embedderControls));
    }

    @Override
    public Configuration configuration() {
        return this.configuration;
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        final WebDriverProvider driverProvider = new PropertyWebDriverProvider();
        final WebDriverSteps lifecycleSteps = new PerStoriesWebDriverSteps(
                driverProvider);
        final SeleniumSteps steps = new SeleniumSteps(driverProvider);
        return new InstanceStepsFactory(this.configuration(), steps,
                lifecycleSteps, new WebDriverScreenshotOnFailure(
                        driverProvider, this.configuration()
                                .storyReporterBuilder()));
    }

    @Override
    protected List<String> storyPaths() {
        return new ConfigurationHelper().getIntegrationStoriesPaths();
    }

}
