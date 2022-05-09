package br.com.chocode.apiWeb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.chocode.apiWeb.dao.PedidoDAO;
import br.com.chocode.apiWeb.model.Pedido;
import br.com.chocode.apiWeb.services.LojaChocodeService;

public class PedidoServiceImpl implements LojaChocodeService<Pedido>{
    private PedidoDAO pedidoDAO;

    @Autowired
    public PedidoServiceImpl(PedidoDAO pedidoDAO){
        this.pedidoDAO = pedidoDAO;
    }

    @Override
    public Pedido save(Pedido pedido){
        return null;
    }

    @Override
    public Pedido findById(Long id){
        return null;
    }

    @Override
    public List<Pedido> findAll(){
        List<Pedido> listaPedido = pedidoDAO.findAll();
        return listaPedido;
    }

    @Override
    public void deleter(Long id){

    }

    @Override
    public Pedido update(Pedido pedido){
        return null;
    }
    
}
