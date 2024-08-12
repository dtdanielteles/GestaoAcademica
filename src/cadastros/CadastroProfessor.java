package cadastros;

import javax.swing.JOptionPane;

import app.Professor;

/**
 * Classe que define um cadastro de professores
 */
public class CadastroProfessor extends Cadastro<Professor>{

	/**
	 * Método que pesquisa um professor pela matrícula
	 * @param matriculaFUB Matrícula do professor a ser pesquisado
	 * @return Professor pesquisado
	 */
    public Professor pesquisar(String matriculaFUB) {
		for (Professor professor : getCadastros()) {
			if (professor.getMatriculaFUB().equalsIgnoreCase(matriculaFUB)) {
				return professor;
			}
		}
		JOptionPane.showMessageDialog(null, "Cadastro não encontrado");
		return null;
	}
}