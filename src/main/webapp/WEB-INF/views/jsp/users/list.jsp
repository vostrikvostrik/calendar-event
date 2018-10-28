<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="google-signin-client_id"
          content="447376838568-pv0rgse1c647bv4t5b1q97hvnjmr7t4o.apps.googleusercontent.com">
</head>
<jsp:include page="../fragments/header.jsp"/>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<body>

<jsp:include page="../events/events.jsp"/>

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

    <!--
    <h1>All Users</h1>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>#ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>framework</th>
            <th>Action</th>
        </tr>
        </thead>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>
                        ${user.id}
                </td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td><c:forEach var="framework" items="${user.framework}" varStatus="loop">
                    ${framework}
                    <c:if test="${not loop.last}">,</c:if>
                </c:forEach></td>
                <td>
                    <spring:url value="/users/${user.id}" var="userUrl"/>
                    <spring:url value="/users/${user.id}/delete" var="deleteUrl"/>
                    <spring:url value="/users/${user.id}/update" var="updateUrl"/>

                    <button class="btn btn-info" onclick="location.href='${userUrl}'">Query</button>
                    <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
                    <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
                </td>
            </tr>
        </c:forEach>
    </table>
    -->

</div>

<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>