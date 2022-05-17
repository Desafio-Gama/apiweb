package br.com.chocode.apiWeb.dao;

import br.com.chocode.apiWeb.model.PedidoProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoProdutoDAO extends JpaRepository<PedidoProduto, Long> {
}
