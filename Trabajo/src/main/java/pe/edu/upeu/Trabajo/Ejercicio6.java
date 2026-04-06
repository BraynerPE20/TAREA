package pe.edu.upeu.Trabajo;

public class Ejercicio6 {
    private double saldo;

    public void depositar(double monto) {
        if (monto > 0) saldo += monto;
    }

    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
        }
    }
}