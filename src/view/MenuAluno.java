package view;

import javax.swing.JOptionPane;

import app.Aluno;
import cadastros.CadastroAluno;
import exceptions.CampoEmBrancoException;

/**
 * Classe que define o menu de interação com o usuário para cadastro de alunos
 */
public class MenuAluno {

	/**
	 * Método que lê os dados de um novo aluno
	 * @return Aluno com os dados lidos
	 * @throws CampoEmBrancoException Exceção lançada caso algum campo esteja em branco
	 */
	public static Aluno dadosNovoAluno() throws CampoEmBrancoException{
		String nome = lerNome();
		if (nome == null || nome.isBlank() || nome.isEmpty()) {
			throw new CampoEmBrancoException("Nome não informado.");
		}

		String cpf = lerCPF();
		if (cpf == null || cpf.isBlank() || cpf.isEmpty()) {
			throw new CampoEmBrancoException("CPF não informado.");
		}

		String email = lerEmail();
		if (email == null || email.isBlank() || email.isEmpty()) {
			throw new CampoEmBrancoException("E-mail não informado.");
		}

		String matricula = lerMatricula();
		if (matricula == null || matricula.isBlank() || matricula.isEmpty()) {
			throw new CampoEmBrancoException("Matrícula não informada.");
		}

		String curso = lerCurso();
		if (curso == null || curso.isBlank() || curso.isEmpty()) {
			throw new CampoEmBrancoException("Curso não informado.");
		}

		return new Aluno(nome, cpf, email, matricula, curso);
	}

	/**
	 * Método que atualiza os dados de um aluno
	 * @param matricula Matrícula do aluno a ser atualizado
	 * @param cadAluno Cadastro de alunos
	 * @return Aluno com os dados atualizados
	 */
	public static Aluno atualizarAluno(String matricula, CadastroAluno cadAluno) {
        Aluno aluno = cadAluno.pesquisar(matricula);

		JOptionPane.showMessageDialog(null, "O cadastro a ser atualizado é:\n"+aluno.toString());

        int opcao = -1;
        do {
        String txt = "Informe o dado a ser atualizado: \n"
                    + "1 - nome\n"
                    + "2 - CPF\n"
                    + "3 - e-mail\n"
                    + "4 - matrícula\n"
                    + "5 - curso\n"
                    + "0 -Voltar para o menu anterior";
        opcao = Integer.parseInt(JOptionPane.showInputDialog(txt));
        switch (opcao) {
            case 1:
                aluno.setNome(lerNome());
                break;
            case 2:
                aluno.setCpf(lerCPF());
                break;
            case 3:
                aluno.setEmail(lerEmail());
                break;
            case 4:
                aluno.setMatricula(lerMatricula());
                break;
            case 5:
                aluno.setCurso(lerCurso());
                break;
            default:
                break;
        }
        } while (opcao != 0);

        return aluno;
    }

	/**
	 * Método que lê o curso do aluno
	 * @return Curso do aluno
	 */
	private static String lerCurso() {
		return JOptionPane.showInputDialog("Informe o curso do aluno: ");
	}

	/**
	 * Método que lê o email do aluno
	 * @return Email do aluno
	 */
	private static String lerEmail() {
		return JOptionPane.showInputDialog("Informe o email do aluno: ");
	}

	/**
	 * Método que lê o CPF do aluno
	 * @return CPF do aluno
	 */
	private static String lerCPF() {
		return JOptionPane.showInputDialog("Informe o CPF do aluno: ");
	}

	/**
	 * Método que lê o nome do aluno
	 * @return Nome do aluno
	 */
	private static String lerNome() {
		return JOptionPane.showInputDialog("Informe o nome do aluno: ");
	}

	/**
	 * Método que lê a matrícula do aluno
	 * @return Matrícula do aluno
	 */
	private static String lerMatricula() {
		return JOptionPane.showInputDialog("Informe a matricula do aluno: ");
	}

	/**
	 * Método que exibe o menu de interação com o usuário para cadastro de alunos
	 * @param cadAluno Cadastro de alunos
	 * @throws CampoEmBrancoException Exceção lançada caso algum campo esteja em branco
	 */
	public static void menuAluno(CadastroAluno cadAluno) throws CampoEmBrancoException {
		String txt = "Informe a opção desejada \n"
				+ "1 - Cadastrar aluno\n"
				+ "2 - Pesquisar aluno\n"
				+ "3 - Atualizar aluno\n"
				+ "4 - Remover aluno\n"
				+ "0 - Voltar para menu anterior";
		
		int opcao=-1;
		do {
			String strOpcao = JOptionPane.showInputDialog(txt);
			opcao = Integer.parseInt(strOpcao);

			switch (opcao) {
			case 1:
				try{
				Aluno novoAluno = dadosNovoAluno();
				cadAluno.cadastrar(novoAluno);
				}catch(CampoEmBrancoException e){
					JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
				break;
				
			case 2: 
				String matricula = lerMatricula();
				Aluno a = cadAluno.pesquisar(matricula);
				if (a != null)
					JOptionPane.showMessageDialog(null, a.toString());
				break;
				
			case 3: 
				matricula = lerMatricula(); 
				Aluno novoCadastro = atualizarAluno(matricula, cadAluno);
				boolean atualizado = cadAluno.atualizar(matricula, novoCadastro);
				if (atualizado) {
					JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
				}
				break;
				
			case 4: 
				matricula = lerMatricula();
				Aluno remover = cadAluno.pesquisar(matricula);
				boolean removido = cadAluno.remover(remover);
				if (removido) {
					JOptionPane.showMessageDialog(null, "Aluno removido do cadastro");
					System.gc();
				}

			default:
				break;
			}
		} while (opcao != 0);
	}


}
