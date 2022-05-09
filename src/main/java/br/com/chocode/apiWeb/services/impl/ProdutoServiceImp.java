package br.com.chocode.apiWeb.services.impl;

import br.com.chocode.apiWeb.dao.ProdutoDAO;
import br.com.chocode.apiWeb.model.Produto;
import br.com.chocode.apiWeb.services.LojaChocodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoServiceImp implements LojaChocodeService<Produto> {
    private ProdutoDAO produtoDAO;

    @Autowired
    public ProdutoServiceImp(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    @Override
    public Produto save(Produto produto) {
        return null;
    }

    @Override
    public Produto findById(Long id) {
        return null;
    }

    public List<Produto> findAll(){
        List<Produto> listProdutos = produtoDAO.findAll();
        return listProdutos;
    }

    @Override
    public void deleter(Long id) {

    }

    @Override
    public Produto update(Produto produto) {
        return null;
    }
}
