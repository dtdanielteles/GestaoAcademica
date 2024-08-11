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

    public static Disciplina atualizarDisciplina(String codigo, CadastroDisciplina cadDisciplina) {
        Disciplina disciplina = cadDisciplina.pesquisar(codigo);

		JOptionPane.showMessageDialog(null, "O cadastro a ser atualizado é:\n"+disciplina.toString());

        int opcao = -1;
        do {
        String txt = "Informe o dado a ser atualizado: \n"
                    + "1 - código\n"
                    + "2 - nome\n"
                    + "0 -Voltar para o menu anterior";
        opcao = Integer.parseInt(JOptionPane.showInputDialog(txt));
        switch (opcao) {
            case 1:
                disciplina.setCodigo(lerCodigo());
                break;
            case 2:
                disciplina.setNome(lerNome());
                break;
            default:
                break;
        }
        } while (opcao != 0);

        return disciplina;
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
                cadDisciplina.cadastrar(novaDisciplina);
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
                Disciplina disciplinaAtualizada = atualizarDisciplina(codigoAtualizar, cadDisciplina);
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
                    boolean removeu = cadDisciplina.remover(disciplinaRemover);
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
