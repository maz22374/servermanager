# Projekt Server Manager

## Synchronisieren des Repositories in einen Ordner

Installiere die neueste Version von [git](https://git-scm.com/downloads) mit den Standardeinstellungen.
Gehe danach in die Windows Eingabeaufforderung (cmd) und führe in einem geeigneten Ordner den Befehl

```
git clone https://github.com/maz22374/servermanager.git
```

Soll der neueste Stand vom Server geladen werden, führe die Datei _resetGit.cmd_ aus. Achtung:
alle lokalen Änderungen werden dabei zurückgesetzt.

## Aufsetzen der Datenbank

Installiere die neuste Version von [Docker](https://www.docker.com/).
Anschließend rufe folgenden Befehl in der Windows Eingabeaufforderung auf, um 
einen MariaDB-Container zu erstellen:
```
docker run --name mariadb -d -p 3306:3306 ^
	-e MARIADB_ROOT_PASSWORD=P@ssw0rd ^
	mariadb:latest
```
Anschließend läuft MariaDB auf dem Port _3306_ (Benutzername: _root_, Passwort: _P@ssw0rd_) und 
ist auf diesem auch erreichbar. Erstelle nun eine Datenbank mit dem Namen _serverdb_.
SQL-Befehl:
```
CREATE DATABASE serverdb;
```

## Starten des Servers

- **Backend:** Rufe im Ordner _server_ den Befehl _mvn spring-boot:run_. Das Backend
  läuft auf _http://localhost:8080_.
- **Frontend:** Rufe im Ordner _serverapp_ den Befehl _npm run start_ auf.

## Deployment der Angular App

Rufe im Ordner _serverapp_ den Befehl _npm run build_ auf. Das Projekt wird
dann in den Ordner _server/src/main/resources/static_ kopiert. Dann liefert das Backend
unter der Adresse _http://localhost:8080_ die Angular App aus.
