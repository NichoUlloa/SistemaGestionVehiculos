package model;

import java.util.ArrayList;
import java.util.List;

public class TiendaVehiculos {
    //atributos
    private String nombreTienda;
    private List<Cliente> clientes;
    private List<Vehiculo> vehiculos;

    //constructor
    public TiendaVehiculos(String nombreTienda) {
        this.nombreTienda = nombreTienda;
        this.vehiculos = new ArrayList<>();
    }

    //getters y setters
    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    //metodo agregar cliente validando que no exista
    public void agregarCliente(Cliente cliente) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
        }
    }

    //metodo eliminar cliente validando que exista
    public void eliminarCliente(Cliente cliente) {
        if (clientes.contains(cliente)) {
            clientes.remove(cliente);
        }
    }

    //realizar venta de vehiculo a cliente, validando que exista stock
    public void realizarVenta(Vehiculo vehiculo, Cliente cliente, String direccionEnvio, String metodoPago) {
        if (vehiculo.getStock() > 0) {
            vehiculo.setStock(vehiculo.getStock() - 1);
            Compra compra = new Compra(vehiculo, cliente, direccionEnvio, metodoPago);
            cliente.setRut(cliente.getRut());
            cliente.setDireccion(cliente.getDireccion());
            cliente.setMetodoPago(cliente.getMetodoPago());
        }
    }

    public Vehiculo buscarVehiculo(String codigo) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getCodigo().equals(codigo)) {
                return vehiculo;
            }
        }
        return null;
    }

    public void agregarCompra(Compra compra) {
    }
}
