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
        
        Bici[] elencoBici = n1.elencoBici();
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
        vociMenu[1] = "1 -->\tAggiungi Bici(posizione)";
        vociMenu[2] = "2 -->\tVisualizza Bici(posizione)";
        vociMenu[3] = "3 -->\tVisualizza Bici(Marca)";
        vociMenu[4] = "4 -->\tElimina Bici (posizione)";
        vociMenu[5] = "5 -->\tModifica Bici(posizione)";
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

                case 1://Aggiungi Bici(posizione)
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

                case 2://Visualizza Bici(posizione)
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

                case 3://Visualizza Bici(Marca)
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

                case 5://Modifica bici(posizione)
                try {
                    n1.modificaBici(n1, tastiera);
                } catch (EccezioneTagliaNonValida ex) {
                    System.out.println("Taglia non valida");
                } catch (EccezionePosizioneOccupata ex) {
                    System.out.println("Posizione occupata");
                }
                break;
                case 6://Mostra elenco bici
                    System.out.println("Elenco delle biciclette nel negozio:");
                    for (int i = 0; i < elencoBici.length; i++) {
                        if (elencoBici[i] != null) {
                            System.out.println("Posizione " + i + ": " + elencoBici[i].toString());
                        }
                    }
                    break;

                case 7://Mostra elenco bici ordinato per taglia
                try {
                    // Ordina l'array di biciclette per taglia
                    Ordinatore.ordinaBiciPerTaglia(elencoBici);
                    System.out.println("Elenco delle biciclette nel negozio ordinato per taglia:");
                    for (int i = 0; i < elencoBici.length; i++) {
                        if (elencoBici[i] != null) {
                            System.out.println("Posizione " + i + ": " + elencoBici[i].toString());
                        }
                    }
                } catch (EccezioneTagliaNonValida ex) {
                    System.out.println("Errore durante l'ordinamento per taglia: " + ex.getMessage());
                }
                break;

                case 8://Esporta bici in formato CSV
                    try {
                    n1.esportaCSV(nomeFileCSV);
                    System.out.println("Esportazione delle biciclette completata con successo.");
                } catch (IOException ex) {
                    System.out.println("Si è verificato un errore durante l'esportazione delle biciclette in formato CSV ");
                }
                break;

                case 9://Importa bici in formato CSV
                try {
                    System.out.println("Inserisci il nome del file CSV da importare:");
                    String nomeFileImport = tastiera.readString();
                    n1.importaDaCSV(nomeFileImport);
                    System.out.println("Importazione delle biciclette completata con successo.");
                } catch (IOException ex) {
                    System.out.println("Si è verificato un errore durante l'importazione delle biciclette in formato CSV: " + ex.getMessage());
                }
                break;

                case 10://Esporta bici in formato binario

                case 11://Importa bici in formato binario

                default:

            }
        } while (scelta != 0);
    }
}
