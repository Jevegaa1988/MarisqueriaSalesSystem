package com.tecmilenio.MarisqueriaSalesSystem;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class SalesSystemTest {
    
    @Test
    public void testCreateSaleRecord() {
        // Establece el Locale a uno específico si necesitas una salida consistente en todas las configuraciones regionales.
        Locale.setDefault(new Locale("en", "US"));

        // Datos de ejemplo para el test
        String product = "Camarones";
        double kilos = 2.5;
        double price = 100.0;

        // Llamada al método que deseamos probar
        String saleRecord = SalesSystem.createSaleRecord(product, kilos, price);
        
        // Asegurarse de que saleRecord no sea nulo
        assertNotNull(saleRecord, "El registro de venta no debe ser nulo");

        // Verificar que la cadena contiene la información correcta
        assertTrue(saleRecord.contains(product), "El registro de venta debe contener el nombre del producto");
        assertTrue(saleRecord.contains(String.format(Locale.ROOT, "%.2f", kilos)), "El registro de venta debe contener la cantidad en kilogramos");
        assertTrue(saleRecord.contains(String.format(Locale.ROOT, "%.2f", price)), "El registro de venta debe contener el precio por kilogramo");
        assertTrue(saleRecord.contains(String.format(Locale.ROOT, "%.2f", kilos * price)), "El registro de venta debe contener el total calculado");
    }
}