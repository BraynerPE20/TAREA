package pe.edu.upeu.trabajo;

public class main5 {
    public static void main(String[] args) {
        Ejercicio5 p = new Ejercicio5("Laptop",1000,"Tech");
        System.out.println(p.precioIVA());
        p.descuento(10);
        System.out.println(p.precio);
    }
}
