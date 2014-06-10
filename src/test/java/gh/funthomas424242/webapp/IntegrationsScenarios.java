package gh.funthomas424242.webapp;

import gh.funthomas424242.webapp.jbehave.helper.ConfigurationHelper;
import gh.funthomas424242.webapp.selenium.helper.AbstractPage;
import gh.funthomas424242.webapp.selenium.helper.EntryPage;

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

public class IntegrationsScenarios extends JUnitStories {

    private final WebDriverProvider driverProvider = new PropertyWebDriverProvider();
    private final WebDriverSteps lifecycleSteps = new PerStoriesWebDriverSteps(
            this.driverProvider);
    private final AbstractPage pages = new EntryPage(this.driverProvider);

    final Configuration configuration;

    public IntegrationsScenarios() {
        this.configuration = new ConfigurationHelper()
                .getProjectSpecificConfiguration();

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
        return new InstanceStepsFactory(this.configuration(), new PortalSteps(
                this.pages), this.lifecycleSteps,
                new WebDriverScreenshotOnFailure(this.driverProvider, this
                        .configuration().storyReporterBuilder()));
    }

    @Override
    protected List<String> storyPaths() {
        return new ConfigurationHelper().getIntegrationStoriesPaths();
    }

}
