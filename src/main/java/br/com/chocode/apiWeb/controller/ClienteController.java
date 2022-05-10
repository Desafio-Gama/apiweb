package br.com.chocode.apiWeb.controller;

import java.util.List;

import br.com.chocode.apiWeb.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.chocode.apiWeb.model.Cliente;
import br.com.chocode.apiWeb.services.imp.ClienteServiceImp;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private ClienteServiceImp clienteServiceImp;

    @Autowired
    public ClienteController(ClienteServiceImp clienteServiceImp) {
        this.clienteServiceImp = clienteServiceImp;
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
        return ResponseEntity.status(201).body(clienteServiceImp.save(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(clienteServiceImp.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        return ResponseEntity.status(200).body(clienteServiceImp.findAll());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clienteServiceImp.deleter(id);
    }
}
