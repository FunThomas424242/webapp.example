package gh.funthomas424242.webapp.selenium.helper;

import java.io.File;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

public class DataFiles extends AbstractPage {

    public DataFiles(final WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    public void open() {
        findElement(By.linkText("Data Files")).click();
    }

    public void pageIsShown() {
        found("Data Files");
    }

    public void uploadFile(final String path) {
        final String absolutePath = new File(path).getAbsolutePath();
        findElement(By.className("wicket-mfu-field")).sendKeys(absolutePath);
        findElement(By.name("uploadButton")).click();
    }

}
