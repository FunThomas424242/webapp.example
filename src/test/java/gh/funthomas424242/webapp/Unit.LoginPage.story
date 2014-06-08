Meta:
@author FunThomas424242

Erzählung:
Um die Story AufbauPortalSeiten Tests definieren zu können
Als Entwickler
Möchte ich alle Modultests als Stories definieren
Damit ich auch den Modultest mittels BDD automatisiert durchführen kann. 


Szenario: Seitenelemente prüfen
Meta:
@themes GUI, modul
Gegeben sei die Datei login.html.
Wenn der Seitentitel lautet Login
Und die Überschrift Ebene1 mit der Id welcome lautet Anmeldung
Wenn das Eingabefeld mit Id user existiert
Und das Passwordfeld mit Id password existiert
Wenn der Button mit der Id ok vom Typ submit und der Beschriftung Anmelden existiert
Dann waren alle Tests erfolgreich und der Speicher kann bereinigt werden.



