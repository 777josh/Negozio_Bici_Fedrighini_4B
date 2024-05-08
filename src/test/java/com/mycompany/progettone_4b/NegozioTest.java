/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progettone_4b;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import utilità.ConsoleInput;

/**
 *
 * @author josfe
 */
public class NegozioTest {

    public NegozioTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetBici() throws Exception {
        Negozio negozio = new Negozio();
        Bici bici1 = new Bici("Marca1", "Modello1", "M", "Nero", "01/01/2024");
        negozio.setBici(bici1, 0);
        assertEquals(bici1, negozio.getBici(0));
    }

    @Test
    public void testSetBici() throws Exception {
        Negozio negozio = new Negozio();
        Bici bici1 = new Bici("Marca1", "Modello1", "M", "Nero", "01/01/2024");
        negozio.setBici(bici1, 0);
        assertEquals(bici1, negozio.getBici(0));
    }

    @Test
    public void testEliminaBici() throws Exception {
        Negozio negozio = new Negozio();
        Bici bici1 = new Bici("Marca1", "Modello1", "M", "Nero", "01/01/2024");
        Bici bici2 = new Bici("Marca2", "Modello2", "L", "Rosso", "02/02/2024");
        negozio.setBici(bici1, 0);
        negozio.setBici(bici2, 1);

        int numBiciBeforeDeletion = negozio.getNumBici();
        negozio.eliminaBici(0);

        assertNull(negozio.getBici(0)); 
        assertEquals(bici2, negozio.getBici(1)); 
        assertEquals(numBiciBeforeDeletion - 1, negozio.getNumBici()); 
        assertNull(negozio.getBici(numBiciBeforeDeletion)); 
    }

    @Test
    public void testModificaBici() throws Exception {
        // Non implementato in NegozioTest in quanto richiede input da tastiera
    }

    @Test
    public void testGetNumBici() throws Exception {
        Negozio negozio = new Negozio();
        Bici bici1 = new Bici("Marca1", "Modello1", "M", "Nero", "01/01/2024");
        negozio.setBici(bici1, 0);
        assertEquals(1, negozio.getNumBici());
    }

    @Test
    public void testGetNumMaxBici() {
        Negozio negozio = new Negozio();
        assertEquals(100, negozio.getNumMaxBici());
    }

    @Test
    public void testElencoBici() throws Exception {
        Negozio negozio = new Negozio();
        Bici bici1 = new Bici("Marca1", "Modello1", "M", "Nero", "01/01/2024");
        Bici bici2 = new Bici("Marca2", "Modello2", "L", "Rosso", "02/02/2024");
        negozio.setBici(bici1, 0);
        negozio.setBici(bici2, 1);
        Bici[] expected = {bici1, bici2};
        assertArrayEquals(expected, negozio.elencoBici());
    }

    @Test
    public void testVisualizzaBiciMarca() throws Exception {
        Negozio negozio = new Negozio();
        Bici bici1 = new Bici("Marca1", "Modello1", "M", "Nero", "01/01/2024");
        Bici bici2 = new Bici("Marca2", "Modello2", "L", "Rosso", "02/02/2024");
        negozio.setBici(bici1, 0);
        negozio.setBici(bici2, 1);
        String[] expected = {"Marca1", "Marca2"};
        assertArrayEquals(expected, negozio.visualizzaBiciMarca(""));
    }

    @Test
    public void testOrdinaBiciPerTaglia() throws Exception {
        Negozio negozio = new Negozio();
        Bici bici1 = new Bici("Marca1", "Modello1", "M", "Nero", "01/01/2024");
        Bici bici2 = new Bici("Marca2", "Modello2", "L", "Rosso", "02/02/2024");
        Bici[] biciArray = {bici2, bici1};
        negozio.ordinaBiciPerTaglia(biciArray);
        assertEquals("L", biciArray[0].getTaglia());
        assertEquals("M", biciArray[1].getTaglia());
    }

    @Test
    public void testEsportaCSV() throws Exception {
        // Non implementato in NegozioTest in quanto coinvolge l'interazione con il file system
    }

    @Test
    public void testImportaDaCSV() throws Exception {
        // Non implementato in NegozioTest in quanto coinvolge l'interazione con il file system
    }

    @Test
    public void testToString() {
        Negozio negozio = new Negozio();
        String expected = "Numero di biciclette presenti: 0";
        assertEquals(expected, negozio.toString());
    }
}
