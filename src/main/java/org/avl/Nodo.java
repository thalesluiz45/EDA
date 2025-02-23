package org.avl;

public class Nodo {
    int chave;
    int altura;
    Nodo esquerda;
    Nodo direita;

    Nodo(int chave) {
        this.chave = chave;
        this.altura = 1; // Um novo nó é sempre adicionado como folha, então altura = 1
    }
}
