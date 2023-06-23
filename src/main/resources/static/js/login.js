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

      if(response=='Correcto'){
            window.location.href = 'tables.html';
      } else{
            alert("Credenciales equivocadas, intente nuevamente");
      }
}