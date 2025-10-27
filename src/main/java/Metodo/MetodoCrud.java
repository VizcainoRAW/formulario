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

public class MetodoCrud {
	public void Insertusuarios(String identificacion,String nombre,String usuario,String contrasena,
			String estado,String fecha){
		
		try {
			PreparedStatement ps = null;
			Conexion con = new Conexion();
			ps=con.conn.prepareStatement("INSERT INTO personas (cc, Nombre, Usuario, Contraseña,"
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

	public java.sql.ResultSet ObtenerSiglaTipoDocumento() {
		java.sql.ResultSet rs = null;
		Statement st = null;
		try {
			Conexion con = new Conexion();
			st = con.conn.createStatement();
			rs = st.executeQuery("SELECT sigla,descripcion FROM adm_tipodocumento");
		} catch (Exception ex) {
			System.out.println("Error en MetodoCrud>>ObtenerSiglaTipoDocumento " + ex);
		}

		return rs;
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
		st = con.conn.createStatement();
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
		st = con.conn.prepareStatement("update personas set  Nombre='"+ Nombre + "',Estado='" + Estado + "',FechaNacimiento='" + Fecha + "'  where cc='" + Identi + "'");
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
		st = con.conn.prepareStatement("DELETE FROM personas WHERE cc = '" + cedula +"'");
		System.out.println(st);
		st.executeUpdate();
		st.close();
		con.cerrar();
		
	} catch (Exception ex) {
		System.out.println("Error en MetodoCrud>>ActualizarDatos " + ex);
		ex.getMessage();
	}
}






}
