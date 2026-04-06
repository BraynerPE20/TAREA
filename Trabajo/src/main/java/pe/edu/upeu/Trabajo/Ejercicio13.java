package pe.edu.upeu.Trabajo;

class Empleado {
    protected double sueldoBase = 1200;
}

public class Ejercicio13 extends Empleado {
    private double bono = 400;

    public double calcularSueldoTotal() {
        return sueldoBase + bono;
    }
}