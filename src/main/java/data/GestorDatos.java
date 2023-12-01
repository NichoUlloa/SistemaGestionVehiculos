package data;

import model.*;

import java.io.*;
import java.util.List;

public class GestorDatos {

    // Método para leer archivos de automóviles
    public static void leerArchivosAutomovil(TiendaVehiculos tienda, String direccionArchivo) {
        String textoArchivo = "";
        try {
            File archivo = new File(direccionArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            while ((textoArchivo = br.readLine()) != null) {
                String[] data = textoArchivo.split(",");
                // Creación de automóvil
                Automovil automovil = new Automovil(data[0], data[1], Integer.parseInt(data[2]),
                        Double.parseDouble(data[3]), Double.parseDouble(data[4]), Integer.parseInt(data[5]),
                        Double.parseDouble(data[6]), Integer.parseInt(data[7]), Double.parseDouble(data[8]));
                tienda.getVehiculos().add(automovil);
            }
        } catch (Exception e) {
            System.out.println("Documento no disponible, favor contactar con administrador");
        }
    }

    // Método para leer archivos de motocicletas
    public static void leerArchivosMotocicleta(TiendaVehiculos tienda, String direccionArchivo) {
        String textoArchivo = "";
        try {
            File archivo = new File(direccionArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            while ((textoArchivo = br.readLine()) != null) {
                String[] data = textoArchivo.split(",");
                // Creación de motocicleta
                Motocicleta motocicleta = new Motocicleta(data[0], data[1], Integer.parseInt(data[2]),
                        Double.parseDouble(data[3]), Double.parseDouble(data[4]), Integer.parseInt(data[5]),
                        Double.parseDouble(data[6]), data[7], data[8]);
                tienda.getVehiculos().add(motocicleta);
            }
        } catch (Exception e) {
            System.out.println("Documento no disponible, favor contactar con administrador");
        }
    }

    // Método para leer archivos de clientes
    public static void leerArchivosCliente(TiendaVehiculos tienda, String direccionArchivo) {
        String textoArchivo = "";
        try {
            File archivo = new File(direccionArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            while ((textoArchivo = br.readLine()) != null) {
                String[] data = textoArchivo.split(",");
                // Creación de cliente
                Cliente cliente = new Cliente(data[0], data[1], data[2], data[3]);
                tienda.agregarCliente(cliente);
            }
        } catch (Exception e) {
            System.out.println("Documento no disponible, favor contactar con administrador");
        }
    }

    // Método para registrar datos en un archivo
    public static boolean registrarDato(Object objeto, String direccionArchivo) {
        boolean lineaVacia = false;
        try {
            File file = new File(direccionArchivo);
            if (!file.exists()) {
                file.createNewFile();
                lineaVacia = true;
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            if (!lineaVacia) {
                bw.newLine();
            }
            bw.write(objeto.toString());
            bw.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error al ingresar dato, favor contactar con administrador");
            return false;
        }
    }
}