<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JMTrain - Logowanie</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" type="text/css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/css/main-bootstrap.css" type="text/css" rel="stylesheet">
    </head>
    <body>

        <jsp:include page="fragments/navbar.jspf" />

        <div class="container">
            <div class="col-sm-6 col-md-4 col-md-offset-4">
                <form class="form-signin" action="j_security_check" method="post">
                    <h2 class="form-signin-heading">Logowanie</h2>
                    <input name="j_username" type="text" class="form-control" placeholder="Podaj e-mail" required autofocus>
                    <input name="j_password" type="password" class="form-control" placeholder="Podaj hasło" required>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Zaloguj</button>
                    <a href="register.jsp">Zarejestruj</a>
                </form>
            </div>
        </div>

        <jsp:include page="fragments/footer.jspf" />

        <script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.2.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/jquery-migrate-1.2.1.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
    </body>
<html>

