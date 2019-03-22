<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Sadiq
  Date: 1/1/17
  Time: 7:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>

<body background="css/pictures/6.jpg" style=" background-repeat: no-repeat; color: #ffffff ; /*width: 100%; height: 100%;*/ margin: 0px; padding: 0px;">

<div style=" padding-top: 20px; text-align: center ; margin: auto ; width: 400px ; height: 200px; margin-top: 200px;">
    <span><h3>Welcome ,  ${user.name} ${user.surname} !</h3></span><br><br>
    <span style="color: aqua;"><h2> You must leave the room at    ${user.end_time} ! </h2></span>
</div>


</body>
</html>