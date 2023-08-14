const popup = document.getElementById('myModal');
    const closePopupBtn = document.querySelector('.close');
    const profileDetails = popup.querySelector('#profile-details');

    // Función para abrir el pop-up y cargar la información del músico
    function openProfile(id) {
        fetch(`/musician/${id}`)
            .then(response => response.text())
            .then(data => {
                profileDetails.innerHTML = data; // Carga los detalles del músico en el pop-up
                popup.style.display = 'block'; // Muestra el pop-up
            })
            .catch(error => {
                console.error('Error loading musician profile:', error);
            });
    }

    // Cerrar el pop-up
    closePopupBtn.addEventListener('click', () => {
        popup.style.display = 'none';
    });

    // Cerrar el pop-up al hacer clic fuera de él
    window.addEventListener('click', event => {
        if (event.target === popup) {
            popup.style.display = 'none';
        }
    });