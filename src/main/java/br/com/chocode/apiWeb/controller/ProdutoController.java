package br.com.chocode.apiWeb.controller;

import br.com.chocode.apiWeb.model.Produto;
import br.com.chocode.apiWeb.services.ProdutoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoServiceImp produtoServiceImp;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        return ResponseEntity.status(200).body(produtoServiceImp.findAll());
    }
}
