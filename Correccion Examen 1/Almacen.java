public class Almacen {
    private Tabla[] tablas;
    private int contador;

    public Almacen() {
        tablas = new Tabla[500]; // Capacidad máxima del almacén
        contador = 0;
    }

    public void agregarTabla(Tabla tabla) {
        if (contador < tablas.length) {
            tablas[contador] = tabla;
            contador++;
            ordenarTablas(); // Ordenar después de agregar
        } else {
            System.out.println("El almacén está lleno. No se puede agregar más tablas.");
        }
    }

    public void setTabla(int i, Tabla tabla) {
        if (i >= 0 && i < contador) {
            tablas[i] = tabla; // Sobrescribir la tabla en el índice dado
            ordenarTablas(); // Ordenar después de modificar
        }
    }

    public void eliminarTabla(int i) {
        if (i >= 0 && i < contador) {
            for (int j = i; j < contador - 1; j++) {
                tablas[j] = tablas[j + 1]; // Desplazar las tablas hacia la izquierda
            }
            tablas[contador - 1] = null; // Limpiar la última posición
            contador--; // Disminuir el contador
            ordenarTablas(); // Ordenar después de eliminar
        }
    }

    public int getContador() {
        return contador;
    }

    public Tabla getTabla(int i) {
        if (i >= 0 && i < contador) {
            return tablas[i];
        }
        return null; // Devolver nulo si el índice es inválido
    }

    public boolean estaLleno() {
        return contador >= tablas.length;
    }

    private void ordenarTablas() {
        for (int i = 0; i < contador - 1; i++) {
            for (int j = i + 1; j < contador; j++) {
                if (debeIntercambiar(tablas[i], tablas[j])) {
                    Tabla temp = tablas[i];
                    tablas[i] = tablas[j];
                    tablas[j] = temp;
                }
            }
        }
    }

    private boolean debeIntercambiar(Tabla t1, Tabla t2) {
        if (t1.getAncho() > t2.getAncho()) {
            return true; // Intercambiar si t1 es más ancho
        } else if (t1.getAncho() == t2.getAncho()) {
            return t1.getLargo() > t2.getLargo(); // Intercambiar si anchos son iguales y t1 es más largo
        }
        return false; // No intercambiar
    }
}





