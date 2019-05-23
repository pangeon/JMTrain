<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

    </head>
    <body id="sessionClock" onload="timeMin();timeSec()">
    <h2>Witaj na stronie testowej !</h2>
    <h3>Aplikacja jest w budowie</h3>
    <p>Twoja przeglądarka: ${header['user-agent'] }</p>
    <!-- VM Options -Djava.net.preferIPv4Stack=true -->
    <p>Twój adres IP: <%= request.getRemoteAddr() %></p>
    <p>Dane sesji: <%= request.getSession().getAttribute("user") %></p>
    <p>Nazwa użytkownika: ${sessionScope.user.email}</p>
    <p>Rola: ${sessionScope.user.role}</p>
    <p>
        Czas sesji: <span id="min">15</span>:<span id="sec">60</span>
    </p>
    <ul>
        <li><a href="TestConnectionServlet">TestConnectionServlet</a></li>
        <li><a href="start.jsp">Start</a></li>
    </ul>
    <script src="${pageContext.request.contextPath}/resources/js/sessionCounter.js"></script>
    </body>
</html>
