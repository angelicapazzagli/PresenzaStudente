/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenzastudente;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
            reader.readLine();
        }
    }
}
