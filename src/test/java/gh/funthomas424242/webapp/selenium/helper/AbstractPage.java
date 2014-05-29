package gh.funthomas424242.webapp.selenium.helper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

import java.util.List;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public abstract class AbstractPage extends WebDriverPage {

    public AbstractPage(final WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    public void found(final String text) {
        found(getPageSource(), text);
    }

    public void found(final String pageSource, final String text) {
        if (!pageSource.contains(escapeHtml(text))) {
            fail("Text: '" + text + "' not found in page '" + pageSource + "'");
        }
    }

    public void found(final List<String> texts) {
        for (final String text : texts) {
            found(text);
        }
    }

    public void notFound(final String text) {
        notFound(getPageSource(), text);
    }

    public void notFound(final String pageSource, final String text) {
        assertThat(pageSource.contains(escapeHtml(text)), is(false));
    }

    private String escapeHtml(final String text) {
        return text.replace("<", "&lt;").replace(">", "&gt;");
    }

}
