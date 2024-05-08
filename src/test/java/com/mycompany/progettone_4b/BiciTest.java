/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progettone_4b;

import eccezioni.EccezioneTagliaNonValida;
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

    @Test
    public void testCostruttore() {
        Bici bici = new Bici("Marca", "Modello", "M", "Nero", "01/01/2024");
        assertEquals("Marca", bici.getMarca());
        assertEquals("Modello", bici.getModello());
        assertEquals("M", bici.getTaglia());
        assertEquals("Nero", bici.getColore());
        assertEquals("01/01/2024", bici.getDataUscita());
    }

    @Test
    public void testSetTaglia() {
        Bici bici = new Bici("Marca", "Modello", "M", "Nero", "01/01/2024");

        // Test con taglia valida
        try {
            bici.setTaglia("L");
            assertEquals("L", bici.getTaglia());
        } catch (EccezioneTagliaNonValida e) {
            // Se viene sollevata un'eccezione, il test fallisce
            fail("Dovrebbe accettare la taglia L");
        }

        // Test con taglia non valida
        try {
            bici.setTaglia("XXL");
            fail("Dovrebbe sollevare un'eccezione per taglia non valida");
        } catch (EccezioneTagliaNonValida e) {
            // Se viene sollevata un'eccezione, il test passa
        }
    }

    @Test
    public void testSetGetIdBici() {
        Bici bici = new Bici("Marca", "Modello", "M", "Nero", "01/01/2024");
        bici.setIdBici(10);
        assertEquals(10, bici.getIdBici());
    }

    @Test
    public void testSetGetMarca() {
        Bici bici = new Bici("Marca", "Modello", "M", "Nero", "01/01/2024");
        bici.setMarca("Nuova Marca");
        assertEquals("Nuova Marca", bici.getMarca());
    }

    @Test
    public void testSetGetModello() {
        Bici bici = new Bici("Marca", "Modello", "M", "Nero", "01/01/2024");
        bici.setModello("Nuovo Modello");
        assertEquals("Nuovo Modello", bici.getModello());
    }

    @Test
    public void testSetGetColore() {
        Bici bici = new Bici("Marca", "Modello", "M", "Nero", "01/01/2024");
        bici.setColore("Bianco");
        assertEquals("Bianco", bici.getColore());
    }

    @Test
    public void testSetGetDataUscita() {
        Bici bici = new Bici("Marca", "Modello", "M", "Nero", "01/01/2024");
        bici.setDataUscita("02/02/2025");
        assertEquals("02/02/2025", bici.getDataUscita());
    }
    @Test
    public void testCostruttoreCopia() {
        Bici biciOriginale = new Bici("Marca", "Modello", "M", "Nero", "01/01/2024");
        Bici biciCopia = new Bici(biciOriginale);
        assertEquals(biciOriginale.getIdBici(), biciCopia.getIdBici());
        assertEquals(biciOriginale.getMarca(), biciCopia.getMarca());
        assertEquals(biciOriginale.getModello(), biciCopia.getModello());
        assertEquals(biciOriginale.getTaglia(), biciCopia.getTaglia());
        assertEquals(biciOriginale.getColore(), biciCopia.getColore());
        assertEquals(biciOriginale.getDataUscita(), biciCopia.getDataUscita());
    }
    
}
