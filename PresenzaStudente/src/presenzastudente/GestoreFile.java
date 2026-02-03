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
    private ArrayList<PresenzaGiornaliera> registro;
    
    public GestoreFile(String csv) {
        this.file = csv;
        this.registro = new ArrayList<>();
    }
    
    public void addStudente(PresenzaGiornaliera s) {
        if(s != null) {
            registro.add(s);
        }
    }
    
    public void stampaRegistro() {
        for(int i = 0; i < registro.size(); i++) {
            PresenzaGiornaliera s = registro.get(i);
            System.out.println(s.getData() + " " + s.getMatricola() + s.getNome() + s.getStato());
        }
    }
    
    public void readFile() throws FileNotFoundException, IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while((line = reader.readLine()) != null) {
                if(i != 0) {
                    String[] colonne = line.split(",");
                    LocalDate data = LocalDate.parse(colonne[0]);
                    int matricola = Integer.parseInt(colonne[1]);
                    PresenzaGiornaliera s = new PresenzaGiornaliera(data, matricola, colonne[2], colonne[3]);
                    addStudente(s);
                }
                i++;
            }
        }
    }
    
    public void checkAssenze() {
        ArrayList<AssenteCounter> assenze = new ArrayList();
        ArrayList<AssenteCounter> presenti = new ArrayList();
        for(int i = 0; i < registro.size(); i++) {
            PresenzaGiornaliera s = registro.get(i);
            if("ASSENTE".equals(s.getStato())) {
                boolean check = false;
                for(int j = 0; j < assenze.size(); j++) {
                    AssenteCounter a = assenze.get(j);
                    if(a.getMatricola() == s.getMatricola()) {
                        a.aggiungiAssenza();
                        check = true;
                    }
                }
                if(check == false) {
                    AssenteCounter nuovo = new AssenteCounter(s.getMatricola(), s.getNome());
                    nuovo.aggiungiAssenza();
                    assenze.add(nuovo);
                }
            }
            else {
               AssenteCounter p = new AssenteCounter(s.getMatricola(), s.getNome()); 
               assenze.add(p);
            }
        }
        for(int i = 0; i < assenze.size(); i++) {
            AssenteCounter a = assenze.get(i);
            System.out.println(a.getNome() + " Assenze: " + a.getAssenze());
            if(a.getAssenze() == 0) {
                presenti.add(a);
            }
        }
        System.out.println("Sempre presenti: ");
        for(int i = 0; i < presenti.size(); i++) {
            AssenteCounter a = presenti.get(i);
            System.out.println(a.getNome());
        }
    }
    
    public boolean controllaRange(LocalDate data, LocalDate inizio, LocalDate fine) {
        return (!data.isBefore(inizio) && !data.isAfter(fine));
    }
    
    public void check(LocalDate inizio, LocalDate fine) {
        ArrayList<AssenteCounter> assenzeRange = new ArrayList();
        for(int i = 0; i < registro.size(); i++) {
            PresenzaGiornaliera s = registro.get(i);
            boolean c = controllaRange(s.getData(), inizio, fine);
            if(c) {
                if("ASSENTE".equals(s.getStato())) {
                    boolean check = false;
                    for(int j = 0; j < assenzeRange.size(); j++) {
                        AssenteCounter a = assenzeRange.get(j);
                        if(a.getMatricola() == s.getMatricola()) {
                            a.aggiungiAssenza();
                            check = true;
                        }
                    }
                    if(check == false) {
                        AssenteCounter nuovo = new AssenteCounter(s.getMatricola(), s.getNome());
                        nuovo.aggiungiAssenza();
                        assenzeRange.add(nuovo);
                    }
                }
            }           
        }
        for(int i = 0; i < assenzeRange.size(); i++) {
            AssenteCounter a = assenzeRange.get(i);
            System.out.println(a.getNome() + " Assenze: " + a.getAssenze() + " nel range " + inizio + " / " + fine);
            if(a.getAssenze() == 0) {
                assenzeRange.add(a);
            }
        }
    }
}
