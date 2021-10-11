async function modify(pacienteId) {

    const { value: formValues } = await Swal.fire({
        title: 'Ingrese los datos del paciente',
        html:
            `<input id="nombre" placeholder="Nombre">
            <input id="apellido" placeholder="Apellido"> <br>
            <input id="dni" placeholder="DNI">
            <input id="email" placeholder="Email"> <br>
            <label for="fechaAlta">Fecha de alta:</label>
            <input id="fechaAlta"type=date name="fechaAlta"> <br>
            <input id="calle" placeholder="Calle">
            <input id="numero" placeholder="Numero"> <br>
            <input id="localidad" placeholder="Localidad">
            <input id="provincia" placeholder="Provincia">`,
        focusConfirm: false,
        preConfirm: () => {
            return [
                document.getElementById('nombre').value,
                document.getElementById('apellido').value,
                document.getElementById('dni').value,
                document.getElementById('email').value,
                document.getElementById('fechaAlta').value,
                document.getElementById('calle').value,
                document.getElementById('numero').value,
                document.getElementById('localidad').value,
                document.getElementById('provincia').value,
            ]
        }
    })


        if (formValues) {

            [nuevoNombre, nuevoApellido, nuevoDNI, nuevoEmail, nuevaFechaAlta, nuevaCalle, nuevoNumero, nuevaLocalidad, nuevaProvincia] = formValues;

            let data = {
                id: pacienteId,
                apellido: nuevoApellido,
                nombre: nuevoNombre,
                dni: nuevoDNI,
                email: nuevoEmail,
                fechaAlta: nuevaFechaAlta,
                domicilio: {
                    calle: nuevaCalle,
                    numero: nuevoNumero,
                    localidad: nuevaLocalidad,
                    provincia: nuevaProvincia,
                }


            }
            const url = '/pacientes/update';
            const settings = {
                method: 'PUT',
                headers: { 'Content-Type': "application/json" },
                body: JSON.stringify(data)
            }

            fetch(url, settings)
                .catch(e => console.log(e))

            location.reload()

        }
    
}

