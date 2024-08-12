package exceptions;

public class TurmaNaoEncontradaException extends Exception {
    // Construtor que aceita uma mensagem
    public TurmaNaoEncontradaException(String mensagem) {
        super(mensagem); // Passa a mensagem para o construtor da classe Exception
    }
}
