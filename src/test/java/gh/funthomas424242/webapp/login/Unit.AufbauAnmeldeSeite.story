Meta:
@author FunThomas424242

Erzählung:
Um die Login Seite implementieren zu können
Als Entwickler
Möchte ich alle Modultests als Stories definieren
Damit ich auch den Modultest mittels BDD automatisiert durchführen kann. 


Szenario: Anmeldeseite Seitenelemente prüfen
Meta:
@skip
@themes GUI, modul
Gegeben sei die Datei login/login.html.
Wenn der Seitentitel lautet Login
Und die Überschrift Ebene1 mit der Id welcome lautet Anmeldung
Wenn das Eingabefeld mit Id user existiert
Und das Passwordfeld mit Id password existiert
Wenn der Button mit der Id ok vom Typ submit und der Beschriftung Anmelden existiert
Dann war der Test erfolgreich.

Szenario: Erfolgreiche Anmeldung
Meta:
@skip
@themes GUI, modul
Gegeben sei die Datei login.html.



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


