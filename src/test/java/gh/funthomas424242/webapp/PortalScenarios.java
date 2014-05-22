package gh.funthomas424242.webapp;

import gh.funthomas424242.webapp.jbehave.helper.ConfigurationHelper;
import gh.funthomas424242.webapp.jbehave.helper.StoryPfadBuilder;

import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

@RunWith(JUnitReportingRunner.class)
public class PortalScenarios extends JUnitStories {

    private final Configuration configuration;

    public PortalScenarios() {
        super();
        this.configuration = new ConfigurationHelper()
                .getProjectSpecificConfiguration();

        final EmbedderControls embedderControls = configuredEmbedder()
                .embedderControls();
        embedderControls.doBatch(false);
        embedderControls.doGenerateViewAfterStories(true);
        embedderControls.doIgnoreFailureInStories(false);
        embedderControls.doIgnoreFailureInView(false);
        embedderControls.doSkip(false);
        embedderControls.doVerboseFailures(false);
        embedderControls.doVerboseFiltering(false);
        embedderControls.useStoryTimeoutInSecs(300);
        embedderControls.useThreads(1);
    }

    @Override
    public Configuration configuration() {
        return this.configuration;
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new PortalSteps());
    }

    @Override
    protected List<String> storyPaths() {
        final List<String> stories = new StoryFinder().findPaths(
                new StoryPfadBuilder().getStartURL(), "**/*.story", "");
        return stories;
    }

}
