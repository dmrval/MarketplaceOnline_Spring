<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link href="styles.css" rel="stylesheet">
    <title>Show Items</title>
    <style>
        <%@ include file="/WEB-INF/styles/styles.css" %>
    </style>
</head>

<body>
<div class="head_sky">
    You are logged in as: Guest
    <span class="logout_span"><a href="/logout">Logout</a></span>
</div>
<h1>
    Online Marketplace
</h1>


<h4 class="search_parameters">Search parameters</h4>

<form name="searchParams" action="/guest/searchParams" method="post" class="keyword">
    <h5>Keyword:</h5>
    <div class="field">
        <input type="text" name="searchText" value=""/>
        <select name="selecter">
            <option>Name</option>
            <option>Seller</option>
            <option>Start price</option>
        </select>
        <button>Search</button>
    </div>
</form>
<div>
    <span class="logout_span"><a href="/guest/showAllItems">Show All Items</a></span>
</div>

<div class="div_center">
    <h2>Dear guest. Here are all the products in the auction.</h2>
</div>
<div>
    <table>
        <caption>All Items in auction</caption>
        <tr>
            <td>UID</td>
            <td>Title</td>
            <td>Description</td>
            <td>Seller</td>
            <td>Start price</td>
            <td>Bid inc</td>
            <td>Best offer</td>
            <td>Bidder</td>
            <td>Stop date</td>
        </tr>
        <br>
        <c:forEach var="product" items="${allProducts}">
            <tr>
                <td>${product.uid}</td>
                <td>${product.nameProduct}</td>
                <td>${product.description}</td>
                <td>${product.info.master.sex.respectCall} ${product.info.master.fullname}</td>
                <td>${product.info.startPrice}</td>
                <td>${product.info.stepLevel}</td>
                <td>
                    <c:choose>
                        <c:when test="${product.info.bidder!=null}">
                            ${product.info.bidder.bidderOffer}
                        </c:when>
                        <c:otherwise>
                            ---
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${product.info.bidder!=null}">
                            ${product.info.bidder.bidderUser.fullname}
                        </c:when>
                        <c:otherwise>
                            ---
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>${product.info.time}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>

</html>
