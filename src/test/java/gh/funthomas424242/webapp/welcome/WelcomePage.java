package gh.funthomas424242.webapp.welcome;

import gh.funthomas424242.lib.selenium.SeleniumPage;

import org.jbehave.web.selenium.WebDriverProvider;

public class WelcomePage extends SeleniumPage {

    public static final String PAGE_URL = "http://localhost:8080/webapp.example/";

    public WelcomePage(final WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    @Override
    public String getPageUrl() {
        return PAGE_URL;
    }
}
