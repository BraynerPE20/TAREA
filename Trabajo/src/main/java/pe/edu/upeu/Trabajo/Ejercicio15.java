package pe.edu.upeu.Trabajo;

class Figura {
    public double area() { return 0; }
}

public class Ejercicio15 extends Figura {
    private double radio;
    public Ejercicio15(double radio) { this.radio = radio; }

    @Override
    public double area() { return Math.PI * radio * radio; }
}