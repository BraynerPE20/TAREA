package pe.edu.upeu.trabajo;

public class Ejercicio2 {
    String marca, modelo;
    int anio, velocidadActual = 0;

    public Ejercicio2(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    void acelerar(int km) {
        velocidadActual += km;
    }

    void frenar(int km) {
        velocidadActual = Math.max(0, velocidadActual - km);
    }

    void estado() {
        System.out.println(marca + " " + modelo + " " + velocidadActual);
    }
}