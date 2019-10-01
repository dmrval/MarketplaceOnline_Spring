<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Damir_Valeev
  Date: 9/11/2019
  Time: 12:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="styles.css"/>
    <title>User</title>
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

<h4 class="search_parameters">Search parameters</h4>

<form name="searchParams" action="/user/showMyItems/searchParams" method="post" class="keyword">
    <h5>Keyword:</h5>
    <div class="field">
        <input type="text" name="searchText" value=""/>
        <select name="selecter">
            <option>Name</option>
        </select>
        <button>Search</button>
    </div>
</form>


<div>
    <span class="logout_span"><a href="/user/showAllItems">Show All Items</a></span>
    <span class="logout_span"><a href="/user/showMyItems">Show My Items</a></span>
    <span class="logout_span"><a href="/user/addProduct">Sell</a></span>
</div>
<div class="div_center">
    <h2>Dear ${currentUser.sex.respectCall} ${currentUser.fullname}. Here are your products.</h2>
</div>
<div>
    <table>
        <caption>Your Items</caption>
        <tr>
            <td>Name product</td>
            <td>Description</td>
            <td>Start price</td>
            <td>Step level</td>
            <td>Time</td>
        </tr>
        <br>
        <c:forEach var="prod" items="${userItems}">
            <tr>
                <td><c:out value="${prod.nameProduct}"/></td>
                <td><c:out value="${prod.description}"/></td>
                <td><c:out value="${prod.info.startPrice}"/></td>
                <td><c:out value="${prod.info.stepLevel}"/></td>
                <td><c:out value="${prod.info.time}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
