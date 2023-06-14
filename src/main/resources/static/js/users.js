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
        let usuarioHtml='<tr><td>'+user.id+'</td><td>'+user.nombre+'</td><td>'+user.apellido+'</td><td>'+user.correo+'</td><td>'+user.celular+'</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>';
        listadoHtml+=usuarioHtml;
      }

      console.log(users);

      document.querySelector('#users tbody').outerHTML=listadoHtml;




}