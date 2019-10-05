<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link href="styles.css" rel="stylesheet">
    <title>Login</title>
    <style>
        <%@ include file="/WEB-INF/styles/styles.css" %>
    </style>
</head>

<body>
<form name="f" action="/login" method="post">
    <fieldset class="fieldcss">
        <legend>Please, log in</legend>
        <div class="field">
            <br>
            <label for="username">Login</label>
            <input type="text" id="username" name="username" value=""/>
        </div>
        <br>
        <div class="field">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" value=""/>
        </div>
        <br>
        <div class="login">
            <button class="login_buttons, bigButton">Sign in</button>
        </div>
    </fieldset>
</form>
<br>
<div class="login">
    <button class="login_buttons, bigButton" name="submit" type="submit"><a href="/login" class="button">Reset</a></button>
    <button class="login_buttons, bigButton" name="submit" type="button"><a href="/guest/showAllItems" class="button">Enter as guest</a></button>
    <button class="login_buttons, bigButton" name="submit" type="button"><a href="/signUp" class="button">Registration</a></button>
</div>
</body>
</html>
