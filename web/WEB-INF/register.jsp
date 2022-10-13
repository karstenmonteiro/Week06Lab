<%-- 
    Document   : register
    Created on : 13-Oct-2022, 12:01:48 AM
    Author     : Karsten Monteiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
        <form action="ShoppingList" method="post">
            <input type="text" name="username">
            <input type="hidden" name="action" value="register">
            <input type="submit" value="Register">
        </form>
    </body>
</html>
