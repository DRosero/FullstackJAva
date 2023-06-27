// Call the dataTables jQuery plugin
$(document).ready(function() {

});


async function iniciarSesion(){
    let datosUsuarioLogin={};

    datosUsuarioLogin.correo=document.getElementById('txtCorreoLogin').value;
    datosUsuarioLogin.password=document.getElementById('txtPasswordLogin').value;

      const request = await fetch('/login', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(datosUsuarioLogin)
      });
      const response = await request.text();

      if(response!='Error en inicio de sesion'){
      localStorage.token=response;
      localStorage.correo=datosUsuarioLogin.correo;
            window.location.href = 'users.html';
      } else{
            alert("Credenciales equivocadas, intente nuevamente");
      }
}