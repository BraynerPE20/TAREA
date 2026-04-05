package pe.edu.upeu.trabajo;

import java.util.*;

public class Ejercicio16 {
    ArrayList<Object> lista = new ArrayList<>();

    void encolar(Object o){ lista.add(o); }

    Object desencolar(){ return lista.remove(0); }
}
