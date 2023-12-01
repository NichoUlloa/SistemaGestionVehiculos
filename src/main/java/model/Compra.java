package model;

import java.util.ArrayList;

public class Compra {

    //atributos
    private Vehiculo vehiculo;
    private Cliente cliente;
    private String direccionEnvio;
    private String metodoPago;

    //constructor
    public Compra(Vehiculo vehiculo, Cliente cliente, String direccionEnvio, String metodoPago) {
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.direccionEnvio = direccionEnvio;
        this.metodoPago = metodoPago;
    }

    //getters y setters
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }


}