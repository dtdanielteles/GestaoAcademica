package view;

import java.util.Iterator;

import javax.swing.JOptionPane;

import app.Aluno;
import app.Disciplina;
import app.Professor;
import app.Turma;
import cadastros.CadastroTurma;
import cadastros.CadastroAluno;
import cadastros.CadastroDisciplina;
import cadastros.CadastroProfessor;

public class MenuTurma {

    public static Turma dadosNovaTurma(CadastroDisciplina cadDisciplina) {
        String codigo = lerCodigo();
        Disciplina disciplina = lerDisciplina(cadDisciplina);
        return new Turma(codigo, disciplina);
    }

    private static String lerCodigo() {
        String codigo = JOptionPane.showInputDialog("Informe o código da turma: ");
        return codigo;
    }

    // private static String lerHorario() {
    //     return JOptionPane.showInputDialog("Informe o horario da turma: ");
    // }

    private static Disciplina lerDisciplina(CadastroDisciplina cadDisciplina) {
        String codigo = JOptionPane.showInputDialog("Informe o codigo da disciplina: ");
        Disciplina disciplina = cadDisciplina.pesquisar(codigo);
        if (disciplina == null) {
            JOptionPane.showMessageDialog(null, "Disciplina não encontrada");
        }
        return disciplina;
    }

