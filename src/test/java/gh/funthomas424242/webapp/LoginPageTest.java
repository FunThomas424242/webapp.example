package gh.funthomas424242.webapp;

import java.io.File;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public class LoginPageTest {

    static final WebClient webClient = new WebClient();

    static HtmlPage page;

    @BeforeClass
    public static void init() throws Exception {
        final String userDir = System.getProperty("user.dir");
        final String testDir = userDir + File.separator + "src"
                + File.separator + "main" + File.separator + "webapp"
                + File.separator;
        final String filePath = testDir + "login.html";

        page = webClient.getPage("file:///" + filePath);

    }

    @AfterClass
    public static void tearDown() {
        webClient.closeAllWindows();
    }

    @Test
    public void checkElements() {

        // Titel prüfen
        Assert.assertEquals("Login", LoginPageTest.page.getTitleText());

        // Überschrift prüfen
        final HtmlHeading1 ueberschrift = LoginPageTest.page
                .getHtmlElementById("welcome");
        Assert.assertEquals("Anmeldung", ueberschrift.getTextContent());

        // Eingabefeld user prüfen
        final HtmlTextInput userField = LoginPageTest.page
                .getHtmlElementById("user");
        // Eingabefeld user prüfen
        final HtmlPasswordInput passwordField = LoginPageTest.page
                .getHtmlElementById("password");
        // final HtmlDivision okButton = page.getElementByName("ok");

    }
}
