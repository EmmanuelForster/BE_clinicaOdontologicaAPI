window.addEventListener('load', function () {

    let nombre = document.getElementById('nombre');
    let apellido = document.getElementById('apellido');
    let dni = document.getElementById('dni');
    let email = document.getElementById('email');
    let fechaAlta = document.getElementById('fechaAlta');
    let calle = document.getElementById('calle');
    let numero = document.getElementById('numero');
    let localidad = document.getElementById('localidad');
    let provincia = document.getElementById('provincia');
    let formulario = document.getElementById('formulario');


    formulario.addEventListener('submit', (e) => {

        e.preventDefault();

        let data = {
            apellido: apellido.value,
            nombre: nombre.value,
            dni: dni.value,
            email: email.value,
            fechaAlta: fechaAlta.value,
            domicilio: {
                calle: calle.value,
                numero: numero.value,
                localidad: localidad.value,
                provincia: provincia.value
            }
        }

        let settings = {
            method: 'POST',
            headers: { 'Content-Type': "application/json" },
            body: JSON.stringify(data)
        }

        fetch('/pacientes/create', settings)
            .catch(e => console.log(e))

            formulario.reset();

    })

})
