package com.gabriel.ltp.model;

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
    private String descricao;
    private int grauReRisco;

   
    
}