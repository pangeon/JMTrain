<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JMTrain - Rejestracja</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" type="text/css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/css/main-bootstrap.css" type="text/css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/css/bootstrapValidator.css" type="text/css" rel="stylesheet">

    </head>
    <body>
        <jsp:include page="fragments/navbar.jspf" />

        <div class="container">
            <div class="col-sm-6 col-md-4 col-md-offset-4">
                <form id="registryForm" class="form-signin" method="post" action="register"
                      data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
                      data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
                      data-bv-feedbackicons-validating="glyphicon glyphicon-refresh"
                >
                    <h2 class="form-signin-heading">Rejestracja</h2>
                    <div class="form-group">
                        <input name="email" class="form-control" placeholder="Email"
                               data-bv-regexp="true"
                               data-bv-regexp-regexp="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
                               data-bv-emailaddress="true"
                               autofocus
                        />
                    </div>
                    <div class="form-group">
                        <input name="password" type="password" class="form-control" placeholder="Hasło"
                               data-bv-regexp="true"
                               data-bv-regexp-regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$"
                               data-bv-regexp-message="Hasło minimum osiem znaków w tym: duża litera, mała litera oraz liczba."
                               required />
                    </div>
                    <button class="btn btn-lg btn-primary btn-block" type="submit" >Zarejestruj</button>
                </form>
            </div>
        </div>
        <jsp:include page="fragments/footer.jspf" />
        <script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.2.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/jquery-migrate-1.2.1.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrapValidator.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/pl_PL.js"></script>
        <script>
            $(document).ready(function() {
                $('#registryForm').bootstrapValidator();
            });
        </script>
    </body>
<html>
