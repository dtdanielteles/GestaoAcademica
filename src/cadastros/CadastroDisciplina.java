package cadastros;

import app.Disciplina;

public class CadastroDisciplina extends Cadastro<Disciplina> {

    // public boolean cadastrarDisciplina(Disciplina d){
	// 	boolean cadastrou = cadastrar(d);
	// 	return cadastrou;
	// }

    public Disciplina pesquisar(String codigo) {
		for (Disciplina disciplina : getCadastros()) {
			if (disciplina.getCodigo().equalsIgnoreCase(codigo)) {
				return disciplina;
			}
		}
		return null;
	}
	
	// public boolean removerDisciplina(Disciplina d) {
	// 	return remover(d);
	// }
	
	// public boolean atualizar( String codigo, Disciplina disciplina) {
	// 	for (int i = 0; i < getCadastros().size(); i++) {
	// 		if (getCadastros().get(i).getCodigo().equalsIgnoreCase(codigo)) {
	// 			getCadastros().set(i, disciplina);
	// 			return true;
	// 		}
	// 	}
	// 	return false;
	// }
}