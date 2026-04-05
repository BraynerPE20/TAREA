package pe.edu.upeu.trabajo;

import java.util.*;

public class Ejercicio12 {
    ArrayList<Object> lista = new ArrayList<>();
    int max=3;

    void agregar(Object o){
        if(lista.size()>=max) throw new RuntimeException();
        lista.add(o);
    }
}
