package gh.funthomas424242.webapp.jbehave.helper;

import java.util.ArrayList;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStoryMaps;

public class StoryMap extends JUnitStoryMaps {

    public StoryMap() {
        configuredEmbedder().useMetaFilters(metaFilters());
    }

    @Override
    public Configuration configuration() {
        return new ConfigurationHelper().getProjectSpecificConfiguration();
    }

    @Override
    protected List<String> metaFilters() {
        final ArrayList<String> filters = new ArrayList<String>();
        filters.add("+author *");
        filters.add("themes *");
        filters.add("-skip");
        return filters;
    }

    @Override
    protected List<String> storyPaths() {

        final List<String> stories = new StoryFinder().findPaths(
                new StoryPfadBuilder().getStartURL(), "**/*.story", "");
        return stories;

    }

}
