<%--
  Created by IntelliJ IDEA.
  User: Suzukie
  Date: 27.03.2024
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main </title>
</head>
<body>
Hello (forward)= ${user}
<hr/>
Hi (redirect/forward)= ${user_name}
<hr/>

<form action ="controller">
    <input type="hidden" name="command" value = "logout" >
    <input type="submit" value="logout" >
</form>

<ul>
    <li>
        <a href="http://localhost:8081/FirstTomcat_war_exploded/">Go back </a>
    </li>
</ul>

</body>
</html>
