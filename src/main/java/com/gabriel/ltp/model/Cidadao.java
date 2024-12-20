
package com.gabriel.ltp.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Cid")
public class Cidadao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_Cidadao;

    @Column(
        nullable = false,
        length = 50
    )
    private String nome;

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

    @Column(
        unique = true,
        nullable = false,
        length =  11
    )
    private String telefone;

//    @OneToMany(mappedBy = "cidadao")
//    @JsonManagedReference
//    private List<Denuncia> denuncias;

}
