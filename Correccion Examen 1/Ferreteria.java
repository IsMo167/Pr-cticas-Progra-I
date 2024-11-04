import java.util.Scanner;

public class Ferreteria {
    private Almacen almacen;
    private double totalVentas;
    private Tabla[] registroVentas;
    private int contadorVentas;

    public Ferreteria() {
        almacen = new Almacen();
        totalVentas = 0;
        registroVentas = new Tabla[500]; // Array para almacenar tablas vendidas
        contadorVentas = 0;
    }

    public void atenderClientes() {
        Scanner scanner = new Scanner(System.in);
        double maxAncho = 4.0;
        double maxLargo = 6.0;
    
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1) Vender a otro usuario");
            System.out.println("2) Revisar el estado del almacén");
            System.out.println("3) Registro de ventas");
            System.out.println("4) Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
    
            switch (opcion) {
                case 1:
                    venderTabla(maxAncho, maxLargo, scanner);
                    break;
                case 2:
                    revisarAlmacen();
                    break;
                case 3:
                    mostrarRegistroVentas();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
    
    private void venderTabla(double maxAncho, double maxLargo, Scanner scanner) {
        double ancho, largo;
    
        while (true) {
            System.out.print("Ingrese el ancho de la tabla requerida: ");
            ancho = scanner.nextDouble();
            System.out.print("Ingrese el largo de la tabla requerida: ");
            largo = scanner.nextDouble();
    
            // Validar dimensiones
            if (ancho > maxAncho || largo > maxLargo) {
                System.out.println("Dimensiones no válidas. Asegúrese de que no excedan las máximas.");
            } else if (ancho >= largo) {
                System.out.println("El ancho debe ser menor que el largo. Intente de nuevo.");
            } else {
                break; // Salir del bucle si las dimensiones son válidas
            }
        }
    
        // Intentar utilizar un residuo en lugar de crear una nueva tabla
        int i = encontrarResiduo(ancho, largo);
        if (i != -1) {
            // Si se encuentra un residuo adecuado
            Tabla tablaUsada = almacen.getTabla(i);
            System.out.println("Se utilizará el residuo: Ancho: " + tablaUsada.getAncho() + 
                               ", Largo: " + tablaUsada.getLargo());
            
            // Registrar la tabla vendida con las dimensiones solicitadas
            registrarVenta(new Tabla(ancho, largo));
            
            // Calcular nuevos residuos
            double nuevoResiduoAncho = tablaUsada.getAncho() - ancho;
            double nuevoResiduoLargo = tablaUsada.getLargo() - largo;
    
            // Almacenar nuevos residuos si son válidos
            if (nuevoResiduoAncho > 0 && nuevoResiduoLargo > 0) {
                double areaResiduo = nuevoResiduoAncho * nuevoResiduoLargo; // Calcular el área del residuo
                double precioResiduo = areaResiduo * 1000; // Precio del residuo
                Tabla nuevoResiduo = new Tabla(nuevoResiduoAncho, nuevoResiduoLargo);
                System.out.println("Precio del nuevo residuo: " + precioResiduo);
                almacen.setTabla(i, nuevoResiduo); // Sobrescribir el residuo en el almacén
                System.out.println("Se ha actualizado el residuo: Ancho: " + nuevoResiduo.getAncho() + 
                                   ", Largo: " + nuevoResiduo.getLargo());
            } else {
                // Si no hay residuo, eliminar la tabla de residuos utilizada
                almacen.eliminarTabla(i);
            }
        } else {
            // Crear tabla vendida si no hay residuos disponibles
            Tabla tablaVendida = new Tabla(ancho, largo);
            registrarVenta(tablaVendida);
            
            // Calcular residuos de la tabla nueva
            double residuoAncho = maxAncho - ancho;
            double residuoLargo = maxLargo - largo;
    
            // Almacenar residuos si son válidos
            if (residuoAncho > 0 && residuoLargo > 0) {
                double areaResiduo = residuoAncho * residuoLargo; // Calcular el área del residuo
                double precioResiduo = areaResiduo * 1000; // Precio del residuo
                Tabla residuo = new Tabla(residuoAncho, residuoLargo);
                System.out.println("Precio del residuo: " + precioResiduo);
                almacen.agregarTabla(residuo);
                System.out.println("Se ha guardado el residuo: Ancho: " + residuo.getAncho() + 
                                   ", Largo: " + residuo.getLargo());
            }
        }
    
        if (almacen.estaLleno()) {
            System.out.println("El almacén está lleno. No se pueden atender más clientes.");
        }
    }
    
    private int encontrarResiduo(double ancho, double largo) {
        for (int i = 0; i < almacen.getContador(); i++) {
            Tabla tabla = almacen.getTabla(i);
            if (tabla.getAncho() >= ancho && tabla.getLargo() >= largo) {
                return i; // Devolver el índice del residuo encontrado
            }
        }
        return -1; // No se encontró un residuo adecuado
    }    
    
    

    private void registrarVenta(Tabla tabla) {
        if (contadorVentas < registroVentas.length) {
            registroVentas[contadorVentas] = new Tabla(tabla.getAncho(), tabla.getLargo());
            totalVentas += tabla.getPrecio();
            System.out.println("Se ha vendido la tabla: Ancho: " + tabla.getAncho() +
                               ", Largo: " + tabla.getLargo() +
                               ", Precio: " + tabla.getPrecio());
            contadorVentas++;
        } else {
            System.out.println("No se pueden registrar más ventas. Registro lleno.");
        }
    }

    private void revisarAlmacen() {
        System.out.println("Estado del almacén:");
        if (almacen.getContador() == 0) {
            System.out.println("El almacén está vacío.");
        } else {
            for (int i = 0; i < almacen.getContador(); i++) {
                Tabla tabla = almacen.getTabla(i);
                System.out.println("Tabla " + (i + 1) + ": Ancho: " + tabla.getAncho() +
                                   ", Largo: " + tabla.getLargo() +
                                   ", Precio: " + tabla.getPrecio());
            }
        }
    }

    private void mostrarRegistroVentas() {
        System.out.println("Registro de ventas:");
        for (int i = 0; i < contadorVentas; i++) {
            Tabla tabla = registroVentas[i];
            System.out.println("Tabla " + (i + 1) + ": Ancho: " + tabla.getAncho() +
                               ", Largo: " + tabla.getLargo() +
                               ", Precio: " + tabla.getPrecio());
        }
        System.out.println("Total de ventas: " + totalVentas);
    }
    
    public static void main(String[] args) {
        Ferreteria ferreteria = new Ferreteria();
        ferreteria.atenderClientes();
    }
}


