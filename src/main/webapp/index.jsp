<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<h2>Witaj na stronie testowej !</h2>
<h3>Aplikacja jest w budowie</h3>
<p>Twoja przeglądarka: ${header['user-agent'] }</p>
<p>Twój adres IP: <%= request.getRemoteAddr() %></p>
<p>Dane sesji: <%= request.getSession().getAttribute("email") %></p>
<ul>
    <li><a href="TestConnectionServlet">TestConnectionServlet</a></li>
    <li><a href="start.jsp">Start</a></li>
</ul>
</body>
</html>
