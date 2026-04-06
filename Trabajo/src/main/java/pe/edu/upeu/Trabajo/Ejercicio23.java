package pe.edu.upeu.Trabajo;

class MoldeBase {
    public double calcular() { return 0; }
}

public class Ejercicio23 extends MoldeBase {
    private double lado = 4;
    @Override
    public double calcular() { return lado * lado; }
}
