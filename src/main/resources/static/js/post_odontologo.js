window.addEventListener('load', function () {

    let nombre = document.getElementById('nombre');
    let apellido = document.getElementById('apellido');
    let matricula = document.getElementById('matricula');
    let formulario = document.getElementById('formulario');

    formulario.addEventListener('submit', (e) => {

        e.preventDefault();

        let data = {
            apellido: apellido.value,
            nombre: nombre.value,
            matricula: matricula.value
        }

        let settings = {
            method: 'POST',
            headers: { 'Content-Type': "application/json" },
            body: JSON.stringify(data)
        }

        fetch('/odontologos/create', settings)
            .catch(e => console.log(e))

        formulario.reset();
    })

})
