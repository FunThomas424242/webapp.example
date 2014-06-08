Meta:
@author FunThomas424242

Erzählung:
Um Kochrezepte erfassen zu können
Als Koch
Möchte ich alle notwendigen Daten in einer Webanwendung eingeben können
Damit ich diese anschließend als Kochbuch Projekt exportieren kann.


Szenario: Start Seite anzeigen

Meta:
@themes GUI 
@themes integration


Gegeben sei die Webserver Übersichtsseite.
Wenn der erste Link geklickt wird
Dann wird zur Welcome Seite navigiert.

Szenario: Welcome Seite Kontextbeschreibung

Meta:
@themes GUI


Gegeben sei als aktuelle Seite die Startseite (welcome page).
Wenn die Seite betrachtet wird
Dann enthält diese unter der Id welcome eine Überschrift mit folgendem Text Beispiel Web-Anwendung.


Szenario: Navigation zur Login Seite

Meta:
@themes GUI, integration

Gegeben sei als aktuelle Seite die Startseite (welcome page).
Wenn der Link Anmelden geklickt wird
Dann wird zur Login Seite navigiert.

Szenario: Login Seite Kontextbeschreibung

Meta:
@themes GUI, integration

Gegeben sei als aktuelle Seite die Loginseite.
Wenn die Seite betrachtet wird
Dann enthält diese ein Eingabefeld mit Id user.

Gegeben sei als aktuelle Seite die Loginseite.
Wenn die Seite betrachtet wird
Dann enthält diese ein Eingabefeld mit Id password.

Gegeben sei als aktuelle Seite die Loginseite.
Wenn die Seite betrachtet wird
Dann enthält diese einen Button mit Text Anmelden.



