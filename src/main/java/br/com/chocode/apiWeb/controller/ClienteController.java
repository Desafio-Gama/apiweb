package br.com.chocode.apiWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.chocode.apiWeb.model.Cliente;
import br.com.chocode.apiWeb.services.impl.ClienteServiceImp;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteServiceImp clienteServiceImp;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        return ResponseEntity.status(200).body(clienteServiceImp.findAll());
    }
}
