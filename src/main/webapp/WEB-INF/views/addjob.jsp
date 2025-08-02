<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Add Job</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css' />" />
</head>
<body>
    <h2>Add Job</h2>
    <form action="submitJob" method="post">
        <label>Title: </label><input type="text" name="title" required/><br>
        <label>Description: </label><input type="text" name="description" required/><br>
        <button type="submit">Submit</button>
    </form>
</body>
</html>