package gh.funthomas424242.webapp;

import gh.funthomas424242.webapp.selenium.helper.AbstractPage;
import gh.funthomas424242.webapp.selenium.helper.Pages;

import java.util.Stack;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.openqa.selenium.By;

public class PortalSteps extends Steps {

    private final Pages pages;
    private AbstractPage currentPage;

    public PortalSteps(final Pages pages) {
        this.pages = pages;
    }

    private Stack<String> stackUnderTest;
    private String searchElement;

    @Given("sei als aktuelle Seite die Startseite.")
    public void navHome() {
        this.currentPage = this.pages.home().open();
    }

    @When("die Seite betrachtet wird")
    public void noOperation() {

    }

    @When("das Element $element hinzugefügt wird")
    public void anElementIsAdded(final String element) {
        this.stackUnderTest.push(element);
    }

    @When("das oberste Element vom Stack entfernt wird")
    public void removeLastElement() {
        this.stackUnderTest.pop();
    }

    @When("das Element $element gesucht wird")
    public void searchForElement(final String element) {
        this.searchElement = element;
    }

    @Then("enthält diese unter der $id eine Überschrift mit folgendem Text $text.")
    public void containsSection(final String id, final String text) {
        final String foundText = this.currentPage.findElement(By.id(id))
                .getText();
        Assert.assertEquals(text, foundText);
    }

    @Then("liegt das Element $word ganz oben auf dem Stack.")
    public void theResultingElementShouldBe(final String word) {
        Assert.assertEquals(1, this.stackUnderTest.search(word));
    }

    @Then("ist die erwartete Position $pos.")
    public void thePositionReturnedShouldBe(final int pos) {
        Assert.assertEquals(pos, this.stackUnderTest.search(this.searchElement));
    }
}
