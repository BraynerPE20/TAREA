package pe.edu.upeu.Trabajo;

class CanalNotificacion {
    public void enviar(String mensaje) { System.out.println("Enviando: " + mensaje); }
}

public class Ejercicio18 extends CanalNotificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("WhatsApp enviado: " + mensaje);
    }
}