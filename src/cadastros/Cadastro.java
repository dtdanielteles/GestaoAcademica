package cadastros;

public class Cadastro <T> {
    T cadastros[];
    int numObjetosCadastrados;

    public Cadastro() {
        cadastros = (T[]) new Object[0];
        numObjetosCadastrados = 0;
    }

    public boolean cadastrar (T t) {
        T temp[] = (T[]) new Object[cadastros.length + 1];
        for(int i = 0; i < cadastros.length; i++) {
            temp[i] = cadastros[i];
        }
        temp[temp.length - 1] = t;
        numObjetosCadastrados++;
        cadastros = temp;
        return true;
    }

    public boolean remover (T t) {
        if (t == null) {
            return false;
        }

        T[] temp = (T[]) new Object[cadastros.length - 1];
        int j = 0;
        for(int i = 0; i < numObjetosCadastrados; i++) {
            if(cadastros[i] != t){
                temp[j] = cadastros[i];
                j++;
            } else {
                cadastros[i] = null;
            }
        }
        cadastros = temp;
        numObjetosCadastrados--;
        return true;
    }

    public T pesquisar (String codigo) {
        for(int i = 0; i < numObjetosCadastrados; i++) {
            if(cadastros[i].toString().equalsIgnoreCase(codigo)) {
                return cadastros[i];
            }
        }
        return null;
    }

    public boolean atualizar (String codigo, T t) {
        for(int i = 0; i < numObjetosCadastrados; i++) {
            if(cadastros[i].toString().equalsIgnoreCase(codigo)) {
                cadastros[i] = t;
                return true;
            }
        }
        return false;
    }





}
