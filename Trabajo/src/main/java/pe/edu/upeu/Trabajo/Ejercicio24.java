package pe.edu.upeu.Trabajo;

class ServicioEnvio {
    public double calcularCosto() { return 10.0; }
}

public class Ejercicio24 extends ServicioEnvio {
    @Override
    public double calcularCosto() { return 25.50; }
}