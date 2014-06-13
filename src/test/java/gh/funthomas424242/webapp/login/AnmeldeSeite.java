package gh.funthomas424242.webapp.login;

import gh.funthomas424242.lib.selenium.SeleniumPage;

import org.jbehave.web.selenium.WebDriverProvider;

public class AnmeldeSeite extends SeleniumPage {

    public static final String PAGE_URL = "http://localhost:8080/webapp.example/login/login.html";

    public AnmeldeSeite(final WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    @Override
    public String getPageUrl() {
        return PAGE_URL;
    }

}
