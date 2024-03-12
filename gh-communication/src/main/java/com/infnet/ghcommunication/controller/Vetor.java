package com.infnet.ghcommunication.controller;

public class Vetor {
    public int[] Vet;

    public Vetor(int[] vetor) {
        Vet = vetor;
    }

    public int CalcularSoma() {
        int soma = 0;
        for (int i = 0; i < Vet.length; i++) {
            soma += Vet[i];
        }
        return soma;
    }

    public int MaiorElemento() {
        int maior = -2147483648;
        for (int i = 0; i < Vet.length; i++) {
            if(Vet[i] > maior) {
                maior = Vet[i];
            }
        }
        return maior;
    }

    public int MenorElemento() {
        int menor = Integer.MAX_VALUE;
        for (int i = 0; i < Vet.length; i++) {
            if(Vet[i] < menor) {
                menor = Vet[i];
            }
        }
        return menor;
    }

    public double CalcularMedia() {
        int soma = 0;
        for (int i = 0; i < Vet.length; i++) {
            soma += Vet[i];
        }
        return (double) soma / Vet.length;
    }

}
