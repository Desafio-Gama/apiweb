package br.com.chocode.apiWeb.controller;

import java.util.List;
import br.com.chocode.apiWeb.services.LojaChocodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.chocode.apiWeb.model.Pedido;


@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private LojaChocodeService<Pedido> pedidoService;

    @Autowired
    public PedidoController(LojaChocodeService<Pedido> pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<Pedido> save(@RequestBody Pedido pedido) {
        return ResponseEntity.status(201).body(pedidoService.save(pedido));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(pedidoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        return ResponseEntity.status(200).body(pedidoService.findAll());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        pedidoService.deleter(id);
    }
}
