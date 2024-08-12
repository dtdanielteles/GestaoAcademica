package cadastros;

import java.util.LinkedList;
import java.util.List;

import exceptions.CampoEmBrancoException;

/**
 * Classe abstrata que define um cadastro genérico
 * @param <T> Tipo de objeto a ser cadastrado
 */
public abstract class Cadastro <T> {
    private List<T> cadastros;

    /**
     * Construtor padrão que inicializa a lista de cadastros
     */
    public Cadastro () {
        cadastros = new LinkedList<>();
    }

    /**
     * Método que cadastra um objeto
     * @param t Objeto a ser cadastrado
     * @return Número de objetos cadastrados
     * @throws CampoEmBrancoException Exceção lançada quando um campo obrigatório não é preenchido
     */
    public int cadastrar (T t) throws CampoEmBrancoException {
        boolean cadastrou = this.cadastros.add(t); // Adiciona o objeto à lista
        if (cadastrou) {
            return this.cadastros.size(); // Atualiza o número de objetos cadastrados
        }
        return 0;
    }

    /**
     * Método que remove um objeto
     * @param t Objeto a ser removido
     * @return true se o objeto foi removido com sucesso
     */
    public boolean remover (T t) {
        return cadastros.remove(t);
    }

    /**
     * Método que pesquisa um objeto pelo código
     * @param codigo Código do objeto a ser pesquisado
     * @return Objeto pesquisado
     */
    public abstract T pesquisar (String codigo);

    /**
     * Método que atualiza um objeto
     * @param codigo Código do objeto a ser atualizado
     * @param t Objeto atualizado
     * @return true se a atualização foi bem-sucedida
     */
    public boolean atualizar (String codigo, T t) {
        boolean resposta = false;
        T remover = pesquisar(codigo); // Pesquisa o objeto pelo codigo
        if (remover != null) {
            cadastros.remove(remover); // Remove o objeto antigo
            resposta = cadastros.add(t); // Adiciona o novo objeto
        }
        return resposta; // Retorna true se a atualização foi bem-sucedida
    }

    /**
     * Método que retorna a lista de cadastros
     * @return Lista de cadastros
     */
    public List<T> getCadastros() {
        return cadastros;
    }
}
