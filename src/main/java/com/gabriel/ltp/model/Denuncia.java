package com.gabriel.ltp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Denuncia{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String desc;
    private int grauReRisco;

    public Denuncia(){

    }

    public Denuncia (String desc, int grauReRisco){
        this.desc = desc;
        this.grauReRisco = grauReRisco;
    }

    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public int getGrauReRisco() {
        return grauReRisco;
    }
    public void setGrauReRisco(int grauReRisco) {
        this.grauReRisco = grauReRisco;
    }

    
    
}