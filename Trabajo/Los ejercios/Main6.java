package pe.edu.upeu.trabajo;

public class Main6 {
    public static void main(String[] args) {
        Ejercicio6 c = new Ejercicio6("Brayner",500);
        c.depositar(200);
        c.retirar(100);
        System.out.println(c.saldo);
    }
}
