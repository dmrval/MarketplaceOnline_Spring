<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link href="styles.css" rel="stylesheet">
    <title>Registration</title>
    <style>
        <%@ include file="/WEB-INF/styles/styles.css" %>
    </style>
    <script type="text/javascript">
        function redirect() {
            window.location = "/signUp"
        }
    </script>
</head>

<body>
<%--@elvariable id="user" type="com.epam.dmrval.entity.User"--%>
<c:if test="${passNotMatch==1}">
    <div class="error">
        The entered passwords do not match
    </div>
</c:if>
<form:form name="reg" modelAttribute="user" action="/registration" method="post">
    <fieldset class="fieldcss">
        <legend>Registration</legend>
        <div class="reg">
            <form:label path="fullname">Full Name:</form:label>
            <form:input path="fullname" type="text" id="fullname" name="fullname" value=""/>
        </div>
        <br>
        <div class="reg">
            <form:label path="address">Billing address:</form:label>
            <form:input path="address" type="text" id="address" name="address" value=""/>
        </div>
        <br>
        <div class="reg">
            <form:label path="sex">What to call you:</form:label>
            <form:select path="sex" id="user_sex" for="user_sex">
                <form:options items="${Sex.values()}"/>
            </form:select>
        </div>
        <br>
        <hr>
        <br>
        <div>
            <div class="reg">
                <form:label path="login" for="login">Login:</form:label>
                <form:input path="login" type="text" id="login" name="login" value=""/>
            </div>
            <br>
            <div class="reg">
                <form:label path="password" for="password">Password:</form:label>
                <form:input path="password" type="password" id="password" name="password" value=""/>
            </div>
            <br>
            <div class="reg">
                <label for="repassword">Re-enter Password</label>
                <input type="password" id="repassword" name="repassword" value=""/>
            </div>
        </div>
        <br>
        <div>
            <input class="registration_buttons" name="submit" type="submit" value="Registration"/>
            <input type="button" onclick="redirect()" value="Reset">
        </div>
    </fieldset>
</form:form>
</body>
</html>
