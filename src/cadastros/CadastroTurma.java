package cadastros;

import java.util.ArrayList;
import java.util.List;

import app.Turma;

public class CadastroTurma {
    int numTurmas;
    private List<Turma> turmas;

    // Construtor da classe CadastroTurma
    public CadastroTurma() {
        numTurmas = 0;
        turmas = new ArrayList<Turma>();
    }

    // Método para cadastrar uma nova turma
    public int cadastrarTurma(Turma a) {
        boolean cadastrou = turmas.add(a); // Adiciona a turma à lista
        if (cadastrou) {
            numTurmas = turmas.size(); // Atualiza o número de turmas cadastradas
        }
        return numTurmas;
    }

    // Método para pesquisar uma turma pelo número
    public Turma pesquisarTurma(int numeroTurma) {
        for (Turma a : turmas) { // Itera sobre a lista de turmas
            if (a.getNumero() == numeroTurma) { // Verifica se o número da turma corresponde ao procurado
                return a; // Retorna a turma encontrada
            }
        }
        return null; // Retorna null se a turma não for encontrada
    }

    // Método para remover uma turma
    public boolean removerTurma(Turma a) {
        return turmas.remove(a); // Remove a turma da lista
    }

    // Método para atualizar uma turma
    public boolean atualizarTurma(int numero, Turma a) {
        boolean resposta = false;
        Turma remover = pesquisarTurma(numero); // Pesquisa a turma pelo número
        if (remover != null) {
            turmas.remove(remover); // Remove a turma antiga
            resposta = turmas.add(a); // Adiciona a nova turma
        }
        return resposta; // Retorna true se a atualização foi bem-sucedida
    }
}
