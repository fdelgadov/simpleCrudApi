package com.example.demoSimpleCRUD;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "catalogo") 
public class Catalogo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String TIPO;
    private Float VALOR;
    
    public Long getID() {
        return ID;
    }
    public void setID(Long iD) {
        ID = iD;
    }
    public String getTIPO() {
        return TIPO;
    }
    public void setTIPO(String tIPO) {
        TIPO = tIPO;
    }
    public Float getVALOR() {
        return VALOR;
    }
    public void setVALOR(Float vALOR) {
        VALOR = vALOR;
    }
}
