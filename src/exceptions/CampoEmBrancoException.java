package exceptions;

/**
 * Classe que representa uma exceção de campo em branco
 */
public class CampoEmBrancoException extends Exception{
    /**
     * Construtor da exceçãao
     * @param msg Mensagem de erro
     */
    public CampoEmBrancoException(String msg){
        super(msg);
    }
}
