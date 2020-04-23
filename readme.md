### WYMAGANIA:

-------------------------
1.Przestestowano w określonych warunkach: 
-IntelliJ IDEA wersja enterprise.
-System operacyjny Linux Fedora 29, Linux Mint 19.1, WINDOWS 10
-javac 11.0.1, 12.0.1

Wdrożenie aplikacji jest możliwe z dowolnego IDE, przy wybraniu preferowanej przez siebie wersji jdk oraz systemu operacyjnego.

2.Wymagania niezbędne:
-Zainstalowane JDK
-Serwer aplikacyjny Tomcat 7
-MySQL Database 8.0.13 / Pakiet XAMPP (MariaDB)
-Maven

3.Maven zadba o pobranie bibliotek:

*mysql-connector-java 8.0.15
*javax.servlet-api 4.0.1
*commons-logging 1.2
*spring-beans 4.1.4.RELEASE
*spring-core 4.1.4.RELEASE
*spring-jdbc 4.1.4.RELEASE
*spring-tx 4.1.4.RELEASE
*taglibs-standard-impl 1.2.1
*taglibs-standard-spec 1.2.1


### URUCHOMIENIE BAZY DANYCH:

------------------------
1) LINUX ***
Poprzez interfejs tekstowy w konsoli:
mysql -u <nazwa_użytkownika> -p
Password: <hasło>

w folderze sql/doc znajduje się plik: run-script.txt - zawiera on opis scieżek do plików SQL:
mysql> source <twoja_lokalizacja>/JMTrain/sql/scripts/jmtraindb.sql - polecenie tworzy schemat bazy danych
mysql> source <twoja_lokalizacja>/JMTrain/sql/scripts/insert_jmtraindb.sql - polecenie wstawia przykładowe dane
mysql> source <twoja_lokalizacja>/JMTrain/sql/scripts/show.sql - polecenie wyświela zawartość tabel
mysql> source <twoja_lokalizacja>/JMTrain/delete_jmtrain.sql - polecenie usuwa wszystkie tabele (nie bazę !)

2) WINDOWS 10 ***
Zainstalowany pakiet XAMPP pozwala na skorzystanie z bazy danych MariaDB. Drobne różnice stwarzają konieczność użycia pliku \JMTrain\sql\scripts\jmtraindb_mdb.sql
przy tworzeniu schematu bazy. Konieczna jest też zmiana kodowania, należy zastąpić plik my.ini (\JMTrain\sql\conf\my.ini) w pakiecie XAMPP (\xampp\mysql\bin)

Problemy: by mieć pewność że polecenia INSERT nie sprawią kłopotów, należy je przekopiować w okno konsoli przy inicjacji menadżera bazy w cmd

### URUCHOMIENIE APLIKACJI:

------------------------
1.Na serwerze aplikacyjnym powinny zlaleźć się pliki wysłane tam w postaci pliku .war. 
Foldery określają położenie plików "webapps" lub "work/Catalina/localhost" (w zależności od tego czy wysyłamy pliki przy pomocy interfejsu webowego tomcata czy IDE)

2.Aplikacja po wgraniu plików jest dostępna z poziomu przeglądarki WWW pod adresem "http://<Twoje_IP>/JMTrain" (localhost)
	UWAGA ! Opcja "-Djava.net.preferIPv4Stack=true" (VM Options) wymusza adres IP w wersji IPv4, co jest użyteczne przy testowaniu. 


### PRAWA AUTORSKIE I ŹRÓDŁA:

-------------------------

[Aplikacja zainspirowana tutorial-em: https://javastart.pl/kurs/java-ee]

Program ma charakter edukacyjny, autor nie przewiduje komercyjnych zastosowań. Zachęcam także do kupna
kursu z wyżej wymienionej strony gdzie w pełni wyjaśniono zastosowanie wykorzystanego wzorca projektowego.

Opis instalacji MYSQL na Linux'ie: 
--- https://www.if-not-true-then-false.com/2010/install-mysql-on-fedora-centos-red-hat-rhel/

Opis instalacji JDK 11 na Linux'ie:
--- https://tecadmin.net/install-oracle-java-11-lts-on-centos/

Opis instalacji Tomcat 9 na Linux'ie:
--- https://tecadmin.net/install-apache-tomcat-9-on-centos/


