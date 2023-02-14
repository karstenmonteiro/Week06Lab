<%-- 
    Document   : shoppingList
    Created on : 13-Feb-2023, 9:20:27 PM
    Author     : Karsten Monteiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <span>Hello, ${username}</span>
        <a href="ShoppingList?action=logout">Logout</a>
        
        <!-- add items -->
        <form action="" method="post">
            <h2>List</h2>
            Add item: <input type="text" name="item">
            <input type="submit" value="Add">
            <input type="hidden" name="action" value="add">
        </form>
        
        <!-- items list -->
        <form action="" method="post">
            <ul>
                <c:forEach var="item" items="${itemsList}">
<!------------------------------------------------------------------------------------------------------------
                    MAY BE ABLE TO DELETE the following line
-------------------------------------------------------------------------------------------------------------->
                    <li><input type="radio" name="item" value="<c:out value='${item}' />"><c:out value='${item}' /></li>
                </c:forEach>
            </ul>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>
    </body>
</html>
