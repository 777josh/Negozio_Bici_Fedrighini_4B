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

    /**
     * Test of getBici method, of class Negozio.
     */
    @Test
    public void testGetBici() throws Exception {
        System.out.println("getBici");
        int posizione = 0;
        Negozio instance = new Negozio();
        Bici expResult = null;
        Bici result = instance.getBici(posizione);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBici method, of class Negozio.
     */
    @Test
    public void testSetBici() throws Exception {
        System.out.println("setBici");
        Bici bici = null;
        int posizione = 0;
        Negozio instance = new Negozio();
        instance.setBici(bici, posizione);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of EliminaBici method, of class Negozio.
     */
    @Test
    public void testEliminaBici() throws Exception {
        System.out.println("EliminaBici");
        int posizione = 0;
        Negozio instance = new Negozio();
        instance.EliminaBici(posizione);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificaBici method, of class Negozio.
     */
    @Test
    public void testModificaBici() throws Exception {
        System.out.println("modificaBici");
        Negozio negozio = null;
        ConsoleInput tastiera = null;
        Negozio instance = new Negozio();
        instance.modificaBici(negozio, tastiera);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumBici method, of class Negozio.
     */
    @Test
    public void testGetNumBici() {
        System.out.println("getNumBici");
        Negozio instance = new Negozio();
        int expResult = 0;
        int result = instance.getNumBici();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumMaxBici method, of class Negozio.
     */
    @Test
    public void testGetNumMaxBici() {
        System.out.println("getNumMaxBici");
        Negozio instance = new Negozio();
        int expResult = 0;
        int result = instance.getNumMaxBici();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of elencoBici method, of class Negozio.
     */
    @Test
    public void testElencoBici() {
        System.out.println("elencoBici");
        Negozio instance = new Negozio();
        Bici[] expResult = null;
        Bici[] result = instance.elencoBici();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visualizzaBiciMarca method, of class Negozio.
     */
    @Test
    public void testVisualizzaBiciMarca() {
        System.out.println("visualizzaBiciMarca");
        String marcaDaCercare = "";
        Negozio instance = new Negozio();
        String[] expResult = null;
        String[] result = instance.visualizzaBiciMarca(marcaDaCercare);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ordinaBiciPerTaglia method, of class Negozio.
     */
    @Test
    public void testOrdinaBiciPerTaglia() throws Exception {
        System.out.println("ordinaBiciPerTaglia");
        Bici[] biciArray = null;
        Negozio.ordinaBiciPerTaglia(biciArray);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esportaCSV method, of class Negozio.
     */
    @Test
    public void testEsportaCSV() throws Exception {
        System.out.println("esportaCSV");
        String nomeFile = "";
        Negozio instance = new Negozio();
        instance.esportaCSV(nomeFile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importaDaCSV method, of class Negozio.
     */
    @Test
    public void testImportaDaCSV() throws Exception {
        System.out.println("importaDaCSV");
        String nomeFile = "";
        Negozio instance = new Negozio();
        instance.importaDaCSV(nomeFile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Negozio.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Negozio instance = new Negozio();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
