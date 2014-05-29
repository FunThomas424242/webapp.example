package gh.funthomas424242.webapp.selenium.helper;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

public class Home extends AbstractPage {

    public Home(final WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    public Home open() {
        get("http://localhost:8080/webapp.example/");
        manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return this;
    }

    public String findUeberschrift(final String id) {
        return findElement(By.id(id)).getText();
    }
}
