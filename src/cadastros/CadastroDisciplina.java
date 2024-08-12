package cadastros;

import javax.swing.JOptionPane;

import app.Disciplina;

/**
 * Classe que define um cadastro de disciplinas
 */
public class CadastroDisciplina extends Cadastro<Disciplina> {

	/**
	 * Método que pesquisa uma disciplina pelo código
	 * @param codigo Código da disciplina a ser pesquisada
	 * @return Disciplina pesquisada
	 */
    public Disciplina pesquisar(String codigo) {
		for (Disciplina disciplina : getCadastros()) {
			if (disciplina.getCodigo().equalsIgnoreCase(codigo)) {
				return disciplina;
			}
		}
		JOptionPane.showMessageDialog(null, "Cadastro não encontrado");
		return null;
	}
}