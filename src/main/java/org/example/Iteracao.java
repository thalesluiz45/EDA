package org.example;

import java.util.List;

public class Iteracao {

    public static boolean numeroNaLista(List<Integer> lista, int numero) {

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) == numero) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> lista = List.of(1, 2, 3, 4, 5);
        int numero = 3;

        boolean resultado = numeroNaLista(lista, numero);
        if(resultado){
            System.out.println("O número está na lista.");
        }else{
            System.out.println("O número não está na lista.");
        }
    }
}

