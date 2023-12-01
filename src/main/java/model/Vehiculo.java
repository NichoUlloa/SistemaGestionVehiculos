package model;

public abstract class Vehiculo {
    //atributos
    private String marca;
    private String modelo;
    private int anioFabricacion;
    private double pesoVeiculo;
    private double precio;
    private int stock;

    private double potencia;

    //constructor
    public Vehiculo(String marca, String modelo, int anioFabricacion, double pesoVeiculo, double precio, int stock, double potencia) {
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.pesoVeiculo = pesoVeiculo;
        this.precio = precio;
        this.stock = stock;
        this.potencia = potencia;
    }

    //getters y setters
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public double getPesoVeiculo() {
        return pesoVeiculo;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public void setPesoVeiculo(double pesoVeiculo) {
        this.pesoVeiculo = pesoVeiculo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public abstract double calcularVelocidadMaxima();

    @Override
    public String toString() {
        return "Vehiculo{" + "marca=" + marca + ", modelo=" + modelo + ", año de fabricacion=" + anioFabricacion + ", peso del vehiculo=" + pesoVeiculo + ", precio=" + precio + ", stock=" + stock + ", potencia=" + potencia + '}';
    }

}
