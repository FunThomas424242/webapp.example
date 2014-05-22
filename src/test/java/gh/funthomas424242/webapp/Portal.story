Meta:
@author FunThomas424242

Erzählung:
Um Kochrezepte erfassen zu können
Als Koch
Möchte ich alle notwendigen Daten in einer Webanwendung eingeben können
Damit ich diese anschließend als Kochbuch Projekt exportieren kann.

 

Szenario: Startseite

Meta:
@themes GUI

Gegeben sei die laufende Webanwendung
Wenn der URL http://localhost:8080 aufgerufen wird
Dann wird ein Link zur Welcome Seite angezeigt.

Szenario: Welcome Seite

Meta:
@themes GUI

Gegeben sei die laufende Webanwendung
Wenn der URL http://localhost:8080/webapp.example/ aufgerufen wird
Dann wird die Seite http://localhost:8080/webapp.example/index.html angezeigt.


Szenario: Aufbau der Welcome Seite
Meta:
@themes GUI

Gegeben sei die laufende Webanwendung
Wenn der URL http://localhost:8080/webapp.example/index.html aufgerufen wird
Dann wird eine Überschrift mit dem Text Willkommen angezeigt.
