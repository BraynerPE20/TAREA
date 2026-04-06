package pe.edu.upeu.Trabajo;

class CalculoImpuesto {
    public double obtenerTasa(double monto) { return monto * 0.10; }
}

public class Ejercicio19 extends CalculoImpuesto {
    @Override
    public double obtenerTasa(double monto) { return monto * 0.18; }
}