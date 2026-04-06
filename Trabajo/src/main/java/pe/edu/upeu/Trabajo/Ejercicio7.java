package pe.edu.upeu.Trabajo;

public class Ejercicio7 {
    private int horas, minutos, segundos;

    public void ticTac() {
        segundos++;
        if (segundos == 60) { segundos = 0; minutos++; }
        if (minutos == 60) { minutos = 0; horas++; }
        if (horas == 24) horas = 0;
    }
}