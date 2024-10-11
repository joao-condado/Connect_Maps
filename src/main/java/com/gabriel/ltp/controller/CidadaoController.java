package com.gabriel.ltp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.gabriel.ltp.model.Cidadao;

public class CidadaoController {
    

    @GetMapping("/cidadao/{id}")
    public String endPoint2(@PathVariable("id") Long valor){
        return "Parâmetros recebido: " + valor;
    }


    @PutMapping("/cidadao/atualizar")
    @ResponseStatus(HttpStatus.CREATED)
    public Cidadao AttUser(@RequestBody Cidadao cidadaoAtualizado){
        return cidadaoAtualizado;
    }

    @DeleteMapping("/cidadao/apagar/{id}")
    public String endPoint5(@PathVariable("id") int id){
        if(id == 1)
            return "Remoção de informação com id " + id + "realizada";
        else{
            return "Objeto para id " + id + "não encontrado";
        }
    }

    @PostMapping("/cidadao/criarUsuarioCidadao")
    @ResponseStatus(HttpStatus.CREATED)
    public Cidadao endPoint3(@RequestBody Cidadao CidadaoNovo){
        return CidadaoNovo;
    }

}
