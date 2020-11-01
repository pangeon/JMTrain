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
    </body>
</html>