    private static boolean definirDisciplina(CadastroDisciplina cadDisciplina, CadastroTurma cadTurma) {
        String codigo = JOptionPane.showInputDialog("Digite o codigo da turma em que a disciplina será definida:");

        Iterator<Turma> itTurma = cadTurma.getCadastros().iterator();
        Iterator<Disciplina> itDisciplina = cadDisciplina.getCadastros().iterator();

        while (itTurma.hasNext()) {
            Turma t = itTurma.next();
            if (t.getCodigo().equalsIgnoreCase(codigo)) {
                String codigoDisciplina = JOptionPane.showInputDialog("Digite o codigo da disciplina será definida para a turma "+t.getCodigo()+":");

                while (itDisciplina.hasNext()) {
                    Disciplina disciplina = itDisciplina.next();
                    if (disciplina.getCodigo().equalsIgnoreCase(codigoDisciplina)) {
                        t.disciplina = disciplina;
                        JOptionPane.showMessageDialog(null, "Disciplina definida com sucesso!");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static int matricularAluno(CadastroAluno cadAluno, CadastroTurma cadTurma) {
		String codigo = JOptionPane.showInputDialog("Digite o codigo da turma em que o aluno será matriculado:");

		Iterator<Turma> itTurma = cadTurma.getCadastros().iterator();
        Iterator<Aluno> itAluno = cadAluno.getCadastros().iterator();

        while (itTurma.hasNext()) {
            Turma t = itTurma.next();
            if (t.getCodigo().equalsIgnoreCase(codigo)) {
                do {
                    String mat = JOptionPane.showInputDialog("Digite a matricula do aluno:");

                    while (itAluno.hasNext()) {
                        Aluno a = itAluno.next();
                        if (a.getMatricula().equalsIgnoreCase(mat)) {
                            t.getAlunosMatriculados().add(a);
                        JOptionPane.showMessageDialog(null, "Aluno matriculado com sucesso!");
                        }
                    }
                } while (JOptionPane.showConfirmDialog(null, "Você deseja matricular mais alunos em"+t.getCodigo()+"?") == JOptionPane.YES_OPTION);
            }
            return t.getAlunosMatriculados().size();
        }
        return 0;
	}

    private static int removerAluno(CadastroAluno cadAluno, CadastroTurma cadTurma) {
        String codigo = JOptionPane.showInputDialog("Digite o codigo da turma da qual o aluno será removido:");

		Iterator<Turma> itTurma = cadTurma.getCadastros().iterator();
        Iterator<Aluno> itAluno = cadAluno.getCadastros().iterator();

        while (itTurma.hasNext()) {
            Turma t = itTurma.next();
            if (t.getCodigo().equalsIgnoreCase(codigo)) {
                do {
                    String mat = JOptionPane.showInputDialog("Digite a matricula do aluno:");

                    while (itAluno.hasNext()) {
                        Aluno a = itAluno.next();
                        if (a.getMatricula().equalsIgnoreCase(mat)) {
                            t.getAlunosMatriculados().remove(a);
                        JOptionPane.showMessageDialog(null, "Aluno removido com sucesso!");
                        }
                    }
                } while (JOptionPane.showConfirmDialog(null, "Você deseja remover mais alunos de"+t.getCodigo()+"?") == JOptionPane.YES_OPTION);
            }
            return t.getAlunosMatriculados().size();
        }
        return 0;
    }

    private static boolean matricularProfessor(CadastroProfessor cadProfessor, CadastroTurma cadTurma) {
        String codigo = JOptionPane.showInputDialog("Digite o codigo da turma em que o professor será matriculado:");

        Iterator<Turma> itTurma = cadTurma.getCadastros().iterator();
        Iterator<Professor> itProfessor = cadProfessor.getCadastros().iterator();

        while (itTurma.hasNext()) {
            Turma t = itTurma.next();
            if (t.getCodigo().equalsIgnoreCase(codigo)) {

                String matFUB = JOptionPane.showInputDialog(null, "Digite a matricula FUB do professor:");

                while (itProfessor.hasNext()) {
                    Professor p = itProfessor.next();
                    if(p.getMatriculaFUB().equalsIgnoreCase(matFUB)) {
                        t.professor = p;
                        JOptionPane.showMessageDialog(null, "Professor matriculado com sucesso!");

                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean removerProfessor(CadastroProfessor cadProfessor, CadastroTurma cadTurma) {
        String codigo = JOptionPane.showInputDialog("Digite o codigo da turma da qual o professor será removido:");

        Iterator<Turma> itTurma = cadTurma.getCadastros().iterator();
        Iterator<Professor> itProfessor = cadProfessor.getCadastros().iterator();

        while (itTurma.hasNext()) {
            Turma t = itTurma.next();
            if (t.getCodigo().equalsIgnoreCase(codigo)) {

                String matFUB = JOptionPane.showInputDialog(null, "Digite a matricula FUB do professor:");

                while (itProfessor.hasNext()) {
                    Professor p = itProfessor.next();
                    if(p.getMatriculaFUB().equalsIgnoreCase(matFUB)) {
                        t.professor = null;
                        JOptionPane.showMessageDialog(null, "Professor removido com sucesso!");

                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void menuTurma(CadastroAluno cadAluno, CadastroProfessor cadProfessor, CadastroTurma cadTurma, CadastroDisciplina cadDisciplina) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar turma\n"
                + "2 - Pesquisar turma\n"
                + "3 - Atualizar turma\n"
                + "4 - Remover turma\n"
                + "5 - Definir disciplina para uma turma\n"
                + "6 - Matricular aluno em turma\n"
                + "7 - Remover aluno de turma\n"
                + "8 - Matricular professor em turma\n"
                + "9 - Remover professor de turma\n"
                + "10 - Listar turma"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    Turma novaTurma = dadosNovaTurma(cadDisciplina);
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
                    Turma novoCadastro = dadosNovaTurma(cadDisciplina);
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
                    definirDisciplina(cadDisciplina, cadTurma);
                    break;
                case 6:
                    matricularAluno(cadAluno, cadTurma);
                    break;
                case 7:
                    removerAluno(cadAluno, cadTurma);
                    break;
                case 8:
                    matricularProfessor(cadProfessor, cadTurma);
                    break;
                case 9:
                    removerProfessor(cadProfessor, cadTurma);
                    break;

                default:
                    break;
            }
        } while (opcao != 0);
        return;
    }

}
