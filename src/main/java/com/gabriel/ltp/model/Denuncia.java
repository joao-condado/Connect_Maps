package com.gabriel.ltp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Denuncias")
public class Denuncia{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_Denuncia;
    
     @Column(
        nullable = false,
        length = 40
    )
    private String descricao;
    
    @Column(
        nullable = false,
        length = 40
    )
    
    private int grauDeRisco;

    @Column(
        nullable = false,
        length = 20
    )
    private String categoria;
    

    @ManyToOne
    @JoinColumn(name = "Id_Cidadao", nullable = false)
    @JsonManagedReference
    private Cidadao cidadao;


}