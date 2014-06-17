Meta:
@author FunThomas424242
Erzählung:
Um die Login Seite implementieren zu können
Als Entwickler
Möchte ich alle Modultests als Stories definieren
Damit ich auch den Modultest mittels BDD automatisiert durchführen kann. 


Szenario: Anmeldeseite Seitenelemente prüfen
Meta:
@themes GUI, modul
Gegeben sei die Datei login/login.html.
Wenn der Seitentitel lautet Login
Und die Überschrift Ebene1 mit der Id welcome lautet Anmeldung
Dann war der Test erfolgreich.

Gegeben sei die Datei login/login.html.
Wenn das Eingabefeld mit Id user existiert
Und das Passwordfeld mit Id password existiert
Dann war der Test erfolgreich.

Gegeben sei die Datei login/login.html.
Wenn der Button mit der Id anmelden vom Typ submit und der Beschriftung Anmelden existiert
Dann war der Test erfolgreich.

