package br.com.chocode.apiWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.chocode.apiWeb.model.Pedido;
import br.com.chocode.apiWeb.services.impl.PedidoServiceImpl;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoServiceImpl pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll(){
        return ResponseEntity.status(200).body(pedidoService.findAll());
    }
}
