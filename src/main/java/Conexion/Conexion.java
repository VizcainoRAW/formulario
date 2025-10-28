/**
 * el metodo Conexion, se encarga de hacer la conexion de la base de datos
 * con el programa.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;


public class Conexion {
    private static final Logger log = Logger.getLogger(Conexion.class.getName());

    public Connection connection = null;  // La conexion con la BD
    private static final String URL = "jdbc:mysql://192.9.0.206:3307/prueba";
    private static final String USER = "root";
    private static final String PASS = "123";

    /**
     * Crea la conexion con la base de datos y la almacena en el atributo ´connection´.
     *
     * el atributo inicia como nulo, se tiene que llamar a esta funcion por lo menos una vez para inicializar la conexion.
     *
     * este metodo ejecuta un info log de util java.util.logging.Logger con el siguiente mensaje: "Conexion creada con exito" cuado
     * se crea con exito una conexion. en caso de error se hace catch ejecutanto un log del mismo logger con un nivel "SEVERE" con el mensaje "Error al conectarse a la base de datos (exception)"
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Conexion() throws SQLException, ClassNotFoundException { // se encarga de realizar la conexionsss
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USER,PASS);
            log.info("Conexion creada con exito");
        } catch (ClassNotFoundException e) {
            log.log(Level.SEVERE, "Error al conectarse a la base de datos: ",e);
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "Error al conectarse a la base de datos: ",ex);
        }
    }

    /**
     * Cierra la conexion a la base de datos.
     * terminano con el acceso a la base de datos a todo objeto que este usando la referencia al atributo ´connecion´ de esta clase
     */
    public void cerrar() {
        try {
            connection.close();
        }
        catch (Exception ex) { }
    }
}