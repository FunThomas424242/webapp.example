package gh.funthomas424242.webapp;

import gh.funthomas424242.webapp.selenium.helper.AbstractPage;
import gh.funthomas424242.webapp.selenium.helper.LoginPage;
import gh.funthomas424242.webapp.selenium.helper.WelcomePage;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PortalSteps extends Steps {

    private AbstractPage currentPage;

    public PortalSteps(final AbstractPage page) {
        this.currentPage = page;
    }

    @Given("sei die Webserver Übersichtsseite.")
    public void atServerHome() {
        this.currentPage = this.currentPage.getEntryPage().open();
    }

    @Given("sei als aktuelle Seite die Startseite (welcome page).")
    public void atWeclcomeFile() {
        this.currentPage = this.currentPage.getWelcomePage().open();
    }

    @Given("sei als aktuelle Seite die Loginseite.")
    public void atLoginFile() {
        this.currentPage = this.currentPage.getLoginPage().open();
    }

    @When("der erste Link geklickt wird")
    public void anElementIsAdded() {
        this.currentPage.findElement(By.tagName("a")).click();
    }

    @When("die Seite betrachtet wird")
    public void noOperation() {

    }

    @When("der Link $linkTitel geklickt wird")
    public void anElementIsAdded(final String linkText) {
        this.currentPage.findElement(By.linkText(linkText)).click();
    }

    @Then("enthält diese unter der Id $id eine Überschrift mit folgendem Text $text.")
    public void containsSection(final String id, final String text) {
        final String foundText = this.currentPage.findElement(By.id(id))
                .getText();
        Assert.assertEquals(text, foundText);
    }

    @Then("enthält diese ein Eingabefeld mit Id $id.")
    public void containsSection(final String id) {
        final WebElement field = this.currentPage.findElement(By.id(id));
        Assert.assertNotNull(field);
    }

    @Then("wird zur Welcome Seite navigiert.")
    public void currentPageIsWelcome() {
        Assert.assertEquals(WelcomePage.PAGE_URL,
                this.currentPage.getCurrentUrl());
    }

    @Then("wird zur Login Seite navigiert.")
    public void currentPageIsLogin() {
        Assert.assertEquals(LoginPage.PAGE_URL,
                this.currentPage.getCurrentUrl());
    }

    @Then("wird zur Seite $fileName navigiert.")
    public void theResultingElementShouldBe(final String fileName) {
        Assert.assertEquals(fileName, this.currentPage.getCurrentUrl());
    }

}
