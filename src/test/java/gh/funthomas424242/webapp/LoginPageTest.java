package gh.funthomas424242.webapp;

import java.io.File;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

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

        Assert.assertEquals("Login", LoginPageTest.page.getTitleText());

        final HtmlHeading1 ueberschrift = LoginPageTest.page
                .getHtmlElementById("welcome");

        Assert.assertEquals("Anmeldung", ueberschrift.getTextContent());

        // final HtmlDivision okButton = page.getElementByName("ok");

    }
}
