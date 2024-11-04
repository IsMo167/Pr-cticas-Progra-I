public class Tabla {
    private double ancho;
    private double largo;
    private double precioBase = 24000;

    public Tabla(double ancho, double largo) {
        this.ancho = ancho;
        this.largo = largo;
    }

    public double getAncho() {
        return ancho;
    }

    public double getLargo() {
        return largo;
    }

    public double getPrecio() {
        double areaMaxima = 4 * 6; // área de la tabla más grande
        double areaTabla = ancho * largo;
        return precioBase * (areaTabla / areaMaxima);
    }
}

