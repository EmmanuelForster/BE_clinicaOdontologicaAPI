window.addEventListener('load', function () {

    let tbody = document.querySelector('tbody');

    const url = '/pacientes/getAll';
    const settings = {
        method: 'GET'
    }

    fetch(url, settings)
        .then(response => response.json())
        .then(pacienteList => {

            data = pacienteList.sort((a, b) => a.id - b.id)

            data.forEach(paciente => {


                const deleteButton = `<button class="delete" data-paciente="delete_${paciente.id}" onclick="deleteBy(${paciente.id})"><i class="fas fa-trash-alt"></i></button>`


                const updateButton = `<button class="edit" data-paciente="edit_${paciente.id}" onclick="modify(${paciente.id})"><i class="far fa-edit"></i></button>`

                // const infoButton = `<button class="info" id="${paciente.id}"><i class="fas fa-info-circle"></i></button>`


                const pacienteRow = document.createElement('tr');
                pacienteRow.innerHTML =
                    `<tr id='fila_' + ${paciente.id} > 
                        <td>  ${paciente.id}  </td> 
                        <td class=\td_apellido\>  ${paciente.apellido.toUpperCase()} </td> 
                        <td class=\td_nombre\>  ${paciente.nombre.toUpperCase()}  </td> 
                        <td>  ${paciente.dni}  </td> 
                        <td>  ${paciente.email}  </td> 
                        <td>  ${paciente.fechaAlta}  </td> 
                        <td class="botonera"> ${deleteButton} ${updateButton} </td> 
                    </tr>`;

                tbody.append(pacienteRow);

            })

        })

})