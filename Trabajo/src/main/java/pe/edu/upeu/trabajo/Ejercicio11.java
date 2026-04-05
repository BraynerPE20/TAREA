package pe.edu.upeu.trabajo;

import java.util.*;

public class Ejercicio11 {
    ArrayList<String> lista = new ArrayList<>();

    void agregar(String l){ lista.add(l); }

    String mayor(){
        return Collections.max(lista);
    }
}