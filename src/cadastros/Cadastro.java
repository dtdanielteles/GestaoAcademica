package cadastros;

import java.util.ArrayList;
import java.util.List;

public abstract class Cadastro <T> {
    private List<T> cadastros;

    public Cadastro() {
        cadastros = new ArrayList<>();
    }

    public boolean cadastrar (T t) {
        return cadastros.add(t);
    }

    public boolean remover (T t) {
        return cadastros.remove(t);
    }

    public abstract T pesquisar (String codigo);

    public abstract boolean atualizar (String codigo, T t);

    public List<T> getCadastros() {
        return cadastros;
    }
}
