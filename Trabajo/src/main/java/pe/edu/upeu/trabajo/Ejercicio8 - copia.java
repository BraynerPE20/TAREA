package pe.edu.upeu.trabajo;

import java.util.*;

public class Ejercicio8 {
    ArrayList<Double> notas = new ArrayList<>();

    void agregar(double n){ notas.add(n); }

    double promedio(){
        double s=0;
        for(double x:notas) s+=x;
        return s/notas.size();
    }
}
