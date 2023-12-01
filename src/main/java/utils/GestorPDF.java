package utils;

import model.Cliente;
import model.Compra;
import model.TiendaVehiculos;
import model.Vehiculo;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GestorPDF {

    public void generarFactura(Compra compra) throws IOException {
        // Crear un nuevo documento
        PDDocument documento = new PDDocument();
        // Crear y agregar una nueva página al documento
        PDPage pagina = new PDPage(PDRectangle.A6);
        documento.addPage(pagina);
        // Generar un arreglo de líneas que contendrá la factura PDF
        String[] lineasFactura = obtenerLineasFactura(compra);
        rellenarPDF(documento, pagina, lineasFactura);
        // Guardar el documento en la ubicación especificada
        documento.save(generarNombrePDF(compra));
        documento.close();
    }

    private void rellenarPDF(PDDocument documento, PDPage pagina, String[] lineasFactura) {
        try (PDPageContentStream contenidoPagina = new PDPageContentStream(documento, pagina)) {
            for (int linea = 0; linea < lineasFactura.length; linea++) {
                contenidoPagina.beginText();
                contenidoPagina.newLineAtOffset(10, pagina.getMediaBox().getHeight() - (10 * linea));
                contenidoPagina.setFont(PDType1Font.HELVETICA_BOLD, 8f);
                contenidoPagina.showText(lineasFactura[linea]);
                contenidoPagina.endText();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String[] obtenerLineasFactura(Compra compra) {
        String[] lineasFactura = new String[7];
        lineasFactura[0] = "Factura de Compra";
        lineasFactura[1] = "Fecha: " + obtenerFechaActual();
        lineasFactura[2] = "Cliente: " + compra.getCliente().getNombreCompleto();
        lineasFactura[3] = "Dirección de Envío: " + compra.getDireccionEnvio();
        lineasFactura[4] = "Método de Pago: " + compra.getMetodoPago();
        lineasFactura[5] = "Vehículo: " + compra.getVehiculo().toString();
        lineasFactura[6] = "Total: $" + compra.getVehiculo().getPrecio();
        return lineasFactura;
    }

    private String obtenerNombreCliente(Cliente cliente) {
        return cliente.getNombre() + "_" + cliente.getApellido();
    }

    private String obtenerFechaActual() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        return formatoFecha.format(new Date());
    }

    private String generarNombrePDF(Compra compra) {
        String fechaArchivo = obtenerFechaActual();
        String nombreArchivo = "factura_" + obtenerNombreCliente(compra.getCliente()) + "_" + fechaArchivo + ".pdf";
        return nombreArchivo;
    }
}