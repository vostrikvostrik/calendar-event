<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<head>
    <title>Spring MVC Form Handling Example</title>

    <spring:url value="/resources/core/js/jquery/jquery-1.10.2.js" var="jquery"/>
    <spring:url value="/resources/core/js/jquery/jquery-ui.custom.min.js" var="jqueryui"/>
    <spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrap"/>
    <spring:url value="/resources/core/js/moment.js" var="moment"/>
    <spring:url value="/resources/core/js/bootstrap-datetimepicker.js" var="bootstrapDate"/>

    <spring:url value="/resources/core/js/oauth.js" var="oauthJs"/>
    <spring:url value="/resources/core/js/date.format.js" var="dateformat"/>
    <spring:url value="/resources/core/js/calendar.js" var="calendar"/>

    <script src="${jquery}"></script>
    <script src="${jqueryui}"></script>
    <script src="${bootstrap}"></script>
    <script src="${moment}"></script>
    <script src="${bootstrapDate}"></script>
    <script src="${oauthJs}"></script>
    <script src="${dateformat}"></script>
    <script src="${calendar}"></script>


    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>
    <spring:url value="/resources/core/css/bootstrap-datetimepicker.css" var="bootstrapDateCss"/>
    <spring:url value="/resources/core/css/hello.css" var="coreCss"/>
    <spring:url value="/resources/core/css/calendar.css" var="calendarCss"/>

    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${bootstrapDateCss}" rel="stylesheet"/>
    <link href="${coreCss}" rel="stylesheet"/>
    <link href="${calendarCss}" rel="stylesheet"/>

</head>

<spring:url value="/" var="urlHome"/>
<spring:url value="/users/add" var="urlAddUser"/>

<nav class="navbar navbar-inverse ">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${urlHome}">Spring MVC Form</a>
        </div>
        <div id="navbar">
            <ul class="nav navbar-nav navbar-right">
                <div id="signInBut">
                    <div class="g-signin2" data-onsuccess="onSignIn"></div>
                </div>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <label id="user-name" class="navbar-nav  nav-link"></label>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <div id="signOutBut">

                    <div>
                        <img id="profileImage" src="" width="30" height="30"/></div>
                    <a href="#" onclick="signOut();">Sign out</a>
                </div>
            </ul>
        </div>
    </div>

</nav>


