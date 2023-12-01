package model;

public class Motocicleta extends Vehiculo {
    //atributos
    private String tipoMotor;
    private String tipoSuspenion;

    //constructor
    public Motocicleta(String marca, String modelo, int anioFabricacion, double pesoVeiculo, double precio, int stock, double potencia, String tipoMotor, String tipoSuspenion) {
        super(marca, modelo, anioFabricacion, pesoVeiculo, precio, stock, potencia);
        this.tipoMotor = tipoMotor;
        this.tipoSuspenion = tipoSuspenion;
    }

    //getters y setters
    public String getTipoMotor() {
        return tipoMotor;
    }

    public String getTipoSuspenion() {
        return tipoSuspenion;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public void setTipoSuspenion(String tipoSuspenion) {
        this.tipoSuspenion = tipoSuspenion;
    }

    public double calcularVelocidadMaxima() {
        return (getPotencia() * 2 / getPesoVeiculo()) * 20;
    }

    @Override
    public String toString() {
        return "Motocicleta{" + "tipo de motor=" + tipoMotor + ", tipo de suspenion=" + tipoSuspenion + '}';
    }

}
