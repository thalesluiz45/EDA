package org.example;

import java.util.List;

public class Recursividade2 {

    public static boolean numeroNaLista(List<Integer> lista, int numero) {
        return verificarNumero(lista, numero, 0);
    }

    private static boolean verificarNumero(List<Integer> lista, int numero, int indice) {

        if (indice == lista.size()) {
            return false;
        }

        if (lista.get(indice) == numero) {
            return true;
        }

        return verificarNumero(lista, numero, indice + 1);
    }

    public static void main(String[] args) {
        List<Integer> lista = List.of(1, 2, 3, 4, 5);
        int numero = 6;

        boolean resultado = numeroNaLista(lista, numero);
        if(resultado){
            System.out.println("O número está na lista.");
        }else{
            System.out.println("O número não está na lista.");

        }

    }
}

