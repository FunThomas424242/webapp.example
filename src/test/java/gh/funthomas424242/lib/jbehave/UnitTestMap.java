package gh.funthomas424242.lib.jbehave;

import gh.funthomas424242.webapp.selenium.SeleniumSteps;

import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.junit.JUnitStoryMaps;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.web.selenium.PerStoriesWebDriverSteps;
import org.jbehave.web.selenium.PropertyWebDriverProvider;
import org.jbehave.web.selenium.WebDriverProvider;
import org.jbehave.web.selenium.WebDriverScreenshotOnFailure;
import org.jbehave.web.selenium.WebDriverSteps;

public class UnitTestMap extends JUnitStoryMaps {

    private final Configuration configuration;

    public UnitTestMap() {

        this.configuration = new ConfigurationHelper()
                .getProjectSpecificConfiguration(new ConfigurationHelper()
                        .getUnittestReportBuilder());

        configuredEmbedder().useMetaFilters(metaFilters());
    }

    @Override
    public Configuration configuration() {
        return this.configuration;
    }

    @Override
    protected List<String> metaFilters() {
        return new ConfigurationHelper().getMetaFilters();
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        final WebDriverProvider driverProvider = new PropertyWebDriverProvider();
        final WebDriverSteps lifecycleSteps = new PerStoriesWebDriverSteps(
                driverProvider);
        return new InstanceStepsFactory(this.configuration(),
                new SeleniumSteps(driverProvider), lifecycleSteps,
                new WebDriverScreenshotOnFailure(driverProvider, this
                        .configuration().storyReporterBuilder()));
    }

    @Override
    protected List<String> storyPaths() {
        return new ConfigurationHelper().getUnitStoriesPaths();
    }

}
