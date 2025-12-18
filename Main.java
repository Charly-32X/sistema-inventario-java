//aqui va a estar el menú
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        limpiarPantalla();
        Scanner scanner = new Scanner(System.in);

        ProductoDOA doa = new ProductoDOA();

        int opcion = 0;

        while (opcion!=5) {

            System.out.println("                                 ");
            System.out.println("--Sistema de inventario el pepe");
            System.out.println("1. Ver inventario");
            System.out.println("2. Agregar productos al inventario");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Modificar");
            System.out.println("5. salir");
            System.out.println("Elige una opcion: ");

            if (scanner.hasNextInt()){
                opcion =  scanner.nextInt();
                scanner.nextLine(); //esta funcion limpia el buffer del enter
            } else {
                System.out.println("Error, debe ingresar algun número.");
                scanner.nextLine();
                opcion = 0;
                continue;
            }

                switch (opcion) {
                case 1:
                    limpiarPantalla();
                    doa.listar();
                    break;

                case 2:
                    limpiarPantalla();
                    System.out.println("--Nuevo Ingreso");
                    System.out.println("Nombre del producto: ");
                    String nombre = scanner.nextLine();


                    System.out.println("Ingrese el precio.");
                    System.out.println("Precio: ");
                    while(!scanner.hasNextDouble()){ //este while, es un comprobador
                        System.out.println("Unicamente se aceptan numeros para el precio");
                        scanner.next();
                    }
                    double precio = scanner.nextDouble();
                    
                    System.out.println("Ingrese la cantida de stock");
                    System.out.println("Stock: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("El stock acepta nada mas numeros");
                        scanner.next();    
                    }
                    int stock = scanner.nextInt();
                    scanner.nextLine();

                    doa.insertar(nombre, precio, stock);
                    break;

                    case 3:
                        limpiarPantalla();
                        doa.listar();
                        System.out.println("Que producto desea eliminar?");
                        System.out.println("Ingrese la ID del producto:");
                            while(!scanner.hasNextInt()){ //otro comprobador
                                System.out.println("Solamente se puede ingresar números");
                                scanner.next();
                            }
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        String detalles = doa.obtenerDetallesProducto(id); //asignamos una variable con la funcion de obtener detalles

                        if (detalles!= null){ //si encuentra que el producto existe, o sea que es distinto a null entonces se podra borrar.
                            System.out.printf("¿Estas seguro que quieres eliminar este producto? "+ detalles);
                            System.out.println("Estas seguro? si/no");
                            String sino = scanner.nextLine();
                            if (sino.equalsIgnoreCase("si")) {
                                doa.eliminar(id);
                                System.out.println("Presione enter para continuar");
                                scanner.nextLine();
                            } else {
                                System.out.println("El producto no se eliminara");
                            }
                        } else {
                            System.out.println("No existe ningún producto con esa ID. " + id);

                        }
                        
                    break;

                    case 4:
                        limpiarPantalla();
                        doa.listar();
                        System.out.println("Que producto desea modificar?");
                        System.out.println("Ingrese la ID del producto:");
                            while(!scanner.hasNextInt()){ //otro comprobador
                                System.out.println("Solamente se puede ingresar números");
                                scanner.next();
                            }
                        int iD = scanner.nextInt();
                        scanner.nextLine();
                        String modi = doa.obtenerDetallesProducto(iD); //asignamos una variable con la funcion de obtener detalles
                        

                        if (modi!=null) {
                            
                            System.out.printf("Estas seguro que quieres modificar este producto?" + modi);
                            System.out.println("Estas seguro? Si/No");
                            String sino = scanner.nextLine();
                            if (sino.equalsIgnoreCase("si")){
                                System.out.println("Ingrese nuevo nombre del producto: ");
                                String name = scanner.nextLine();   

                                System.out.println("Ingrese el nuevo precio: ");
                                while(!scanner.hasNextDouble()){ //este while, es un comprobador
                                System.out.println("Unicamente se aceptan numeros para el precio");
                                scanner.next();
                                }
                                double preci = scanner.nextDouble();

                                System.out.println("Ingrese el nuevo stock: ");
                                while (!scanner.hasNextInt()) {
                                 System.out.println("SOlamente se aceptan numeros para el stock. ");
                                 scanner.next();
                                }
                                int stocki = scanner.nextInt();
                                scanner.nextLine();
                                doa.modificar(name, preci, stocki, iD);
                                System.out.println("Presione enter para continuar.");
                                scanner.nextLine();

                            } else {
                                System.out.println("No se modificara el producto.");
                            }
                        } else {
                            System.out.println("No existe ningún producto con esa ID. "+ iD);
                        }

                        break;

                    case 5:
                        System.out.println("Chau.");
                        break;
            
                default:
                    System.out.println("Ingrese una opción");
            }

        
        }
        scanner.close();
    }

    public static void limpiarPantalla() {
                    try {
            // Esto invoca directamente al comando 'clear' deñ Linux Mint
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            // Si falla, no hace nada (si queres para windows lo agregas aquí.)
            System.out.println("Error al limpiar consola.");
        }
     }
}