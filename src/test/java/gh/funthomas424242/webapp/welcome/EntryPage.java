package gh.funthomas424242.webapp.welcome;

import gh.funthomas424242.lib.selenium.SeleniumPage;

import org.jbehave.web.selenium.WebDriverProvider;

public class EntryPage extends SeleniumPage {

    public static final String PAGE_URL = "http://localhost:8080";

    public EntryPage(final WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    

    // public AbstractPage clickLinkByText(final String linkText) {
    // findElement(By.name(linkText)).click();
    // return new WelcomePage(this.getDriverProvider());
    // }

    @Override
    public String getPageUrl() {
        return PAGE_URL;
    }

}
