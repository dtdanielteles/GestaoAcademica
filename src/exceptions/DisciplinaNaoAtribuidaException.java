package exceptions;

/**
 * Classe que representa uma exceção de disciplina não atribuida
 */
public class DisciplinaNaoAtribuidaException extends Exception {
    /**
     * Construtor da exceção
     * @param msg Mensagem de erro
     */
    public DisciplinaNaoAtribuidaException(String msg) {
        super(msg);
    }
}
