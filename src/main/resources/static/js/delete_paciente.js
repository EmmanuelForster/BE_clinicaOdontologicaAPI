function deleteBy(id){
    const url = `/pacientes/delete/${id}`
    const settings = {
        method: 'DELETE'
    }
    fetch(url,settings)
     .then(response => console.log(response))

    
    location.reload();

}