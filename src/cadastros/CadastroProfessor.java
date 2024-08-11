package cadastros;

import javax.swing.JOptionPane;

import app.Professor;

public class CadastroProfessor extends Cadastro<Professor>{

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