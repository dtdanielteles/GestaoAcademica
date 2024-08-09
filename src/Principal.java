import javax.swing.JOptionPane;

import cadastros.CadastroAluno;
import cadastros.CadastroDisciplina;
import cadastros.CadastroTurma;
import view.MenuAluno;
import view.MenuDisciplina;
import view.MenuPrincipal;
import view.MenuTurma;

public class Principal {

	static CadastroAluno cadAluno;
	static CadastroTurma cadTurma;
	static CadastroDisciplina cadDisciplina;

	public static void main(String[] args) {
		cadAluno = new CadastroAluno();
		cadTurma = new CadastroTurma();
		cadDisciplina = new CadastroDisciplina();

		int opcao = 0;

		do {
			opcao = MenuPrincipal.menuOpcoes();
			switch (opcao) {
				case 1:
					MenuAluno.menuAluno(cadAluno);
					break;
				case 2:
					JOptionPane.showMessageDialog(null, "Cadastro de professores a ser implementado");
					break;
				case 3:
					MenuDisciplina.menuDisciplina(cadDisciplina);
					break;
				case 4:
					MenuTurma.menuTurma(cadTurma, cadDisciplina);
					break;
				case 0:
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opcao invalida");
					opcao = -1;
					break;
			}
		} while (opcao != 0);
		return;
	}

}
