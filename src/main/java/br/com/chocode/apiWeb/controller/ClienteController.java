package br.com.chocode.apiWeb.controller;

import java.util.List;

import br.com.chocode.apiWeb.services.ClienteChocodeService;
import br.com.chocode.apiWeb.services.LojaChocodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.chocode.apiWeb.model.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private ClienteChocodeService<Cliente> clienteServiceImp;

    @Autowired
    public ClienteController(ClienteChocodeService<Cliente> clienteServiceImp) {
        this.clienteServiceImp = clienteServiceImp;
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
        return ResponseEntity.status(201).body(clienteServiceImp.save(cliente));
    }

    @GetMapping("/busca")
    public ResponseEntity<Cliente> findById(@RequestParam String email) {
        Cliente cliente = clienteServiceImp.findByEmail(email);
        if (cliente == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(200).body(cliente);
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
