package view;

import javax.swing.JOptionPane;

import app.Professor;
import cadastros.CadastroProfessor;

public class MenuProfessor {

	public static Professor dadosNovoProfessor() {
		String nome = lerNome();
		String cpf = lerCPF();
		String email = lerEmail();
		String matriculaFUB = lerMatriculaFUB(); 
		String areaFormacao = lerAreaFormacao();
		return new Professor(nome, cpf, email, matriculaFUB, areaFormacao);
	}

    public static Professor atualizarProfessor(String matriculaFUB, CadastroProfessor cadProfessor) {
        Professor professor = cadProfessor.pesquisar(matriculaFUB);

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

	private static String lerAreaFormacao() {
		return JOptionPane.showInputDialog("Informe a área de formação do(a) professor(a): ");
	}

	private static String lerEmail() {
		return JOptionPane.showInputDialog("Informe o email do(a) professor(a): ");
	}

	private static String lerCPF() {
		return JOptionPane.showInputDialog("Informe o CPF do(a) professor(a): ");
	}

	private static String lerNome() {
		return JOptionPane.showInputDialog("Informe o nome do(a) professor(a): ");
	}

	private static String lerMatriculaFUB() {
		return JOptionPane.showInputDialog("Informe a matricula FUB do(a) professor(a): ");
	}

	public static void menuProfessor(CadastroProfessor cadProfessor) {
		String txt = "Informe a opção desejada \n"
				+ "1 - Cadastrar professor(a)\n"
				+ "2 - Pesquisar professor(a)\n"
				+ "3 - Atualizar professor(a)\n"
				+ "4 - Remover professor(a)\n"
				+ "0 - Voltar para menu anterior";
		
		int opcao=-1;
		do {
			String strOpcao = JOptionPane.showInputDialog(txt);
			opcao = Integer.parseInt(strOpcao);

			switch (opcao) {
			case 1:
				Professor novoProfessor = dadosNovoProfessor();
				cadProfessor.cadastrar(novoProfessor);
				break;
				
			case 2: 
				String matriculaFUB = lerMatriculaFUB();
				Professor p = cadProfessor.pesquisar(matriculaFUB);
				if (p != null)
					JOptionPane.showMessageDialog(null, p.toString());
				break;
				
			case 3: 
				matriculaFUB = lerMatriculaFUB(); 
				Professor novoCadastro = atualizarProfessor(matriculaFUB, cadProfessor);
				boolean atualizado = cadProfessor.atualizar(matriculaFUB, novoCadastro);
				if (atualizado) {
					JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
				}
				break;
				
			case 4: 
				matriculaFUB = lerMatriculaFUB();
				Professor remover = cadProfessor.pesquisar(matriculaFUB);
				boolean removido = cadProfessor.remover(remover);
				if (removido) {
					JOptionPane.showMessageDialog(null, "Professor removido do cadastro");
					System.gc();
				}

			default:
				break;
			}
		} while (opcao != 0);
		return;
	}


}
