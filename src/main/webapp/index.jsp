<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reserva de Vuelos</title>
    <link rel="stylesheet" href="./css/styles.css">
    <link rel="stylesheet" href="./css/error-css.css">
    <link rel="stylesheet" href="./css/button-hover.css">
    <link rel="stylesheet" href="./css/register-styles.css">
</head>
<body>
<header>
    <nav>
        <img src="./css/assets/logo.png" alt="" class="page-logo">
        <ul>
            <li><a href="index.jsp" class="a__link">Inicio</a></li>
            <li><a href="" class="a__link">Soporte</a></li>
            <li id="last-nav-item"><a href="" class="a__link">Mis reservas</a></li>
            <li>
                <button onclick="toggleJSP('login')">Iniciar sesión</button>
            </li>
            <li>
                <button onclick="toggleJSP('register')">Registro</button>
            </li>
        </ul>
    </nav>
    <section class="reservation-form">
        <form class="form-wrapper" action="FlightSearchServlet" method="post">
            <div class="form-div-one">
                <div class="search-wrapper">
                    <input type="text" id="from" name="from" placeholder="Origen" required>
                    <input type="text" id="to" name="to" placeholder="Destino" required>
                </div>

                <button type="submit" onsubmit="toggleFlightSearch()">BUSCAR VUELOS</button>
            </div>

            <div class="form-filters">
                <div class="date-wrapper">
                    <input type="text" id="departure-date" name="departure-date" placeholder="Fecha de ida" onfocus="(this.type='date')">
                    <input type="text" id="return-date" name="return-date" placeholder="Fecha de vuelta" onfocus="(this.type='date')">
                </div>

                <div class="passengers-class-wrapper">
                    <input type="text" id="passengers" name="passengers" min="1" max="10" placeholder="Pasajeros">

                    <select id="class" name="class" required>
                        <option value="" disabled selected>Clase</option>
                        <option value="economy">Economica</option>
                        <option value="business">Negocios</option>
                        <option value="first">Primera Clase</option>
                    </select>
                </div>
            </div>
        </form>
    </section>
</header>
    <main class="index_main">

        <!-- TODO:
        - Implementar funcion en el input 'from' y 'to' para que pueda ser de tipo select, y autorellene los vuelos que haya disponibles
        - Implementar poder reservar vuelos y añadirlos al carrito, y posteriormente cuando se reserven añadir a reservas de cuenta.
        -->

        <%if (request.getParameter("from") != null && request.getParameter("to") != null) {%>
        <jsp:include page="flights-search-result.jsp"/>
        <%}%>

        <div class="jsp" id="login" style="display: none">
            <jsp:include page="login.jsp"/>
        </div>

        <div class="jsp" id="register" style="display: none">
            <jsp:include page="register.jsp"/>
        </div>

        <%if (request.getSession().getAttribute("username") != null) {%>
        <section class="user-profile">
            <h2>Bienvenido/a, <%=request.getSession().getAttribute("username")%>
            </h2>
            <form action="LogoutServlet" method="get">
                <button type="submit">CERRAR SESIÓN</button>
            </form>
        </section>
        <%}%>

    </main>

<%String loginError = (String) request.getAttribute("loginError"); %>

<%if (loginError != null) {%>
<div class="error">
    <div class="error__icon">
        <svg fill="none" height="24" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg">
            <path d="m13 13h-2v-6h2zm0 4h-2v-2h2zm-1-15c-1.3132 0-2.61358.25866-3.82683.7612-1.21326.50255-2.31565 1.23915-3.24424 2.16773-1.87536 1.87537-2.92893 4.41891-2.92893 7.07107 0 2.6522 1.05357 5.1957 2.92893 7.0711.92859.9286 2.03098 1.6651 3.24424 2.1677 1.21325.5025 2.51363.7612 3.82683.7612 2.6522 0 5.1957-1.0536 7.0711-2.9289 1.8753-1.8754 2.9289-4.4189 2.9289-7.0711 0-1.3132-.2587-2.61358-.7612-3.82683-.5026-1.21326-1.2391-2.31565-2.1677-3.24424-.9286-.92858-2.031-1.66518-3.2443-2.16773-1.2132-.50254-2.5136-.7612-3.8268-.7612z"
                  fill="#393a37"></path>
        </svg>
    </div>
    <div class="error__title"><%=loginError%>
    </div>
    <div class="error__close" onclick="errorClose(this)">
        <svg height="20" viewBox="0 0 20 20" width="20" xmlns="http://www.w3.org/2000/svg">
            <path d="m15.8333 5.34166-1.175-1.175-4.6583 4.65834-4.65833-4.65834-1.175 1.175 4.65833 4.65834-4.65833 4.6583 1.175 1.175 4.65833-4.6583 4.6583 4.6583 1.175-1.175-4.6583-4.6583z"
                  fill="#393a37"></path>
        </svg>
    </div>
</div>
<%}%>

<footer>
    <p>&copy; 2024 Reserva de Vuelos. Todos los derechos reservados.</p>
</footer>

<script src="./js/error-close.js"></script>
<script src="./js/toggle-login-register.js"></script>
</body>
</html>
