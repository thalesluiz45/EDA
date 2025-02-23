package org.avl;

public class AVLTree {
    private Nodo raiz;

    // Altura
    private int altura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.altura;
    }

    // Fator de balanceamento
    private int fatorBalanceamento(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return altura(nodo.esquerda) - altura(nodo.direita);
    }

    // Atualiza a altura
    private void atualizarAltura(Nodo nodo) {
        if (nodo != null) {
            nodo.altura = Math.max(altura(nodo.esquerda), altura(nodo.direita)) + 1;
        }
    }

    // Rotação à esquerda
    private Nodo rotacaoEsquerda(Nodo y) {
        Nodo x = y.direita;
        Nodo T2 = x.esquerda;

        // Realiza a rotação
        x.esquerda = y;
        y.direita = T2;

        // Atualiza alturas
        atualizarAltura(y);
        atualizarAltura(x);

        return x;
    }

    // Rotação à direita
    private Nodo rotacaoDireita(Nodo x) {
        Nodo y = x.esquerda;
        Nodo T2 = y.direita;

        // Realiza a rotação
        y.direita = x;
        x.esquerda = T2;

        // Atualiza alturas
        atualizarAltura(x);
        atualizarAltura(y);

        return y;
    }

    // Balanceamento
    private Nodo balancear(Nodo nodo) {
        atualizarAltura(nodo);

        int fb = fatorBalanceamento(nodo);

        if (fb > 1 && fatorBalanceamento(nodo.esquerda) >= 0) {
            return rotacaoDireita(nodo);
        }

        if (fb < -1 && fatorBalanceamento(nodo.direita) <= 0) {
            return rotacaoEsquerda(nodo);
        }

        if (fb > 1 && fatorBalanceamento(nodo.esquerda) < 0) {
            nodo.esquerda = rotacaoEsquerda(nodo.esquerda);
            return rotacaoDireita(nodo);
        }

        if (fb < -1 && fatorBalanceamento(nodo.direita) > 0) {
            nodo.direita = rotacaoDireita(nodo.direita);
            return rotacaoEsquerda(nodo);
        }

        return nodo;
    }

    // Inserção de um nó
    public void inserir(int chave) {
        raiz = inserir(raiz, chave);
    }

    private Nodo inserir(Nodo nodo, int chave) {
        if (nodo == null) {
            return new Nodo(chave);
        }

        if (chave < nodo.chave) {
            nodo.esquerda = inserir(nodo.esquerda, chave);
        } else if (chave > nodo.chave) {
            nodo.direita = inserir(nodo.direita, chave);
        } else {

            return nodo;
        }

        atualizarAltura(nodo);

        return balancear(nodo);
    }

    // Remoção de um nó
    public void remover(int chave) {
        raiz = remover(raiz, chave);
    }

    private Nodo remover(Nodo nodo, int chave) {
        if (nodo == null) {
            return null;
        }

        if (chave < nodo.chave) {
            nodo.esquerda = remover(nodo.esquerda, chave);
        } else if (chave > nodo.chave) {
            nodo.direita = remover(nodo.direita, chave);
        } else {
            if (nodo.esquerda == null || nodo.direita == null) {
                Nodo temp = (nodo.esquerda != null) ? nodo.esquerda : nodo.direita;
                if (temp == null) {
                    temp = nodo;
                    nodo = null;
                } else {
                    nodo = temp;
                }
            } else {
                Nodo temp = menorValor(nodo.direita);
                nodo.chave = temp.chave;
                nodo.direita = remover(nodo.direita, temp.chave);
            }
        }

        if (nodo == null) {
            return null;
        }

        atualizarAltura(nodo);

        return balancear(nodo);
    }

    private Nodo menorValor(Nodo nodo) {
        Nodo atual = nodo;
        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }
        return atual;
    }

    // Função para imprimir a árvore (in-order)
    public void inOrder() {
        inOrder(raiz);
    }

    private void inOrder(Nodo nodo) {
        if (nodo != null) {
            inOrder(nodo.esquerda);
            System.out.print(nodo.chave + " ");
            inOrder(nodo.direita);
        }
    }

}
