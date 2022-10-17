<%-- 
    Document   : shoppinglist
    Created on : 13-Oct-2022, 12:01:57 AM
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
        <span>Hello, ${username} ${two}</span>
        <a href="ShoppingList?action=logout">Logout</a>
        
        <form action="" method="post">
            <h2>List</h2>
            Add item: <input type="text" name="item"><input type="submit" value="Add Item">
            <input type="hidden" name="action" value="add">
        </form>
        
        <form action="" method="post">
            <ul>
                <c:forEach var="item" items="${itemsList}">
                    <li><input type="radio" name="item" value="<c:out value='${item}' />"><c:out value='${item}' /></li>
                </c:forEach>
            </ul>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>
        
    </body>
</html>
