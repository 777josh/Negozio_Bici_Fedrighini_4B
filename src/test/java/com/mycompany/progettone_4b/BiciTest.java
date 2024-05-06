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

/**
 *
 * @author josfe
 */
public class BiciTest {
    
    public BiciTest() {
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
     * Test of getIdBici method, of class Bici.
     */
    @Test
    public void testGetIdBici() {
        System.out.println("getIdBici");
        Bici instance = null;
        int expResult = 0;
        int result = instance.getIdBici();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdBici method, of class Bici.
     */
    @Test
    public void testSetIdBici() {
        System.out.println("setIdBici");
        int idBici = 0;
        Bici instance = null;
        instance.setIdBici(idBici);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNextIdBici method, of class Bici.
     */
    @Test
    public void testGetNextIdBici() {
        System.out.println("getNextIdBici");
        int expResult = 0;
        int result = Bici.getNextIdBici();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNextIdBici method, of class Bici.
     */
    @Test
    public void testSetNextIdBici() {
        System.out.println("setNextIdBici");
        int nextId = 0;
        Bici.setNextIdBici(nextId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMarca method, of class Bici.
     */
    @Test
    public void testGetMarca() {
        System.out.println("getMarca");
        Bici instance = null;
        String expResult = "";
        String result = instance.getMarca();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMarca method, of class Bici.
     */
    @Test
    public void testSetMarca() {
        System.out.println("setMarca");
        String marca = "";
        Bici instance = null;
        instance.setMarca(marca);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getModello method, of class Bici.
     */
    @Test
    public void testGetModello() {
        System.out.println("getModello");
        Bici instance = null;
        String expResult = "";
        String result = instance.getModello();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setModello method, of class Bici.
     */
    @Test
    public void testSetModello() {
        System.out.println("setModello");
        String modello = "";
        Bici instance = null;
        instance.setModello(modello);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTaglia method, of class Bici.
     */
    @Test
    public void testGetTaglia() {
        System.out.println("getTaglia");
        Bici instance = null;
        String expResult = "";
        String result = instance.getTaglia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTaglia method, of class Bici.
     */
    @Test
    public void testSetTaglia() throws Exception {
        System.out.println("setTaglia");
        String taglia = "";
        Bici instance = null;
        instance.setTaglia(taglia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColore method, of class Bici.
     */
    @Test
    public void testGetColore() {
        System.out.println("getColore");
        Bici instance = null;
        String expResult = "";
        String result = instance.getColore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColore method, of class Bici.
     */
    @Test
    public void testSetColore() {
        System.out.println("setColore");
        String colore = "";
        Bici instance = null;
        instance.setColore(colore);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataUscita method, of class Bici.
     */
    @Test
    public void testGetDataUscita() {
        System.out.println("getDataUscita");
        Bici instance = null;
        String expResult = "";
        String result = instance.getDataUscita();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataUscita method, of class Bici.
     */
    @Test
    public void testSetDataUscita() {
        System.out.println("setDataUscita");
        String dataUscita = "";
        Bici instance = null;
        instance.setDataUscita(dataUscita);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Bici.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Bici instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
