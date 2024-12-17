package hashTable.sLista;

public class TabelaHash {
    private Aluno[] tabela;
    private int tamanho;
    private int quantidade;
    private final Aluno APAGADO = new Aluno(-1, "APAGADO");

    public TabelaHash(int tamanhoInicial) {
        this.tamanho = tamanhoInicial;
        this.tabela = new Aluno[tamanho];
        this.quantidade = 0;
    }

    private int calcularHash(int matricula) {
        return matricula % tamanho;
    }

    private void redimensionar() {
        int novoTamanho = tamanho * 2;
        Aluno[] novaTabela = new Aluno[novoTamanho];

        for (Aluno aluno : tabela) {
            if (aluno != null && aluno != APAGADO) {
                int novaPosicao = aluno.getMatricula() % novoTamanho;
                while (novaTabela[novaPosicao] != null) {
                    novaPosicao = (novaPosicao + 1) % novoTamanho;
                }
                novaTabela[novaPosicao] = aluno;
            }
        }

        this.tabela = novaTabela;
        this.tamanho = novoTamanho;
    }

    public void inserirValor(int matricula, String nome) {
        if (quantidade >= tamanho / 2) {
            redimensionar();
        }

        int posicao = calcularHash(matricula);
        while (tabela[posicao] != null && tabela[posicao] != APAGADO) {
            if (tabela[posicao].getMatricula() == matricula) {
                tabela[posicao] = new Aluno(matricula, nome);
                return;
            }
            posicao = (posicao + 1) % tamanho;
        }

        tabela[posicao] = new Aluno(matricula, nome);
        quantidade++;
    }

    public String pegarValor(int matricula) {
        int posicao = calcularHash(matricula);
        while (tabela[posicao] != null) {
            if (tabela[posicao] != APAGADO && tabela[posicao].getMatricula() == matricula) {
                return tabela[posicao].getNome();
            }
            posicao = (posicao + 1) % tamanho;
        }
        return null; // Não encontrado
    }

    public boolean removerValor(int matricula) {
        int posicao = calcularHash(matricula);
        while (tabela[posicao] != null) {
            if (tabela[posicao] != APAGADO && tabela[posicao].getMatricula() == matricula) {
                tabela[posicao] = APAGADO;
                quantidade--;
                return true;
            }
            posicao = (posicao + 1) % tamanho;
        }
        return false; // Não encontrado
    }

    public void imprimirTabela() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println("Posição " + i + ": " + (tabela[i] == null ? "NULL" : tabela[i]));
        }
    }

    public static void main(String[] args) {
        TabelaHash tabelaHash = new TabelaHash(5);

        tabelaHash.inserirValor(101, "Alice");
        tabelaHash.inserirValor(202, "Bob");
        tabelaHash.inserirValor(303, "Carol");

        System.out.println("Tabela após inserção:");
        tabelaHash.imprimirTabela();

        System.out.println("\nBuscar aluno com matrícula 202:");
        System.out.println("Nome: " + tabelaHash.pegarValor(202));

        System.out.println("\nRemover aluno com matrícula 202:");
        boolean removido = tabelaHash.removerValor(202);
        System.out.println("Removido: " + removido);

        System.out.println("\nTabela após remoção:");
        tabelaHash.imprimirTabela();

        tabelaHash.inserirValor(404, "Daniel");
        tabelaHash.inserirValor(505, "Eva");
        tabelaHash.inserirValor(606, "Frank");

        System.out.println("\nTabela após redimensionamento:");
        tabelaHash.imprimirTabela();
    }
}

