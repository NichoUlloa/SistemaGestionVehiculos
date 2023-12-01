package vista;

import java.util.ArrayList;
import java.util.Scanner;
import model.*;

public class Menu {

    public static void menuPrincipal(TiendaVehiculos tienda) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("Bienvenido al sistema de gestión de vehículos");
            System.out.println("1. Buscar vehículo");
            System.out.println("2. Agregar vehículo al carrito");
            System.out.println("3. Realizar compra");
            System.out.println("4. Salir");
            System.out.println("Ingrese una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    buscarVehiculo(tienda);
                    break;
                case 2:
                    agregarVehiculCarrito(tienda);
                    break;
                case 3:
                    realizarCompra(tienda);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 4);
    }

    //menu cliente
    private static void buscarVehiculo(TiendaVehiculos tienda) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el código del vehículo: ");
        String codigo = sc.nextLine();
        Vehiculo vehiculo = tienda.buscarVehiculo(codigo);
        if (vehiculo != null) {
            System.out.println(vehiculo.toString());
        } else {
            System.out.println("Vehículo no encontrado");
        }
    }

    private static void agregarVehiculCarrito(TiendaVehiculos tienda) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el código del vehículo: ");
        String codigo = sc.nextLine();
        Vehiculo vehiculo = tienda.buscarVehiculo(codigo);
        if (vehiculo != null) {
            System.out.println("Ingrese la cantidad de vehículos: ");
            int cantidad = sc.nextInt();
            double subtotal = vehiculo.getPrecio() * cantidad;
            System.out.println("El subtotal es: " + subtotal);
        } else {
            System.out.println("Vehículo no encontrado");
        }
    }

    private static void realizarCompra(TiendaVehiculos tienda) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el código del vehículo: ");
        String codigo = sc.nextLine();
        Vehiculo vehiculo = tienda.buscarVehiculo(codigo);
        if (vehiculo != null) {
            System.out.println("Ingrese la dirección de envío: ");
            String direccionEnvio = sc.nextLine();
            System.out.println("Ingrese el método de pago: ");
            String metodoPago = sc.nextLine();
            System.out.println("Ingrese su nombre: ");
            String nombre = sc.nextLine();
            System.out.println("Ingrese su apellido: ");
            String apellido = sc.nextLine();
            System.out.println("Ingrese su rut: ");
            String rut = sc.nextLine();
            System.out.println("Ingrese su dirección: ");
            String direccion = sc.nextLine();
            System.out.println("Ingrese su método de pago: ");
            String metodoPagoCliente = sc.nextLine();
            Cliente cliente = new Cliente(nombre, apellido, rut, direccion, metodoPagoCliente);
            Compra compra = new Compra(vehiculo, cliente, direccionEnvio, metodoPago);
            tienda.agregarCompra(compra);
            System.out.println("Compra realizada con éxito");
        } else {
            System.out.println("Vehículo no encontrado");
        }
    }

    //menu administrador
    //metodo para agregar cliente, eliminar cliente



}