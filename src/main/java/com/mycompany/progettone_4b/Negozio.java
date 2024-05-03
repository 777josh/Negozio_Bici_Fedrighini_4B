/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progettone_4b;

/**
 *
 * @author josh
 */
import eccezioni.EccezionePosizioneNonValida;
import eccezioni.EccezionePosizioneOccupata;
import eccezioni.EccezionePosizioneVuota;
import eccezioni.EccezioneTagliaNonValida;
import eccezioni.FileException;
import java.io.IOException;
import utilità.TextFile;

public class Negozio {

    private final static int NUM_MAX_BICI = 100;
    private Bici[] bici;
    private Bici[] elencoBici;
    private int numeroBici;
    
    public Negozio() {
        bici = new Bici[NUM_MAX_BICI];
        this.elencoBici = new Bici[NUM_MAX_BICI];
        this.numeroBici = 0;
    }

    public Negozio(Negozio n) {
        bici = new Bici[NUM_MAX_BICI];
        Bici b;
        for (int i = 0; i < n.getNumMaxBici(); i++) {
            try {
                b = n.getBici(i);
                if (b != null) {
                    this.setBici(b, i);
                }
            } catch (EccezionePosizioneNonValida ex) {

            } catch (EccezionePosizioneVuota ex) {

            } catch (EccezionePosizioneOccupata ex) {

            }

        }
    }

    public Negozio(Bici[] elencoBici) {
        bici = new Bici[NUM_MAX_BICI];
        int numBiciDaAggiungere;

        numBiciDaAggiungere = elencoBici.length;
        if (numBiciDaAggiungere > NUM_MAX_BICI) {
            numBiciDaAggiungere = NUM_MAX_BICI;
        }

        for (int i = 0; i < numBiciDaAggiungere; i++) {
            if (elencoBici[i] != null)
                try {
                setBici(elencoBici[i], i);
            } catch (EccezionePosizioneNonValida ex) {

            } catch (EccezionePosizioneOccupata ex) {

            }
        }
    }

    public Bici getBici(int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneVuota {
        Bici b;
        if (posizione < 0 || posizione >= NUM_MAX_BICI) {
            throw new EccezionePosizioneNonValida();
        }
        if (bici[posizione] == null) {
            throw new EccezionePosizioneVuota();
        }
        b = bici[posizione];
        return new Bici(b);
    }

    public void setBici(Bici bici, int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneOccupata {
        if (posizione < 0 || posizione >= NUM_MAX_BICI) {
            throw new EccezionePosizioneNonValida();
        }
        if (this.bici[posizione] != null) {
            throw new EccezionePosizioneOccupata();
        }
        this.bici[posizione] = new Bici(bici);
    }

    public void EliminaBici(int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneVuota {
        if (posizione < 0 || posizione >= NUM_MAX_BICI) {
            throw new EccezionePosizioneNonValida();
        }
        if (bici[posizione] == null) {
            throw new EccezionePosizioneVuota();
        }
        bici[posizione] = null;
    }

    public int getNumBici() {
        int cont = 0;
        for (int i = 0; i < this.getNumMaxBici(); i++) {
            if (bici[i] != null) {
                cont++;
            }
        }
        return cont;
    }

    public int getNumMaxBici() {
        return NUM_MAX_BICI;
    }
    
    public Bici[] elencoBici() {
        return bici;
    }

    public String[] visualizzaBiciMarca(String marcaDaCercare) {
        int contaBiciMarca = 0;
        Bici b;
        String[] visualizzaMarcaBici;

        for (int i = 0; i < this.getNumMaxBici(); i++) {
            try {
                b = this.getBici(i);
                if (b.getMarca().equalsIgnoreCase(marcaDaCercare)) {
                    contaBiciMarca++;
                }
            } catch (EccezionePosizioneNonValida ex) {

            } catch (EccezionePosizioneVuota ex) {

            }
        }

        if (contaBiciMarca == 0) {
            return null;
        }
        visualizzaMarcaBici = new String[contaBiciMarca];

        contaBiciMarca = 0;

        for (int i = 0; i < this.getNumMaxBici(); i++) {
            try {
                b = this.getBici(i);
                if (b.getMarca().equalsIgnoreCase(marcaDaCercare)) {
                    visualizzaMarcaBici[contaBiciMarca] = b.toString();
                    contaBiciMarca++;
                }
            } catch (EccezionePosizioneNonValida ex) {

            } catch (EccezionePosizioneVuota ex) {

            }
        }
        return visualizzaMarcaBici;
    }
    

    private static int ElencoBiciOrdinatoPerTaglia(String taglia) {
        switch (taglia) {
            case "xs":
                return 1;
            case "s":
                return 2;
            case "m":
                return 3;
            case "l":
                return 4;
            case "xl":
                return 5;
            default:
                return 0;
        }
    }

    public void esportaCSV(String nomeFile) throws IOException {
        TextFile f1;
        Bici b;
        f1 = new TextFile(nomeFile, 'W');
        String dBici;
        for (int i = 0; i < this.getNumMaxBici(); i++) {
            try {
                b = this.getBici(i);
                dBici = i + ";" + b.getIdBici() + ";" + b.getMarca() + ";" + b.getModello() + ";" + b.getTaglia() + ";" + b.getDataUscita();
                f1.toFile(dBici);
            } catch (EccezionePosizioneVuota ex) {

            } catch (FileException ex) {

            } catch (EccezionePosizioneNonValida ex) {

            }
            f1.closeFile();
        }
    }

    public void importaDaCSV(String nomeFile) throws IOException {
        String rigaLetta;
        String[] dBici;
        TextFile f1;
        int posizione, idBici;
        String marca, modello, taglia, colore, dataUscita;
        Bici b;
        f1 = new TextFile(nomeFile, 'R');

        do {
            try {
                rigaLetta = f1.fromFile();
                dBici = rigaLetta.split(";");
                posizione = Integer.parseInt(dBici[0]);
                idBici = Integer.parseInt(dBici[1]);
                marca = dBici[2];
                modello = dBici[3];
                taglia = dBici[4];
                colore = dBici[5];
                dataUscita = dBici[6];
                b = new Bici(marca, modello, taglia, colore, dataUscita);
                try {
                    this.setBici(b, posizione);
                } catch (EccezionePosizioneNonValida ex) {

                } catch (EccezionePosizioneOccupata ex) {

                }
            } catch (FileException ex) {
                f1.closeFile();
                System.out.println("Importazione terminata!");
                break;
            } 
        } while (true);
    }

    public String toString()

    {
        String s = "";
        for (int i = 0; i < NUM_MAX_BICI; i++) {
            if (bici[i] == null) {
                s += i + "-->\n";
            } else {
                s += i + "-->\t" + bici[i].toString() + "\n";
            }
        }
        return s;
    }
}
