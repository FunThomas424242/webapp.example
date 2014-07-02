package gh.funthomas424242.lib.htmlunit;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public class HtmlUnitSteps extends Steps {

    static final WebClient webClient = new WebClient();

    String filePathPrefix;

    protected HtmlPage page;

    public HtmlUnitSteps(final String pathPräfix) {
        this.filePathPrefix = pathPräfix;
    }

    @BeforeScenario
    public void setUpStory() {

    }

    @AfterScenario
    public void tearDownStory() {
        webClient.closeAllWindows();
    }

    @Given("sei die Datei $fileName.")
    public void atFile(final String fileName) throws Exception {
        this.page = webClient.getPage(this.filePathPrefix + fileName);
    }

    @When("der Seitentitel lautet $titel")
    public void anPageTitel(final String titel) {
        Assert.assertEquals(titel, this.page.getTitleText());
    }

    @When("die Überschrift Ebene1 mit der Id $id lautet $text")
    public void anHeading1(final String id, final String text) {
        final HtmlHeading1 ueberschrift = this.page
                .getHtmlElementById("welcome");
        Assert.assertEquals(text, ueberschrift.getTextContent());
    }

    @When("das Eingabefeld mit Id $id existiert")
    public void anInputField(final String id) {
        final HtmlTextInput userField = this.page.getHtmlElementById(id);
        Assert.assertNotNull(userField);
    }

    @When("das Passwordfeld mit Id $id existiert")
    public void anPasswordField(final String id) {
        final HtmlPasswordInput passwordField = this.page
                .getHtmlElementById(id);
        Assert.assertNotNull(passwordField);
    }

    @When("der Button mit der Id $id vom Typ $typ und der Beschriftung $text existiert")
    public void anButton(final String id, final String typ, final String text) {
        final HtmlButton anmeldenButton = (HtmlButton) this.page
                .getHtmlElementById(id);
        Assert.assertEquals(typ, anmeldenButton.getTypeAttribute());
        Assert.assertEquals(text, anmeldenButton.getTextContent());
    }

    @Then("war der Test erfolgreich.")
    public void theResultingElementShouldBe() {

    }

}
