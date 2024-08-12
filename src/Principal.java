import javax.swing.JOptionPane;

import cadastros.CadastroAluno;
import cadastros.CadastroDisciplina;
import cadastros.CadastroProfessor;
import cadastros.CadastroTurma;
import view.MenuAluno;
import view.MenuProfessor;
import view.MenuDisciplina;
import view.MenuPrincipal;
import view.MenuTurma;

import exceptions.CampoEmBrancoException;
import exceptions.DisciplinaNaoAtribuidaException;
import exceptions.ProfessorNaoAtribuidoException;

/**
 * Classe principal do programa
 */
public class Principal {

	public static CadastroAluno cadAluno;
	public static CadastroTurma cadTurma;
	public static CadastroDisciplina cadDisciplina;
	public static CadastroProfessor cadProfessor;

	/**
	 * Método principal do programa
	 * @param args Argumentos passados por linha de comando
	 * @throws CampoEmBrancoException Exceção lançada quando um campo obrigatório não é preenchido
	 * @throws ProfessorNaoAtribuidoException Exceção lançada quando o professor não é atribuído
	 * @throws DisciplinaNaoAtribuidaException Exceção lançada quando a disciplina não é atribuída
	 */
	public static void main(String[] args) throws CampoEmBrancoException, ProfessorNaoAtribuidoException, DisciplinaNaoAtribuidaException {
		cadAluno = new CadastroAluno();
		cadTurma = new CadastroTurma();
		cadDisciplina = new CadastroDisciplina();
		cadProfessor = new CadastroProfessor();

		int opcao = 0;

		do {
			opcao = MenuPrincipal.menuOpcoes();
			switch (opcao) {
				case 1:
					MenuAluno.menuAluno(cadAluno);
					break;
				case 2:
					MenuProfessor.menuProfessor(cadProfessor);
					break;
				case 3:
					MenuDisciplina.menuDisciplina(cadDisciplina);
					break;
				case 4:
					MenuTurma.menuTurma(cadAluno, cadProfessor, cadTurma, cadDisciplina);
					break;
				case 0:
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opcao invalida");
					opcao = -1;
					break;
			}
		} while (opcao != 0);
	}

}
