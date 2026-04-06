package pe.edu.upeu.Trabajo;

class AccionConectar {
    protected boolean estado;
    public void cambiarEstado(boolean e) { this.estado = e; }
}

public class Ejercicio28 extends AccionConectar {
    public void verificar() {
        if (estado) System.out.println("Dispositivo en línea");
    }
}