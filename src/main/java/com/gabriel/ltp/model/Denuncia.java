package com.gabriel.ltp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
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
    private int grauReRisco;

   
    
}