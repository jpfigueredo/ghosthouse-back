package com.infnet.ghcommunication.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VetorTest {

    @Test
    public void testCalcularSoma() {
        int[] vetor = {1, 2, 3, 4, 5};
        Vetor v = new Vetor(vetor);
        assertEquals(15, v.CalcularSoma(), "A soma dos elementos do vetor deve ser 15");
    }

    @Test
    public void testMaiorElemento() {
        int[] vetor = {10, 5, 8, 20, 15};
        Vetor v = new Vetor(vetor);
        assertEquals(20, v.MaiorElemento(), "O maior elemento do vetor deve ser 20");
    }

    @Test
    public void testMenorElemento() {
        int[] vetor = {10, 5, 8, 20, 15};
        Vetor v = new Vetor(vetor);
        assertEquals(5, v.MenorElemento(), "O menor elemento do vetor deve ser 5");
    }

    @Test
    public void testCalcularMedia() {
        int[] vetor = {1, 2, 3, 4, 5};
        Vetor v = new Vetor(vetor);
        assertEquals(3, v.CalcularMedia(), "A média dos elementos do vetor deve ser 3");
    }

}
