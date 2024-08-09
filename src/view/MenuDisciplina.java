package view;

import javax.swing.JOptionPane;

import app.Disciplina;
import cadastros.CadastroDisciplina;

public class MenuDisciplina {

    public static Disciplina dadosNovaDisciplina() {
        String codigo = lerCodigo();
        String nome = lerNome();
        return new Disciplina(codigo, nome);
    }

    private static String lerCodigo() {
        return JOptionPane.showInputDialog("Informe o codigo da disciplina: ");
    }

    private static String lerNome() {
        return JOptionPane.showInputDialog("Informe o nome da disciplina: ");
    }

    public static void menuDisciplina(CadastroDisciplina cadDisciplina) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar disciplina\n"
                + "2 - Pesquisar disciplina\n"
                + "3 - Atualizar disciplina\n"
                + "4 - Remover disciplina\n"
                + "0 - Voltar para menu anterior";

        int opcao=-1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
            case 1:
                Disciplina novaDisciplina = dadosNovaDisciplina();
                cadDisciplina.cadastrarDisciplina(novaDisciplina);
                break;

            case 2:
                String codigo = lerCodigo();
                Disciplina d = cadDisciplina.pesquisar(codigo);
                if (d != null)
                    JOptionPane.showMessageDialog(null, d.toString());
                else
                    JOptionPane.showMessageDialog(null, "Disciplina não encontrada");
                break;

            case 3:
                String codigoAtualizar = lerCodigo();
                Disciplina disciplinaAtualizada = dadosNovaDisciplina();
                boolean atualizou = cadDisciplina.atualizar(codigoAtualizar, disciplinaAtualizada);
                if (atualizou)
                    JOptionPane.showMessageDialog(null, "Disciplina atualizada com sucesso");
                else
                    JOptionPane.showMessageDialog(null, "Disciplina não encontrada");
                break;

            case 4:
                String codigoRemover = lerCodigo();
                Disciplina disciplinaRemover = cadDisciplina.pesquisar(codigoRemover);
                if (disciplinaRemover != null) {
                    boolean removeu = cadDisciplina.removerDisciplina(disciplinaRemover);
                    if (removeu)
                        JOptionPane.showMessageDialog(null, "Disciplina removida com sucesso");
                    else
                        JOptionPane.showMessageDialog(null, "Erro ao remover disciplina");
                } else {
                    JOptionPane.showMessageDialog(null, "Disciplina não encontrada");
                }
                break;
            }
        } while (opcao != 0);
    }
}
