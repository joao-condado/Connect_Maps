package com.gabriel.ltp.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class DenunciaController {

    @GetMapping("/placeholderGetDenuncia")
    public String endpointGetDesc(){
        return "Exemplo Get Denuncia";
    }

    @GetMapping("/placeholderGetDenuncia/{parametro}")
    public String endpointGetDescParam(){
        return "Exemplo Get Denuncia";
    }

}