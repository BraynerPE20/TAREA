package pe.edu.upeu.Trabajo;

import java.util.ArrayList;

public class Ejercicio1 {
    private ArrayList<String> productos = new ArrayList<>();

    public void agregar(String item) {
        if (!productos.contains(item)) {
            productos.add(item);
            System.out.println("Agregado: " + item);
        }
    }
}