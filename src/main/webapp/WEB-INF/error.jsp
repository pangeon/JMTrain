<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>JMTrain v 0.5</title>
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
            <button class="btn btn-danger btn-block" disabled="disabled" style="padding: 20px; font-size: 30px">Coś poszło nie tak !</button>
            <br />
            <p class="btn-warning" style="text-align: center; padding: 10px;">Skontaktuj się z admininistratorem:
                <a href="mailto:kamil.cecherz@gmail">kamil.cecherz@gmail.com</a>
                w celu wyjaśnienia problemu.
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
