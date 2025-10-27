<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language='java' contentType="text/html; charset=utf-8" import='java.util.*' %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>SAIM Sistema de Apoyo de Informacion Medica</title> 
<script language="javascript" type="text/javascript" src="ajaxseguridad.js"></script>
<link rel="STYLESHEET" type="text/css" href="estilo_lab1.css" />
<link rel="SHORTCUT ICON" href="Imagenes/IconO.ico" />

<%
String Codu =(String)session.getAttribute("sfantasma");

if(Codu==null){
	Codu="";
}



%>
<style>
#ilogin
{
	background: #316AC5;
	width: 30%;
	height: 10%;
	border-left: 2px solid #888;
	border-top: 2px solid #888;
	border-bottom: 6px solid #888;
	border-right: 2px solid #888;
}
#mlogin
{
	background: #FFFFFF;
	width: 30%;
	height: 35%;
	border-left: 2px solid #888;
	border-top: 2px solid #888;
	border-bottom: 6px solid #888;
	border-right: 2px solid #888;
}
#flogin
{
	background: #316AC5;
	width: 30%;
	height: 10%;
	border-left: 2px solid #888;
	border-top: 2px solid #888;
	border-bottom: 2px solid #888;
	border-right: 2px solid #888;
}
</style>

<script language="javascript">
function A(){
	//var k=null;	tecla =   e.keyCode;  e.which;
	//if(tecla == 13){seguridad_login();}
	window.location.href="Seg_login.jsp";
}
function focus(){document.getElementById("contrasena").focus();}
</script>
</head>
<%
if(Codu.equals("")){%>

 <script language="javascript">alert("No Tiene Permiso Para ver esta Pagina....");window.location.href="Seg_login.jsp";</script>
 <%}else{
%>
<body onload="focus() ">
<br /><br /><br /><br /><br /><br /><br />
<script>
if (history.forward(1)){location.replace(history.forward(-1))}
</script>
<center>
<div id="ilogin"  class="style11" >
	<table width="100%" > <tr> <td>&nbsp;</td> </tr> </table>
<b>
S A I M
</b>
	<table width="100%" > <tr align="right"> <td id="sombra1"><p ></p></td> </tr> </table>
</div>
<div id="mlogin" >
	<form name="login" target="_self" class="style12" id="login">
		<table width="100%"  align="center" >
		
		
		<tr align="right">
<td>Nueva Contraseña:</td><td><div align="left" style="size:inherit"><input  name="contrasena" type="password" id="contrasena" size="30" maxlength="50" /></div></td>
		</tr>	<tr align="right">
<td>Confirmar Contraseña:</td><td><div align="left" style="size:inherit"><input  name="contrasenanew" type="password" id="contrasenanew" size="30" maxlength="50" /></div></td>
		</tr>	
<tr align="right">
<td>Número de documento:</td><td><div align="left" style="size:inherit"><input  name="tipodoc" type="text" id="tipodoc"  size="30" maxlength="50" /></div></td>
		</tr>	

		<tr class="style11"><td colspan="2" align="center"><input type="button" class="boton4" onclick="javascript:cambiapass(<%=Codu%>);" value="Actualizar"/> <input type="button" class="boton4" onclick="javascript:A();" value="Cancelar"/></td></tr>
		</table>
	</form> 
          <div id="seguridad" class="style8"></div>
</div>
<div id="flogin" class="style11" align="left" >
<br />
<table width="100%">
<tr align="left">
<td>
<b>
© 2017 Reservados todos los derechos
</b>
</td>
</tr>
<tr>
<td><a id="somos" href="javascript:tf();" style="color:white">Quienes Somos?</a></td>
</tr>
</table>
</div>
</center>
<input name="Codu" type="hidden" id="Codu" value="<%=Codu%>"/>
</body>
<%}
%>
</html>