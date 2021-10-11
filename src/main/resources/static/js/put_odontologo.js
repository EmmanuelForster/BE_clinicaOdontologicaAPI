async function modify(odontologoId) {

    const { value: formValues } = await Swal.fire({
        title: 'Ingrese los datos del odontologo',
        html:
            '<input id="nombre" placeholder="Nombre">' +
            '<input id="apellido" placeholder="Apellido">' +
            '<input id="matricula" placeholder="Matricula">',
        focusConfirm: false,
        preConfirm: () => {
            
            return [
                document.getElementById('nombre').value,
                document.getElementById('apellido').value,
                document.getElementById('matricula').value
            ]
        }
    })
    

    if (formValues) {

        [nuevoNombre, nuevoApellido, nuevaMatricula] = formValues;

        let data = {
            id: odontologoId,
            apellido: nuevoApellido,
            nombre: nuevoNombre,
            matricula: nuevaMatricula
        }
        const url = '/odontologos/update';
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




