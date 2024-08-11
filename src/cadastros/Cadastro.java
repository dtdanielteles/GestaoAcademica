package cadastros;

import java.util.LinkedList;
import java.util.List;

import exceptions.CampoEmBrancoException;

public abstract class Cadastro <T> {
    private List<T> cadastros;

    // Construtor da classe
    public Cadastro () {
        cadastros = new LinkedList<>();
    }

    public int cadastrar (T t) throws CampoEmBrancoException {
        // return cadastros.add(t);
        

        boolean cadastrou = this.cadastros.add(t); // Adiciona o objeto à lista
        if (cadastrou) {
            return this.cadastros.size(); // Atualiza o número de objetos cadastrados
        }
        return 0;
    }

    public boolean remover (T t) {
        return cadastros.remove(t);
    }

    public abstract T pesquisar (String codigo);

    public boolean atualizar (String codigo, T t) {
        boolean resposta = false;
        T remover = pesquisar(codigo); // Pesquisa o objeto pelo codigo
        if (remover != null) {
            cadastros.remove(remover); // Remove o objeto antigo
            resposta = cadastros.add(t); // Adiciona o novo objeto
        }
        return resposta; // Retorna true se a atualização foi bem-sucedida
    };

    public List<T> getCadastros() {
        return cadastros;
    }
}
