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
import utilità.ConsoleInput;
import utilità.Ordinatore;
import utilità.TextFile;

public class Negozio {

    // Numero massimo di biciclette che il negozio può contenere
    private final static int NUM_MAX_BICI = 100;
    // Array per memorizzare le biciclette nel negozio
    private Bici[] bici;
    // Array per memorizzare l'elenco delle biciclette
    private Bici[] elencoBici;
    // Numero attuale di biciclette nel negozio
    private int numeroBici;

    /**
     * Costruttore di default per la classe Negozio.
     */
    public Negozio() {
        bici = new Bici[NUM_MAX_BICI];
        this.elencoBici = new Bici[NUM_MAX_BICI];
        this.numeroBici = 0;
    }

    /**
     * Costruttore di copia per la classe Negozio.
     *
     * @param n Il negozio da copiare.
     */
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
                // Eccezione gestita
            } catch (EccezionePosizioneVuota ex) {
                // Eccezione gestita
            } catch (EccezionePosizioneOccupata ex) {
                // Eccezione gestita
            }
        }
    }

    /**
     * Costruttore che crea un negozio con un elenco di biciclette predefinito.
     *
     * @param elencoBici L'elenco di biciclette da aggiungere al negozio.
     */
    public Negozio(Bici[] elencoBici) {
        bici = new Bici[NUM_MAX_BICI];
        int numBiciDaAggiungere;

        // Determina il numero di biciclette da aggiungere, limitato al numero massimo di biciclette del negozio
        numBiciDaAggiungere = elencoBici.length;
        if (numBiciDaAggiungere > NUM_MAX_BICI) {
            numBiciDaAggiungere = NUM_MAX_BICI;
        }

        // Aggiunge le biciclette all'array del negozio
        for (int i = 0; i < numBiciDaAggiungere; i++) {
            if (elencoBici[i] != null)
                try {
                // Imposta la bicicletta nella posizione corrispondente
                setBici(elencoBici[i], i);
            } catch (EccezionePosizioneNonValida ex) {
                // Eccezione gestita
            } catch (EccezionePosizioneOccupata ex) {
                // Eccezione gestita
            }
        }
    }

    /**
     * Restituisce la bicicletta nella posizione specificata nel negozio.
     *
     * @param posizione La posizione della bicicletta nel negozio.
     * @return La bicicletta trovata.
     * @throws EccezionePosizioneNonValida Se la posizione non è valida.
     * @throws EccezionePosizioneVuota Se la posizione è vuota.
     */
    public Bici getBici(int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneVuota {
        Bici b;
        // Verifica se la posizione è valida
        if (posizione < 0 || posizione >= NUM_MAX_BICI) {
            throw new EccezionePosizioneNonValida();
        }
        // Verifica se la posizione contiene una bicicletta
        if (bici[posizione] == null) {
            throw new EccezionePosizioneVuota();
        }
        // Restituisce una copia della bicicletta trovata
        b = bici[posizione];
        return new Bici(b);
    }

    /**
     * Imposta una bicicletta nella posizione specificata nel negozio.
     *
     * @param bici La bicicletta da impostare.
     * @param posizione La posizione in cui impostare la bicicletta.
     * @throws EccezionePosizioneNonValida Se la posizione non è valida.
     * @throws EccezionePosizioneOccupata Se la posizione è già occupata da
     * un'altra bicicletta.
     */
    public void setBici(Bici bici, int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneOccupata {
        // Verifica se la posizione è valida
        if (posizione < 0 || posizione >= NUM_MAX_BICI) {
            throw new EccezionePosizioneNonValida();
        }
        // Verifica se la posizione è già occupata da un'altra bicicletta
        if (this.bici[posizione] != null) {
            throw new EccezionePosizioneOccupata();
        }
        // Verifica se la posizione è già occupata da un'altra bicicletta
        this.bici[posizione] = new Bici(bici);
    }

    /**
     * Elimina la bicicletta dalla posizione specificata nel negozio.
     *
     * @param posizione La posizione da cui eliminare la bicicletta.
     * @throws EccezionePosizioneNonValida Se la posizione non è valida.
     * @throws EccezionePosizioneVuota Se la posizione non contiene una
     * bicicletta.
     */
    public void EliminaBici(int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneVuota {
        // Verifica se la posizione è valida
        if (posizione < 0 || posizione >= NUM_MAX_BICI) {
            throw new EccezionePosizioneNonValida();
        }
        // Verifica se la posizione contiene una bicicletta
        if (bici[posizione] == null) {
            throw new EccezionePosizioneVuota();
        }
        // Elimina la bicicletta dalla posizione specificata
        bici[posizione] = null;
    }
    
    public void modificaBici(Negozio negozio, ConsoleInput tastiera) throws EccezioneTagliaNonValida, EccezionePosizioneOccupata {
    try {
        // Chiedi all'utente la posizione della bicicletta da modificare
        System.out.println("Inserisci la posizione della bicicletta da modificare:");
        int posizione = tastiera.readInt();

        // Ottieni la bicicletta dalla posizione specificata
        Bici biciDaModificare = negozio.getBici(posizione);

        if (biciDaModificare != null) {
            int scelta;
            do {
                // Mostra un menu per la modifica dei parametri
                System.out.println("Cosa desideri modificare?");
                System.out.println("1. Marca");
                System.out.println("2. Modello");
                System.out.println("3. Taglia");
                System.out.println("4. Colore");
                System.out.println("5. Data di Uscita");
                System.out.println("0. Esci e Salva");

                // Leggi la scelta dell'utente
                scelta = tastiera.readInt();

                // Modifica il parametro corrispondente in base alla scelta
                switch (scelta) {
                    case 1:
                        System.out.print("Nuova marca: ");
                        String nuovaMarca = tastiera.readString();
                        biciDaModificare.setMarca(nuovaMarca);
                        break;
                    case 2:
                        System.out.print("Nuovo modello: ");
                        String nuovoModello = tastiera.readString();
                        biciDaModificare.setModello(nuovoModello);
                        break;
                    case 3:
                        try{
                        System.out.print("Nuova taglia: ");
                        String nuovaTaglia = tastiera.readString();
                        biciDaModificare.setTaglia(nuovaTaglia);
                        }catch(EccezioneTagliaNonValida e)
                        {
                            System.out.println("Taglia non corretta");    
                        }
                        break;
                    case 4:
                        System.out.print("Nuovo colore: ");
                        String nuovoColore = tastiera.readString();
                        biciDaModificare.setColore(nuovoColore);
                        break;
                    case 5:
                        System.out.print("Nuova data di uscita (GG/MM/AAAA): ");
                        String nuovaDataUscita = tastiera.readString();
                        biciDaModificare.setDataUscita(nuovaDataUscita);
                        break;
                    case 0:
                        // Esci e salva le modifiche
                        negozio.setBici(biciDaModificare, posizione);
                        System.out.println("Modifiche salvate.");
                        break;
                    default:
                        System.out.println("Scelta non valida.");
                }
            } while (scelta != 0);
        } else {
            System.out.println("Nessuna bicicletta trovata in quella posizione.");
        }
    } catch (IOException ex) 
    {
        
    } catch (EccezionePosizioneNonValida ex) 
    {
        System.out.println("Posizione non valida");
    }catch (EccezionePosizioneVuota ex)
    {
        System.out.println("Posizione vuota");
    }catch (EccezionePosizioneOccupata ex)
    {
        System.out.println("Posizione occupata");
    }
}

    /**
     * Restituisce il numero di biciclette attualmente presenti nel negozio.
     *
     * @return Il numero di biciclette nel negozio.
     */
    public int getNumBici() {
        int cont = 0;
        // Conta il numero di biciclette non nulle nell'array bici
        for (int i = 0; i < this.getNumMaxBici(); i++) {
            if (bici[i] != null) {
                cont++;
            }
        }
        return cont;
    }

    /**
     * Restituisce il numero massimo di biciclette che il negozio può contenere.
     *
     * @return Il numero massimo di biciclette supportate dal negozio.
     */
    public int getNumMaxBici() {
        return NUM_MAX_BICI;
    }

    /**
     * Restituisce un array contenente l'elenco di tutte le biciclette nel
     * negozio.
     *
     * @return Un array di oggetti Bici rappresentante l'elenco delle biciclette
     * nel negozio.
     */
    public Bici[] elencoBici() {
        return bici;
    }

    /**
     * Restituisce un array di stringhe rappresentante le biciclette di una data
     * marca presenti nel negozio.
     *
     * @param marcaDaCercare La marca delle biciclette da cercare.
     * @return Un array di stringhe contenente le rappresentazioni testuali
     * delle biciclette della marca specificata.
     */
    public String[] visualizzaBiciMarca(String marcaDaCercare) {
        // Conta il numero di biciclette della marca specificata presenti nel negozio
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
                // Eccezione gestita
            } catch (EccezionePosizioneVuota ex) {
                // Eccezione gestita
            }
        }
        // Se non ci sono biciclette della marca specificata, restituisce null
        if (contaBiciMarca == 0) {
            return null;
        }
        // Altrimenti, crea un array di stringhe per le biciclette della marca specificata
        visualizzaMarcaBici = new String[contaBiciMarca];
        contaBiciMarca = 0;// Reimposta il contatore
        // riempie l'array di stringhe con le rappresentazioni testuali delle biciclette della marca specificata
        for (int i = 0; i < this.getNumMaxBici(); i++) {
            try {
                b = this.getBici(i);
                if (b.getMarca().equalsIgnoreCase(marcaDaCercare)) {
                    visualizzaMarcaBici[contaBiciMarca] = b.toString();
                    contaBiciMarca++;
                }
            } catch (EccezionePosizioneNonValida ex) {
                // Eccezione gestita
            } catch (EccezionePosizioneVuota ex) {
                // Eccezione gestita
            }
        }
        return visualizzaMarcaBici;
    }

    /**
     * Restituisce un valore intero che rappresenta l'ordine della taglia della
     * bicicletta.
     *
     * @param taglia La taglia della bicicletta.
     * @return Un intero che rappresenta l'ordine della taglia della bicicletta.
     */
    public static void ordinaBiciPerTaglia(Bici[] biciArray) throws EccezioneTagliaNonValida {
        // Creiamo un array di taglie corrispondenti alle bici
        String[] taglie = new String[biciArray.length];
        for (int i = 0; i < biciArray.length; i++) {
            taglie[i] = biciArray[i].getTaglia();
        }

        // Ordiniamo l'array di taglie in ordine crescente
        String[] taglieOrdinate = Ordinatore.bubbleSortCrescente(taglie);

        // Assegniamo le taglie ordinate alle bici nell'array originale
        for (int i = 0; i < biciArray.length; i++) {
            biciArray[i].setTaglia(taglieOrdinate[i]);
        }
    }

    /**
     * Esporta i dati delle biciclette presenti nel negozio in un file CSV.
     *
     * @param nomeFile Il nome del file CSV in cui esportare i dati.
     * @throws IOException Se si verifica un errore durante l'operazione di IO.
     */
    public void esportaCSV(String nomeFile) throws IOException {
        TextFile f1;
        Bici b;
        // Apre il file CSV in modalità scrittura
        f1 = new TextFile(nomeFile, 'W');
        // Stringa per memorizzare i dati di ogni bicicletta
        String dBici;
        // Scorre tutte le biciclette presenti nel negozio
        for (int i = 0; i < this.getNumMaxBici(); i++) {
            try {
                // Ottiene la bicicletta nella posizione corrente
                b = this.getBici(i);
                // Costruisce la stringa dei dati della bicicletta nel formato CSV
                dBici = i + ";" + b.getIdBici() + ";" + b.getMarca() + ";" + b.getModello() + ";" + b.getTaglia() + ";" + b.getDataUscita();
                // Scrive la stringa nel file CSV
                f1.toFile(dBici);
            } catch (EccezionePosizioneVuota ex) {
                // Gestisce l'eccezione se la posizione è vuota
            } catch (FileException ex) {
                // Gestisce l'eccezione se si verifica un errore nel file
            } catch (EccezionePosizioneNonValida ex) {
                // Gestisce l'eccezione se la posizione non è valida
            }
            // Chiude il file CSV dopo aver completato l'operazione per ogni bicicletta
            f1.closeFile();
        }
    }

    /**
     * Importa i dati delle biciclette da un file CSV nel negozio.
     *
     * @param nomeFile Il nome del file CSV da cui importare i dati.
     * @throws IOException Se si verifica un errore durante l'operazione di IO.
     */
    public void importaDaCSV(String nomeFile) throws IOException {
        String rigaLetta;
        String[] dBici;
        TextFile f1;
        int posizione, idBici;
        String marca, modello, taglia, colore, dataUscita;
        Bici b;
        // Apre il file CSV in modalità lettura
        f1 = new TextFile(nomeFile, 'R');

        do {
            try {
                // Legge una riga dal file CSV
                rigaLetta = f1.fromFile();
                // Divide la riga letta in array di stringhe utilizzando il delimitatore ";"
                dBici = rigaLetta.split(";");
                // Estrae i dati della bicicletta dalla riga letta
                posizione = Integer.parseInt(dBici[0]);
                idBici = Integer.parseInt(dBici[1]);
                marca = dBici[2];
                modello = dBici[3];
                taglia = dBici[4];
                colore = dBici[5];
                dataUscita = dBici[6];
                // Crea un nuovo oggetto Bici con i dati estratti
                b = new Bici(marca, modello, taglia, colore, dataUscita);
                try {
                    // Imposta la bicicletta nella posizione specificata nel negozio
                    this.setBici(b, posizione);
                } catch (EccezionePosizioneNonValida ex) {
                    // Gestisce l'eccezione se la posizione non è valida
                } catch (EccezionePosizioneOccupata ex) {
                    // Gestisce l'eccezione se la posizione è già occupata
                }
            } catch (FileException ex) {
                // Gestisce l'eccezione se si verifica un errore nel file
                f1.closeFile();
                System.out.println("Importazione terminata!");
                break;
            }
        } while (true);
    }

    /**
     * Restituisce una rappresentazione testuale dello stato del negozio.
     *
     * @return Una stringa contenente le informazioni sulle biciclette presenti
     * nel negozio.
     */
    public String toString() {
        // Stringa per memorizzare la rappresentazione testuale dello stato del negozio
        String s = "";
        // Itera attraverso tutte le posizioni nel negozio
        for (int i = 0; i < NUM_MAX_BICI; i++) {
            // Verifica se la posizione corrente contiene una bicicletta
            if (bici[i] == null) {
                // Se la posizione è vuota, aggiunge l'indice della posizione seguito da un newline
                s += i + "-->\n";
            } else {
                // Se la posizione contiene una bicicletta, aggiunge l'indice della posizione seguito dalla rappresentazione testuale della bicicletta e un newline
                s += i + "-->\t" + bici[i].toString() + "\n";
            }
        }
        return s;
    }
}
