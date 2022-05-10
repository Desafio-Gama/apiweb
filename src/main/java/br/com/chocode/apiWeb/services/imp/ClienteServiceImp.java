package br.com.chocode.apiWeb.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import br.com.chocode.apiWeb.dao.ClienteDAO;
import br.com.chocode.apiWeb.model.Cliente;
import br.com.chocode.apiWeb.services.LojaChocodeService;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImp implements LojaChocodeService<Cliente> {
    private ClienteDAO clienteDAO;

    @Autowired
    public ClienteServiceImp(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public Cliente save(Cliente cliente) {

        return clienteDAO.saveAndFlush(cliente);
    }

    @Override
    public Cliente findById(Long id) {

        return clienteDAO.findById(id).get();
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> listClientes = clienteDAO.findAll();
        return listClientes;
    }

    @Override
    public void deleter(Long id) {
        clienteDAO.deleteById(id);
    }

    @Override
    public Cliente update(Cliente cliente) {
        Cliente clienteBase = findById(cliente.getId());
        if (cliente.getNome() != null){
            clienteBase.setNome(cliente.getNome());
        }
        if (cliente.getEmail() != null){
            clienteBase.setEmail(cliente.getEmail());
        }
        return save(clienteBase);
    }

}
