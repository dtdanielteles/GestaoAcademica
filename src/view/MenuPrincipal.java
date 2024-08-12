package view;

import javax.swing.JOptionPane;

/**
 * Classe que define o menu principal
 */
public class MenuPrincipal {

	/**
	 * Método que exibe o menu principal
	 * @return Opção escolhida pelo usuário
	 */
	public static int menuOpcoes() {
		String opcoes = "1 - Abrir menu de alunos \n"
				+ "2 - Abrir menu de professores \n"
				+ "3 - Abrir menu de disciplinas \n"
				+ "4 - Abrir menu de turmas \n"
				+ "0 - Sair";

		String strOpcao = JOptionPane.showInputDialog(opcoes);

        return Integer.parseInt(strOpcao);
	}

}
