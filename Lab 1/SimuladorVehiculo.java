import java.util.Scanner;

public class SimuladorVehiculo {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String marcaSim;
        String modeloSim;
        double velMaxSim;
        double velActSim;
        double nivCombSim;
        double kmetrajeSim;
        boolean estMotorSim;
        
        System.out.println ("Bienvenid@ al simulador de conducción");
        System.out.println ("Favor antes de empezar, selecciona las características de los vehículo y de manejo");
        System.out.println ("________________________________________________________________________");
        
        System.out.print("Ingrese la marca del vehiculo 1: ");
        marcaSim = scanner.nextLine();
        System.out.print("Ingrese el modelo del vehiculo 1: ");
        modeloSim = scanner.nextLine();
        System.out.print("Ingrese la velocidad máxima del vehiculo 1: ");
        velMaxSim = scanner.nextDouble();
        System.out.print("Ingrese la velocidad actual del vehiculo 1: ");
        velActSim = scanner.nextDouble();
        System.out.print("Ingrese el nivel del combustible del vehiculo 1: ");
        nivCombSim = scanner.nextDouble();
        System.out.print("Ingrese el kilometraje del vehiculo 1: ");
        kmetrajeSim = scanner.nextDouble();
        System.out.print("Ingrese el estado del motor del vehiculo 1 (true/encedido y false/apagado): ");
        estMotorSim = scanner.nextBoolean();
        scanner.nextLine();
        Vehiculo vehiculo1 = new Vehiculo (marcaSim, modeloSim, velMaxSim, velActSim, nivCombSim, kmetrajeSim, estMotorSim);
        System.out.println ("________________________________________________________________________");
        
        System.out.print("Ingrese la marca del vehiculo 2: ");
        marcaSim = scanner.nextLine();
        System.out.print("Ingrese el modelo del vehiculo 2: ");
        modeloSim = scanner.nextLine();
        System.out.print("Ingrese la velocidad máxima del vehiculo 2: ");
        velMaxSim = scanner.nextDouble();
        System.out.print("Ingrese la velocidad actual del vehiculo 2: ");
        velActSim = scanner.nextDouble();
        System.out.print("Ingrese el nivel del combustible del vehiculo 2: ");
        nivCombSim = scanner.nextDouble();
        System.out.print("Ingrese el kilometraje del vehiculo 2: ");
        kmetrajeSim = scanner.nextDouble();
        System.out.print("Ingrese el estado del motor del vehiculo 2 (true/encedido y false/apagado): ");
        estMotorSim = scanner.nextBoolean();
        scanner.nextLine();
        Vehiculo vehiculo2 = new Vehiculo (marcaSim, modeloSim, velMaxSim, velActSim, nivCombSim, kmetrajeSim, estMotorSim);
        System.out.println ("________________________________________________________________________");
        
        System.out.print("Ingrese la marca del vehiculo 3: ");
        marcaSim = scanner.nextLine();
        System.out.print("Ingrese el modelo del vehiculo 3: ");
        modeloSim = scanner.nextLine();
        System.out.print("Ingrese la velocidad máxima del vehiculo 3: ");
        velMaxSim = scanner.nextDouble();
        System.out.print("Ingrese la velocidad actual del vehiculo 3: ");
        velActSim = scanner.nextDouble();
        System.out.print("Ingrese el nivel del combustible del vehiculo 3: ");
        nivCombSim = scanner.nextDouble();
        System.out.print("Ingrese el kilometraje del vehiculo 3: ");
        kmetrajeSim = scanner.nextDouble();
        System.out.print("Ingrese el estado del motor del vehiculo 3 (true/encedido y false/apagado): ");
        estMotorSim = scanner.nextBoolean();
        scanner.nextLine();
        Vehiculo vehiculo3 = new Vehiculo (marcaSim, modeloSim, velMaxSim, velActSim, nivCombSim, kmetrajeSim, estMotorSim);
        System.out.println ("________________________________________________________________________");
        // Menú interactivo
        int opcion;
        do {
            System.out.println("\n----- Menú de Operaciones -----");
            System.out.println("1. Mostrar información vehículo");
            System.out.println("2. Acelerar");
            System.out.println("3. Frenar");
            System.out.println("4. Recargar Combustible");
            System.out.println("5. Encender Vehiculo");
            System.out.println("6. Apagar Vehiculo");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarInformacionVehiculo (seleccionarVehiculo(scanner, vehiculo1, vehiculo2, vehiculo3));
                    break;
                case 2:
                    acelerarVehiculo(scanner, seleccionarVehiculo(scanner, vehiculo1, vehiculo2, vehiculo3));
                    break;
                case 3:
                    frenarVehiculo(scanner, seleccionarVehiculo(scanner, vehiculo1, vehiculo2, vehiculo3));
                    break;
                case 4:
                    recargarCombustibleVehiculo(scanner, seleccionarVehiculo(scanner, vehiculo1, vehiculo2, vehiculo3));
                    break;
                case 5:
                    encenderVehiculo(scanner, seleccionarVehiculo(scanner, vehiculo1, vehiculo2, vehiculo3));
                    break;
                case 6:
                    apagarVehiculo(scanner, seleccionarVehiculo(scanner, vehiculo1, vehiculo2, vehiculo3));
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 7);

        scanner.close();
    }

    private static Vehiculo seleccionarVehiculo(Scanner scanner, Vehiculo vehiculo1, Vehiculo vehiculo2, Vehiculo vehiculo3) {
        System.out.print("Ingrese el número de vehiculo (1-3): ");
        int numVehiculo = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        switch (numVehiculo) {
            case 1:
                return vehiculo1;
            case 2:
                return vehiculo2;
            case 3:
                return vehiculo3;
            default:
                System.out.println("Número de vehiculo inválido.");
                return null;
        }
    }

    private static void mostrarInformacionVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null) {
            vehiculo.mostrarInformacion();
        }
    }

    private static void acelerarVehiculo(Scanner scanner, Vehiculo vehiculo) {
        if (vehiculo != null) {
            System.out.print("Ingrese cuantos Kilómetros por hora deseas acelerar: ");
            double incremento = scanner.nextDouble();
            vehiculo.acelerar(incremento);
        }
    }
    private static void frenarVehiculo(Scanner scanner, Vehiculo vehiculo) {
        if (vehiculo != null) {
            System.out.print("Ingrese cuantos Kilómetros por hora deseas frenar: ");
            double decremento = scanner.nextDouble();
            vehiculo.frenar(decremento);
        }
    }
    public static void recargarCombustibleVehiculo(Scanner scanner, Vehiculo vehiculo) {
        if (vehiculo != null) {
            System.out.print("Ingrese cuanto porcentaje deseas llenar: ");
            double cantidad = scanner.nextDouble();
            vehiculo.recargarCombustible(cantidad);
        }
    }
    public static void encenderVehiculo(Scanner scanner, Vehiculo vehiculo) {
        if (vehiculo != null) {
            System.out.print("Ingrese true para encender: ");
            boolean encender = scanner.nextBoolean();
            vehiculo.encenderMotor(encender);
        }
    }
    public static void apagarVehiculo(Scanner scanner, Vehiculo vehiculo) {
        if (vehiculo != null) {
            System.out.print("Ingrese false para apagar ");
            boolean apagar = scanner.nextBoolean();
            vehiculo.apagarMotor(apagar);
        }
    }
}