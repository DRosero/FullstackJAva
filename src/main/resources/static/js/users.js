// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios();
  $('#users').DataTable();
});


async function cargarUsuarios(){

      const request = await fetch('/users', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }
      });
      const users = await request.json();

      let listadoHtml='';


      for (let user of users){
        let botonEliminar='<a href="#" onclick="eliminarUsuario('+user.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
        let usuarioHtml='<tr><td>'+user.id+'</td><td>'+user.nombre+'</td><td>'+user.apellido+'</td><td>'+user.correo+'</td><td>'+user.celular+'</td><td>'+botonEliminar+'</td></tr>';
        listadoHtml+=usuarioHtml;
      }

      console.log(users);

      document.querySelector('#users tbody').outerHTML=listadoHtml;
}

async function eliminarUsuario(id){

    if(!confirm('¿Desea borrar el usuario?')){
        return;
    }
    const request = await fetch('/users/'+id, {
            method: 'DELETE',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            }
          });
    location.reload();
}