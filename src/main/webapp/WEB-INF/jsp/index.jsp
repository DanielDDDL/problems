<%--Strng
  User: Daniel
  Date: 01/02/2018
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hey!</title>
</head>
<body>

    <h3>Hello! How do you do?</h3>

    <p>Well, I would create a page with a list of all the books, but you don't mind
        navigating using urls and the id's on the database, do you? :b</p>
    <p>Let me help you!</p>
    <ul>
        <li><i>GET - /book/add</i> - Form to create a new book</li>
        <li><i>POST - /book/add</i> - Submit creation form to server</li>
        <li><i>GET - /book/edit/{id}</i> - Form to edit book with id informed in request</li>
        <li><i>POST - /book/edit/</i> - Submit changes made</li>
    </ul>

    <p>And this is the page where you get redirected to when one of those process is done. So here is a message with what happened: </p>
    <h3>${message}</h3>

</body>
</html>
