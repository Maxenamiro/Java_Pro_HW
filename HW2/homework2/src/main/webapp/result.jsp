<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!Doctype html>
<html>
<head>
    <title>Result</title>
</head>
<body>
<table>
    <c:forEach items="${answers}" var="o">
        <tr>
            <td><c:out value="${o}"></c:out></td>
        </tr>
    </c:forEach>
</table>

<br/><a href="/homework2_war_exploded/">Go Back</a>
</body>
</html>
