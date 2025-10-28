package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Metodo.MetodoCrud;

/**
 * Servlet implementation class ControFormulario
 */
@WebServlet("/ControFormulario")
public class ControFormulario extends HttpServlet {
	private static final long serialVersionUID = 1L;
//

       
   
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		String valor = req.getParameter("valor");
		//session = req.getSession(true);
		HttpSession session = req.getSession(true);
		res.setContentType("text/JSP;charset=UTF-8");
		PrintWriter out;
		out = res.getWriter();

		MetodoCrud mad = new MetodoCrud();
		
		
		ResultSet rs = null;
		ResultSet rs1 = null;
		
	//	String usuarioresp = (String) session.getAttribute("codusuario");
			
		if(valor.equals("1")){

		
			
		}
		
		switch (valor) {
			
		case "Inicio":
			out.print( INGRESO_JSP );
			break;
		
		case "Busqueda":
			out.print( BUSQUEDA_JSP );
			break;
		
		case "Guardar":
			String identificacion=req.getParameter("identificacion");
			String nombre=req.getParameter("nombre");
			String usuario=req.getParameter("usuario");
			String contrasena=req.getParameter("contrasena");
			String estado=req.getParameter("estado");
			String fecha=req.getParameter("fecha");
			
			try {
				mad.Insertusuarios(identificacion, nombre, usuario, contrasena, estado, fecha);
				
			} catch (Exception e) {
				// TODO: handle exception
			}	
			
			break;
			
		case "Buscar":
			String numdocu = req.getParameter("txtnumdocu");
			String Identificacion = "";
			String Nombre = "";
			String Estado = "";
			String FechaNaci = "";
			rs1 = mad.obtenerDatos(numdocu);
			try {
				while(rs1.next()) {
					Identificacion = rs1.getString(1);
					Nombre = rs1.getString(2);
					Estado = rs1.getString(3);
					FechaNaci = rs1.getString(4);
				}
				
				rs1.getStatement().getConnection().close();
				
			} catch (SQLException e) {
				out.print("Error 1.1" + e);
				e.printStackTrace();
			}
	
			out.print(" <TR>"
					+ "  <TD COLSPAN='2'>"
					+ "   <TABLE WIDTH='100%' BORDER='0' BORDERCOLOR='#104e8b' style='height:22px;'>"
					+ "    <TR>"
					+ "     <TD ALIGN='center' BGCOLOR='#104e8b' STYLE='color:#FFFFFF;'><B>ACTUALIZAR DATOS</B></TD>"
					+ "    </TR>"
					+ "   </TABLE>"
					+ "  </TD>"
					+ " </TR>"
					+ "<table width='100%'>");
		
		
			out.print("<tr><td align='left'><span>Identificacion</span></td><td align='left'><input name='txtIdentificaion' type='text' id='txtIdentificaion'  style='width:71.5%' maxlength='12' value='"
							+ Identificacion + "'disabled/></td>" 
					        + "<td align='left'><span >Nombre</span></td>"
							+ "<td align='left'><input name='txtNombre' type='text' id='txtNombre'   maxlength='12' style='width:71.5%' value='"
							+ Nombre + "'/></td></tr>"
							+"<tr><td align='left'><span>Estado</span></td><td align='left'><input name='txtelefijo' type='text' id='txtEstado' style='width:71.5%' maxlength='12' value='"
							+ Estado + "'/></td>"
                           + "<td align='left'><span > Fecha de Nacimiento</span></td>"
							+ "<td align='left'><input name='txtFechaNaci' type='text' id='txtFechaNaci'  maxlength='12' style='width:71.5%' value='"
							+ FechaNaci + "'/></td></tr>"
				           +"<tr>" 
				           +"<td colspan='6'  align='center' ><input type='button' name='btingresar' class='boton4' id='Eliminar' value='Eliminar' onclick='eliminar()'></td>"
							+"<td colspan='6'  align='center' ><input type='button' name='btingresar' class='boton4' id='Guardar' value='Actualizar' onclick='ActualizarD()'></td>"
							+"</tr>");
			break;
        
		case "Eliminar":
            String cedulaUsuarioAeliminar = req.getParameter("cedula");
            mad.eliminar(cedulaUsuarioAeliminar);
			break;

        case "2":
            String Identi = req.getParameter("txtIdentificaion");
            String nombreParaActualizar = req.getParameter("txtNombre");
            String estadoParaActualizar = req.getParameter("txtEstado");
            String fechanaci = req.getParameter("txtFechaNaci");
            String encabezado = "";


                try {
                    if (encabezado.equals("")) {
                        mad.ActualizarDatos(Identi, nombreParaActualizar, estadoParaActualizar, fechanaci);
                    }
                    //mad.ActualizarDatos(Identi, nombre, estado, fechanaci);
                } catch (Exception e) {
                    System.out.println("Error " + e);
                    e.printStackTrace();
                }
				break;
		}
    }
	
		
	
	
	private static  String INGRESO_JSP = "<table width='100%' aling='center'>"
					+ "							<tr>"
					+ "								<td colspan='6' id='cabecera2' class='style11'   BGCOLOR='#76A7AB' STYLE='color:#FFFFFF;'><div	align='center'><p><strong >SOLICITUD DE INGRESO</strong></p></div></td>"
					+ "							</tr>"
					+ "							<tr>	"
					+ "								<td><span class='Estilo8'>Identificacion</span></td>"
					+ "								<td><label> <input name='identificacin' type='text' id='identificacion'maxlength='20' value='' /> <span class='style8'>*</span></label></td>												"
					+ "								<td><span class='Estilo8'>Nombre</span></td>"
					+ "								<td><label> <input name='sa' type='text' id='nombre' maxlength='20' value='' /> </label></td>"
					+ "							</tr>"
					+ "							<tr>"
					+ "								<td><span class='Estilo8'>usuario</span></td>"
					+ "							 	<td><label> <input name='txtnombre' type='text' id='usuario'  value='' /><span class='style8'>*</span></label></td>"
					+ "								<td><span class='Estilo8'>Password</span></td>"
					+ "								<td><label> <input name='txtsnombre' type='text' id='contrasena'  value='' /><span class='style8'>*</span></label></td>"
					+ "							</tr>"
					+ "							<tr>"
					+ "								<td><span class='Estilo8'>Estado</span></td>"
					+ "								<td><label> <input name='sexo' type='text' id='estado' value='' /> <span class='style8'>*</span></label></td>"
					+ "								<td><span class='Estilo8'>Fecha Nacimiento</span></td>"
					+ "								<td><label> <input type='date' name='txtfechanaci' id='fecha' maxlength='10' /> <span class='style8'>*</span></label></td>"
					+ "								<td colspan='6'  align='center' ><input type='button' name='btingresar' class='boton4' id='MostrarBusqueda' value='     Iniciar busqueda    ' onclick='mostrarBusqueda()'></td>"
					+ "								<td colspan='6'  align='center' ><input type='button' name='btingresar' class='boton4' id='Guardar' value='     Ingresar    ' onclick='guardar()'></td>\r\\n"
					+ "							</tr>"
					+ "						</table>	";

	
	private static final String BUSQUEDA_JSP = "<TR>"
				+ "  <TD COLSPAN='2'>"
				+ "   <TABLE WIDTH='100%' BORDER='0' BORDERCOLOR='#104e8b' style='height:22px;'>"
				+ "    <TR>"
				+ "     <TD ALIGN='center' BGCOLOR='#104e8b' STYLE='color:#FFFFFF;'><B>BUSCAR USUARIO</B></TD>"
				+ "    </TR>"
				+ "   </TABLE>"
				+ "  </TD>"
				+ " </TR>"
				+ "<table width='100%' align='center' style='margin-top: 5px;'>"			
				+ "  <td width='40%' align='right'><div class='style6'>NUMERO DOCUMENTO</div></td>"
				+ "  <td width='240' align='right'><input type='text'class='form-control' id='txtnumdocu' name='txtnumdocu'size='30' onkeyup='noespacios()'  maxlength='15'/><span class='style8'>*</span></td>"
				+ "  <td width='238'><input id='Button' type='button' class='btn btn-info' value='Buscar' onclick='buscar()'/></td>"
				+ " </tr>" 
				+ "</table>";
}