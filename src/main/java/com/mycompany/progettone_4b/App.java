/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.progettone_4b;

import java.io.*;
import utilità.*;
import eccezioni.*;

/**
 *
 * @author josh
 */
public class App {

    public static void main(String[] args) throws IOException {
        int numeroVociMenu = 11;
        String[] vociMenu = new String[numeroVociMenu];
        int scelta;
        Menu menu;
        int NUM_MAX_BICI = 100;
        Negozio n1 = new Negozio();
        //  Scanner tastiera=new Scanner(System.in);
        ConsoleInput tastiera = new ConsoleInput();
        String marca, modello, taglia, colore, dataUscita = null;
        int posizione, idBici;
        TextFile f1 = null;

        Bici b;
        Bici[] elencoBiciOrdinatoPerTaglia;
        String[] VisualizzaBiciMarca;
        String nomeFileCSV = "bici.csv";

        vociMenu[0] = "0 -->\tEsci";
        vociMenu[1] = "1 -->\tVisualizza Bici(posizione)";
        vociMenu[2] = "2 -->\tVisualizza Bici(Marca)";
        vociMenu[3] = "3 -->\tAggiungi Bici(posizione)";
        vociMenu[4] = "4 -->\tElimina Bici (posizione)";
        vociMenu[5] = "5 -->\tMostra elenco bici";
        vociMenu[6] = "6 -->\tMostra elenco bici ordinato per taglia";
        vociMenu[7] = "7 -->\tEsporta bici in formato CSV";
        vociMenu[8] = "8 -->\tImporta bici in formato CSV";
        vociMenu[9] = "9 -->\tEsporta bici in formato binario";
        vociMenu[10] = "10 -->\tImporta bici in formato binario";

        menu = new Menu(vociMenu);

        do {
            scelta = menu.sceltaMenu();

            switch (scelta) {
                case 0://esci
                    System.out.println("Hai scelto: Esci");
                    break;
                    
                case 1://Visualizza Bici(posizione)
                    try {
                    do {
                        try {
                            System.out.println("Posizione (0..99) --> ");
                            posizione = tastiera.readInt();
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Posizione non corretto");
                        }
                    } while (true);
                    b = n1.getBici(posizione);
                    System.out.println("Bici trovata:\n" + b.toString());
                } catch (IOException e) {
                    System.out.println("Errore. Impossibile leggere da tastiera");
                } catch (EccezionePosizioneNonValida ex) {
                    System.out.println("Posizione non valida!");
                } catch (EccezionePosizioneVuota ex) {
                    System.out.println("Nessuna bici presente in quella posizione!");
                }
                break;
                case 2://Visualizza Bici(Marca)
                    System.out.println("Inserisci la marca da cercare:");
                    String marcaDaCercare = tastiera.readString();
                    String[] biciMarca = n1.visualizzaBiciMarca(marcaDaCercare);
                    if (biciMarca != null) {
                        System.out.println("Biciclette della marca " + marcaDaCercare + ":");
                        for (String biciInfo : biciMarca) {
                            System.out.println(biciInfo);
                        }
                    } else {
                        System.out.println("Nessuna bicicletta trovata per la marca " + marcaDaCercare);
                    }
                    break;
                    
                case 3://Aggiungi Bici(posizione)
                    try {

                    System.out.print("Marca --> ");
                    marca = tastiera.readString();
                    System.out.print("Modello --> ");
                    modello = tastiera.readString();
                    System.out.print("colore --> ");
                    colore = tastiera.readString();

                    do {
                        try {
                            System.out.print("Taglia(XS,S,M,L,XL) --> ");
                            taglia = tastiera.readString();
                            if (!taglia.equals("XS") && !taglia.equals("S") && !taglia.equals("M") && !taglia.equals("L") && !taglia.equals("XL")) {
                                throw new EccezioneTagliaNonValida();
                            }
                            break;
                        } catch (EccezioneTagliaNonValida ex) {
                            System.out.println("Taglia non corretta.");

                        }
                    } while (true);

                    do {
                        try {
                            System.out.print("Data Uscita (GG/MM/AAAA) --> ");
                            dataUscita = tastiera.readString();
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Data non corretta.");
                        }
                    } while (true);

                    do {
                        try {
                            System.out.print("Posizione (0..100) --> ");
                            posizione = tastiera.readInt();
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Posizione non corretta");
                        }
                    } while (true);
                    b = new Bici(marca, modello, taglia, colore, dataUscita);
                    n1.setBici(b, posizione);
                    System.out.println("Bici inserita correttamente.");
                } catch (IOException ex) {
                    System.out.println("Errore. Impossibile leggere da tastiera.");
                } catch (EccezionePosizioneNonValida ex) {
                    System.out.println("Posizione non valida!");
                } catch (EccezionePosizioneOccupata ex) {
                    System.out.println("Posizione occupata!");
                }
                break;
                
                case 4://Elimina Bici (posizione)
                try {
                    System.out.print("Inserisci la posizione della bicicletta da eliminare: ");
                    posizione = tastiera.readInt();
                    n1.EliminaBici(posizione);
                    System.out.println("Bicicletta eliminata correttamente.");
                } catch (EccezionePosizioneNonValida ex) {
                    System.out.println("La posizione inserita non è valida.");
                } catch (EccezionePosizioneVuota ex) {
                    System.out.println("Non c'è nessuna bicicletta nella posizione specificata.");
                }
                break;
                
                case 5://Mostra elenco bici
                    System.out.println("Elenco delle biciclette nel negozio:");
                    Bici[] elencoBici = n1.elencoBici();
                    for (int i = 0; i < elencoBici.length; i++) {
                        if (elencoBici[i] != null) {
                            System.out.println("Posizione " + i + ": " + elencoBici[i].toString());
                        }
                    }
                    break;
                    
                case 6://Mostra elenco bici ordinato per taglia

                case 7://Esporta bici in formato CSV

                case 8://Importa bici in formato CSV

                case 9://Esporta bici in formato binario

                case 10://Importa bici in formato binario

                default:

            }
        } while (scelta != 0);
    }
}
