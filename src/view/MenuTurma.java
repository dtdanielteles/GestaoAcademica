package view;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import app.Aluno;
import app.Disciplina;
import app.Professor;
import app.Turma;
import cadastros.CadastroTurma;
import cadastros.CadastroAluno;
import cadastros.CadastroDisciplina;
import cadastros.CadastroProfessor;

import exceptions.CampoEmBrancoException;
import exceptions.DisciplinaNaoAtribuidaException;
import exceptions.ProfessorNaoAtribuidoException;

/**
 * Classe que define o menu de turmas
 */
public class MenuTurma {

    /**
     * Método que recebe os dados de uma nova turma
     * @param cadDisciplina Cadastro de disciplinas
     * @param cadProfessor Cadastro de professores
     * @param cadAluno Cadastro de alunos
     * @param cadTurma Cadastro de turmas
     * @return Turma com os dados lidos
     * @throws CampoEmBrancoException Exceção lançada quando um campo obrigatório não é preenchido
     * @throws ProfessorNaoAtribuidoException Exceção lançada quando o professor não é atribuído
     * @throws DisciplinaNaoAtribuidaException Exceção lançada quando a disciplina não é atribuída
     */
    public static Turma dadosNovaTurma(CadastroDisciplina cadDisciplina, CadastroProfessor cadProfessor, CadastroAluno cadAluno, CadastroTurma cadTurma) throws CampoEmBrancoException, ProfessorNaoAtribuidoException, DisciplinaNaoAtribuidaException{
        String codigo = lerCodigo();
        Disciplina disciplina = lerDisciplina(cadDisciplina);
        Professor professor = matricularProfessor(cadProfessor, cadTurma);
        List<Aluno> alunos = matricularAluno(codigo, cadAluno, cadTurma);

        Turma turma = new Turma(codigo, disciplina, professor, alunos);

		if (turma.getCodigo() == null || turma.getCodigo().isBlank() || turma.getCodigo().isEmpty()) {
			throw new CampoEmBrancoException("Código da turma não informado.");
		}
		if (turma.getDisciplina() == null) {
			throw new DisciplinaNaoAtribuidaException("Código da disciplina não informado.");
		}
		if (turma.getProfessor() == null) {
			throw new ProfessorNaoAtribuidoException("Professor(a) não informado(a).");
		}
		if (turma.getAlunosMatriculados() == null || turma.getAlunosMatriculados().isBlank() ||turma.getAlunosMatriculados().isEmpty()) {
			throw new CampoEmBrancoException("Não há alunos matriculados na turma.");
		}
        return turma;
    }

    /**
     * Método que atualiza os dados de uma turma
     * @param codigo Código da turma a ser atualizada
     * @param cadDisciplina Cadastro de disciplinas
     * @param cadProfessor Cadastro de professores
     * @param cadAluno Cadastro de alunos
     * @param cadTurma Cadastro de turmas
     * @return Turma com os dados atualizados
     */
    public static Turma atualizarTurma(String codigo, CadastroDisciplina cadDisciplina, CadastroProfessor cadProfessor, CadastroAluno cadAluno, CadastroTurma cadTurma) {
        Turma turma = cadTurma.pesquisar(codigo);

        JOptionPane.showMessageDialog(null, "O cadastro a ser atualizado é:\n"+turma.toString());

        int opcao = -1;
        do {
        String txt = "Informe o dado a ser atualizado: \n"
                    + "1 - codigo\n"
                    + "2 - disciplina\n"
                    + "3 - professor\n"
                    + "4 - alunos matriculados\n"
                    + "0 -Voltar para o menu anterior";
        opcao = Integer.parseInt(JOptionPane.showInputDialog(txt));
        switch (opcao) {
            case 1:
                turma.setCodigo(lerCodigo());
                break;
            case 2:
                turma.setDisciplina(lerDisciplina(cadDisciplina));
                break;
            case 3:
                turma.setProfessor(matricularProfessor(cadProfessor, cadTurma));
                break;
            case 4:
                turma.setAlunos(matricularAluno(codigo, cadAluno, cadTurma));
                break;
            default:
                break;
        }
        } while (opcao != 0);

        return turma;
    }

    /**
     * Método que lê o código da turma
     * @return Código da turma
     */
    private static String lerCodigo() {
        String codigo = JOptionPane.showInputDialog("Informe o código da turma: ");
        return codigo;
    }

    /**
     * Método que lê a disciplina
     * @param cadDisciplina Cadastro de disciplinas
     * @return Disciplina lida
     */
    private static Disciplina lerDisciplina(CadastroDisciplina cadDisciplina) {
        String codigo = JOptionPane.showInputDialog("Informe o codigo da disciplina: ");
        Disciplina disciplina = cadDisciplina.pesquisar(codigo);
        if (disciplina == null) {
            JOptionPane.showMessageDialog(null, "Disciplina não encontrada");
        }
        return disciplina;
    }

