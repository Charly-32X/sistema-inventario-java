# Sistema de Inventario CRUD (Java + MySQL)

Sistema de gestión de inventario de consola desarrollado en Java utilizando arquitectura DAO y patrón MVC.

##  Funcionalidades
- **Conexión a Base de Datos:** Uso de JDBC con MySQL.
- **CRUD Completo:**
  -  Agregar productos.
  - Listar inventario (Ver productos).
  -  Modificar productos (con validación de ID).
  -  Eliminar productos.
- **Persistencia:** Los datos se guardan en una base de datos real, no en memoria.

##Tecnologías
- Java (JDK 17+)
- MySQL
- Linux Mint (Entorno de desarrollo)
- Visual Studio Code

##Cómo ejecutar
1. Clonar el repositorio.
2. Importar la base de datos (script SQL incluido).
3. Compilar: `javac *.java`
4. Ejecutar: `java -cp .:mysql-connector-j-9.5.0.jar Main`

---
*Desarrollado por [Charly Xol] como proyecto de portafolio.*
