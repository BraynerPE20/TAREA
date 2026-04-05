package pe.edu.upeu.trabajo;

public class Ejercicio1 {
    private String nombre;
    private int edad;
    private String correo;

    public Ejercicio1(String nombre, int edad, String correo) {
        this.nombre = nombre;
        setEdad(edad);
        this.correo = correo;
    }

    public void setEdad(int edad) {
        if (edad > 0) this.edad = edad;
    }

    public void presentarse() {
        System.out.println(nombre + " - " + edad + " - " + correo);
    }
}