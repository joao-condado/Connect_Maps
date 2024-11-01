package com.gabriel.ltp.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "AgCivil")
public class Agente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int numIdent;
    
    @Column(
        nullable = false,
        length = 40
    )
    private String funcao;
    
    @Column(
        unique = true,
        nullable = false,
        length = 40
    )
    private String senhaA;

     
    @OneToMany(mappedBy = "Agente")
    public List <Denuncia> denuncias;
}
