package br.com.chocode.apiWeb.services.imp;

import java.util.List;

import br.com.chocode.apiWeb.services.ClienteChocodeService;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.chocode.apiWeb.dao.ClienteDAO;
import br.com.chocode.apiWeb.model.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImp implements ClienteChocodeService<Cliente> {
    private ClienteDAO clienteDAO;
    private RedisServiceImp redis;

    @Autowired
    public ClienteServiceImp(ClienteDAO clienteDAO, RedisServiceImp redis) {
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
        String key = "idCliente" + id;
        String keyNome = "nomeCliente" + id;
        String keyEmail = "emailCliente" + id;

        try {
            if (redis.read(key) != null) {
                cliente = new Cliente();

                cliente.setId(id);
                cliente.setNome(redis.read(keyNome) + " Redis");
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

    public Cliente findByEmail(String email) {
        Cliente cliente;
        String key = "cliente" + email;
        String keyNome = "clienteNome" + email;
        String keyEmail = "clienteEmail" + email;

        try {
            if (redis.read(keyEmail) != null) {
                cliente = new Cliente();

                cliente.setId(Long.parseLong(redis.read(key)));
                cliente.setNome(redis.read(keyNome) + " DB");
                cliente.setEmail(email);

                return cliente;

            } else {
                cliente = clienteDAO.findByEmail(email);

                redis.write(key, cliente.getId().toString(), 60);
                redis.write(keyNome, cliente.getNome(), 60);
                redis.write(keyEmail, cliente.getEmail(), 60);

                return cliente;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
