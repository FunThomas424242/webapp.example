Meta:
@author FunThomas424242

Erzählung:
Um Kochrezepte erfassen zu können
Als Koch
Möchte ich mich am Portal anmelden können
Damit ich die Funktionen der Webanwendung nutzen kann.


Szenario: Erfolgreiche Anmeldung
Meta:
@skip
@themes GUI, integration
Gegeben sei als aktuelle Seite die Loginseite.
Wenn in das Textfeld user der Text Huluvu424242 eingegeben wird
Und in das Passwordfeld password der Text Geheim eingegeben wird
Dann wird die Meldung Ihre Anmeldung war erfolgreich angezeigt.

Szenario: Keine Anmeldung
Meta:
@skip
@themes GUI, integration
Gegeben sei als aktuelle Seite die Loginseite.
Wenn in das Textfeld user nichts eingegeben wird
Und in das Passwordfeld password nichts eingegeben wird
Dann wird die Meldung Ihre Anmeldung war nicht erfolgreich - Bitte prüfen Sie Ihre Zugangsdaten. angezeigt.



Szenario: sonstiges
 // Button mit Hinweis Anmeldung erfolgreich
        // final HtmlLabel okMeldung = (HtmlLabel) page
        // .getHtmlElementById("meldung_ok");
        // Assert.assertEquals("Ihre Anmeldung war erfolgreich.",
        // okMeldung.asText());
        // Assert.assertEquals("hide", okMeldung.getAttribute("visible"));
        //
        // // Button mit Hinweis Anmeldung fehlgeschlagen
        // final HtmlLabel errorMeldung = (HtmlLabel) page
        // .getHtmlElementById("meldung_error");
        // Assert.assertEquals(
        // "Ihre Anmeldung ist nicht erfolgt - bitte Zugangsdaten prüfen.",
        // errorMeldung.asText());
        // Assert.assertEquals("hide", errorMeldung.getAttribute("visible"));




