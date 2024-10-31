package com.gabriel.ltp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.ltp.model.Cidadao;

@RestController
@RequestMapping("/cidadao")
public class CidadaoController {
    

    @GetMapping("/{id}")
    public String endPoint2(@PathVariable("id") Long valor){
        return "Parâmetros recebido: " + valor;
    }


    @PutMapping("/atualizar")
    @ResponseStatus(HttpStatus.CREATED)
    public Cidadao AttUser(@RequestBody Cidadao cidadaoAtualizado){
        return cidadaoAtualizado;
    }


    @DeleteMapping("/apagar/{id}")
    public String endPoint5(@PathVariable("id") int id){
        if(id == 1)
            return "Remoção de informação com id " + id + "realizada";
        else{
            return "Objeto para id " + id + "não encontrado";
        }
    }


    @PostMapping("/criarUsuarioCidadao")
    // @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> criarUsuarioCidadao(@RequestBody Cidadao cidadaoNovo){
        return ResponseEntity.ok("Cidadão cadastrado com sucesso!\n\nEmail: " + cidadaoNovo.getEmail() + "\nSenha: " + cidadaoNovo.getSenha());
    }

}