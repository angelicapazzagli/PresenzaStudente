/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenzastudente;

import java.util.Date;

/**
 *
 * @author pazzagli.angelica
 */
public class Studente {
    private String nome;
    private Date data;
    private int matricola;
    private Stato stato;
    
    public Studente(String nome, Date data, int matr, Stato st) {
        this.nome = nome;
        this.data = data;
        this.matricola = matr;
        this.stato = st;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public int getMatricola() {
        return this.matricola;
    }
    
    public Date getData() {
        return this.data;
    }
    
    public Stato getStato() {
        return this.stato;
    }
}
