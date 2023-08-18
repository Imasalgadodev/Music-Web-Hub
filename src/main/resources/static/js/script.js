document.addEventListener("DOMContentLoaded", function () {
    const loginLink = document.getElementById("login-link");
    const loginFormContainer = document.getElementById("login-form-container");
    const registerPopup = document.getElementById("register-popup");
    const registerPopupLink = document.getElementById("register-popup-link");
    const loginPopupLink = document.getElementById("login-popup-link");

    loginLink.addEventListener("click", function (event) {
        event.preventDefault();
        loginFormContainer.style.display = "block";
    });

    registerPopupLink.addEventListener("click", function (event) {
        event.preventDefault();
        loginFormContainer.style.display = "none";
        registerPopup.style.display = "block";
    });

    loginPopupLink.addEventListener("click", function (event) {
        event.preventDefault();
        registerPopup.style.display = "none";
        loginFormContainer.style.display = "block";
    });
});
