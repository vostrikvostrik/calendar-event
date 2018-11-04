<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
</head>
<jsp:include page="../fragments/header.jsp"/>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<body>
Hello <security:authentication property="principal.username" />!

<jsp:include page="events.jsp"/>

<div class="container">

    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>
    <c:if test="${not empty error}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${error}</strong>
        </div>
    </c:if>
    <div id="wrap">
        <div id="calendar"></div>
        <div style="clear:both"></div>
    </div>
</div>

<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>