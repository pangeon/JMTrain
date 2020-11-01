<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>JMTrain v 0.2</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/main-bootstrap.css" type="text/css" rel="stylesheet">
</head>
<body id="sessionClock" onload="timeMin();timeSec()">

<jsp:include page="fragments/navbar.jspf" />

<div class="container">
    <div class="row bs-callout bs-callout-primary">
        <div class="col col-md-12 col-sm-12">
            <button class="btn btn-default btn-default" disabled="disabled" style="padding: 20px; font-size: 30px; width: 100%">Gratulujemy !</button>
            <br />
            <br />
            <p class="btn-default" disabled="disabled" style="text-align: center; padding: 10px;">
                <strong>Konto <span style="color: red"><c:out value="${requestScope.email}" /></span>
                    zostało zarejestrowanie w systemie
                </strong>
                <br />
                Cieszymy się, że jesteś z Nami. Zapraszamy do zapoznania się z naszą ofertą szkoleń:
                <a href="${pageContext.request.contextPath}/courses">tutaj</a>
            </p>
        </div>
    </div>
</div>

<jsp:include page="fragments/footer.jspf" />

<script src="${pageContext.request.contextPath}/resources/js/sessionCounter.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.2.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-migrate-1.2.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>
