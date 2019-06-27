<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style type="text/css">
            h1, h2 {
                text-align: center;
                padding: 1%;
                background-color: red;
                color: white;
            }
            a {
                text-decoration: none;
                text-underline: none;
                color: white;
            }
            h2:hover {
                background-color: #2aabd2;
            }
        </style>
    </head>
    <body>
        <h1>-- JMTrain v. 0.3 --</h1>
        <ul>
            <li>Twoja przeglądarka: ${header['user-agent'] }</li>
            <li>Twój adres IP: <%= request.getRemoteAddr() %></li>
            <li>Rola: ${sessionScope.user.role}</li>
        </ul>
        <!-- VM Options -Djava.net.preferIPv4Stack=true -->
        <h2><a href="start">START</a></h2>
        <script src="${pageContext.request.contextPath}/resources/js/sessionCounter.js"></script>

        <h3>WYMAGANIA:</h3>
        <h4>1.Przestestowano w określonych warunkach:</h4>
        <ul>
            <li>IntelliJ IDEA wersja enterprise.</li>
            <li>System operacyjny Linux Fedora 29, Linux Mint 19.1, WINDOWS 10</li>
            <li>javac 11.0.1, 12.0.1</li>
        </ul>

        <p>Wdrożenie aplikacji jest możliwe z dowolnego IDE, przy wybraniu preferowanej przez siebie wersji jdk oraz systemu operacyjnego.</p>

        <h4>2.Wymagania niezbędne:</h4>
        <ul>
            <li>Zainstalowane JDK</li>
            <li>Serwer aplikacyjny Tomcat 7</li>
            <li>MySQL Database 8.0.13 / Pakiet XAMPP (MariaDB)</li>
            <li>Maven</li>
        </ul>
        <h4>3.Maven zadba o pobranie bibliotek:</h4>

        <ul>
            <li>*mysql-connector-java 8.0.15</li>
            <li>*javax.servlet-api 4.0.1</li>
            <li>*commons-logging 1.2</li>
            <li>*spring-beans 4.1.4.RELEASE</li>
            <li>*spring-core 4.1.4.RELEASE</li>
            <li>*spring-jdbc 4.1.4.RELEASE</li>
            <li>*spring-tx 4.1.4.RELEASE</li>
            <li>*taglibs-standard-impl 1.2.1</li>
            <li>*taglibs-standard-spec 1.2.1</li>
        </ul>

        <h3>URUCHOMIENIE BAZY DANYCH:</h3>
        <h4>1) LINUX ***</h4>
        <p>
            Poprzez interfejs tekstowy w konsoli:<br />
            mysql -u <nazwa_użytkownika> -p Password: <hasło>
        </p>

        <p>
            w folderze sql/doc znajduje się plik: run-script.txt - zawiera on opis scieżek do plików SQL:<br />
            mysql> source <twoja_lokalizacja>/JMTrain/sql/scripts/jmtraindb.sql - polecenie tworzy schemat bazy danych<br />
            mysql> source <twoja_lokalizacja>/JMTrain/sql/scripts/insert_jmtraindb.sql - polecenie wstawia przykładowe dane<br />
            mysql> source <twoja_lokalizacja>/JMTrain/sql/scripts/show.sql - polecenie wyświela zawartość tabel<br />
            mysql> source <twoja_lokalizacja>/JMTrain/delete_jmtrain.sql - polecenie usuwa wszystkie tabele (nie bazę !)<br />
        </p>

        <h4>2) WINDOWS 10 ***</h4>
        <p>
            Zainstalowany pakiet XAMPP pozwala na skorzystanie z bazy danych MariaDB. Drobne różnice stwarzają konieczność użycia pliku \JMTrain\sql\scripts\jmtraindb_mdb.sql
            przy tworzeniu schematu bazy. Konieczna jest też zmiana kodowania, należy zastąpić plik my.ini (\JMTrain\sql\conf\my.ini) w pakiecie XAMPP (\xampp\mysql\bin)
        </p>
        <p>
            Problemy: by mieć pewność że polecenia INSERT nie sprawią kłopotów, należy je przekopiować w okno konsoli przy inicjacji menadżera bazy w cmd.
        </p>

        <h3>URUCHOMIENIE APLIKACJI:</h3>
        <ul>
            <li>1.Na serwerze aplikacyjnym powinny zlaleźć się pliki wysłane tam w postaci pliku .war.
                Foldery określają położenie plików "webapps" lub "work/Catalina/localhost" (w zależności od tego czy wysyłamy pliki przy pomocy interfejsu webowego tomcata czy IDE)
            </li>
            <li>2.Aplikacja po wgraniu plików jest dostępna z poziomu przeglądarki WWW pod adresem "http://<Twoje_IP>/JMTrain" (localhost)
                UWAGA ! Opcja "-Djava.net.preferIPv4Stack=true" (VM Options) wymusza adres IP w wersji IPv4, co jest użyteczne przy testowaniu.
            </li>
        </ul>

        <h3>PRAWA AUTORSKIE I ŹRÓDŁA:</h3>

        <p>[Aplikacja zainspirowana tutorial-em: https://javastart.pl/kurs/java-ee]</p>

        <p>Program ma charakter edukacyjny, autor nie przewiduje komercyjnych zastosowań. Zachęcam także do kupna
        kursu z wyżej wymienionej strony gdzie w pełni wyjaśniono zastosowanie wykorzystanego wzorca projektowego.</p>

        <ul>
            <li>
                Opis instalacji MYSQL na Linux'ie:
                --- https://www.if-not-true-then-false.com/2010/install-mysql-on-fedora-centos-red-hat-rhel/
            </li>
            <li>
                Opis instalacji JDK 11 na Linux'ie:
                --- https://tecadmin.net/install-oracle-java-11-lts-on-centos/
            </li>
            <li>
                Opis instalacji Tomcat 9 na Linux'ie:
                --- https://tecadmin.net/install-apache-tomcat-9-on-centos/
            </li>
        </ul>
    </body>
</html>
