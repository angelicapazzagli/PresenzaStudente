/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenzastudente;

/**
 *
 * @author 39333
 */
public class Assenza {
    public int matricola, nAssenze;
    public String nome;
    
    public Assenza(int matricola, String nome) {
        this.matricola = matricola;
        this.nome = nome;
        nAssenze = 0;
    }
    
    public void aggiungiAssenza() {
        this.nAssenze++;
    }
    
    public int getAssenze() {
        return nAssenze;
    }
    
    public int getMatricola() {
        return matricola;
    }
    
    public String getNome() {
        return nome;
    }
}
