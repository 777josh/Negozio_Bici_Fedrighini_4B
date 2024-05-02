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
        int NUM_MAX_BICI=100;
        Negozio n1=new Negozio();
        ConsoleInput tastiera = new ConsoleInput();
        String marca,modello,taglia,colore,dataUscita=null;
        int posizione,idBici;
        TextFile f1=null;
        
        Bici b;
        Bici[] elencoBiciOrdinatoPerTaglia;
        String[] VisualizzaBiciMarca;
        String nomeFileCSV="bici.csv";

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
                case 0:
                    System.out.println("Hai scelto: Esci");
                    break;
                case 1:
                    try 
                    {
                        do
                        {
                            try
                            {
                                System.out.println("Posizione (0..99) --> ");
                                posizione=tastiera.readInt();
                                break;
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Posizione non corretto");
                            }
                        }while(true);
                        b=n1.getBici(posizione);
                        System.out.println("Bici trovata:\n"+b.toString());
                    } 
                    catch(IOException e)
                    {
                        System.out.println("Errore. Impossibile leggere da tastiera");
                    }
                    catch (EccezionePosizioneNonValida ex) 
                    {
                        System.out.println("Posizione non valida!");
                    } 
                    catch (EccezionePosizioneVuota ex)
                    {
                        System.out.println("Nessuna bici presente in quella posizione!");
                    }
                    break;
                case 2:
                    
                case 3:
                    try 
                    {
                        
                        System.out.print("Marca --> ");
                        marca=tastiera.readString();
                        System.out.print("Modello --> ");
                        modello=tastiera.readString();  
                        System.out.print("colore --> ");
                        colore=tastiera.readString();  
                        
                        do
                        {
                            //try
                            {
                               System.out.print("Taglia --> ");
                               taglia=tastiera.readString(); 
                               break;
                            }
                            /*catch(EccezioneTagliaNonValida ex)
                            {
                                System.out.println("Taglia non corretto.");
                            }*/
                             
                        }while(true);
                        
                        do
                        {
                            try
                            {
                               System.out.print("Data Uscita (GG/MM/AAAA) --> ");
                               dataUscita=tastiera.readString(); 
                               break;
                            }
                            catch(NumberFormatException e)
                            {
                                System.out.println("Data non corretta.");
                            }   
                        }while(true);
                        
                        do
                        {
                            try
                            {
                                System.out.print("Posizione (0..100) --> ");
                                posizione=tastiera.readInt();
                                break;
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Posizione non corretta");
                            }
                        }while(true);
                        b=new Bici(marca, modello, taglia, colore, dataUscita);
                        n1.setBici(b, posizione);
                        System.out.println("Bici inserita correttamente.");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Errore. Impossibile leggere da tastiera.");
                    } 
                    catch (EccezionePosizioneNonValida ex) 
                    {
                        System.out.println("Posizione non valida!");
                    } 
                    catch (EccezionePosizioneOccupata ex) 
                    {
                        System.out.println("Posizione occupata!");
                    } 
                   break;
                case 4:
                    
                case 5:
                    
                case 6:
                    
                case 7:
                    
                case 8:
                    
                case 9:
                    
                case 10:
                    
                default:
                    
            }
        } while (scelta != 0);
    }
}
