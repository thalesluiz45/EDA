package hashTable.listaSEncadeada;

public class TabelaHash {
    private ListaEncadeada[] tabela;
    private int tamanho;

    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        tabela = new ListaEncadeada[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new ListaEncadeada();
        }
    }

    private int calcularHash(int matricula) {
        return matricula % tamanho;
    }

    public void inserirValor(int matricula, String nome) {
        int posicao = calcularHash(matricula);
        Aluno aluno = new Aluno(matricula, nome);
        tabela[posicao].adicionar(aluno);
    }

    public String pegarValor(int matricula) {
        int posicao = calcularHash(matricula);
        Aluno aluno = tabela[posicao].buscar(matricula);
        return (aluno != null) ? aluno.getNome() : null;
    }

    public boolean removerValor(int matricula) {
        int posicao = calcularHash(matricula);
        return tabela[posicao].remover(matricula);
    }

    public void imprimirTabela() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println("Posição " + i + ": " + tabela[i].getLista());
        }
    }

    public static void main(String[] args) {
        TabelaHash tabelaHash = new TabelaHash(10);

        tabelaHash.inserirValor(101, "Alice");
        tabelaHash.inserirValor(102, "Bob");
        tabelaHash.inserirValor(203, "Carol");

        System.out.println("Tabela após inserção:");
        tabelaHash.imprimirTabela();

        System.out.println("\nBuscar aluno com matrícula 102:");
        System.out.println("Nome: " + tabelaHash.pegarValor(102));

        System.out.println("\nRemover aluno com matrícula 102:");
        boolean removido = tabelaHash.removerValor(102);
        System.out.println("Removido: " + removido);

        System.out.println("\nTabela após remoção:");
        tabelaHash.imprimirTabela();
    }
}
