package view;

import javax.swing.JOptionPane;

import app.Professor;
import cadastros.CadastroProfessor;
import exceptions.CampoEmBrancoException;

/**
 * Classe que define o menu de professores
 */
public class MenuProfessor {

	/**
	 * Método que lê os dados de um novo professor
	 * @return Professor com os dados lidos
	 * @throws CampoEmBrancoException Exceção lançada caso algum campo esteja em branco
	 */
	public static Professor dadosNovoProfessor() throws CampoEmBrancoException{
		String nome = lerNome();
		String cpf = lerCPF();
		String email = lerEmail();
		String areaFormacao = lerAreaFormacao();
		String matriculaFUB = lerMatriculaFUB(); 

		Professor p = new Professor(nome, cpf, email, areaFormacao, matriculaFUB);

		if (p.getNome() == null || p.getNome().isBlank() || p.getNome().isEmpty()) {
			throw new CampoEmBrancoException("Nome não informado.");
		}
		if (p.getCpf() == null || p.getCpf().isBlank() || p.getCpf().isEmpty()) {
			throw new CampoEmBrancoException("CPF não informado.");
		}
		if (p.getEmail() == null || p.getEmail().isBlank() || p.getEmail().isEmpty()) {
			throw new CampoEmBrancoException("E-mail não informado.");
		}
		if (p.getMatriculaFUB() == null || p.getMatriculaFUB().isBlank() || p.getMatriculaFUB().isEmpty()) {
			throw new CampoEmBrancoException("Matrícula FUB não informada.");
		}
		if (p.getAreaFormacao() == null || p.getAreaFormacao().isBlank() || p.getAreaFormacao().isEmpty()) {
			throw new CampoEmBrancoException("Área de formação não informada.");
		}
 		return p;
	}

	/**
	 * Método que atualiza os dados de um professor
	 * @param matriculaFUB Matrícula do professor a ser atualizado
	 * @param cadProfessor Cadastro de professores
	 * @return Professor com os dados atualizados
	 */
    public static Professor atualizarProfessor(String matriculaFUB, CadastroProfessor cadProfessor) {
        Professor professor = cadProfessor.pesquisar(matriculaFUB);

		JOptionPane.showMessageDialog(null, "O cadastro a ser atualizado é:\n"+professor.toString());

        int opcao = -1;
        do {
        String txt = "Informe o dado a ser atualizado: \n"
                    + "1 - nome\n"
                    + "2 - CPF\n"
                    + "3 - e-mail\n"
                    + "4 - matrícula FUB\n"
                    + "5 - área de formação\n"
                    + "0 -Voltar para o menu anterior";
        opcao = Integer.parseInt(JOptionPane.showInputDialog(txt));
        switch (opcao) {
            case 1:
                professor.setNome(lerNome());
                break;
            case 2:
                professor.setCpf(lerCPF());
                break;
            case 3:
                professor.setEmail(lerEmail());
                break;
            case 4:
                professor.setMatriculaFUB(lerMatriculaFUB());
                break;
            case 5:
                professor.setAreaFormacao(lerAreaFormacao());
                break;
            default:
                break;
        }
        } while (opcao != 0);

        return professor;
    }

	/**
	 * Método que lê a área de formação do professor
	 * @return Área de formação do professor
	 */
	private static String lerAreaFormacao() {
		return JOptionPane.showInputDialog("Informe a área de formação do(a) professor(a): ");
	}

	/**
	 * Método que lê o e-mail do professor
	 * @return E-mail do professor
	 */
	private static String lerEmail() {
		return JOptionPane.showInputDialog("Informe o email do(a) professor(a): ");
	}

	/**
	 * Método que lê o CPF do professor
	 * @return CPF do professor
	 */
	private static String lerCPF() {
		return JOptionPane.showInputDialog("Informe o CPF do(a) professor(a): ");
	}

	/**
	 * Método que lê o nome do professor
	 * @return Nome do professor
	 */
	private static String lerNome() {
		return JOptionPane.showInputDialog("Informe o nome do(a) professor(a): ");
	}

	/**
	 * Método que lê a matrícula FUB do professor
	 * @return Matrícula FUB do professor
	 */
	private static String lerMatriculaFUB() {
		return JOptionPane.showInputDialog("Informe a matricula FUB do(a) professor(a): ");
	}

	/**
	 * Método que exibe o menu de professores
	 * @param cadProfessor Cadastro de professores
	 */
	public static void menuProfessor(CadastroProfessor cadProfessor) {
		String txt = "Informe a opção desejada \n"
				+ "1 - Cadastrar professor(a)\n"
				+ "2 - Pesquisar professor(a)\n"
				+ "3 - Atualizar professor(a)\n"
				+ "4 - Remover professor(a)\n"
				+ "0 - Voltar para menu anterior";
		
		int opcao = -1;
		do {
			String strOpcao = JOptionPane.showInputDialog(txt);
			try {
				opcao = Integer.parseInt(strOpcao);
	
				switch (opcao) {
				case 1:
					try {
						Professor novoProfessor = dadosNovoProfessor();
						cadProfessor.cadastrar(novoProfessor);
						JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso.");
					} catch (CampoEmBrancoException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
					}
					break;
					
				case 2:
					String matriculaFUB = lerMatriculaFUB();
					Professor p = cadProfessor.pesquisar(matriculaFUB);
					if (p != null)
						JOptionPane.showMessageDialog(null, p.toString());
					else
						JOptionPane.showMessageDialog(null, "Professor não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
					break;
					
				case 3:
					matriculaFUB = lerMatriculaFUB();
					Professor novoCadastro = atualizarProfessor(matriculaFUB, cadProfessor);
					boolean atualizado = cadProfessor.atualizar(matriculaFUB, novoCadastro);
					if (atualizado) {
						JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso.");
					} else {
						JOptionPane.showMessageDialog(null, "Professor não encontrado para atualização.", "Erro", JOptionPane.ERROR_MESSAGE);
					}
					break;
					
				case 4:
					matriculaFUB = lerMatriculaFUB();
					Professor remover = cadProfessor.pesquisar(matriculaFUB);
					if (remover != null) {
						boolean removido = cadProfessor.remover(remover);
						if (removido) {
							JOptionPane.showMessageDialog(null, "Professor removido com sucesso.");
						} else {
							JOptionPane.showMessageDialog(null, "Erro ao remover professor.", "Erro", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Professor não encontrado para remoção.", "Erro", JOptionPane.ERROR_MESSAGE);
					}
					break;
	
				case 0:
					// Voltar para o menu anterior
					break;
	
				default:
					JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, selecione uma opção válida.", "Erro", JOptionPane.ERROR_MESSAGE);
					break;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		} while (opcao != 0);
	}
}
