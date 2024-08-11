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

public class MenuTurma {

    public static Turma dadosNovaTurma(CadastroDisciplina cadDisciplina, CadastroProfessor cadProfessor, CadastroAluno cadAluno, CadastroTurma cadTurma) {
        String codigo = lerCodigo();
        Disciplina disciplina = lerDisciplina(cadDisciplina);
        Professor professor = matricularProfessor(cadProfessor, cadTurma);
        List<Aluno> alunos = matricularAluno(codigo, cadAluno, cadTurma);
        return new Turma(codigo, disciplina, professor, alunos);
    }

    public static Turma atualizarTurma(String codigo, CadastroDisciplina cadDisciplina, CadastroProfessor cadProfessor, CadastroAluno cadAluno, CadastroTurma cadTurma) {
        Turma turma = cadTurma.pesquisar(codigo);

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
            
        } while (JOptionPane.showConfirmDialog(null, "Você deseja matricular mais alunos em"+codigoTurma+"?") == JOptionPane.YES_OPTION);
        
        return alunos;
	}

    private static Professor matricularProfessor(CadastroProfessor cadProfessor, CadastroTurma cadTurma) {
        String matFUB = JOptionPane.showInputDialog("Digite a matricula FUB do professor:");
        Professor p = cadProfessor.pesquisar(matFUB);
        if (p == null) {
            JOptionPane.showMessageDialog(null, "Matricula FUB não encontrada");
        }
        return p;
    }

    private static String listarTurma(CadastroTurma cadTurma) {
        String codigo = JOptionPane.showInputDialog("Digite o código da turma a ser listada:");
        Turma t = cadTurma.pesquisar(codigo);

        String listar = "Código da turma: "+t.getCodigo()+"\n"
                    +"Disciplina: "+t.getDisciplina()+"\n"
                    +"Professor: "+t.getProfessor()+"\n"
                    +"Alunos: \n"+t.getAlunosMatriculados();
        return listar;
    }

    public static void menuTurma(CadastroAluno cadAluno, CadastroProfessor cadProfessor, CadastroTurma cadTurma, CadastroDisciplina cadDisciplina) {
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
        return;
    }

}
