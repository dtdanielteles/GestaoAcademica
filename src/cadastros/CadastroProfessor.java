package cadastros;

import app.Professor;

public class CadastroProfessor extends Cadastro<Professor>{

    // public boolean CadastrarProfessor(Professor p){
	// 	boolean cadastrou = cadastrar(p);
	// 	return cadastrou;
	// }

    public Professor pesquisar(String matriculaFUB) {
		for (Professor professor : getCadastros()) {
			if (professor.getMatriculaFUB().equalsIgnoreCase(matriculaFUB)) {
				return professor;
			}
		}
		return null;
	}
	
	// public boolean removerProfessor(Professor p) {
	// 	return remover(p);
	// }
	
	// public boolean atualizar( String matriculaFUB, Professor novoProfessor) {
	// 	for (Professor professor : getCadastros()) {
	// 		if (professor.getMatriculaFUB().equalsIgnoreCase(matriculaFUB)) {
    //             professor = novoProfessor;
	// 			return true;
	// 		}
	// 	}
	// 	return false;
    // }
}