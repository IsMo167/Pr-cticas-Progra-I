public class Nodo {
    // Atributos de la clase Nodo
    private int valor;        // El valor que guarda el nodo
    private Nodo siguiente;   // Referencia al siguiente nodo
    
    // Constructor de la clase Nodo
    public Nodo(int valor) {
        this.valor = valor;  // Inicializa el valor del nodo
        this.siguiente = null; // Inicializa el siguiente nodo como null
    }
    
    // Métodos para acceder y modificar el valor y el siguiente nodo (getters y setters)
    public int getValor() {
        return valor;
    }
    
    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public Nodo getSiguiente() {
        return siguiente;
    }
    
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    // Método para imprimir el valor del nodo
    public void imprimirNodo() {
        System.out.println("Nodo: " + valor);
    }
    
    public static void main(String[] args) {
        // Crear nodos
        Nodo nodo1 = new Nodo(14);
        Nodo nodo2 = new Nodo(5);
    
        // Enlazar nodos
        nodo1.setSiguiente(nodo2);
    
        // Imprimir valores
        System.out.println("Nodo 1:");
        nodo1.imprimirNodo();
    
        System.out.println("Nodo 2:");
        nodo1.getSiguiente().imprimirNodo();
    }
}
