package cadastros;

import javax.swing.JOptionPane;

import app.Turma;

/**
 * Classe que define um cadastro de turmas
 */
public class CadastroTurma extends Cadastro<Turma> {

    /**
     * Método que pesquisa uma turma pelo código
     * @param codigoTurma Código da turma a ser pesquisada
     * @return Turma pesquisada
     */
    public Turma pesquisar(String codigoTurma) {
        for (Turma a : this.getCadastros()) { // Itera sobre a lista de turmas
            if (a.getCodigo().equalsIgnoreCase(codigoTurma)) { // Verifica se o número da turma corresponde ao procurado
                return a; // Retorna a turma encontrada
            }
        }
        JOptionPane.showMessageDialog(null, "Cadastro não encontrado");
        return null; // Retorna null se a turma não for encontrada
    }
}
