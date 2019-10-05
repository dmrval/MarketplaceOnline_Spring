<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


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
<%--@elvariable id="productSearcher" type="com.epam.dmrval.entity.ProductSearcher"--%>
<form:form name="advancedSearch" modelAttribute="productSearcher" action="/advancedSearch" method="post">
    <fieldset class="fieldcss">
        <legend>Advanced search</legend>
        <div class="reg">
            <form:label path="uid" for="uid">Item UID:</form:label>
            <form:input path="uid" type="number" id="uid" name="uid" value="0" required="required"/>
            <form:errors path="uid" cssClass="error"/>
        </div>
        <br>
        <div class="reg">
            <form:label path="nameProduct" for="title">Title:</form:label>
            <form:input path="nameProduct" type="text" id="title" name="title" value=""/>
        </div>
        <br>
        <div class="reg">
            <form:label path="description" for="description">Description:</form:label>
            <form:input path="description" type="text" id="description" name="description" value=""/>
        </div>
        <br>
        <hr>
        <br>
        <div>
            <form:label path="minPrice" for="minprice">Min. price:</form:label>
            <form:input path="minPrice" class="shortinput" type="number" id="minprice" name="minprice"
                        required="required"/>
            <form:errors path="minPrice" cssClass="error"/>

            <form:label path="maxPrice" for="maxprice">Max. price:</form:label>
            <form:input path="maxPrice" class="shortinput" type="number" id="maxprice" name="maxprice"
                        value="999999999.9" required="required"/>
            <form:errors path="maxPrice" cssClass="error"/>
        </div>
        <br>
        <hr>
        <div>
            <form:checkbox path="bidding"/>Show Only Buy It Now Items
        </div>
        <hr>
        <br>
        <br>
        <div class="reg">
            <form:label path="expireDate">Expire date:</form:label>
            <form:input path="expireDate" type="datetime-local" id="expiredate" name="expiredate" value=""/>
            <form:errors path="expireDate" cssClass="error"/>
        </div>
        <br>
        <hr>
        <br>
        <div class="reg">
            <form:label path="bestOffer" for="bestOffer">Bidder Count:</form:label>
            <form:input path="bestOffer" type="number" id="bestOffer" name="bestOffer" required="required"/>
            <form:errors path="bestOffer" cssClass="error"/>

        </div>
        <br>
        <div>
            <input class="registration_buttons" name="submit" type="submit" value="Search"/>
            <a href="/clearField" class="clearSearch">Clear Search</a>
        </div>
    </fieldset>
</form:form>

</body>
</html>
