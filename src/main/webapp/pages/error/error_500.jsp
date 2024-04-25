<%--
  Created by IntelliJ IDEA.
  User: Suzukie
  Date: 28.03.2024
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>500</title>
</head>
<body>

    Request from : ${pageContext.errorData.requestURI} is failed <br/>
    Servlet name: ${pageContext.errorData.servletName}- <br/>
    Status code: ${pageContext.errorData.statusCode} <br/>
    Exception: ${pageContext.exception.message} <br/>
    <br/><br/><br/>
    Message from exception: ${error_msg}

<ul>
    <li>
        <a href="http://localhost:8081/FirstTomcat_war_exploded/">Go back </a>
    </li>
</ul>

</body>
</html>
