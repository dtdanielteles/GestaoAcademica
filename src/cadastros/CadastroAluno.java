package cadastros;

import javax.swing.JOptionPane;

import app.Aluno;

public class CadastroAluno extends Cadastro<Aluno> {
	
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












