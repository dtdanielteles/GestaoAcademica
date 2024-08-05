package view;

import javax.swing.JOptionPane;

import app.Turma;
import cadastros.CadastroTurma;

public class MenuTurma {

    public static Turma dadosNovaTurma() {
        int numero = lerNumero();
        String horario = lerHorario();
        return new Turma(numero, horario);
    }

    private static int lerNumero() {
        String numeroStr = JOptionPane.showInputDialog("Informe o numero da turma: ");
        return Integer.parseInt(numeroStr);
    }

    private static String lerHorario() {
        return JOptionPane.showInputDialog("Informe o horario da turma: ");
    }

    public static void menuTurma(CadastroTurma cadTurma) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar turma\n"
                + "2 - Pesquisar turma\n"
                + "3 - Atualizar turma\n"
                + "4 - Remover turma\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    Turma novaTurma = dadosNovaTurma();
                    cadTurma.cadastrarTurma(novaTurma);
                    break;

                case 2:
                    int numero = lerNumero();
                    Turma a = cadTurma.pesquisarTurma(numero);
                    if (a != null)
                        JOptionPane.showMessageDialog(null, a.toString());
                    break;

                case 3:
                    numero = lerNumero();
                    Turma novoCadastro = dadosNovaTurma();
                    boolean atualizado = cadTurma.atualizarTurma(numero, novoCadastro);
                    if (atualizado) {
                        JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
                    }
                    break;

                case 4:
                    numero = lerNumero();
                    Turma remover = cadTurma.pesquisarTurma(numero);
                    boolean removido = cadTurma.removerTurma(remover);
                    if (removido) {
                        JOptionPane.showMessageDialog(null, "Turma removida do cadastro");
                        System.gc();
                    }

                default:
                    break;
            }
        } while (opcao != 0);
        return;
    }

}
