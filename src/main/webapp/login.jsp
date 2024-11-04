<%--
  Created by IntelliJ IDEA.
  User: alex3
  Date: 04/11/2024
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%if (request.getSession().getAttribute("username") == null) {%>
<section class="login-form">
    <form action="LoginServlet" method="post">
        <h2>Inicio de sesión</h2>
        <label for="username">Nombre de usuario:</label>
        <input type="text" id="username" name="username">
        <label for="password">Contraseña:</label>
        <input type="password" name="password" id="password">
        <button type="submit">INICIAR SESIÓN</button>
    </form>
</section>
<%}%>
</body>
</html>
