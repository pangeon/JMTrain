<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<h2>Witaj na stronie testowej !</h2>
<h3>Aplikacja jest w budowie</h3>
Twoja przeglądarka: ${header['user-agent'] }
<a href="TestConnectionServlet">TestConnectionServlet</a>
<a href="start.jsp">Start</a>
<% for(int i=0; i<5; i++) { %>
<p>Paragraf numer <%= i %></p>
<% } %>

</body>
</html>
