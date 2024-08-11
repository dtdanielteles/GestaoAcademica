package cadastros;

import javax.swing.JOptionPane;

import app.Turma;

public class CadastroTurma extends Cadastro<Turma> {
    
    // Método para pesquisar uma turma pelo número
    public Turma pesquisar(String codigoTurma) {
        for (Turma a : this.getCadastros()) { // Itera sobre a lista de turmas
            if (a.getCodigo() == codigoTurma) { // Verifica se o número da turma corresponde ao procurado
                return a; // Retorna a turma encontrada
            }
        }
        JOptionPane.showMessageDialog(null, "Cadastro não encontrado");
        return null; // Retorna null se a turma não for encontrada
    }
}
