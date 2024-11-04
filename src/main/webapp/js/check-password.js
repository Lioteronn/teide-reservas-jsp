// Obtener elementos del DOM
const form = document.getElementById("registerForm");
const password = document.getElementById("password");
const confirmPassword = document.getElementById("confirmPassword");
const errorMessage = document.getElementById("error-message");

// Función para verificar si las contraseñas coinciden
form.addEventListener("submit", function (event) {
    if (password.value !== confirmPassword.value) {
        event.preventDefault(); // Evita el envío del formulario
        errorMessage.style.display = "block"; // Muestra el mensaje de error
    } else {
        errorMessage.style.display = "none"; // Oculta el mensaje de error si coinciden
    }
});

// Ocultar mensaje de error al cambiar confirmPassword
confirmPassword.addEventListener("input", function () {
    if (password.value === confirmPassword.value) {
        errorMessage.style.display = "none";
    }
});