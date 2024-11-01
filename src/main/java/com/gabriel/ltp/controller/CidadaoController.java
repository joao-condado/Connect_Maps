package com.gabriel.ltp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.gabriel.ltp.repository.CidadaoRepository;



@RestController
@RequestMapping("/cidadao")
public class CidadaoController {
    
    @Autowired
    CidadaoRepository cidadaoRepository;

    @GetMapping("/{id}")
    public Cidadao RetornarCidadao(@PathVariable("id") int valor){
        return cidadaoRepository.findById(valor).get();
    }


    @PutMapping("/atualizar")
    @ResponseStatus(HttpStatus.CREATED)
    public Cidadao AttCidadao(@RequestBody Cidadao cidadaoAtualizado){
        cidadaoRepository.save(cidadaoAtualizado);
        return cidadaoAtualizado;
    }


    @DeleteMapping("/apagar/{id}")
    public String DelCidadao(@PathVariable("id") int id){
        Cidadao cidadaoDel = RetornarCidadao(id);
        cidadaoRepository.delete(cidadaoDel);
        return "Apagado com sucesso";
    }


    @PostMapping("/criarUsuarioCidadao")
    // @ResponseStatus(HttpStatus.CREATED)
    public String criarUsuarioCidadao(@RequestBody Cidadao cidadaoNovo){
        cidadaoRepository.save(cidadaoNovo);
        return "Criado com sucesso";
    }

}