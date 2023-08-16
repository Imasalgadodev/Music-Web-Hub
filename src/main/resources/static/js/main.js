// Script para desplazarse suavemente a las secciones
document.addEventListener("DOMContentLoaded", () => {
    const links = document.querySelectorAll('a[href^="#"]');
    for (const link of links) {
        link.addEventListener("click", smoothScroll);
    }
});

function smoothScroll(event) {
    event.preventDefault();
    const targetId = event.currentTarget.getAttribute("href");
    const targetElement = document.querySelector(targetId);
    targetElement.scrollIntoView({
        behavior: "smooth",
        block: "start",
    });
}
