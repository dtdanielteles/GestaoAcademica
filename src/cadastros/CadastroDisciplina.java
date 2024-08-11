package cadastros;

import javax.swing.JOptionPane;

import app.Disciplina;

public class CadastroDisciplina extends Cadastro<Disciplina> {

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