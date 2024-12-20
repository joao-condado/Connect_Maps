package com.gabriel.ltp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*")
@RequestMapping("/cidadao")
public class CidadaoController {
    
    @Autowired
    CidadaoRepository cidadaoRepository;

    @GetMapping("/{id}")
    public Cidadao RetornarCidadao(@PathVariable("id") int valor){
        return cidadaoRepository.findById(valor).get();
    }

    @GetMapping("/todos")
    public List<Cidadao> RetornarTodosCidadaos() {
        return (List<Cidadao>) cidadaoRepository.findAll();
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
    public ResponseEntity<Cidadao> criarUsuarioCidadao(@RequestBody Cidadao cidadaoNovo){
        cidadaoRepository.save(cidadaoNovo);
        return ResponseEntity.ok(cidadaoNovo);
    }

}