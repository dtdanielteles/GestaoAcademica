package exceptions;

/**
 * Classe que representa uma exceção de professor não atribuido
 */
public class ProfessorNaoAtribuidoException extends Exception {
    /**
     * Construtor da exceção
     * @param msg Mensagem de erro
     */
    public ProfessorNaoAtribuidoException(String msg) {
        super(msg);
    }
}
