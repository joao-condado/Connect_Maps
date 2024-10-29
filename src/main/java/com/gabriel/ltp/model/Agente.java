
package com.gabriel.ltp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class Agente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numIdent;
    private String funcao;
    private String senhaA;

    
}
