package pe.edu.upeu.repository;

import javafx.css.converter.LadderConverter;
import pe.edu.upeu.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    private static ClienteRepository intance = new ClienteRepository();

    public static ClienteRepository getInstance(){
        if (intance==null){
            intance=new ClienteRepository();
        }
        return intance;
    }

    List<Cliente> clientes= new ArrayList<>();

    public void agregarCliente(Cliente c){
        clientes.add(c);
    }

    public List<Cliente> listarClientes(){
        return clientes;
    }

    public void actualizarCliente(Cliente c, int index){
        clientes.set(index, c);
    }

    public void eliminarClientes(int index){
        clientes.remove(index);
    }

    public void eliminarTodo(){
        clientes.clear();
    }

    public void datosPrederterminados(){
        clientes.add(new Cliente("01", "Mateo Quispe",
                "985475214", "mate@gmail.com"));

        clientes.add(new Cliente("02", "Pedrito Apaza Apaza"));
    }

    public int getClientes(){
        return clientes.size();
    }

}
