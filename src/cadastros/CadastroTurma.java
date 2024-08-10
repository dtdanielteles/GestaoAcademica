package cadastros;

// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.List;

import app.Turma;

public class CadastroTurma extends Cadastro<Turma> {
    // int numTurmas;
    // private List<Turma> turmas;

    // Construtor da classe CadastroTurma
    // public CadastroTurma() {
    //     turmas = new LinkedList<Turma>();
    // }

    // Método para cadastrar uma nova turma
    // public int cadastrarTurma(Turma a) {
    //     boolean cadastrou = this.cadastros.add(a); // Adiciona a turma à lista
    //     if (cadastrou) {
    //         return this.cadastros.size(); // Atualiza o número de turmas cadastradas
    //     }
    //     return 0;
    // }

    // Método para pesquisar uma turma pelo número
    public Turma pesquisar(String codigoTurma) {
        for (Turma a : this.getCadastros()) { // Itera sobre a lista de turmas
            if (a.getCodigo() == codigoTurma) { // Verifica se o número da turma corresponde ao procurado
                return a; // Retorna a turma encontrada
            }
        }
        return null; // Retorna null se a turma não for encontrada
    }

    // Método para remover uma turma
    // public boolean remover(Turma a) {
    //     return super.remover(a); // Remove a turma da lista
    // }

    // Método para atualizar uma turma
    // public boolean atualizar(String codigo, Turma a) {
    //     boolean resposta = false;
    //     Turma remover = pesquisar(codigo); // Pesquisa a turma pelo número
    //     if (remover != null) {
    //         turmas.remove(remover); // Remove a turma antiga
    //         resposta = turmas.add(a); // Adiciona a nova turma
    //     }
    //     return resposta; // Retorna true se a atualização foi bem-sucedida
    // }
}
