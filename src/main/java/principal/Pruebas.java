package principal;

import model.*;
import data.GestorDatos;
import utils.GestorPDF;

public class Principal {
    public static void main(String[] args) {
        iniciarPruebas();
    }

    public static void iniciarPruebas() {
        TiendaVehiculos tienda = new TiendaVehiculos("Mi Tienda de Vehículos");

        // Cargar datos de prueba desde archivos
        GestorDatos.leerArchivosAutomovil(tienda, "datos/automoviles.txt");
        GestorDatos.leerArchivosMotocicleta(tienda, "datos/motocicletas.txt");
        GestorDatos.leerArchivosCliente(tienda, "datos/clientes.txt");

        // Mostrar la lista de vehículos disponibles
        System.out.println("Lista de vehículos disponibles:");
        for (Vehiculo vehiculo : tienda.getVehiculos()) {
            System.out.println(vehiculo);
        }

        // Crear clientes de prueba
        Cliente cliente1 = new Cliente("Juan", "Perez", "Calle 123", "Tarjeta de Crédito");
        Cliente cliente2 = new Cliente("Maria", "Lopez", "Avenida 456", "Transferencia Bancaria");

        // Agregar clientes a la tienda
        tienda.agregarCliente(cliente1);
        tienda.agregarCliente(cliente2);

        // Mostrar la lista de clientes
        System.out.println("\nLista de clientes:");
        for (Cliente cliente : tienda.getClientes()) {
            System.out.println(cliente);
        }

        // Simular una compra
        Vehiculo vehiculoCompra = tienda.getVehiculos().get(0); // Seleccionar el primer vehículo de la lista
        cliente1.realizarCompra(vehiculoCompra, "Calle 123", "Tarjeta de Crédito", tienda);

        // Mostrar la lista de vehículos después de la compra
        System.out.println("\nLista de vehículos después de la compra:");
        for (Vehiculo vehiculo : tienda.getVehiculos()) {
            System.out.println(vehiculo);
        }

        // Mostrar la lista de compras del cliente
        System.out.println("\nCompras realizadas por " + cliente1.getNombre() + ":");
        for (Compra compra : cliente1.getCompras()) {
            System.out.println(compra);
        }

        // Generar factura en PDF para la última compra
        if (!cliente1.getCompras().isEmpty()) {
            GestorPDF gestorPDF = new GestorPDF();
            try {
                gestorPDF.generarFactura(cliente1.getCompras().get(cliente1.getCompras().size() - 1));
                System.out.println("\nFactura generada en PDF correctamente.");
            } catch (Exception e) {
                System.out.println("Error al generar el PDF de la factura.");
            }
        }
    }
}