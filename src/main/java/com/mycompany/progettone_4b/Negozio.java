/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progettone_4b;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Negozio {
    private Bici[] listaBici;
    private int numBici;

    public Negozio(int maxSize) {
        listaBici = new Bici[maxSize];
        numBici = 0;
    }

    public void aggiungiBici(Bici bici) {
        if (numBici < listaBici.length) {
            listaBici[numBici] = bici;
            numBici++;
        } else {
            System.out.println("Impossibile aggiungere la bici, lo spazio è esaurito.");
        }
    }

    public void visualizzaBiciIdBici(long idBici) {
        boolean trovata = false;
        for (int i = 0; i < numBici; i++) {
            if (listaBici[i].getIdBici() == idBici) {
                System.out.println(listaBici[i]);
                trovata = true;
                break;
            }
        }
        if (!trovata) {
            System.out.println("Nessuna bicicletta trovata con l'ID specificato: " + idBici);
        }
    }

    public void visualizzaBiciMarca(String marca) {
        boolean trovata = false;
        for (int i = 0; i < numBici; i++) {
            if (listaBici[i].getMarca().equalsIgnoreCase(marca)) {
                System.out.println(listaBici[i]);
                trovata = true;
                break;
            }
        }
        if (!trovata) {
            System.out.println("Nessuna bicicletta trovata con la marca specificata: " + marca);
        }
    }

    public void eliminaBiciIdBici(long idBici) {
        boolean eliminata = false;
        for (int i = 0; i < numBici; i++) {
            if (listaBici[i].getIdBici() == idBici) {
                for (int j = i; j < numBici - 1; j++) {
                    listaBici[j] = listaBici[j + 1];
                }
                numBici--;
                eliminata = true;
                System.out.println("Bicicletta eliminata con successo dalla IdBici: " + idBici);
                break;
            }
        }
        if (!eliminata) {
            System.out.println("Nessuna bicicletta trovata alla IdBici specificata: " + idBici);
        }
    }

    public Bici[] elencoBici() {
        Bici[] elenco = Arrays.copyOf(listaBici, numBici);
        return elenco;
    }

    public Bici[] elencoBiciOrdinatoTaglia() {
        Bici[] elencoOrdinato = Arrays.copyOf(listaBici, numBici);
        Arrays.sort(elencoOrdinato, Comparator.comparing(Bici::getTaglia));
        return elencoOrdinato;
    }

    // Metodo per scrivere su file CSV
    public void scriviSuFileCSV(String nomeFile) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeFile))) {
            for (int i = 0; i < numBici; i++) {
                writer.println(listaBici[i].getMarca() + "," +
                               listaBici[i].getModello() + "," +
                               listaBici[i].getTaglia() + "," +
                               listaBici[i].getColore() + "," +
                               listaBici[i].getDataUscita() + "," +
                               listaBici[i].getIdBici());
            }
            System.out.println("Dati esportati in formato CSV con successo.");
        }    }

    // Metodo per scrivere su file binario
    public void scriviSuFileBinario(String nomeFile) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeFile))) {
            oos.writeObject(listaBici);
            System.out.println("Dati esportati in formato binario con successo.");
        } catch (IOException e) {
            System.out.println("Errore durante la scrittura su file binario: " + e.getMessage());
        }
    }

    // Metodo per leggere da file CSV
    public void leggiDaFileCSV(String nomeFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                // Creare una nuova bicicletta e aggiungerla alla listaBici
                Bici nuovaBici = new Bici(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], Long.parseLong(tokens[5]));
                aggiungiBici(nuovaBici);
            }
            System.out.println("Dati importati da file CSV con successo.");
        } catch (IOException e) {
            System.out.println("Errore durante la lettura da file CSV: " + e.getMessage());
        }
    }

    // Metodo per leggere da file binario
    public void leggiDaFileBinario(String nomeFile) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeFile))) {
            Bici[] biciLetta = (Bici[]) ois.readObject();
            for (Bici b : biciLetta) {
                aggiungiBici(b);
            }
            System.out.println("Dati importati da file binario con successo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Errore durante la lettura da file binario: " + e.getMessage());
        }
    }


    @Override
    public String toString() {
        return "Negozio{" + "listaBici=" + listaBici + ", numBici=" + numBici + '}';
    }
   
}
