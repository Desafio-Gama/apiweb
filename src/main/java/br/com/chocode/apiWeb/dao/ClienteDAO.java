package br.com.chocode.apiWeb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.chocode.apiWeb.model.Cliente;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Long> {
    Cliente findByEmail(String email);
}
