package org.avl;

public class Nodo {
    int chave;
    int altura;
    Nodo esquerda;
    Nodo direita;

    Nodo(int chave) {
        this.chave = chave;
        this.altura = 1;
    }
}
