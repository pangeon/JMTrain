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
        <h1>JMTrain v. 0.4</h1>
        <ul>
            <li>Browser engine: ${header['user-agent']}</li>
            <li>IP: <%= request.getRemoteAddr() %></li>
        </ul>
        <h2><a href="start">START</a></h2>
        <script src="${pageContext.request.contextPath}/resources/js/sessionCounter.js"></script>
        <div>
            <h3>OPIS DZIAŁANIA:</h3>
            <p>
                Aplikacja umożliwia zarządzanie kursami. Program umożliwia edycję danych osobowych użytkowników oraz dodawanie zapisów na kursy.
                Aplikacja jest bezpieczna - po rejestracji wysyła potwierdzenie e-mailem i szyfruje hasła. Baza zapisuje dane wykorzystując
                algorytm MD5.
            </p>
        </div>
    </body>
</html>
