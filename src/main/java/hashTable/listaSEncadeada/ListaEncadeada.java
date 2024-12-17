package hashTable.listaSEncadeada;

import java.util.LinkedList;

public class ListaEncadeada {
    private LinkedList<Aluno> lista;

    public ListaEncadeada() {
        lista = new LinkedList<>();
    }

    public void adicionar(Aluno aluno) {
        lista.add(aluno);
    }

    public Aluno buscar(int matricula) {
        for (Aluno aluno : lista) {
            if (aluno.getMatricula() == matricula) {
                return aluno;
            }
        }
        return null;
    }

    public boolean remover(int matricula) {
        return lista.removeIf(aluno -> aluno.getMatricula() == matricula);
    }

    public LinkedList<Aluno> getLista() {
        return lista;
    }
}

