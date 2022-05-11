package br.com.chocode.apiWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {

    @GetMapping("/busca")
    public String buscar(){
        return "home/cliente";
    }
}
