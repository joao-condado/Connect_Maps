
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

import com.gabriel.ltp.model.Agente;

@RestController
@RequestMapping("/agente")
public class AgenteController {
    
    @GetMapping("/{numIdent}")
    public String endPoint2(@PathVariable("numIdent") Long valor){
        return "Parâmetros recebido: " + valor;
    }


    @PutMapping("/atualizar")
    @ResponseStatus(HttpStatus.CREATED)
    public Agente AttUser(@RequestBody Agente agenteAtualizado){
        return agenteAtualizado;
    }

    @DeleteMapping("/apagar/{numIdent}")
    public String endPoint5(@PathVariable("numIdent") int numIdent){
        if(numIdent == 1)
            return "Remoção de informação com id " + numIdent + "realizada";
        else{
            return "Objeto para id " + numIdent + "não encontrado";
        }
    }

    @PostMapping("/criarUsuarioAgente")
    // @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> criarUsuarioAgente(@RequestBody Agente agente){
        return ResponseEntity.ok("Agente criado com sucesso!\n\nNumero Identificador: " + agente.getNumIdent() + "\nFunção do Agente: " + agente.getFuncao() + "\nSenha do Agente: " + agente.getSenhaA());
    }




}