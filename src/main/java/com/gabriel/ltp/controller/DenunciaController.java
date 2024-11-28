package com.gabriel.ltp.controller;

import java.util.List;

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
import com.gabriel.ltp.model.Denuncia;
import com.gabriel.ltp.repository.CidadaoRepository;
import com.gabriel.ltp.repository.DenunciaRepository;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/denuncia")
public class DenunciaController {

    @Autowired
    DenunciaRepository denunciaRepository;

    @Autowired
    private CidadaoRepository cidadaoRepository;

    @GetMapping("/{id}")
    public Denuncia RetornarDenuncia(@PathVariable("id") int valor){
        return denunciaRepository.findById(valor).get();
    }

    @PutMapping("/atualizar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Denuncia AttDenuncia(@PathVariable("id") int id, @RequestBody Denuncia denunciaAtualizada){
    // Busca a denúncia existente pelo ID
        Denuncia denunciaExistente = denunciaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Denúncia não encontrada"));

    // Atualiza apenas os campos que foram fornecidos na requisição
        if (denunciaAtualizada.getDescricao() != null) {
        denunciaExistente.setDescricao(denunciaAtualizada.getDescricao());
        }
        if (denunciaAtualizada.getGrauDeRisco() != null) {
        denunciaExistente.setGrauDeRisco(denunciaAtualizada.getGrauDeRisco());
        }
        if (denunciaAtualizada.getCategoria() != null) {
        denunciaExistente.setCategoria(denunciaAtualizada.getCategoria());
        }

    // Salva a denúncia com os dados atualizados
        denunciaRepository.save(denunciaExistente);
    
        return denunciaExistente;
    }


    @PostMapping("/cadastrarDenuncia")
    // @ResponseStatus(HttpStatus.CREATED)
    // public String cadastrarDenuncia(@RequestBody Denuncia denuncia){
    //      Cidadao cidadao = cidadaoRepository.findById(denuncia.getCidadao().getId_Cidadao())
    //         .orElseThrow(() -> new EntityNotFoundException("Cidadao não encontrado"));
    //     denuncia.setCidadao(cidadao);
    //     denunciaRepository.save(denuncia);
    //     return "Cadastrado com sucesso";
    //     // return ResponseEntity.ok("Agente criado com sucesso!\n\nNumero Identificador: " + agente.getNumIdent() + "\nFunção do Agente: " + agente.getFuncao() + "\nSenha do Agente: " + agente.getSenhaA());
    // }
    public String cadastrarDenuncia(@RequestBody Denuncia denuncia){
        // Aqui, não estamos mais associando um cidadão à denúncia
        denunciaRepository.save(denuncia);
        return "Denúncia cadastrada com sucesso!";
    }

    @GetMapping("/todos")
    public List<Denuncia> RetornarTodasDenuncias() {
        return (List<Denuncia>) denunciaRepository.findAll();
    }

    @DeleteMapping("/apagar/{id}")
    public String DelDenuncia(@PathVariable("id") int id){
        Denuncia denunciaDel = RetornarDenuncia(id);
        denunciaRepository.delete(denunciaDel);
        return "Apagado com sucesso";
    }
}