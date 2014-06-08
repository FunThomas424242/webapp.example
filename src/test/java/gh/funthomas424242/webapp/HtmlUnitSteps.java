package gh.funthomas424242.webapp;

import java.io.File;

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
    final String filePathPrefix;

    static HtmlPage page;

    public HtmlUnitSteps() {
        final String userDir = System.getProperty("user.dir");
        final String testDir = userDir + File.separator + "src"
                + File.separator + "main" + File.separator + "webapp"
                + File.separator;
        this.filePathPrefix = testDir;
    }

    @Given("sei die Datei $fileName.")
    public void atFile(final String fileName) throws Exception {
        page = webClient.getPage("file:///" + this.filePathPrefix + fileName);
    }

    @When("der Seitentitel lautet $titel")
    public void anPageTitel(final String titel) {
        Assert.assertEquals(titel, page.getTitleText());
    }

    @When("die Überschrift Ebene1 mit der Id $id lautet $text")
    public void anHeading1(final String id, final String text) {
        final HtmlHeading1 ueberschrift = page.getHtmlElementById("welcome");
        Assert.assertEquals(text, ueberschrift.getTextContent());
    }

    @When("das Eingabefeld mit Id $id existiert")
    public void anInputField(final String id) {
        final HtmlTextInput userField = page.getHtmlElementById(id);
        Assert.assertNotNull(userField);

    }

    @When("das Passwordfeld mit Id $id existiert")
    public void anPasswordField(final String id) {
        final HtmlPasswordInput passwordField = page.getHtmlElementById(id);
        Assert.assertNotNull(passwordField);
    }

    @When("der Button mit der Id $id vom Typ $typ und der Beschriftung $text existiert")
    public void anButton(final String id, final String typ, final String text) {
        final HtmlButton anmeldenButton = (HtmlButton) page
                .getHtmlElementById(id);
        Assert.assertEquals(typ, anmeldenButton.getTypeAttribute());
        Assert.assertEquals(text, anmeldenButton.getTextContent());
    }

    @Then("war der Test erfolgreich.")
    public void theResultingElementShouldBe() {

    }

    @Then("waren alle Tests erfolgreich und der Speicher kann bereinigt werden.")
    public void theAfterClasse() {
        webClient.closeAllWindows();
    }

}
