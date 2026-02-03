/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presenzastudente;

import java.io.IOException;
import java.time.LocalDate;

/**
 *
 * @author pazzagli.angelica
 */
public class PresenzaStudente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        GestoreFile gf = new GestoreFile("0_PresenzeStudenti.csv");
        gf.readFile();
        gf.stampaRegistro(); 
        System.out.println("\n");
        gf.checkAssenze();
        System.out.println("\n");
        gf.check(LocalDate.of(2026,01,15), LocalDate.of(2026,01,15));
    }    
}
