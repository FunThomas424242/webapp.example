Meta:
@author FunThomas424242

Erzählung:
Um die Navigation der Portalseiten zu definieren
Als Entwickler
Möchte ich alle Navigationswege über Stories definieren
Damit ich die Navigation im Integrationstest prüfen kann. 



Szenario: Start Seite anzeigen
Meta:
@themes GUI, integration
Gegeben sei die Webserver Übersichtsseite.
Wenn der erste Link geklickt wird
Dann wird zur Welcome Seite navigiert.

Szenario: Navigation zur Login Seite
Meta:
@themes GUI, integration
Gegeben sei als aktuelle Seite die Startseite (welcome page).
Wenn der Link Anmelden geklickt wird
Dann wird zur Login Seite navigiert.





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


