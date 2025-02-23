package org.avl;

public class Main {

    public static void main(String[] args) {
        AVLTree arvore = new AVLTree();

        arvore.inserir(10);
        arvore.inserir(20);
        arvore.inserir(30);
        arvore.inserir(40);
        arvore.inserir(50);
        arvore.inserir(25);

        System.out.println("Árvore AVL após inserções:");
        arvore.inOrder();

        arvore.remover(30);
        System.out.println("\nÁrvore AVL após remover 30:");
        arvore.inOrder();
    }
}
