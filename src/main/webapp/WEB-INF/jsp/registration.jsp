<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link href="styles.css" rel="stylesheet">
    <title>Registration</title>
    <style>
        <%@ include file="/WEB-INF/styles/styles.css" %>
    </style>
</head>

<body>
<form name="reg" action="/registr" method="post">
    <fieldset>
        <legend>Registration</legend>
        <div class="reg">
            <label for="fullname">Full Name:</label>
            <input type="text" id="fullname" name="fullname" value=""/>
        </div>
        <br>
        <div class="reg">
            <label for="address">Billing address:</label>
            <input type="text" id="address" name="address" value=""/>
        </div>
        <br>
        <br>
        <div>
            <div class="reg">
                <label for="login">Login:</label>
                <input type="text" id="login" name="login" value=""/>
            </div>
            <br>
            <div class="reg">
                <label for="password">Password:</label>
                <input type="text" id="password" name="password" value=""/>
            </div>
            <br>
            <div class="reg">
                <label for="repassword">Re-enter Password</label>
                <input type="text" id="repassword" name="repassword" value=""/>
            </div>
        </div>
        <br>
        <div>
            <input class="registration_buttons" name="submit" type="submit" value="Registration"/>
            <button class="registration_buttons" name="submit" type="submit">Reset</button>

        </div>

    </fieldset>
</form>


</body>
</html>
