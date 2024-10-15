package org.example;

import java.util.List;

public class Recursividade {

    private static int contador(List<Integer> lista, int indice) {

        if (indice == lista.size()) {
            return 0;
        }

        int contaAtual;
        if (lista.get(indice) == 2) {
            contaAtual = 1;
        } else {
            contaAtual = 0;
        }

        return contaAtual + contador(lista, indice + 1);
    }

    public static int contarDois(List<Integer> lista) {
        return contador(lista, 0);
    }

    public static void main(String[] args) {
        List<Integer> numeros = List.of(2, 3, 4, 2, 4, 2, 6, 2);
        int resultado = contarDois(numeros);
        System.out.println(resultado);
    }
}
