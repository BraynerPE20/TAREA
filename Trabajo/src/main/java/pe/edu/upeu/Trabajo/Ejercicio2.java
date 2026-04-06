package pe.edu.upeu.Trabajo;

import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio2 {
    private ArrayList<Double> temperaturas = new ArrayList<>();

    public void registrar(double temp) {
        temperaturas.add(temp);
    }

    public double obtenerMaxima() {
        return Collections.max(temperaturas);
    }
}