/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenzastudente;

import java.time.LocalDate;

/**
 *
 * @author pazzagli.angelica
 */
public class Studente {
    private String nome;
    private LocalDate data;
    private int matricola;
    private String stato;
    
    public Studente(LocalDate data, int matr, String nome, String st) {      
        this.data = data;
        this.matricola = matr;
        this.nome = nome;
        this.stato = st;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public int getMatricola() {
        return this.matricola;
    }
    
    public LocalDate getData() {
        return this.data;
    }
    
    public String getStato() {
        return this.stato;
    }
}
