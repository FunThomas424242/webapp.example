package gh.funthomas424242.webapp.selenium.helper;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

public abstract class AbstractPage extends WebDriverPage {

    abstract public String getPageUrl();

    public AbstractPage(final WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    public boolean isCurrentPage() {
        final String url = this.getCurrentUrl();
        return getPageUrl().equals(url);
    }

    public String findUeberschrift(final String id) {
        return findElement(By.id(id)).getText();
    }

    public AbstractPage getEntryPage() {
        return new EntryPage(getDriverProvider());
    }

    public WelcomePage getWelcomePage() {
        return new WelcomePage(getDriverProvider());
    }

    public AbstractPage getLoginPage() {
        return new LoginPage(getDriverProvider());
    }

    public AbstractPage open() {
        get(getPageUrl());
        manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return this;
    }

    // public void found(final String text) {
    // found(getPageSource(), text);
    // }
    //
    // public void found(final String pageSource, final String text) {
    // if (!pageSource.contains(escapeHtml(text))) {
    // fail("Text: '" + text + "' not found in page '" + pageSource + "'");
    // }
    // }
    //
    // public void found(final List<String> texts) {
    // for (final String text : texts) {
    // found(text);
    // }
    // }
    //
    // public void notFound(final String text) {
    // notFound(getPageSource(), text);
    // }
    //
    // public void notFound(final String pageSource, final String text) {
    // assertThat(pageSource.contains(escapeHtml(text)), is(false));
    // }
    //
    // private String escapeHtml(final String text) {
    // return text.replace("<", "&lt;").replace(">", "&gt;");
    // }

}
