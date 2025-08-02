<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Job Posted</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css' />" />
</head>
<body>
    <h2>Job Posted Successfully</h2>
    <p>Title: ${title}</p>
    <p>Description: ${description}</p>
    <a href="/">Go Home</a>
</body>
</html>