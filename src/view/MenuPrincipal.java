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
		int opcao = -1;
		boolean entradaValida = false;

		while (!entradaValida) {
			String opcoes = "1 - Abrir menu de alunos \n"
					+ "2 - Abrir menu de professores \n"
					+ "3 - Abrir menu de disciplinas \n"
					+ "4 - Abrir menu de turmas \n"
					+ "0 - Sair";

			String strOpcao = JOptionPane.showInputDialog(opcoes);

			//Verifica se a entrada está vazia ou é nula
			if(strOpcao == null || strOpcao.trim().isEmpty()){
				JOptionPane.showMessageDialog(null, "Entrada não pode ser vazia. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
				continue;
			}

			try{
				//Converte a entrada para um inteiro
				opcao = Integer.parseInt(strOpcao);
				//Se a conversão foi bem sucedida a entrada é valida
				entradaValida = true;
			} catch(NumberFormatException e){
				// Exibe uma mensagem de erro se a entrada não for um número válido
				JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		return opcao;

	}
}
