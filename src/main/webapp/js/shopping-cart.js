const shoppingCartButton = document.querySelector(".shopping-cart-button");
const shoppingCartWrapper = document.querySelector(".cart-wrapper");
const shoppingCartCloseButton = document.querySelector(".cart-close-button");

shoppingCartButton.addEventListener("click", () => {
   shoppingCartWrapper.style.display === "none" ? shoppingCartWrapper.style.display = "block" : shoppingCartWrapper.style.display = "none";
});

shoppingCartCloseButton.addEventListener("click", () => {
    shoppingCartWrapper.style.display = "none";
});