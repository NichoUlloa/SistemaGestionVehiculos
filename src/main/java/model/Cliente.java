package model;

import java.util.ArrayList;

public class Cliente {
    //atributos
    private String nombre;
    private String apellido;
    private String rut;
    private String direccion;
    private String metodoPago;

    //constructor
    public Cliente(String nombre, String apellido, String direccion, String metodoPago) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.metodoPago = metodoPago;
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getRut() {
        return rut;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    //los clientes pueden buscar vehiculos por marca, modelo o tipo
    public ArrayList<Vehiculo> buscarVehiculo(String marca, String modelo, String tipo, TiendaVehiculos tienda) {
        ArrayList<Vehiculo> vehiculosEncontrados = new ArrayList<>();
        for (Vehiculo vehiculo : tienda.getVehiculos()) {
            if (vehiculo.getMarca().equals(marca) || vehiculo.getModelo().equals(modelo) || vehiculo.getClass().getSimpleName().equals(tipo)) {
                vehiculosEncontrados.add(vehiculo);
            }
        }
        return vehiculosEncontrados;
    }

    //- cada compra realizada debe tener una lista de vehiculos, cliente asociado y fecha de compra. cada vez que se realiza una compra, la cantidad de vehiculos en stock debe disminuir.


    //los clientes pueden agregar vehiculos a su carrito de compras y ver su subtotal
    public double agregarVehiculoCarrito(Vehiculo vehiculo, int cantidad) {
        return vehiculo.getPrecio() * cantidad;
    }

    //metodo los clientes pueden hacer una compra y proporcionar informacion de envio y pago
    public void realizarCompra(Vehiculo vehiculo, String direccionEnvio, String metodoPago, TiendaVehiculos tienda) {
        if (tienda.getVehiculos().contains(vehiculo)) {
            tienda.getVehiculos().remove(vehiculo);
            Compra compra = new Compra(vehiculo, this, direccionEnvio, metodoPago);
            this.agregarCompra(compra);
        }
    }

    public void agregarCompra(Compra compra) {
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", apellido=" + apellido + ", rut=" + rut + ", direccion=" + direccion + ", metodoPago=" + metodoPago + '}';
    }


}

