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
    @Autowired
    private LojaChocodeService<Produto> produtoServiceImp;

    @PostMapping
    public ResponseEntity<Produto> save(Produto produto) {
        return ResponseEntity.status(201).body(produtoServiceImp.save(produto));
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Produto> findById(Long id) {
        return ResponseEntity.status(200).body(produtoServiceImp.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        return ResponseEntity.status(200).body(produtoServiceImp.findAll());
    }

    @DeleteMapping
    public ResponseEntity<String> delete(Long id) {
        return ResponseEntity.status(200).body("Produto Deletado");
    }
}
