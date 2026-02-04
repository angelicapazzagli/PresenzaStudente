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
 * @author PAZZAGLI.ANGELICA
 */
public class FileManager {
    private static String file;
    
    public static ArrayList<PresenzaGiornaliera> readFile(ArrayList<PresenzaGiornaliera> registro) throws FileNotFoundException, IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while((line = reader.readLine()) != null) {
                if(i != 0) {
                    String[] colonne = line.split(",");
                    LocalDate data = LocalDate.parse(colonne[0]);
                    int matricola = Integer.parseInt(colonne[1]);
                    PresenzaGiornaliera s = new PresenzaGiornaliera(data, matricola, colonne[2], colonne[3]);
                    registro.add(s);
                }
                i++;
            }
        }
        return registro;
    }
}
