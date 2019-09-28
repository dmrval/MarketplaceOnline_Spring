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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
</head>

<jsp:useBean id="currentUser" scope="session" type="com.epam.dmrval.entity.User"/>
<body>

<div class="head_sky">
    You are logged in as: ${currentUser.sex.respectCall} ${currentUser.fullname}
    <span class="logout_span"><a href="/logout">Logout</a></span>
</div>
<h1>
    Online Marketplace
</h1>


<h4 class="search_parameters">Search parameters</h4>

<form name="searchParams" action="/searchParams" method="post" class="keyword">
    <h5>Keyword:</h5>
    <div class="field">
        <input type="text" name="searchText" value=""/>
        <select name="selecter">
            <option>Name</option>
            <option>Seller</option>
        </select>
        <button>Search</button>
    </div>
</form>


<div>
    <span class="logout_span"><a href="/showItems">Show All Items</a></span>
    <span class="logout_span"><a href="/showMyItems?currentUser=${currentUser.fullname}">Show My Items</a></span>
    <span class="logout_span"><a href="/addProduct">Sell</a></span>
</div>
<div class="div_center">
    <h2>Dear ${currentUser.sex.respectCall} ${currentUser.fullname}. Here are all the products in the auction.</h2>
</div>
<div id="test1">
    <jsp:useBean id="allProducts" scope="session" type="java.util.List"/>
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
            <td>Bidding</td>
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
                        <c:when test="${product.info.bidder.bidderOffer!=0}">
                            ${product.info.bidder.bidderOffer}
                        </c:when>
                        <c:otherwise>
                            ---
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${product.info.bidder.bidderOffer!=0}">
                            ${product.info.bidder.bidderUser.fullname}
                        </c:when>
                        <c:otherwise>
                            ---
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>${product.info.time}</td>
                <td>
                    <c:choose>
                        <c:when test="${product.info.bidding == true && !product.info.master.fullname.equals(currentUser.fullname)}">
                            <form name="biddUp" action="/biddUp" method="post">
                                <input type="number" name="biddLot" value="${product.info.stepLevel}"
                                       min="${product.info.stepLevel}">
                                <input hidden name="biddInfo" value="${product.nameProduct}">
                                <button id="bidButton">Bid</button>
                            </form>
                        </c:when>
                        <c:otherwise>
                            Not for sale
                            <c:if test="${product.info.master.fullname.equals(currentUser.fullname)}">
                                , it's your
                            </c:if>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>

</html>
