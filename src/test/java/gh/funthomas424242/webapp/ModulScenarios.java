package gh.funthomas424242.webapp;

import gh.funthomas424242.webapp.jbehave.helper.ConfigurationHelper;
import gh.funthomas424242.webapp.jbehave.helper.StoryPfadBuilder;

import java.util.ArrayList;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.embedder.executors.SameThreadExecutors;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

@RunWith(JUnitReportingRunner.class)
public class ModulScenarios extends JUnitStories {

    final Configuration configuration;

    public ModulScenarios() {
        this.configuration = new ConfigurationHelper()
                .getProjectSpecificConfiguration();

        final Embedder embedder = configuredEmbedder();
        embedder.useMetaFilters(metaFilters());

        final EmbedderControls embedderControls = embedder.embedderControls();
        embedderControls.doSkip(false);
        // embedderControls.doVerboseFiltering(true);
        embedder.useExecutorService(new SameThreadExecutors()
                .create(embedderControls));

    }

    protected List<String> metaFilters() {
        final ArrayList<String> filters = new ArrayList<String>();
        filters.add("+author *");
        filters.add("themes *");
        filters.add("-skip");
        return filters;
    }

    @Override
    public Configuration configuration() {
        return this.configuration;
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(this.configuration(),
                new HtmlUnitSteps(), this.configuration()
                        .storyReporterBuilder());
    }

    @Override
    protected List<String> storyPaths() {
        final List<String> stories = new StoryFinder().findPaths(
                new StoryPfadBuilder().getStartURL(),
                StoryPfadBuilder.UNIT_STORY_PATTERN, "");
        return stories;
    }

}
