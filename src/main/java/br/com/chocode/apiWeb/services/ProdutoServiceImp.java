package br.com.chocode.apiWeb.services;

import br.com.chocode.apiWeb.dao.ProdutoDAO;
import br.com.chocode.apiWeb.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoServiceImp {
    private ProdutoDAO produtoDAO;

    @Autowired
    public ProdutoServiceImp(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    public List<Produto> findAll(){
        List<Produto> listProdutos = produtoDAO.findAll();
        return listProdutos;
    }
}
