package br.com.chocode.apiWeb.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.chocode.apiWeb.dao.PedidoDAO;
import br.com.chocode.apiWeb.model.Pedido;
import br.com.chocode.apiWeb.services.LojaChocodeService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImp implements LojaChocodeService<Pedido>{
    private PedidoDAO pedidoDAO;

    @Autowired
    public PedidoServiceImp(PedidoDAO pedidoDAO){
        this.pedidoDAO = pedidoDAO;
    }

    @Override
    public Pedido save(Pedido pedido){
        return pedidoDAO.saveAndFlush(pedido);
    }

    @Override
    public Pedido findById(Long id){
        return pedidoDAO.findById(id).get();
    }

    @Override
    public List<Pedido> findAll(){
        List<Pedido> listaPedido = pedidoDAO.findAll();
        return listaPedido;
    }

    @Override
    public void deleter(Long id){
        pedidoDAO.findById(id).get();
    }

    @Override
    public Pedido update(Pedido pedido){
        Pedido pedidoBanco = findById(pedido.getId());
        if (pedido.getData() != null){
            pedidoBanco.setData(pedido.getData());
        }
        if (pedido.getCliente() != null){
            pedidoBanco.setCliente(pedido.getCliente());
        }
        
        return save(pedidoBanco);
    }
    
}
