/**
 * NOMBRE DE LA CLASE: MetodoActualizarDemografico
 * AUTOR: Oscar Rolong Schweiger
 * DESCRIPCION: En este metodo se encuentra lo necesario para consultar y actualizar
 * 				los datos demograficos del paciente.
 * 				
 */
package Metodo;

import java.sql.PreparedStatement;
import java.sql.Statement;

import Conexion.Conexion;


/**
 * Esta clase esta encargada de hacer las operaciones CRUD a la base de datos, dirijida a la tabla {@code Usuarios} <br>
 *  <p>
 * Tabla cuyos atributos son:
 * <blockquote><pre>
 * String identificacion,
 * String nombre,
 * String usuario,
 * String contrasena,
 * String estado,
 * String fecha
 * </pre></blockquote>
 * @category persistencia / DAO (Data Acces Object)
 * @author Ivan Vizcaino
 */
public class MetodoCrud {

	/**
	 * Guarda en la base de datos los parametros ingresados todos en formato de texto {@code String}
	 * <p>
	 * No evita duplicados
	 *  
	 * @param identificacion numero de identificacion, no distingue tipo, puede contener las iniciales dle tipo
	 * @param nombre nombre del ingreso
	 * @param usuario
	 * @param contrasena
	 * @param estado
	 * @param fecha
	 */
	public void Insertusuarios(String identificacion,String nombre,String usuario,String contrasena,
			String estado,String fecha){
		
		try {
			PreparedStatement ps = null;
			Conexion con = new Conexion();
			ps=con.connection.prepareStatement("INSERT INTO personas (cc, Nombre, Usuario, Contraseña,"
					+ "Estado,FechaNacimiento)  "
					+ "VALUES (?,?,?,?,?,?)");
			ps.setString(1, identificacion);
			ps.setString(2, nombre);
			ps.setString(3, usuario);
			ps.setString(4, contrasena);
			ps.setString(5, estado);
			ps.setString(6, fecha);
			ps.executeUpdate();
			ps.close();
			con.cerrar();
		} catch (Exception e) {
			System.out.println("Error en Insertusuarios" + e);
		}
	}


public java.sql.ResultSet obtenerDatos(String cedula) {
	/**
	 * en este metodo se obtienen los datos del paciente al cual se le quiere
	 * modificar algun dato demografico y tiene como datos de entrada el tipo de
	 * documento y el numero del documento.
	 */

	java.sql.ResultSet rs = null;
	Statement st = null;
	try {
		Conexion con = new Conexion();
		st = con.connection.createStatement();
		rs = st.executeQuery("select cc, Nombre, Estado , FechaNacimiento from personas where cc ='" + cedula+ "'");
	} catch (Exception ex) {
		System.out.println("Error en MetodoCrud>>obtenerDatosPacienteActuaDemogra " + ex);
	}
	return rs;
} 

public  void ActualizarDatos(String Identi, String Nombre, String Estado, String Fecha) {

	/**
	 * en este metodo se obtienen los datos que fueron modificados para su posterior
	 * actualizacion. se tienen como datos de entrada todos los datos que fueron
	 * modificados
	 */
	
	PreparedStatement st = null;
	try {
		Conexion con = new Conexion();
		st = con.connection.prepareStatement("update personas set  Nombre='"+ Nombre + "',Estado='" + Estado + "',FechaNacimiento='" + Fecha + "'  where cc='" + Identi + "'");
		st.executeUpdate();
		st.close();
		con.cerrar();
	} catch (Exception ex) {
		System.out.println("Error en MetodoCrud>>ActualizarDatos " + ex);
		ex.getMessage();
	}	
}

public void eliminar(String cedula) {
	System.out.println("");
	PreparedStatement st = null;
	try {
		Conexion con = new Conexion();
		st = con.connection.prepareStatement("DELETE FROM personas WHERE cc = '" + cedula +"'");
		st.executeUpdate();
		st.close();
		con.cerrar();
		
	} catch (Exception ex) {
		System.out.println("Error en MetodoCrud>>ActualizarDatos " + ex);
		ex.getMessage();
	}
}
}
