package pe.edu.upeu.repository;

import pe.edu.upeu.model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private static ClienteRepository intance;
    public static ClienteRepository getInstance(){
        if (intance == null) intance = new ClienteRepository();
        return intance;
    }

    List<Cliente> clientes = new ArrayList<>();

    public void agregarCliente(Cliente c){ clientes.add(c); }
    public List<Cliente> listarClientes(){ return clientes; }
    public void actualizarCliente(Cliente c, int index){ clientes.set(index, c); }
    public void eliminarClientes(int index){ clientes.remove(index); }

    public void datosPrederterminados(){
        clientes.add(new Cliente("20123456789", "Comercial El Sol", "Res. Municipal 001", "Juan Perez", "Av. Floral 123"));
        clientes.add(new Cliente("10456789123", "Ferretería Central", "Título Propiedad 45", "Maria Apaza", "Jr. Lima 456"));
    }
}