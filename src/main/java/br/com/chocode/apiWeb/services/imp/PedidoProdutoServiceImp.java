package br.com.chocode.apiWeb.services.imp;

import br.com.chocode.apiWeb.dao.PedidoProdutoDAO;
import br.com.chocode.apiWeb.model.PedidoProduto;
import br.com.chocode.apiWeb.services.LojaChocodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoProdutoServiceImp implements LojaChocodeService<PedidoProduto> {
    private PedidoProdutoDAO pedidoProdutoDAO;

    @Autowired
    public PedidoProdutoServiceImp(PedidoProdutoDAO pedidoProdutoDAO) {
        this.pedidoProdutoDAO = pedidoProdutoDAO;
    }

    @Override
    public PedidoProduto save(PedidoProduto pedidoProduto) {
        return pedidoProdutoDAO.saveAndFlush(pedidoProduto);
    }

    @Override
    public PedidoProduto findById(Long id) {
        return pedidoProdutoDAO.findById(id).get();
    }

    @Override
    public List<PedidoProduto> findAll() {
        return pedidoProdutoDAO.findAll();
    }

    @Override
    public void deleter(Long id) {
        pedidoProdutoDAO.deleteById(id);
    }

    @Override
    public PedidoProduto update(PedidoProduto pedidoProduto) {
        if (pedidoProduto == null || pedidoProduto.getId() == null){
            return null;
        }
        PedidoProduto pedidoProdutoBase = findById(pedidoProduto.getId());
        if (pedidoProduto.getPedido() != null){
            pedidoProdutoBase.setPedido(pedidoProduto.getPedido());
        }
        if (pedidoProduto.getProduto() != null){
            pedidoProdutoBase.setProduto(pedidoProduto.getProduto());
        }
        if (pedidoProduto.getQuantidade() != null){
            pedidoProdutoBase.setQuantidade(pedidoProduto.getQuantidade());
        }
        if (pedidoProduto.getPreco() != null){
            pedidoProdutoBase.setPreco(pedidoProduto.getPreco());
        }
        return save(pedidoProdutoBase);
    }
}