    /**
     * Método que matricula um aluno em uma turma
     * @param codigoTurma Código da turma
     * @param cadAluno Cadastro de alunos
     * @param cadTurma Cadastro de turmas
     * @return Lista de alunos matriculados
     */
    private static List<Aluno> matricularAluno(String codigoTurma, CadastroAluno cadAluno, CadastroTurma cadTurma) {
        List<Aluno> alunos = new LinkedList<>();
		
        do {
            String mat = JOptionPane.showInputDialog("Digite a matricula do aluno:");
            Aluno a = cadAluno.pesquisar(mat);

            if (a == null) {
                JOptionPane.showMessageDialog(null, "Matricula não encontrada.");
                return null;
            } else {
                alunos.add(a);
                JOptionPane.showMessageDialog(null, "Aluno matriculado com sucesso!");
            }
            
        } while (JOptionPane.showConfirmDialog(null, "Você deseja matricular mais alunos em "+codigoTurma+"?") == JOptionPane.YES_OPTION);
        
        return alunos;
	}

    /**
     * Método que matricula um professor em uma turma
     * @param cadProfessor Cadastro de professores
     * @param cadTurma Cadastro de turmas
     * @return Professor matriculado
     */
    private static Professor matricularProfessor(CadastroProfessor cadProfessor, CadastroTurma cadTurma) {
        String matFUB = JOptionPane.showInputDialog("Digite a matricula FUB do professor:");
        Professor p = cadProfessor.pesquisar(matFUB);
        if (p == null) {
            JOptionPane.showMessageDialog(null, "Matricula FUB não encontrada");
        }
        return p;
    }

    /**
     * Método que lista uma turma
     * @param cadTurma Cadastro de turmas
     */
    private static void listarTurma(CadastroTurma cadTurma) {
        String codigo = JOptionPane.showInputDialog("Digite o código da turma a ser listada:");
        Turma t = cadTurma.pesquisar(codigo);

        String listar = "Código da turma: "+t.getCodigo()+"\n"
                    +"Disciplina: "+t.getDisciplina()+"\n"
                    +"Professor: "+t.getProfessor()+"\n"
                    +"Alunos: \n"+t.getAlunosMatriculados();
        JOptionPane.showMessageDialog(null, listar);
    }

    /**
     * Método que exibe o menu de turmas
     * @param cadAluno Cadastro de alunos
     * @param cadProfessor Cadastro de professores
     * @param cadTurma Cadastro de turmas
     * @param cadDisciplina Cadastro de disciplinas
     * @throws CampoEmBrancoException Exceção lançada quando um campo obrigatório não é preenchido
     * @throws ProfessorNaoAtribuidoException Exceção lançada quando o professor não é atribuído
     * @throws DisciplinaNaoAtribuidaException Exceção lançada quando a disciplina não é atribuída
     */
    public static void menuTurma(CadastroAluno cadAluno, CadastroProfessor cadProfessor, CadastroTurma cadTurma, CadastroDisciplina cadDisciplina) throws CampoEmBrancoException, ProfessorNaoAtribuidoException, DisciplinaNaoAtribuidaException {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar turma\n"
                + "2 - Pesquisar turma\n"
                + "3 - Atualizar turma\n"
                + "4 - Remover turma\n"
                + "5 - Listar turma\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    Turma novaTurma = dadosNovaTurma(cadDisciplina, cadProfessor, cadAluno, cadTurma);
                    cadTurma.cadastrar(novaTurma);
                    break;

                case 2:
                    String codigo = lerCodigo();
                    Turma a = cadTurma.pesquisar(codigo);
                    if (a != null)
                        JOptionPane.showMessageDialog(null, a.toString());
                    break;

                case 3:
                    codigo = lerCodigo();
                    Turma novoCadastro = atualizarTurma(codigo, cadDisciplina, cadProfessor, cadAluno, cadTurma);
                    boolean atualizado = cadTurma.atualizar(codigo, novoCadastro);
                    if (atualizado) {
                        JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
                    }
                    break;

                case 4:
                    codigo = lerCodigo();
                    Turma remover = cadTurma.pesquisar(codigo);
                    boolean removido = cadTurma.remover(remover);
                    if (removido) {
                        JOptionPane.showMessageDialog(null, "Turma removida do cadastro");
                        System.gc();
                    }

                case 5:
                    listarTurma(cadTurma);
                    break;

                default:
                    break;
            }
        } while (opcao != 0);
    }

}
