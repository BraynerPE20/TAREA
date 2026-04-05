package pe.edu.upeu.trabajo;

public class Ejercicio5 {
    String nombre, categoria;
    double precio;

    public Ejercicio5(String nombre, double precio, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    double precioIVA() {
        return precio * 1.19;
    }

    void descuento(double pct) {
        precio *= (1 - pct/100);
    }
}
