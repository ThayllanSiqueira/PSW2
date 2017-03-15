/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author ra21551794
 */
@Entity
public class Vinho implements Serializable {
    
    private String nome;
    private String uva;
    private int ano_safra;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int cod;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUva() {
        return uva;
    }

    public void setUva(String uva) {
        this.uva = uva;
    }

    public int getAno_safra() {
        return ano_safra;
    }

    public void setAno_safra(int ano_safra) {
        this.ano_safra = ano_safra;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
    
    public boolean persiste() {
        return false; 
    }
}
