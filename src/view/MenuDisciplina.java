package view;

import javax.swing.JOptionPane;

import app.Disciplina;
import cadastros.CadastroDisciplina;
import exceptions.CampoEmBrancoException;

/**
 * Classe que define o menu de disciplinas
 */
public class MenuDisciplina {

    /**
     * Método que lê os dados de uma nova disciplina
     * @return Disciplina com os dados lidos
     * @throws CampoEmBrancoException Exceção lançada quando um campo obrigatório não é preenchido
     */
    public static Disciplina dadosNovaDisciplina() throws CampoEmBrancoException {
        String codigo = lerCodigo();
        String nome = lerNome();

        Disciplina disciplina = new Disciplina(codigo, nome);

        if (disciplina.getCodigo() == null || disciplina.getCodigo().isBlank() || disciplina.getCodigo().isEmpty()) {
			throw new CampoEmBrancoException("Código da disciplina não informado.");
		}
		if (disciplina.getNome() == null || disciplina.getNome().isBlank() ||disciplina.getNome().isEmpty()) {
			throw new CampoEmBrancoException("Não há alunos matriculados na turma.");
		}

        return disciplina;
    }

    /**
     * Método que atualiza os dados de uma disciplina
     * @param codigo Código da disciplina a ser atualizada
     * @param cadDisciplina Cadastro de disciplinas
     * @return Disciplina com os dados atualizados
     */
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

    /**
     * Método que lê o código da disciplina
     * @return Código da disciplina
     */
    private static String lerCodigo() {
        return JOptionPane.showInputDialog("Informe o codigo da disciplina: ");
    }

    /**
     * Método que lê o nome da disciplina
     * @return Nome da disciplina
     */
    private static String lerNome() {
        return JOptionPane.showInputDialog("Informe o nome da disciplina: ");
    }

    /**
     * Método que exibe o menu de disciplinas
     * @param cadDisciplina Cadastro de disciplinas
     * @throws CampoEmBrancoException Exceção lançada quando um campo obrigatório não é preenchido
     */
    public static void menuDisciplina(CadastroDisciplina cadDisciplina) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar disciplina\n"
                + "2 - Pesquisar disciplina\n"
                + "3 - Atualizar disciplina\n"
                + "4 - Remover disciplina\n"
                + "0 - Voltar para menu anterior";
    
        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            try {
                opcao = Integer.parseInt(strOpcao);
    
                switch (opcao) {
                case 1:
                    try {
                        Disciplina novaDisciplina = dadosNovaDisciplina();
                        cadDisciplina.cadastrar(novaDisciplina);
                        JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso.");
                    } catch (CampoEmBrancoException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
    
                case 2:
                    String codigo = lerCodigo();
                    Disciplina d = cadDisciplina.pesquisar(codigo);
                    if (d != null)
                        JOptionPane.showMessageDialog(null, d.toString());
                    else
                        JOptionPane.showMessageDialog(null, "Disciplina não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
    
                case 3:
                    String codigoAtualizar = lerCodigo();
                    Disciplina disciplinaAtualizada = atualizarDisciplina(codigoAtualizar, cadDisciplina);
                    boolean atualizou = cadDisciplina.atualizar(codigoAtualizar, disciplinaAtualizada);
                    if (atualizou)
                        JOptionPane.showMessageDialog(null, "Disciplina atualizada com sucesso.");
                    else
                        JOptionPane.showMessageDialog(null, "Disciplina não encontrada para atualização.", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
    
                case 4:
                    String codigoRemover = lerCodigo();
                    Disciplina disciplinaRemover = cadDisciplina.pesquisar(codigoRemover);
                    if (disciplinaRemover != null) {
                        boolean removeu = cadDisciplina.remover(disciplinaRemover);
                        if (removeu)
                            JOptionPane.showMessageDialog(null, "Disciplina removida com sucesso.");
                        else
                            JOptionPane.showMessageDialog(null, "Erro ao remover disciplina.", "Erro", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Disciplina não encontrada para remoção.", "Erro", JOptionPane.ERROR_MESSAGE);
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
    
