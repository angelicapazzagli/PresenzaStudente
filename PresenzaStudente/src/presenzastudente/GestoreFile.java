/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenzastudente;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author pazzagli.angelica
 */
public class GestoreFile {
    private String file;
    private ArrayList<Studente> registro;
    
    public GestoreFile(String csv) {
        this.file = csv;
        this.registro = new ArrayList<>();
    }
    
    public void addStudente(Studente s) {
        if(s != null) {
            registro.add(s);
        }
    }
    
    public void readFile() throws FileNotFoundException, IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] colonne = line.split(",");
                LocalDate data = LocalDate.parse(colonne[0]);
                int matricola = Integer.parseInt(colonne[1]);
                Studente s = new Studente(data, matricola, colonne[2], colonne[3]);
                addStudente(s);
            }
        }
    }
    
    public void checkAssenze() {
        ArrayList<Assenza> assenze = new ArrayList();
        for(int i = 0; i < registro.size(); i++) {
            Studente s = registro.get(i);
            if("ASSENTE".equals(s.getStato())) {
                boolean check = false;
                for(int j = 0; j < assenze.size(); j++) {
                    Assenza a = assenze.get(j);
                    if(a.getMatricola() == s.getMatricola()) {
                        a.aggiungiAssenza();
                        check = true;
                    }
                }
                if(check == false) {
                    Assenza nuovo = new Assenza(s.getMatricola(), s.getNome());
                    nuovo.aggiungiAssenza();
                    assenze.add(nuovo);
                }
            }
        }
    }
    
    public String assenzeAlunno() {
        String ret = "";
        for(int i = 0; i < registro.size(); i++) {
            Studente studente = registro.get(i);
            Assenza s = new Assenza(studente.getMatricola(), studente.getNome());
            ret += s.nome + " Assenze: " + s.getAssenze();
        }
        return ret;
    }
}
