package br.com.chocode.apiWeb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.chocode.apiWeb.dao.ClienteDAO;
import br.com.chocode.apiWeb.model.Cliente;
import br.com.chocode.apiWeb.services.LojaChocodeService;

@Component
public class ClienteServiceImp implements LojaChocodeService<Cliente> {
    private ClienteDAO clienteDAO;

    @Autowired
    public ClienteServiceImp(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public Cliente save(Cliente t) {
        return null;
    }

    @Override
    public Cliente findById(Long id) {
        return null;
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> listClientes = clienteDAO.findAll();
        return listClientes;
    }

    @Override
    public void deleter(Long id) {
    }

    @Override
    public Cliente update(Cliente t) {
        return null;
    }

}
