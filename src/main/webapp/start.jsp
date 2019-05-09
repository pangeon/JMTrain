<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JMTrain v 0.1 test</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" type="text/css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/css/main-bootstrap.css" type="text/css" rel="stylesheet">
    </head>
    <body id="sessionClock" onload="timeMin();timeSec()">
        <nav class = "navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <a href="index.jsp" class="navbar-brand">JMTrain</a>

                <button class="navbar-toggle" data-toggle="collapse" data-target=".navHeaderCollapse">
                    <span class="glyphicon glyphicon-list"></span>
                </button>

                <div class="collapse navbar-collapse navHeaderCollapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active"><a href="#">Start</a></li>
                        <li><a href="start.jsp">Szkolenia</a></li>
                        <li><a href="#">Nasi Trenerzy</a></li>
                        <li><a href="#">Współpraca</a></li>
                        <li><a href="#">Kontakt</a></li>
                        <c:choose>
                            <c:when test="${not empty sessionScope.user}">
                                <li><a href="logout">Wyloguj się</a></li>
                                <li><a href="courses">Lista kursów</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="login">Logowanie</a></li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </div>
            </div>
        </nav>
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

        <footer class="footer">
            <div class="container">
                <p class="navbar-text pull-left">JMTrain v. 0.1 test - developed by <a href="http://cecherz.pl">Kamil Cecherz</a></p>
                <c:if test="${not empty sessionScope.user}">
                    <p class="navbar-text pull-right">
                        Zalogowany jako:
                        <span style="font-weight: bolder">${sessionScope.user.email}</span> |
                        <a href="#">Panel użytkownika</a>
                    </p>
                    <p class="navbar-text pull-right">
                        Czas sesji:
                        <span id="min">5</span> :
                        <span id="sec">60</span>
                    </p>
                </c:if>

            </div>
        </footer>
        <script src="${pageContext.request.contextPath}/resources/js/sessionCounter.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.2.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/jquery-migrate-1.2.1.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
    </body>
</html>
