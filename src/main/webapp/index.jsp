<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reserva de Vuelos</title>
    <link rel="stylesheet" href="./css/styles.css">
    <link rel="stylesheet" href="./css/error-css.css">
</head>
<body>
<header>
    <h1>TEIDE RESERVAS</h1>
</header>
<main>
    <section class="reservation-form">
        <h2>Reserva tu vuelo</h2>
        <form class="form-wrapper" action="FlightSearchServlet" method="post">
            <div class="form-group">
                <label for="from">Desde</label>
                <input type="text" id="from" name="from" required>
            </div>
            <div class="form-group">
                <label for="to">Hacia</label>
                <input type="text" id="to" name="to" required>
            </div>
            <div class="form-group">
                <label for="departure-date">Fecha de Salida</label>
                <input type="date" id="departure-date" name="departure-date">
            </div>
            <div class="form-group">
                <label for="return-date">Fecha de Regreso</label>
                <input type="date" id="return-date" name="return-date">
            </div>
            <div class="form-group">
                <label for="passengers">Pasajeros</label>
                <input type="number" id="passengers" name="passengers" min="1" max="10">
            </div>
            <div class="form-group">
                <label for="class">Clase</label>
                <select id="class" name="class" required>
                    <option value="economy">Economica</option>
                    <option value="business">Negocios</option>
                    <option value="first">Primera Clase</option>
                </select>
            </div>
            <button type="submit">BUSCAR VUELOS</button>
        </form>
    </section>
    <section class="login-form">
        <form action="LoginServlet" method="post">
            <label for="username">Nombre de usuario:</label>
            <input type="text" id="username" name="username">
            <label for="password">Contraseña:</label>
            <input type="password" name="password" id="password">
            <button type="submit">INICIAR SESIÓN</button>
            <a href="register.jsp">Registro</a>
        </form>
    </section>
</main>

<div class="error" style="display: none">
    <div class="error__icon">
        <svg fill="none" height="24" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg"><path d="m13 13h-2v-6h2zm0 4h-2v-2h2zm-1-15c-1.3132 0-2.61358.25866-3.82683.7612-1.21326.50255-2.31565 1.23915-3.24424 2.16773-1.87536 1.87537-2.92893 4.41891-2.92893 7.07107 0 2.6522 1.05357 5.1957 2.92893 7.0711.92859.9286 2.03098 1.6651 3.24424 2.1677 1.21325.5025 2.51363.7612 3.82683.7612 2.6522 0 5.1957-1.0536 7.0711-2.9289 1.8753-1.8754 2.9289-4.4189 2.9289-7.0711 0-1.3132-.2587-2.61358-.7612-3.82683-.5026-1.21326-1.2391-2.31565-2.1677-3.24424-.9286-.92858-2.031-1.66518-3.2443-2.16773-1.2132-.50254-2.5136-.7612-3.8268-.7612z" fill="#393a37"></path></svg>
    </div>
    <div class="error__title">lorem ipsum dolor sit amet</div>
    <div class="error__close"><svg height="20" viewBox="0 0 20 20" width="20" xmlns="http://www.w3.org/2000/svg"><path d="m15.8333 5.34166-1.175-1.175-4.6583 4.65834-4.65833-4.65834-1.175 1.175 4.65833 4.65834-4.65833 4.6583 1.175 1.175 4.65833-4.6583 4.6583 4.6583 1.175-1.175-4.6583-4.6583z" fill="#393a37"></path></svg></div>
</div>

<footer>
    <p>&copy; 2024 Reserva de Vuelos. Todos los derechos reservados.</p>
</footer>
</body>
</html>
