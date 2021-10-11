window.addEventListener('load', function () {

    let tbody = document.querySelector('tbody');

    const url = '/odontologos/getAll';
    const settings = {
        method: 'GET'
    }

    fetch(url, settings)
        .then(response => response.json())
        .then(odontologoList => {

            data = odontologoList.sort((a, b) => a.id - b.id)

            data.forEach(odontologo => {

                const deleteButton = `<button class="delete" id="delete_${odontologo.id}" onclick="deleteBy(${odontologo.id})"><i class="fas fa-trash-alt"></i></button>`


                const updateButton = `<button class="edit" id="edit_${odontologo.id}" onclick="modify(${odontologo.id})"><i class="far fa-edit"></i></button>`

                const odontologoRow = document.createElement('tr');
                odontologoRow.innerHTML =
                    `<tr id='fila_' + ${odontologo.id} > 
                        <td>  ${odontologo.id}  </td> 
                        <td class=\td_nombre\>  ${odontologo.nombre.toUpperCase()} </td> 
                        <td class=\td_apellido\>  ${odontologo.apellido.toUpperCase()}  </td> 
                        <td>  ${odontologo.matricula}  </td> 
                        <td class="botonera">  ${deleteButton} ${updateButton}  </td> 
                    </tr>`; 

                tbody.append(odontologoRow);
                        
            })
           
        })

})
