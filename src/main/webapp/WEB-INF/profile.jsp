<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JMTrain v 0.2</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/main-bootstrap.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrapValidator.css" type="text/css"
          rel="stylesheet">
</head>
<body id="sessionClock" onload="timeMin();timeSec()">

<jsp:include page="fragments/navbar.jspf"/>

<div class="container">
    <div class="row bs-callout bs-callout-primary">
        <div class="col col-md-12 col-sm-12">
            <c:if test="${requestScope.profile_info != null}">
                <h1>DANE PROFILOWE</h1>
                <table class="table table-bordered">
                    <tr>
                        <td>Imię:</td>
                        <td>${requestScope.profile_info.name}</td>
                    </tr>
                    <tr>
                        <td>Nazwisko:</td>
                        <td>${requestScope.profile_info.surname}</td>
                    </tr>
                    <tr>
                        <td>Telefon:</td>
                        <td>${requestScope.profile_info.phone}</td>
                    </tr>
                    <tr>
                        <td>Ulica:</td>
                        <td>${requestScope.profile_info.city}</td>
                    </tr>
                    <tr>
                        <td>Kod pocztowy:</td>
                        <td>${requestScope.profile_info.postcode}</td>
                    </tr>
                    <tr>
                        <td>Ulica:</td>
                        <td>${requestScope.profile_info.street}</td>
                    </tr>
                </table>
                <form id="passwordForm" class="form-inline" method="post" action="profile">
                    <div class="form-group">
                        <input name="updatepass" type="password" class="form-control" placeholder="Nowe hasło"
                               data-bv-regexp="true"
                               data-bv-regexp-regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$"
                               data-bv-regexp-message="Hasło minimum osiem znaków w tym: duża litera, mała litera oraz liczba."
                               required />
                    </div>
                    <button class="btn btn-md btn-warning" type="submit" >Zmień hasło</button>
                </form>
                <br />
                <button class="btn btn-lg btn-danger btn-block" type="submit">Usuń konto z systemu</button>
            </c:if>
            <c:if test="${sessionScope.user.role == 'attendee' && requestScope.profile_info == null}">
                <h1>DANE PROFILOWE</h1>
                <h3 style="text-align: center">
                    Uzupełnij dane profilowe aby zapisać się na szkolenie.
                </h3>
                <form id="profileForm" class="form-signin" method="post" action="account">
                    <h4>Wprowadź dane profilowe:</h4>
                    <div class="form-group">
                        <input name="name" type="text" class="form-control" placeholder="Imię"
                               data-bv-regexp="true"
                               data-bv-regexp-regexp="^[A-ZŁŻŹĄĘŚĆÓ][a-złżźąęćśóń]{2,60}$"
                               data-bv-regexp-message="Imię z dużej litery bez znaków specjalnych oraz liczb (min. 3 znaki)."
                               required autofocus/>
                    </div>
                    <div class="form-group">
                        <input name="surname" type="text" class="form-control" placeholder="Nazwisko"
                               data-bv-regexp="true"
                               data-bv-regexp-regexp="[A-ZŁŻŹĄĘŚĆÓ][a-złżźąęćśóń]{2,30}$-[A-ZŁŻŹĄĘŚĆÓ][a-złżźąęćśóń]{2,30}$|[A-ZŁŻŹĄĘŚĆÓ][a-złżźąęćśóń]{2,60}$"
                               data-bv-regexp-message="Nazwisko z dużej litery bez znaków specjalnych oraz liczb (min. 3 znaki)."
                               required autofocus/>
                    </div>
                    <div class="form-group">
                        <input name="phone" type="tel" class="form-control" placeholder="Telefon"
                               data-bv-regexp="true"
                               data-bv-regexp-regexp="^[0-9\-\+]{9,15}$"
                               data-bv-regexp-message="Numer telefonu od 9 do 15 znaków. Znaki specjalne +/-"
                               required autofocus/>
                    </div>
                    <div class="form-group">
                        <input name="city" type="text" class="form-control" placeholder="Miasto"
                               data-bv-regexp="true"
                               data-bv-regexp-regexp="[A-ZŁŻŹĄĘŚĆÓ][a-złżźąęćśóń]{2,30}$-[A-ZŁŻŹĄĘŚĆÓ][a-złżźąęćśóń]{2,30}$|[A-ZŁŻŹĄĘŚĆÓ][a-złżźąęćśóń]{2,60}$"
                               data-bv-regexp-message="Nazwa miasta pisana dużą literą (min 3 znaki). Możliwy odstęp."
                               required autofocus/>
                    </div>
                    <div class="form-group">
                        <input name="postcode" type="text" class="form-control" placeholder="Kod pocztowy"
                               data-bv-regexp="true"
                               data-bv-regexp-regexp="[0-9]{2}\-[0-9]{3}"
                               data-bv-regexp-message="Format XX-XXX."
                               autofocus/>
                    </div>
                    <div class="form-group">
                        <input name="street" type="text" class="form-control" placeholder="Ulica"
                               data-bv-regexp="true"
                               data-bv-regexp-regexp="^[A-ZŁŻŹĄĘŚĆÓ][a-złżźąęćśóń0-9 /]{2,60}$"
                               data-bv-regexp-message="Pisane wielką literą (min 3 znaki). Dopuszczalny odstęp i znak \"
                               required autofocus/>
                    </div>
                    <input class="btn btn-lg btn-primary btn-block" type="submit"
                           value="Zatwierdź"/>
                </form>
            </c:if>
            <c:if test="${sessionScope.user.role == 'admin' && requestScope.profiles != null}">
                <h1>DANE PERSONALNE UŻYTKOWNIKÓW</h1>
                <h3 style="text-align: center">
                    Dane personalne wszystkich użytkowników - obowiązuje unijna derektywa RODO*
                </h3>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th class="info text-center" scope="col">Imię</th>
                        <th class="info text-center" scope="col">Nazwisko</th>
                        <th class="info text-center" scope="col">Telefon</th>
                        <th class="info text-center" scope="col">Miasto</th>
                        <th class="info text-center" scope="col">Kod pocztowy</th>
                        <th class="info text-center" scope="col">Ulica</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="profile" items="${requestScope.profiles}">
                        <tr>
                            <td><c:out value="${profile.name}"/></td>
                            <td><c:out value="${profile.surname}"/></td>
                            <td><c:out value="${profile.phone}"/></td>
                            <td><c:out value="${profile.city}"/></td>
                            <td><c:out value="${profile.postcode}"/></td>
                            <td><c:out value="${profile.street}"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${sessionScope.user.role == 'admin' && requestScope.profilesList != null}">
                <h1>PROFILE UŻYTKOWNIKÓW SYSTEMU</h1>
                <h3 style="text-align: center">
                    Użytkownicy zarejestrowani w systemie - obowiązuje unijna derektywa RODO*
                </h3>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th class="info text-center" scope="col">Id</th>
                        <th class="info text-center" scope="col">E-mail</th>
                        <th class="info text-center" scope="col">Hasło</th>
                        <th class="info text-center" scope="col">IP</th>
                        <th class="info text-center" scope="col">Token</th>
                        <th class="info text-center" scope="col">Data rejestracji</th>
                        <th class="info text-center" scope="col">Data aktywacji</th>
                        <th class="info text-center" scope="col">Rola</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="profilesListItem" items="${requestScope.profilesList}">
                        <tr>
                            <td><c:out value="${profilesListItem.id}"/></td>
                            <td><c:out value="${profilesListItem.email}"/></td>
                            <td><c:out value="${profilesListItem.password}"/></td>
                            <td><c:out value="${profilesListItem.ip}"/></td>
                            <td><c:out value="${profilesListItem.token}"/></td>
                            <td><fmt:formatDate value="${profilesListItem.regstamp}" type="both" dateStyle="short"
                                                timeStyle="short"/></td>
                            <td><fmt:formatDate value="${profilesListItem.confstamp}" type="both" dateStyle="short"
                                                timeStyle="short"/></td>
                            <td><c:out value="${profilesListItem.role}"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${sessionScope.user.role == 'admin'}">
                <div class="collapse navbar-collapse navHeaderCollapse">
                    <ul class="nav navbar-nav navbar-left">
                        <li><a href="profile">Lista utworzonych profili</a></li>
                        <li><a href="account">Dane personalne użytkowników</a></li>
                    </ul>
                </div>
            </c:if>
        </div>
    </div>
</div>

<jsp:include page="fragments/footer.jspf"/>

<script src="${pageContext.request.contextPath}/resources/js/sessionCounter.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.2.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-migrate-1.2.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrapValidator.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/pl_PL.js"></script>
<script>
    $(document).ready(function () {
        $('#profileForm').bootstrapValidator();
    });
    $(document).ready(function () {
        $('#passwordForm').bootstrapValidator();
    });
</script>
</body>
</html>
