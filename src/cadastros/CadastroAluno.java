package cadastros;

import app.Aluno;

public class CadastroAluno extends Cadastro<Aluno> {
	
	// public int cadastrarAluno(Aluno a) {
	// 	boolean cadastrou = this.cadastrar(a);
	// 	return cadastrou ? cadastros.size() : 0;
	// }
	
	public Aluno pesquisar(String matriculaAluno) {
		for (Aluno aluno : getCadastros()) {
			if (aluno.getMatricula().equalsIgnoreCase(matriculaAluno)) {
				return aluno;
			}
		}
		return null;
	}
	
	// public boolean removerAluno(Aluno a) {
	// 	return remover(a);
	// }
	
	// public boolean atualizar(String matricula, Aluno a) {
	// 	for (int i = 0; i < getCadastros().size(); i++) {
	// 		if (getCadastros().get(i).getMatricula().equalsIgnoreCase(matricula)) {
	// 			getCadastros().set(i, a);
	// 			return true;
	// 		}
	// 	}
	// 	return false;
	// }
}












