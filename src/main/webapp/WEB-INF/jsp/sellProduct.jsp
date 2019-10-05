<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Damir_Valeev
  Date: 9/19/2019
  Time: 1:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="styles.css" rel="stylesheet">
    <title>Registration</title>
    <style>
        <%@ include file="/WEB-INF/styles/styles.css" %>
    </style>
</head>

<body>
<div class="head_sky">
    You are logged in as: ${currentUser.sex.respectCall} ${currentUser.fullname}
    <span class="logout_span"><a href="/logout">Logout</a></span>
</div>
<h1>
    Online Marketplace
</h1>
<%--@elvariable id="buildProduct" type="com.epam.dmrval.entity.ProductBuilder"--%>
<form:form name="addProduct" modelAttribute="buildProduct" action="/user/sellProduct" method="post">
    <fieldset class="field_center">
        <legend>Add new product</legend>
        <div class="addProd">
            <form:label path="nameProduct" for="nameProduct">Product Name:</form:label>
            <form:input path="nameProduct" type="nameProduct" id="nameProduct" name="nameProduct" value=""
                        required="required"/>
            <form:errors path="nameProduct" cssClass="error"/>

        </div>
        <br>
        <div class="addProd">
            <form:label path="description" for="description">Description:</form:label>
            <form:input path="description" type="text" id="description" name="description" value=""
                        required="required"/>
            <form:errors path="description" cssClass="error"/>
        </div>
        <br>
        <hr>
        <br>
        <div>
            <div class="addProd">
                <form:label path="startPrice" for="startPrice">Start price:</form:label>
                <form:input path="startPrice" type="number" id="startPrice" name="startPrice" value=""
                            required="required"/>
                <form:errors path="startPrice" cssClass="error"/>
            </div>
            <br>
            <div class="addProd">
                <form:label path="stepLevel" for="stepLevel">Step level:</form:label>
                <form:input path="stepLevel" type="number" id="stepLevel" name="stepLevel" value=""
                            required="required"/>
                <form:errors path="stepLevel" cssClass="error"/>
            </div>
            <br>
            <hr>
            <br>
            <div class="addProd">
                <form:label path="time" for="time">Time:</form:label>
                <form:input path="time" type="datetime-local" id="time" name="time" value="" required="required"/>
                <form:errors path="time" cssClass="error"/>
            </div>
        </div>
        <br>
        <div>
            <form:checkbox path="bidding"/> Put up for sale
        </div>
        <br>
        <div>
            <input class="bigButton" name="submit" type="submit" value="Add new product in auction"/>
        </div>
    </fieldset>
</form:form>


<br>
<div class="center">
    <button class="bigButton" onclick="document.location='/user/sellProduct/cancel'">Cancel</button>
</div>


</body>

</html>
