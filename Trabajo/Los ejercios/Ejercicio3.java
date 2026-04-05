package pe.edu.upeu.trabajo;

public class Ejercicio3 {
    double base, altura;

    public Ejercicio3(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    double area() {
        return base * altura;
    }

    double perimetro() {
        return 2 * (base + altura);
    }

    boolean esCuadrado() {
        return base == altura;
    }
}
