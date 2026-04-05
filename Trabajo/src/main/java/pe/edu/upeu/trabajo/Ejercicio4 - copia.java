package pe.edu.upeu.trabajo;

public class Ejercicio4 {
    String nombre, codigo;
    double nota;

    public Ejercicio4(String nombre, String codigo, double nota) {
        this.nombre = nombre;
        this.codigo = codigo;
        setNota(nota);
    }

    void setNota(double nota) {
        if(nota>=0 && nota<=10) this.nota = nota;
    }

    String calificacion() {
        return nota >= 6 ? "Aprobado" : "Reprobado";
    }
}
