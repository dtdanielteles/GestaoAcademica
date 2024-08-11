package view;

import javax.swing.JOptionPane;

import app.Aluno;
import cadastros.CadastroAluno;
import exceptions.CampoEmBrancoException;

public class MenuAluno {

	public static Aluno dadosNovoAluno() throws CampoEmBrancoException{
		String nome = lerNome();
		String cpf = lerCPF();
		String email = lerEmail();
		String matricula = lerMatricula(); 
		String curso = lerCurso();

		Aluno a = new Aluno(nome, cpf, email, matricula, curso);

		if (a.getNome() == null || a.getNome().isBlank() || a.getNome().isEmpty()) {
			throw new CampoEmBrancoException("Nome não informado.");
		}
		if (a.getCpf() == null || a.getCpf().isBlank() || a.getCpf().isEmpty()) {
			throw new CampoEmBrancoException("CPF não informado.");
		}
		if (a.getEmail() == null || a.getEmail().isBlank() || a.getEmail().isEmpty()) {
			throw new CampoEmBrancoException("E-mail não informado.");
		}
		if (a.getMatricula() == null || a.getMatricula().isBlank() || a.getMatricula().isEmpty()) {
			throw new CampoEmBrancoException("Matrícula não informada.");
		}
		if (a.getCurso() == null || a.getCurso().isBlank() || a.getCurso().isEmpty()) {
			throw new CampoEmBrancoException("Curso não informado.");
		}
		return a;
	}

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

	private static String lerCurso() {
		return JOptionPane.showInputDialog("Informe o curso do aluno: ");
	}

	private static String lerEmail() {
		return JOptionPane.showInputDialog("Informe o email do aluno: ");
	}

	private static String lerCPF() {
		return JOptionPane.showInputDialog("Informe o CPF do aluno: ");
	}

	private static String lerNome() {
		return JOptionPane.showInputDialog("Informe o nome do aluno: ");
	}

	private static String lerMatricula() {
		return JOptionPane.showInputDialog("Informe a matricula do aluno: ");
	}

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
				Aluno novoAluno = dadosNovoAluno();
				cadAluno.cadastrar(novoAluno);
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
		return;
	}


}
