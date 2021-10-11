function deleteBy(id){
          const url = '/odontologos/delete/'+ id;
          const settings = {
              method: 'DELETE'
          }
          fetch(url,settings)
           .then(response => console.log(response))

          
          location.reload();

}