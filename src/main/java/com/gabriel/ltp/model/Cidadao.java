
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
public class Cidadao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_Cidadao;
    
     @Column(
        unique = true,
        nullable = false,
        length = 40
    )
    private String email;
    
    @Column(
        unique = true,
        nullable = false,
        length = 40
    )
    private String senha;

    

    


}
