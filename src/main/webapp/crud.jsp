 <%@  page language="java" 
 contentType="text/html; charset=utf-8" pageEncoding="utf-8"
  import="Conexion.Conexion"   import="java.sql.*,java.util.*"%>
 
 <%@ page session="true"%>
<%@ page language="java"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crud</title>
</head>
<script src="jss.js" type="text/javascript"></script>

<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<body onload="MostrarCrud();" id="back" >
		<table width="100%" class="style6" aling="center" >
			<tr>
				<td>
					<div id="ingreso" ></div>
				</td>
			</tr>
			<tr>
				<td  width="100%" colspan='6'>
					<div  id="busqueda"></div>	
				</td>
			</tr>
			<tr>
				<td  width="100%" colspan='6'>
					<div  id="mostrar"></div>
				</td>
			</tr>
		</table> 									
</body>
</html>