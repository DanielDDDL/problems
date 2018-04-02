<%--
  Author: Daniel
  Date: 01/02/18
--%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Add new book</title>
    <style type="text/css">
        .error {
            color: red;
            font-size: 0.9em;
            font-weight: bold;
        }
    </style>
</head>
<body>

    <h1>Add book page</h1>
    <p>Here you can add a new book.</p>
    <form:form method="POST" modelAttribute="book" action="${pageContext.request.contextPath}/book/new">
    
    	<form:errors path="" cssClass="error" />
    
        <table>
            <tbody>
            
            <tr>
                <td>Title:</td>
                <td>
                    <form:input path="title" autocomplete="off" />
                    <form:errors path="title" cssClass="error" />
                </td>

            </tr>
            <tr>
                <td>Author:</td>
                <td>
                    <form:input path="author" autocomplete="off" />
                    <form:errors path="author" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Add" /></td>
            </tr>
            </tbody>
        </table>

    </form:form>


</body>
</html>
