package gh.funthomas424242.webapp.selenium.helper;

import org.jbehave.web.selenium.WebDriverProvider;

public class Pages {

    private final WebDriverProvider driverProvider;
    private Home home;

    private DataFiles dataFiles;
    private FindSteps findSteps;
    private RunStory runStory;

    public Pages(final WebDriverProvider driverProvider) {
        this.driverProvider = driverProvider;
    }

    // Navigationen

    public Home home() {
        if (this.home == null) {
            this.home = new Home(this.driverProvider);
        }
        return this.home;
    }

    public AbstractPage getCurrentPage() {
        return this.home;
    }

    public DataFiles dataFiles() {
        if (this.dataFiles == null) {
            this.dataFiles = new DataFiles(this.driverProvider);
        }
        return this.dataFiles;
    }

    public FindSteps findSteps() {
        if (this.findSteps == null) {
            this.findSteps = new FindSteps(this.driverProvider);
        }
        return this.findSteps;
    }

    public RunStory runStory() {
        if (this.runStory == null) {
            this.runStory = new RunStory(this.driverProvider);
        }
        return this.runStory;
    }

}
