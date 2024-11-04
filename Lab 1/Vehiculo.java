import java.util.Scanner;

public class Vehiculo{
    
    Scanner scanner = new Scanner (System.in);
    
    private String marca;
    private String modelo;
    private double velocidadMaxima;
    private double velocidadActual;
    private double nivelCombustible;
    private double kilometraje;
    private boolean estadoMotor;
    
    //Atributos extras
    private double horas;
    private double segundos;
    
    //Método constructor
    public Vehiculo (String marca, String modelo, double velocidadMaxima, double velocidadActual, double nivelCombustible, double kilometraje, boolean estadoMotor){
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
        this.velocidadActual = velocidadActual;
        if(nivelCombustible >= 0){
            this.nivelCombustible = nivelCombustible;
        }
        else{
            System.out.println ("El nivel de combustible no puede ser negativo");
        }
        this.kilometraje = kilometraje;
        this.estadoMotor = estadoMotor;
    }
    public Vehiculo (double horas, double segundos){
        this.horas = horas;
        this.segundos = segundos;
    }
    
    //Métodos set
    public void setMarca (){
        this.marca = marca;
    }
    public void setModelo (){
        this.modelo = modelo;
    }
     public void setVelocidadMaxima (){
        this.velocidadMaxima = velocidadMaxima;
    }
    public void setVelocidadActual (){
        this.velocidadActual = velocidadActual;
    }
    public void setNivelCombustible (){
        if(nivelCombustible >= 0){
            this.nivelCombustible = nivelCombustible;
        }
        else{
            System.out.println ("El nivel de combustible no puede ser negativo");
        }
    }
    public void setKilometraje (){
        this.kilometraje = kilometraje;
    }
    public void setEstadoMotor (){
        this.estadoMotor = estadoMotor;
    }
    
    //Métodos get
    public String getMarca (){
        return marca;
    }
    public String getModelo (){
        return modelo;
    }
    public double getVelocidadMaxima (){
        return velocidadMaxima;
    }
    public double getVelocidadActual (){
        return velocidadActual;
    }
    public double getNivelCombustible (){
        return nivelCombustible;
    }
    public double getKilometraje (){
        return kilometraje;
    }
    public boolean getEstadoMotor (){
        return estadoMotor;
    }
    
    //Métodos set atributos extras
    public void setHoras (){
        this.horas = horas;
    }
    public void setSegundos (){
        this.segundos = segundos;
    }
    
    //Métodos get atributos extras
    public double getHoras (){
        return horas;
    }
    public double getSegundos (){
        return segundos;
    }
    
    //Métodos
    public void acelerar (double incremento){
        
        System.out.println ("Ingresar el tiempo (en horas y solamente números) en que el vehículo se mueve: ");
        horas = scanner.nextDouble ();
        
        if (estadoMotor){
           if(0 < -(velocidadActual + incremento) * 0.15 * horas + 100){
                if (0 < incremento){
                    if (velocidadActual + incremento < velocidadMaxima){
                    velocidadActual = velocidadActual + incremento;
                    nivelCombustible =- velocidadActual * 0.15 * horas + 100;
                    kilometraje = kilometraje + velocidadActual * horas;
                    }
                    else{
                        System.out.println ("Error, el vehiculo superó la velocidad máxima");
                    }
                }
                else{
                    System.out.println ("El incremento no puede ser 0"); 
                }
                System.out.println ("El vehiculo tiene una velocidad actual de: " + velocidadActual + " KM/H");
                System.out.println ("El nivel de combustible actual del vehiculo es de : " + nivelCombustible +" %");
                System.out.println ("El kilometraje actual del vehiculo es de : " + kilometraje + " Kilómetros");
            }
            else{
                System.out.println ("No se puede acelerar sin combustible");
            }
        }
        else{
            System.out.println ("Para acelerar debe encender el motor");
        }
    }
    public void frenar (double decremento){
        
        System.out.println ("Ingresar el tiempo (en segundos y solamente números) en que el vehículo frena: ");
        segundos = scanner.nextDouble ();
        
        if(0 < this.velocidadActual){
            if (0 < (nivelCombustible - (velocidadActual * 0.15 * segundos))){
                if (0 < decremento){
                    if (0 <= velocidadActual - decremento){
                    velocidadActual = velocidadActual - decremento;
                    nivelCombustible = nivelCombustible - (velocidadActual * 0.15 * segundos);
                    kilometraje = kilometraje + (velocidadActual * segundos);
                    }
                    else{
                        System.out.println ("Error, el vehiculo no puede bajar de 0 KM/H");
                    }
                }
                else{
                    System.out.println ("El decremento no puede ser 0"); 
                }
                System.out.println ("El vehiculo tiene una velocidad actual de: " + velocidadActual + " KM/H");
                System.out.println ("El nivel de combustible actual del vehiculo es de : " + nivelCombustible +" %");
                System.out.println ("El kilometraje actual del vehiculo es de : " + kilometraje + " Kilómetros");
            }
            else{
                System.out.println ("Error. El vehiculo no puede gastar más combustible del que posee");
            }
        }
    }
    public void recargarCombustible (double cantidad){
        if (nivelCombustible + cantidad <= 100){
            if (!estadoMotor){
                if (cantidad + nivelCombustible <=100 ){
                    nivelCombustible = cantidad + nivelCombustible;
                }
                else{
                    System.out.println ("Error. No se puede exceder del 100% del tanque de combustible");
                }
            }
            else{
                System.out.println ("No puede recargar combustible con el motor encendido. Apagar el motor...");
            }
        }
        else{
            System.out.println ("Límite de combustible superado");
        }
    }
    public void mostrarInformacion() {
        System.out.println ("________________________________________________________________________");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Velocidad Máxima: " + velocidadMaxima + "KM/H");
        System.out.println("Velocidad Actual: " + velocidadActual + "KM/H");
        System.out.println("Nivel Combustible: " + nivelCombustible + "%");
        System.out.println("Kilometraje: " + kilometraje + "KM");
        System.out.println("Estado del motor: " + estadoMotor);
        System.out.println ("________________________________________________________________________");
    }
    public void encenderMotor(boolean encender) {
        if (!estadoMotor) { 
            estadoMotor = true;
            System.out.println("El motor ha sido encendido.");
        } else {
            System.out.println("El motor ya está encendido.");
        }
    }

    public void apagarMotor(boolean apagar) {
        if (estadoMotor) { 
            estadoMotor = false;
            System.out.println("El motor ha sido apagado.");
        } else {
            System.out.println("El motor ya está apagado.");
        }
    }
}
