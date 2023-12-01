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

    //realizar venta de vehiculo a cliente
    public void realizarVenta(Vehiculo vehiculo, Cliente cliente, String direccionEnvio, String metodoPago) {
        Compra compra = new Compra(vehiculo, cliente, direccionEnvio, metodoPago);
        vehiculos.remove(vehiculo);
        cliente.agregarCompra(compra);
    }



}
