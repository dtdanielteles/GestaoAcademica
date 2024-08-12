package exceptions;

/**
 * Classe que representa uma exceção de turma não encontrada
 */
public class TurmaNaoEncontradaException extends Exception {
    /**
     * Construtor da classe TurmaNaoEncontradaException
     * @param mensagem Mensagem que será exibida quando a exceção for lançada
     */
    // Construtor que aceita uma mensagem
    public TurmaNaoEncontradaException(String mensagem) {
        super(mensagem); // Passa a mensagem para o construtor da classe Exception
    }
}
