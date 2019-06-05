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
                    <h1>CZEGO NAUCZYSZ SIĘ U NAS?</h1>
                    <p>Czy wiesz, że mamy największe doświadczenie w nauczaniu Javy
                        wśród akademii programowania w Polsce? Dzięki temu
                        wypracowaliśmy taką sekwencję zajęć, by kompleksowo
                        wyposażyć Cię w niezbędną wiedzę i umiejętności.
                        Wiemy też, czego potrzebują pracodawcy, więc program kursu,
                        jego forma i zakres tematyczny są odpowiedzią na ich
                        realne potrzeby.
                    </p>
                </div>
                <div class="col col-md-12 col-sm-12">
                    <c:if test="${not empty requestScope.courses}">
                        <h1>OFEROWANE SZKOLENIA</h1>
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th class="info text-center" scope="col">Nazwa szkolenia</th>
                                <th class="info text-center" scope="col">Data rozpoczęcia</th>
                                <th class="info text-center" scope="col">Data zakończenia</th>
                                <th class="info text-center" scope="col">Opis</th>
                                <th class="info text-center" scope="col">Max uczestników</th>
                                <th class="info text-center" scope="col">#</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="course" items="${requestScope.courses}">
                                <tr>
                                    <td><c:out value="${course.title}" /></td>
                                    <td><fmt:formatDate value="${course.start_date}" type = "both"
                                                        dateStyle = "short" timeStyle = "short" /></td>
                                    <td><fmt:formatDate value="${course.end_date}" type = "both"
                                                        dateStyle = "short" timeStyle = "short" /></td>
                                    <td><c:out value="${course.describtion}" /></td>
                                    <td><c:out value="${course.max_attende}" /></td>
                                    <td><button type="button">Zapisz</button></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
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
