package br.com.chocode.apiWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.chocode.apiWeb.model.Pedido;
import br.com.chocode.apiWeb.services.impl.PedidoServiceImpl;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoServiceImpl pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> save(Pedido pedido) {
        return ResponseEntity.status(201).body(pedidoService.save(pedido));
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Pedido> findById(Long id) {
        return ResponseEntity.status(200).body(pedidoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        return ResponseEntity.status(200).body(pedidoService.findAll());
    }

    @DeleteMapping
    public ResponseEntity<String> delete(Long id) {
        return ResponseEntity.status(200).body("Pedido Deletado");
    }
}
