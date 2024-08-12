package cadastros;

import javax.swing.JOptionPane;

import app.Aluno;

/**
 * Classe que define um cadastro de alunos
 */
public class CadastroAluno extends Cadastro<Aluno> {

	/**
	 * Método que pesquisa um aluno pela matrícula
	 * @param matriculaAluno Matrícula do aluno a ser pesquisado
	 * @return Aluno pesquisado
	 */
	public Aluno pesquisar(String matriculaAluno) {
		for (Aluno aluno : getCadastros()) {
			if (aluno.getMatricula().equalsIgnoreCase(matriculaAluno)) {
				return aluno;
			}
		}
		JOptionPane.showMessageDialog(null, "Cadastro não encontrado");
		return null;
	}
}












