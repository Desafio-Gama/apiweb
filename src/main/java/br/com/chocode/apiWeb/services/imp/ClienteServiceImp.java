package br.com.chocode.apiWeb.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import br.com.chocode.apiWeb.dao.ClienteDAO;
import br.com.chocode.apiWeb.model.Cliente;
import br.com.chocode.apiWeb.services.LojaChocodeService;
import br.com.chocode.apiWeb.services.RedisService;

import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImp implements LojaChocodeService<Cliente> {
    private ClienteDAO clienteDAO;
    private RedisService redis;

    @Autowired
    public ClienteServiceImp(ClienteDAO clienteDAO, RedisService redis) {
        this.clienteDAO = clienteDAO;
        this.redis = redis;
    }

    @Override
    public Cliente save(Cliente cliente) {

        return clienteDAO.saveAndFlush(cliente);
    }

    @Override
    public Cliente findById(Long id) {
        Cliente cliente;
        String key = "cliente" + id;
        String keyNome = "clienteNome" + id;
        String keyEmail = "clienteEmail" + id;

        try {
            if (redis.read(key) != null) {
                cliente = new Cliente();

                cliente.setId(id);
                cliente.setNome(redis.read(keyNome) + " DB");
                cliente.setEmail(redis.read(keyEmail));

                return cliente;

            } else {
                cliente = clienteDAO.findById(id).get();

                redis.write(key, cliente.getId().toString(), 60);
                redis.write(keyNome, cliente.getNome(), 60);
                redis.write(keyEmail, cliente.getEmail(), 60);

                return cliente;
            }
        } catch (Exception e) {
            return null;
        }
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
        if (cliente.getNome() != null) {
            clienteBase.setNome(cliente.getNome());
        }
        if (cliente.getEmail() != null) {
            clienteBase.setEmail(cliente.getEmail());
        }
        return save(clienteBase);
    }

}
