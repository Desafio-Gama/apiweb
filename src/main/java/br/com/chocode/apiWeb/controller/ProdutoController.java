package br.com.chocode.apiWeb.controller;

import br.com.chocode.apiWeb.model.Produto;
import br.com.chocode.apiWeb.services.LojaChocodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private LojaChocodeService<Produto> produtoServiceImp;

    @Autowired
    public ProdutoController(LojaChocodeService<Produto> produtoServiceImp) {
        this.produtoServiceImp = produtoServiceImp;
    }

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto produto) {
        return ResponseEntity.status(201).body(produtoServiceImp.save(produto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(produtoServiceImp.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        return ResponseEntity.status(200).body(produtoServiceImp.findAll());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        produtoServiceImp.deleter(id);
    }
}
