/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progettone_4b;

import eccezioni.EccezioneTagliaNonValida;

/**
 * Rappresenta una Bici
 *
 * @author Josh
 */
public class Bici {

    private int idBici;
    private static int nextId = 1;
    private String marca;
    private String modello;
    private String taglia;
    private String colore;
    private String dataUscita;
    //Numero massimo di biciclette supportate.     
    private static final int NUM_MAX_BICI = 100;

    /**
     * Costruisce un oggetto bicicletta con i dettagli specificati.
     *
     * @param marca La marca della bicicletta.
     * @param modello Il modello della bicicletta.
     * @param taglia La taglia della bicicletta.
     * @param colore Il colore della bicicletta.
     * @param dataUscita La data di uscita della bicicletta.
     */
    public Bici(String marca, String modello, String taglia, String colore, String dataUscita) {
        // Assegna un ID univoco alla bicicletta e incrementa il contatore per il prossimo ID disponibile
        this.idBici = nextId;
        nextId++;
        // Inizializza gli attributi della bicicletta con i valori forniti
        this.marca = marca;
        this.modello = modello;
        this.taglia = taglia;
        this.colore = colore;
        this.dataUscita = dataUscita;

    }

    /**
     * Costruttore di copia
     *
     * @param bici L'oggetto bicicletta da cui copiare i dettagli.
     */
    public Bici(Bici bici) {
        // Copia l'ID della bicicletta
        this.idBici = bici.getIdBici();
        // Copia la marca della bicicletta
        this.marca = bici.getMarca();
        // Copia il modello della bicicletta
        this.modello = bici.getModello();
        // Copia la taglia della bicicletta
        this.taglia = bici.getTaglia();
        // Copia il colore della bicicletta
        this.colore = bici.getColore();
        // Copia la data di uscita della bicicletta
        this.dataUscita = bici.getDataUscita();
    }

    public int getIdBici() {
        return idBici;
    }

    public void setIdBici(int idBici) {
        this.idBici = idBici;
    }

    public static int getNextIdBici() {
        return nextId;
    }

    public static void setNextIdBici(int nextId) {
        Bici.nextId = nextId;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getTaglia() {
        return taglia;
    }

    public void setTaglia(String taglia) throws EccezioneTagliaNonValida {
        if (!taglia.equals("XS") && !taglia.equals("S") && !taglia.equals("M") && !taglia.equals("L") && !taglia.equals("XL")) {
            throw new EccezioneTagliaNonValida();
        }
        this.taglia = taglia;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public String getDataUscita() {
        return dataUscita;
    }

    public void setDataUscita(String dataUscita) {
        this.dataUscita = dataUscita;
    }

    @Override
    public String toString() {
        return "Bici{" + "idBici=" + idBici + ", marca=" + marca + ", modello=" + modello + ", taglia=" + taglia + ", colore=" + colore + ", dataUscita=" + dataUscita + '}';
    }

}
