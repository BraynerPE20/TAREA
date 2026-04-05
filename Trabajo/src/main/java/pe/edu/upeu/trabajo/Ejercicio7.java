package pe.edu.upeu.trabajo;

import java.util.*;

public class Ejercicio7 {
    ArrayList<String> lista = new ArrayList<>();

    void agregar(String p){ lista.add(p); }

    void eliminar(String n){
        lista.removeIf(x -> x.equalsIgnoreCase(n));
    }

    void listar(){
        for(String x: lista) System.out.println(x);
    }
}