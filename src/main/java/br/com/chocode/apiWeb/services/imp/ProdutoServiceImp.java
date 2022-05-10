package br.com.chocode.apiWeb.services.imp;

import br.com.chocode.apiWeb.dao.ProdutoDAO;
import br.com.chocode.apiWeb.model.Produto;
import br.com.chocode.apiWeb.services.LojaChocodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImp implements LojaChocodeService<Produto> {
    private ProdutoDAO produtoDAO;

    @Autowired
    public ProdutoServiceImp(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    @Override
    public Produto save(Produto produto) {
         return produtoDAO.saveAndFlush(produto);
    }

    @Override
    public Produto findById(Long id) {
        return produtoDAO.findById(id).get();
    }

    public List<Produto> findAll() {
        List<Produto> listProdutos = produtoDAO.findAll();
        return listProdutos;
    }

    @Override
    public void deleter(Long id) {
        produtoDAO.deleteById(id);

    }

    @Override
    public Produto update(Produto produto) {
        Produto produtoBanco = findById(produto.getId());
        if (produto.getNome() != null){
            produtoBanco.setNome(produto.getNome());
        }
        if (produto.getDescricao() != null){
            produtoBanco.setDescricao(produto.getDescricao());
        }
        if (produto.getQuantidade() != null){
            produtoBanco.setQuantidade(produto.getQuantidade());
        }
        if (produto.getDataCadastro() != null){
            produtoBanco.setDataCadastro(produto.getDataCadastro());
        }
        if (produto.getPreco() != null){
            produtoBanco.setPreco(produto.getPreco());
        }
        return save(produtoBanco);
    }
}
