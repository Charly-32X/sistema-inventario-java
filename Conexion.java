//Aqui estará todo el codigo para la conexión a la base de datos.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/inventario";
    private static final String USER = "dev";
    private static final String PASS = "admin123";


    public static Connection conectar() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch(ClassNotFoundException e) {
            throw new SQLException("No se encontró el Driver");
        }

    }
}
// este codigo genera la conexión con la base de datos, utiliza url (tu local host)
// el nombre del usuario y contraseña (debiste haberla creado antes o te la tiene que dar)
//despeus se crea una "funcion" que usa las funciones de los import para conectarse a la base de datos
// utilizamos SIEMPRE el try, para el manejo de errores, sin  java eso no nos deja utilzar.