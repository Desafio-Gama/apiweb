package br.com.chocode.apiWeb.controller;

import br.com.chocode.apiWeb.model.Cliente;
import br.com.chocode.apiWeb.model.Produto;
import br.com.chocode.apiWeb.services.ClienteChocodeService;
import br.com.chocode.apiWeb.services.LojaChocodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SiteController {
    private ClienteChocodeService<Cliente> clienteService;
    private LojaChocodeService<Produto> produtoService;

    @Autowired
    public SiteController(ClienteChocodeService<Cliente> clienteService, LojaChocodeService<Produto> produtoService) {
        this.clienteService = clienteService;
        this.produtoService = produtoService;
    }

    @GetMapping("/home")
    public String home(){
        return "home/home";
    }

    @GetMapping("/busca")
    public String buscar(){
        return "home/cliente";
    }

    @GetMapping("/resultado")
    public String resultado(Model model) {

        List<Cliente> cli= clienteService.findAll();

        model.addAttribute("clientes", cli);
        return "home/resultado";
    }

    @GetMapping("/pedido")
    public String pedido(){
        return "home/pedido";
    }
}
