/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progettone_4b;

import eccezioni.EccezioneTagliaNonValida;

/**
 *
 * @author josh
 */
public class Bici {

    private int idBici;
    private static int nextId = 1;
    private String marca;
    private String modello;
    private String taglia;
    private String colore;
    private String dataUscita;
    private static final int NUM_MAX_BICI = 100;

    public Bici(String marca, String modello, String taglia, String colore, String dataUscita) {
        this.idBici = nextId;
        nextId++;
        this.marca = marca;
        this.modello = modello;
        this.taglia = taglia;
        this.colore = colore;
        this.dataUscita = dataUscita;

    }

    public Bici(Bici bici) {
        this.idBici = bici.getIdBici();
        this.marca = bici.getMarca();
        this.modello = bici.getModello();
        this.taglia = bici.getTaglia();
        this.colore = bici.getColore();
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

    public void setTaglia(String taglia) throws EccezioneTagliaNonValida{
        if (!taglia.equals("XS") && !taglia.equals("S") && !taglia.equals("M") &&!taglia.equals("L") && !taglia.equals("XL")) {
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
