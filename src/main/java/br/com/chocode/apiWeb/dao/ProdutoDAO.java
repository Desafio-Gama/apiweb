package br.com.chocode.apiWeb.dao;

import br.com.chocode.apiWeb.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProdutoDAO extends JpaRepository<Produto, Long> {

}
