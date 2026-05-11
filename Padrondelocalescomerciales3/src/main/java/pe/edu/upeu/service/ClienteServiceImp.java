package pe.edu.upeu.service;

import pe.edu.upeu.model.Cliente;
import pe.edu.upeu.repository.ClienteRepository;
import java.util.List;

public class ClienteServiceImp implements ClienteServiceInter {
    private ClienteRepository cr = ClienteRepository.getInstance();
    private static ClienteServiceInter instance;

    public static ClienteServiceInter getIntance() {
        if (instance == null) instance = new ClienteServiceImp();
        return instance;
    }

    @Override public void save(Cliente c) { cr.agregarCliente(c); }
    @Override public List<Cliente> findAll() { return cr.listarClientes(); }
    @Override public void update(Cliente c, int index) { cr.actualizarCliente(c, index); }
    @Override public void delete(String index) { cr.eliminarCliente(index); }
}