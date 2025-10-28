/**
 * 
 */
function getXMLObject()  //XML OBJECT
{
   var xmlHttp = false;
   try {
     xmlHttp = new ActiveXObject("Msxml2.XMLHTTP")  // For Old Microsoft Browsers
   }
   catch (e) {
     try {
       xmlHttp = new ActiveXObject("Microsoft.XMLHTTP")  // For Microsoft IE 6.0+
     }
     catch (e2) {
       xmlHttp = false   // No Browser accepts the XMLHTTP Object then false
     }
   }
   if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
     xmlHttp = new XMLHttpRequest();        //For Mozilla, Opera Browsers
   }
   return xmlHttp;  // Mandatory Statement returning the ajax object created
}
var xmlhttp = new getXMLObject(); //xmlhttp holds the ajax object
//////////////////////////////////////////////////////////////////////////////////////////////////////////
function guardar(){
	var identificacion = document.getElementById('identificacion').value;
	var nombre =document.getElementById("nombre").value;
	var usuario= document.getElementById('usuario').value;
	var contrasena =document.getElementById("contrasena").value;
	var estado =document.getElementById("estado").value;
	var fecha= document.getElementById('fecha').value;
	
	if(identificacion==""){
		alert("INGRESE IDENTIFICACION");
		document.getElementById("identificacion").focus();
		return
	}
	if(nombre ==""){
		alert("INGRESE NOMBRE");
		document.getElementById("nombre").focus();
		return
	}
	if(usuario ==""){
		alert("INGRESE USUARIO")
		document.getElementById("usuario").focus();
		return
	}
	if(contrasena==""){
		alert("INGRESE CONTRASEÑA")
		document.getElementById("contrasena").focus();
		return
	}
	if(estado==""){
		alert("INGRESE ESTADO")
		document.getElementById("estado").focus();
		return
	}
	if(fecha==""){
		alert("INGRESE FECHA")
		document.getElementById("fecha").focus();
		return		
	}
	ajax = getXMLObject();
	ajax.open("POST", "ControFormulario", true);
	ajax.onreadystatechange = function(){
		if (ajax.readyState == 4) {
			window.location.reload();
		}
	}
	ajax.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf-8');
	ajax.send("valor=Guardar" 
			+ "&identificacion="+identificacion
			+ "&nombre="+nombre
			+ "&usuario="+usuario
			+ "&contrasena="+contrasena
			+ "&estado="+estado
			+ "&fecha="+fecha
	);
	
	alert("ingreso echo: " + nombre);
}


function MostrarCrud(){
	var contenido = document.getElementById('ingreso');
	ajax = getXMLObject();
	ajax.open("POST", "ControFormulario", true);
	ajax.onreadystatechange = function(){
		if (ajax.readyState == 4) {
			contenido.innerHTML = ajax.responseText;
		}
	}
	ajax.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf-8');
	ajax.send("valor=Inicio");
}

function mostrarBusqueda(){
	 console.log("rendering buscador")
		var busqueda_div = document.getElementById('busqueda');
		ajax = getXMLObject();
		ajax.open("POST", "ControFormulario", true);
		ajax.onreadystatechange = function(){
			if (ajax.readyState == 4) {
				busqueda_div.innerHTML = ajax.responseText;
			}
		}
		ajax.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf-8');
		ajax.send("valor=Busqueda");	
}
	
	
	
function buscar(){
	var contenido = document.getElementById('mostrar');
	var cedula= document.getElementById('txtnumdocu').value;
	var er = new RegExp(/\s/);


		if(cedula==""){
		alert("Ingrese numero de documento");
		document.getElementById("txtnumdocu").value;	
		}else{
			if(er.test(cedula)){
				alert("No se permiten espacios en blanco");
				document.getElementById("txtnumdocu").focus();
			}else{
			ajax = getXMLObject();
			ajax.open("POST", "ControFormulario", true);
			ajax.onreadystatechange = function(){
				if (ajax.readyState == 4){
					
					document.getElementById('txtnumdocu').disabled=true;
					contenido.innerHTML = ajax.responseText;
                                      
      				}
			}
			ajax.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf-8');
			ajax.send("valor=Buscar" +
				   "&txtnumdocu="+cedula);
				
				}
			}
		}

function ActualizarD(){
	var txtIdentificaion = document.getElementById('txtIdentificaion').value;
	var txtNombre =document.getElementById("txtNombre").value;
	var txtEstado= document.getElementById('txtEstado').value;
	var txtFechaNaci =document.getElementById("txtFechaNaci").value;
	
	if(txtIdentificaion == ""){
		alert("INGRESE  DOCUMENTO");
		document.getElementById("txtIdentificaion").focus();
		}else{
		    if(txtNombre == ""){
			alert("INGRESE NOMBRE");
			document.getElementById("txtNombre").focus();
		}else{
			if(txtEstado == ""){
				alert("INGRESE ESTADO")
				document.getElementById("txtEstado").focus();
		}else{
			if(txtFechaNaci==""){
				alert("INGRESE FECHA")
				document.getElementById("txtFechaNaci").focus();
			}else{		

	ajax = getXMLObject();
	ajax.open("POST", "ControFormulario", true);
	ajax.onreadystatechange = function(){
		if (ajax.readyState == 4) {
			alert("Datos Actualizados con exito");
					window.location.reload();
		}
	}
	ajax.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf-8');
	ajax.send("valor=2" 
			+ "&txtIdentificaion="+txtIdentificaion
			+ "&txtNombre="+txtNombre
			+ "&txtEstado="+txtEstado
			+ "&txtFechaNaci="+txtFechaNaci
    );
	  }
	}	
  }
}
}

function eliminar(){
	var cedula = document.getElementById('txtIdentificaion').value;
	console.log("eliminando usuario identificado con: " + cedula)
	ajax = getXMLObject();
	ajax.open("POST", "ControFormulario", true);
	ajax.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf-8');
	ajax.send("valor=Eliminar" +
				   "&cedula="+cedula);
	
}

function noespacios() {
	var er = new RegExp(/\s/);
	var web = document.getElementById('txtnumdocu').value;
	if(er.test(web)){
		alert('No se permiten espacios');
		document.getElementById("txtnumdocu").focus();
		return false;
	}
            else
		return true;
} 	

		

	
