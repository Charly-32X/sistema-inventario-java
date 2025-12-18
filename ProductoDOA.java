//en este archivo voy a meter todo el código para almacenar las futuras tablas.

import java.sql.*;

public class ProductoDOA {

    //con este public void, vamosa a insertar datos a nuestro inventario
    public void insertar(String nombre, double precio, int stock){
        String sql = "INSERT INTO productos (nombre, precio, stock) VALUES (?,?,?)";
        //esta variable es el puente entre sql y java.

        try(Connection con =  Conexion.conectar(); //conecta a la base de datos
        PreparedStatement pstmt = con.prepareStatement(sql)){ //preapara el mensaje

            pstmt.setString(1, nombre);
            pstmt.setDouble(2, precio); //aqui va guardando en las columnas 
            pstmt. setInt(3, stock);
            pstmt.executeUpdate(); //aqui ya es como un guardar definitivo
            System.out.println("El producto se guardó correctamente :D.");
            } catch (SQLException e){
                System.out.println("El producto no se pudo guardar :(."); //maneja el error.
            }
        

    }

    //Ahora este public void servira para mostrar en pantalla lo que se guardé o tu inventario
    public void listar(){
        // este string sql, es la orden que le mandara a la base de datos.
        String sql = "SELECT * FROM productos";
        try (Connection con = Conexion.conectar(); //este try, que tiene contenido dentro
            Statement stmt = con.createStatement(); // del parentesis, se llama try-with-resource
            ResultSet rs = stmt.executeQuery(sql) ) { // el conection conecta a la base de datos, statement es el que busca el mensaje y el result es el resultado que seria el mensaje con los datos

                System.out.println("---INVENTARIO---");
                System.out.printf("%-3s | %-20s | %-2s | %-5s%n", "ID", "NOMBRE", "PRECIO", "STOCK");
                while (rs.next()) { //el while(rs.next) crea un bucle, donde busca contenid en las filas, al encontrar inicia el bucle hasta que termine y se detiene el bucle
                    int idREal = rs.getInt("id"); //aqui obtenemos el id
                    String nombre = rs.getString("nombre");
                    Double precio = rs.getDouble("precio");
                    int stock = rs.getInt("stock");

                    System.out.printf("%-3d | %-20s | Q%.2f | %-5d%n", idREal, nombre, precio, stock);
                }

            } catch (SQLException e){ //este catch es el manejo de error para el sql, cualquier error cae aquí y mantiene seguridad.
                System.out.println("Error al intentar listar: "+ e.getMessage());
            }
    }
    
    //funcion para eliminar
    public void eliminar(int id){
        String sql = "DELETE FROM productos WHERE id = ?";
        try (Connection con = Conexion.conectar();
            PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, id);

                int filasdelet = pstmt.executeUpdate();

                if (filasdelet > 0){
                    System.out.println("Producto eliminado con exito.");
                } else{
                    System.out.println("EL producto no se encontró");
                }
            
        } catch (Exception e) {
            System.out.println("Error, no fue posible eliminar o no existe el producto:" + e.getMessage());
            
        }
    }


    // Función para BUSCAR un solo producto por ID
    public String obtenerDetallesProducto(int id) {
        String sql = "SELECT nombre, precio FROM productos WHERE id = ?";
        String resultado = null;

        try (Connection con = Conexion.conectar();
            PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Si lo encuentra, guardamos los datos en un texto bonito
                resultado = rs.getString("nombre") + " (Q" + rs.getDouble("precio") + ")";
            }

        } catch (Exception e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
        
        return resultado; // Devuelve el texto o null si no lo encontró
    }



    public void modificar (String nombre, double precio, int stock, int id) {
        String sql = "UPDATE productos SET nombre = ?, precio = ?, stock = ? WHERE id = ?";
       try (Connection con = Conexion.conectar();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setString(1, nombre);
            pstmt.setDouble(2, precio); //aqui va modificanto en las columnas 
            pstmt.setInt(3, stock);
            pstmt.setInt(4, id);
            pstmt.executeUpdate(); //aqui ya es como un guardar definitivo
            System.out.println("El producto se módifico correctamente correctamente :D.");
       } catch (Exception e) {
            System.out.println("Error, No existe dicha ID.");
 
       }

    }
}  

    