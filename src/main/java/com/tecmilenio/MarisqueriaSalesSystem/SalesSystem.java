package com.tecmilenio.MarisqueriaSalesSystem;

import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SalesSystem {

    private static Scanner scanner = new Scanner(System.in);
    private static final String CSV_PATH = "C:\\Users\\jesus\\eclipse-workspace\\MarisqueriaSalesSystem\\ventas_marisqueria.csv";

    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de ventas de Marisquería Cost-Mar.");
        
        boolean running = true;
        
        while (running) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Registrar venta");
            System.out.println("2. Ver ventas por fecha");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (option) {
                case 1:
                    registrarVenta();
                    break;
                case 2:
                    verVentasPorFecha();
                    break;
                case 3:
                    running = false;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        
        System.out.println("Gracias por utilizar el sistema de ventas de Marisquería Cost-Mar.");
        scanner.close();
    }
    
    private static void registrarVenta() {
        System.out.println("Ingresando nueva venta...");
        // scanner.nextLine(); // No es necesario si ya se consume el salto de línea después de leer 'option'.
        
        System.out.print("Ingrese el nombre del producto: ");
        String product = scanner.nextLine();
        
        System.out.print("Ingrese la cantidad en kilogramos: ");
        double kilos = Double.parseDouble(scanner.nextLine()); // Cambiado para leer como String luego parsear
        
        System.out.print("Ingrese el precio por kilogramo: ");
        double price = Double.parseDouble(scanner.nextLine()); // Cambiado para leer como String luego parsear
        
        double total = kilos * price;
        System.out.println("Total de la venta: $" + total);
        
        saveSale(product, kilos, price, total);
    }

    private static void verVentasPorFecha() {
        System.out.print("Ingrese la fecha de las ventas a ver (dd/MM/yyyy): ");
        String fechaStr = scanner.nextLine();
        
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = sdf.parse(fechaStr); // Convertir la cadena de entrada a fecha

            Path path = Paths.get(CSV_PATH);
            try (BufferedReader br = Files.newBufferedReader(path)) {
                String line;
                boolean found = false; // Bandera para verificar si se encontraron ventas
                double totalDelDia = 0; // Acumulador para el total de ventas del día
                
                while ((line = br.readLine()) != null) {
                    try {
                        String[] parts = line.split(",");
                        Date fechaVenta = sdf.parse(parts[0]); // Intentar convertir la fecha de la venta
                        if (sdf.format(fechaVenta).equals(sdf.format(fecha))) { // Comparar solo la parte de la fecha
                            System.out.println(line);
                            found = true;
                            totalDelDia += Double.parseDouble(parts[4]); // Sumar al total el valor de la venta
                        }
                    } catch (ParseException | NumberFormatException e) {
                        // Ignorar líneas que no se pueden parsear
                    }
                }
                if (found) {
                    System.out.printf("El total de ventas para %s es: $%.2f%n", fechaStr, totalDelDia);
                } else {
                    System.out.println("No se encontraron ventas para la fecha proporcionada.");
                }
            } catch (IOException e) {
                System.err.println("Error al leer el archivo.");
                e.printStackTrace();
            }
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido.");
        }
    }

    public static String createSaleRecord(String product, double kilos, double price) {
        double total = kilos * price;
        String fechaVenta = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        return String.format(Locale.ROOT, "%s,%s,%.2f,%.2f,%.2f", fechaVenta, product, kilos, price, total);
    }
    
    private static void saveSale(String product, double kilos, double price, double total) {
        File csvFile = new File(CSV_PATH);
        boolean exists = csvFile.exists();
        
        try (PrintWriter out = new PrintWriter(new FileWriter(csvFile, true))) {
            // Si el archivo no existe, escribir primero el encabezado
            if (!exists) {
                out.println("Fecha de Venta,Producto,Cantidad (kg),Precio por kg,Total");
            }
            String fechaVenta = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
            // Formatear la línea a escribir con los datos de la venta
            String saleRecord = String.format(Locale.ROOT, "%s,%s,%.2f,%.2f,%.2f", fechaVenta, product, kilos, price, total);
            out.println(saleRecord);
        } catch (IOException e) {
            System.err.println("Error al guardar la venta.");
            e.printStackTrace();
        }
    }
}