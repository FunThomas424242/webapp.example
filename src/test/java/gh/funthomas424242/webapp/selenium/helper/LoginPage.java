package gh.funthomas424242.webapp.selenium.helper;

import org.jbehave.web.selenium.WebDriverProvider;

public class LoginPage extends AbstractPage {

    public static final String PAGE_URL = "http://localhost:8080/webapp.example/login.html";

    public LoginPage(final WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    @Override
    public String getPageUrl() {
        return PAGE_URL;
    }

}
