package gh.funthomas424242.webapp;

import java.util.Stack;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;

public class PortalSteps extends Steps {

    private Stack<String> stackUnderTest;
    private String searchElement;

    @Given("sei ein leerer Stack.")
    public void anEmptyStack() {
        this.stackUnderTest = new Stack<String>();
    }

    @When("keine Operation auf dem Stack ausgeführt wird")
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

    @Then("enthält der Stack $count Elemente.")
    @Alias("enthält der Stack $count Element.")
    public void isEmptyStack(final int count) {
        Assert.assertEquals(count, this.stackUnderTest.size());
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
