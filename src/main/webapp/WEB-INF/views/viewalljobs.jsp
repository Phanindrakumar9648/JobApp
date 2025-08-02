<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>All Job Listings</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css' />" />
</head>
<body>
    <h2>📋 Job Listings</h2>
    <c:choose>
        <c:when test="${empty jobs}">
            <p>No jobs posted yet.</p>
        </c:when>
        <c:otherwise>
            <table border="1" cellpadding="10">
                <tr>
                    <th>Title</th>
                    <th>Description</th>
                </tr>
                <c:forEach var="job" items="${jobs}">
                    <tr>
                        <td>${job.title}</td>
                        <td>${job.description}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
    <br>
    <a href="/"><button>🏠 Back to Home</button></a>
</body>
</html>
