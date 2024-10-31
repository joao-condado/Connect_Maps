package com.gabriel.ltp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Agente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numIdent;
    private String funcao;
    private String senhaA;

    public Agente(){

    }

    public Agente(int numIdent, String funcao, String senhaA){
        this.funcao = funcao;
        this.numIdent = numIdent;
        this.senhaA = senhaA;
    }

    public int getNumIdent() {
        return numIdent;
    }

    public void setNumIdent(int numIdent) {
        this.numIdent = numIdent;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getSenhaA() {
        return senhaA;
    }

    public void setSenhaA(String senhaA) {
        this.senhaA = senhaA;
    }

    

}


package com.gabriel.ltp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    
}
