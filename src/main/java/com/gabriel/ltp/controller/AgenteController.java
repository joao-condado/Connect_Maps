
package com.gabriel.ltp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.gabriel.ltp.model.Agente;
import com.gabriel.ltp.repository.AgenteRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/agente")
public class AgenteController {
    
    @Autowired
    AgenteRepository agenteRepository;

    @GetMapping("/{numIdent}")
    public Agente RetornarAgente(@PathVariable("numIdent") int valor){
        return agenteRepository.findById(valor).get();
        
    }


    @PutMapping("/atualizar")
    @ResponseStatus(HttpStatus.CREATED)
    public Agente AttAgente(@RequestBody Agente agenteAtualizado){
        agenteRepository.save(agenteAtualizado);
        return agenteAtualizado;
    }

    @DeleteMapping("/apagar/{numIdent}")
    public String DelAgente(@PathVariable("numIdent") int numIdent){
        Agente agenteDel = RetornarAgente(numIdent);
        agenteRepository.delete(agenteDel);
        return "Apagado com sucesso";
    }

    @PostMapping("/criarUsuarioAgente")
    // @ResponseStatus(HttpStatus.CREATED)
    public String criarUsuarioAgente(@RequestBody Agente agente){
        agenteRepository.save(agente);
        return "Criado com sucesso";
        // return ResponseEntity.ok("Agente criado com sucesso!\n\nNumero Identificador: " + agente.getNumIdent() + "\nFunção do Agente: " + agente.getFuncao() + "\nSenha do Agente: " + agente.getSenhaA());
    }




}