package gh.funthomas424242.webapp;

import gh.funthomas424242.webapp.jbehave.helper.ConfigurationHelper;

import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.embedder.executors.SameThreadExecutors;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

//@RunWith(JUnitReportingRunner.class)
public class ModulScenarios extends JUnitStories {

    final Configuration configuration;

    public ModulScenarios() {
        this.configuration = new ConfigurationHelper()
                .getProjectSpecificConfiguration();

        final Embedder embedder = configuredEmbedder();
        embedder.useMetaFilters(new ConfigurationHelper().getMetaFilters());

        final EmbedderControls embedderControls = embedder.embedderControls();
        embedderControls.doSkip(false);
        // embedderControls.doVerboseFiltering(true);
        embedder.useExecutorService(new SameThreadExecutors()
                .create(embedderControls));

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
        return new ConfigurationHelper().getUnitStoriesPaths();
    }

}
