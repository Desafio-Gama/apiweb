package br.com.chocode.apiWeb.controller;

import br.com.chocode.apiWeb.model.PedidoProduto;
import br.com.chocode.apiWeb.services.LojaChocodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos/produtos")
public class PedidoProdutoController {
    private LojaChocodeService<PedidoProduto> produtoLojaChocodeServiceImp;

    @Autowired
    public PedidoProdutoController(LojaChocodeService<PedidoProduto> produtoLojaChocodeServiceImp) {
        this.produtoLojaChocodeServiceImp = produtoLojaChocodeServiceImp;
    }

    @PostMapping
    public ResponseEntity<PedidoProduto> save(@RequestBody PedidoProduto pedidoProduto) {
        return ResponseEntity.status(201).body(produtoLojaChocodeServiceImp.save(pedidoProduto));
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<PedidoProduto> findById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(produtoLojaChocodeServiceImp.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<PedidoProduto>> findAll() {
        return ResponseEntity.status(200).body(produtoLojaChocodeServiceImp.findAll());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        produtoLojaChocodeServiceImp.deleter(id);
    }

}
