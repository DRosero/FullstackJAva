// Call the dataTables jQuery plugin
$(document).ready(function() {

});


async function registrarUsuarios(){
    let datosUsuarioRegistrar={};
    datosUsuarioRegistrar.nombre=document.getElementById('txtNombre').value;
    datosUsuarioRegistrar.apellido=document.getElementById('txtApellido').value;
    datosUsuarioRegistrar.correo=document.getElementById('txtCorreo').value;
    datosUsuarioRegistrar.password=document.getElementById('txtPassword').value;
    datosUsuarioRegistrar.celular=document.getElementById('txtCelular').value;

    let repetirPassword=document.getElementById('txtRepetirPassword').value;

    if(datosUsuarioRegistrar.password!=repetirPassword){
        alert('Las contraseñas no coinciden');
        return;
    }


      const request = await fetch('/users', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(datosUsuarioRegistrar)
      });
      const users = await request.json();
}

