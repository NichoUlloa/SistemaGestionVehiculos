package model;

public class Automovil extends Vehiculo{
    //atributos
    private int numeroPuertas;
    private double tamanioMotor;

    //constructor
    public Automovil(String marca, String modelo, int anioFabricacion, double pesoVeiculo, double precio, int stock, double potencia, int numeroPuertas, double tamanioMotor) {
        super(marca, modelo, anioFabricacion, pesoVeiculo, precio, stock, potencia);
        this.numeroPuertas = numeroPuertas;
        this.tamanioMotor = tamanioMotor;
    }

    //getters y setters

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public double getTamanioMotor() {
        return tamanioMotor;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public void setTamanioMotor(double tamanioMotor) {
        this.tamanioMotor = tamanioMotor;
    }

    //metodo calcular velocidad maxima en km/h = (potencia en caballos de fuerza / peso del vehiculo) * 10
    public double calcularVelocidadMaxima() {
        return (getPotencia() / getPesoVeiculo()) * 10;
    }

    @Override
    public String toString() {
        return "Automovil{" + "numero de puertas=" + numeroPuertas + ", tamaño de Motor=" + tamanioMotor + '}';
    }

}
