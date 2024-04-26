/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progettone_4b;



public class Bici {
    private long idBici;
    private static long nextIdBici = 1;
    private String marca;
    private String modello;
    private String taglia;
    private String colore;
    private String dataUscita;

    public Bici(String marca, String modello, String taglia, String colore, String dataUscita, long idBici) {
        this.idBici = nextIdBici;
        this.marca = marca;
        this.modello = modello;
        this.taglia = taglia;
        this.colore = colore;
        this.dataUscita = dataUscita;
        nextIdBici++;
    }

    public long getIdBici() {
        return idBici;
    }

    public void setIdBici(long idBici) {
        this.idBici = idBici;
    }

    public static long getNextIdBici() {
        return nextIdBici;
    }

    public static void setNextIdBici(long nextIdBici) {
        Bici.nextIdBici = nextIdBici;
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

    public void setTaglia(String taglia) {
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
