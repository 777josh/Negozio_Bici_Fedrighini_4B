/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.progettone_4b;


import java.io.IOException;
import utilità.ConsoleInput;
import utilità.Menu;

public class App {

    public static void main(String[] args) throws IOException {
        int numeroVociMenu = 11;
        String[] vociMenu = new String[numeroVociMenu];
        Menu menu;
        Negozio n1 = new Negozio(100); // Supponiamo che il negozio possa contenere fino a 100 biciclette
        ConsoleInput tastiera = new ConsoleInput();

        vociMenu[0] = "0 -->\tEsci";
        vociMenu[1] = "1 -->\tVisualizza Bici(ID)";
        vociMenu[2] = "2 -->\tVisualizza Bici(Marca)";
        vociMenu[3] = "3 -->\tAggiungi Bici(ID)";
        vociMenu[4] = "4 -->\tElimina Bici (ID)";
        vociMenu[5] = "5 -->\tMostra elenco bici";
        vociMenu[6] = "6 -->\tMostra elenco bici ordinato per taglia";
        vociMenu[7] = "7 -->\tEsporta bici in formato CSV";
        vociMenu[8] = "8 -->\tImporta bici in formato CSV";
        vociMenu[9] = "9 -->\tEsporta bici in formato binario";
        vociMenu[10] = "10 -->\tImporta bici in formato binario";

        menu = new Menu(vociMenu);

        // Loop principale del programma
        int scelta;
        do {
            scelta = menu.sceltaMenu();

            switch (scelta) {
                case 0:
                    System.out.println("Hai scelto: Esci");
                    break;
                case 1:
                    System.out.println("Hai scelto: Visualizza Bici(ID)");
                    System.out.print("Inserisci l'ID della bici da visualizzare: ");
                    long idBici = tastiera.readLong();
                    n1.visualizzaBiciIdBici(idBici);
                    break;
                case 2:
                    System.out.println("Hai scelto: Visualizza Bici(Marca)");
                    System.out.print("Inserisci la marca della bici da visualizzare: ");
                    String marca = tastiera.readString();
                    n1.visualizzaBiciMarca(marca);
                    break;
                case 3:
                    System.out.println("Hai scelto: Aggiungi Bici(ID)");
                    // Implementa l'aggiunta di una nuova bici
                    break;
                case 4:
                    System.out.println("Hai scelto: Elimina Bici(ID)");
                    System.out.print("Inserisci l'ID della bici da eliminare: ");
                    long idBiciDaEliminare = tastiera.readInt();
                    n1.eliminaBiciIdBici(idBiciDaEliminare);
                    break;
                case 5:
                    System.out.println("Hai scelto: Mostra elenco bici");
                    System.out.println("Elenco delle biciclette:");
                    Bici[] elencoBici = n1.elencoBici();
                    for (Bici b : elencoBici) {
                        System.out.println(b);
                    }
                    break;
                case 6:
                    System.out.println("Hai scelto: Mostra elenco bici ordinato per taglia");
                    System.out.println("Elenco delle biciclette ordinato per taglia:");
                    Bici[] elencoBiciOrdinato = n1.elencoBiciOrdinatoTaglia();
                    for (Bici b : elencoBiciOrdinato) {
                        System.out.println(b);
                    }
                    break;
                case 7:
                    System.out.println("Hai scelto: Esporta bici in formato CSV");
                    System.out.print("Inserisci il nome del file CSV di destinazione: ");
                    String nomeFileCSV = tastiera.readString();
                    n1.scriviSuFileCSV(nomeFileCSV);
                    break;
                case 8:
                    System.out.println("Hai scelto: Importa bici in formato CSV");
                    System.out.print("Inserisci il nome del file CSV da importare: ");
                    String nomeFileCSVImport = tastiera.readString();
                    n1.leggiDaFileCSV(nomeFileCSVImport);
                    break;
                case 9:
                    System.out.println("Hai scelto: Esporta bici in formato binario");
                    System.out.print("Inserisci il nome del file binario di destinazione: ");
                    String nomeFileBinario = tastiera.readString();
                    n1.scriviSuFileBinario(nomeFileBinario);
                    break;
                case 10:
                    System.out.println("Hai scelto: Importa bici in formato binario");
                    System.out.print("Inserisci il nome del file binario da importare: ");
                    String nomeFileBinarioImport = tastiera.readString();
                    n1.leggiDaFileBinario(nomeFileBinarioImport);
                    break;
                default:
                    System.out.println("Scelta non valida.");
                    break;
            }
        } while (scelta != 0);
    }
}
