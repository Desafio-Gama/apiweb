package br.com.chocode.apiWeb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.chocode.apiWeb.model.Pedido;

@Repository
public interface PedidoDAO extends JpaRepository<Pedido, Long>{
    
}
