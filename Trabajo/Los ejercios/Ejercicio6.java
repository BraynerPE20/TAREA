package pe.edu.upeu.trabajo;

public class Ejercicio6 {
    String titular;
    double saldo;

    public Ejercicio6(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    void depositar(double m) {
        if(m>0) saldo+=m;
    }

    void retirar(double m) {
        if(m<=saldo) saldo-=m;
    }
}