package gh.funthomas424242.lib.jbehave;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.failures.PassingUponPendingStep;
import org.jbehave.core.failures.RethrowingFailure;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.AbsolutePathCalculator;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.io.UnderscoredCamelCaseResolver;
import org.jbehave.core.parsers.RegexPrefixCapturingPatternParser;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.FreemarkerViewGenerator;
import org.jbehave.core.reporters.PrintStreamStepdocReporter;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.MarkUnmatchedStepsAsPending;
import org.jbehave.core.steps.ParameterControls;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.SilentStepMonitor;
import org.jbehave.core.steps.StepFinder;
import org.jbehave.web.selenium.ContextView;
import org.jbehave.web.selenium.LocalFrameContextView;
import org.jbehave.web.selenium.SeleniumConfiguration;
import org.jbehave.web.selenium.SeleniumContext;
import org.jbehave.web.selenium.SeleniumStepMonitor;
import org.jbehave.web.selenium.WebDriverProvider;

import com.thoughtworks.paranamer.NullParanamer;

public class ConfigurationHelper {

    public Configuration getCommonDefaultConfiguration() {

        final Configuration configuration = new Configuration() {
        };
        // configuration.doDryRun(false); "no dry run" is implicit by using
        // default StoryControls

        // configuration.useDefaultStoryReporter(new ConsoleOutput());
        // deprecated -- rather use StoryReportBuilder

        configuration.useFailureStrategy(new RethrowingFailure());
        configuration.useKeywords(new LocalizedKeywords(Locale.ENGLISH));
        configuration.usePathCalculator(new AbsolutePathCalculator());
        configuration.useParameterControls(new ParameterControls());
        configuration.useParameterConverters(new ParameterConverters());
        configuration.useParanamer(new NullParanamer());
        configuration.usePendingStepStrategy(new PassingUponPendingStep());
        configuration.useStepCollector(new MarkUnmatchedStepsAsPending());
        configuration.useStepdocReporter(new PrintStreamStepdocReporter());
        configuration.useStepFinder(new StepFinder());
        configuration.useStepMonitor(new SilentStepMonitor());
        configuration
                .useStepPatternParser(new RegexPrefixCapturingPatternParser());
        configuration.useStoryControls(new StoryControls());
        configuration.useStoryLoader(new LoadFromClasspath());
        configuration.useStoryParser(new RegexStoryParser(configuration
                .keywords()));
        configuration.useStoryPathResolver(new UnderscoredCamelCaseResolver());
        configuration.useStoryReporterBuilder(new StoryReporterBuilder());
        configuration.useViewGenerator(new FreemarkerViewGenerator());
        return configuration;
    }

    public Configuration getProjectSpecificConfiguration() {

        final Configuration configuration = new Configuration() {
        };
        // configuration.doDryRun(false); "no dry run" is implicit by using
        // default StoryControls

        // configuration.useDefaultStoryReporter(new ConsoleOutput());
        // deprecated -- rather use StoryReportBuilder

        configuration.useFailureStrategy(new RethrowingFailure());
        configuration.useKeywords(new LocalizedKeywords(Locale.GERMAN));
        configuration.usePathCalculator(new AbsolutePathCalculator());
        configuration.useParameterControls(new ParameterControls());
        configuration.useParameterConverters(new ParameterConverters());
        configuration.useParanamer(new NullParanamer());
        configuration.usePendingStepStrategy(new PassingUponPendingStep());
        configuration.useStepCollector(new MarkUnmatchedStepsAsPending());
        configuration.useStepdocReporter(new PrintStreamStepdocReporter());
        configuration.useStepFinder(new StepFinder());
        configuration.useStepMonitor(new SilentStepMonitor());
        configuration
                .useStepPatternParser(new RegexPrefixCapturingPatternParser());
        configuration.useStoryControls(new StoryControls());
        configuration.useStoryLoader(new LoadFromClasspath());
        configuration.useStoryParser(new RegexStoryParser(configuration
                .keywords()));
        configuration.useStoryPathResolver(new UnderscoredCamelCaseResolver());
        configuration.useStoryReporterBuilder(getReportBuilder());
        configuration.useViewGenerator(new FreemarkerViewGenerator());
        return configuration;
    }

    private StoryReporterBuilder getReportBuilder() {
        return new StoryReporterBuilder().withRelativeDirectory("site/jbehave")
        // .withCodeLocation(
        // CodeLocations
        // .codeLocationFromClass(embeddableClass))

                // .withDefaultFormats()
                // .withViewResources(viewResources)

                .withFormats(Format.STATS, Format.HTML, Format.TXT, Format.XML)

        // , Format.CONSOLE)
        // .withFailureTrace(true).withFailureTraceCompression(true)
        // .withCrossReference(this.xref)
        ;
    }

    public Configuration getSeleniumConfiguration() {
        final SeleniumConfiguration configuration = new SeleniumConfiguration() {
        };
        final SeleniumContext seleniumContext = new SeleniumContext();
        final WebDriverProvider webDriverProvider = new org.jbehave.web.selenium.PropertyWebDriverProvider();
        final ContextView contextView = new LocalFrameContextView().sized(500,
                100);

        // configuration.useSelenium(selenium);
        configuration.useSeleniumContext(seleniumContext);
        configuration.useWebDriverProvider(webDriverProvider);
        configuration.useStepMonitor(new SeleniumStepMonitor(contextView,
                seleniumContext, new SilentStepMonitor()));
        //
        configuration.useStoryReporterBuilder(getReportBuilder());
        return configuration;
    }

    public List<String> getMetaFilters() {
        final ArrayList<String> filters = new ArrayList<String>();
        filters.add("+author *");
        filters.add("themes *");
        filters.add("-skip");
        return filters;
    }

    public List<String> getUnitStoriesPaths() {
        final List<String> stories = new StoryFinder().findPaths(
                new StoryPfadBuilder().getStartURL(),
                StoryPfadBuilder.UNIT_STORY_PATTERN, "");
        return stories;
    }

    public List<String> getIntegrationStoriesPaths() {
        final List<String> stories = new StoryFinder().findPaths(
                new StoryPfadBuilder().getStartURL(),
                StoryPfadBuilder.INTEGRATION_STORY_PATTERN, "");
        return stories;
    }

}
