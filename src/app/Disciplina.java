package app;

/**
 * Classe que representa uma disciplina.
 */
public class Disciplina {

    private String codigo, nome;

    /**
     * Construtor da classe Disciplina
     * @param codigo Código da disciplina
     * @param nome Nome da disciplina
     */
    public Disciplina(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    /**
     * Método que retorna o nome da disciplina
     * @return Nome da disciplina
     */
    public final String getNome() {
        return nome;
    }

    /**
     * Método que retorna o código da disciplina
     * @return Código da disciplina
     */
    public final String getCodigo() {
        return codigo;
    }

    /**
     * Método que atribui um nome à disciplina
     * @param nome O nome a ser atribuido à disciplina
     */
    public final void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método que atribui um código à disciplina
     * @param codigo O código a ser atribuido à disciplina
     */
    public final void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Método que retorna uma representação em String da disciplina
     * @return Representação em String da disciplina
     */
    public String toString() {
        String resposta = super.toString() + "\n";
        resposta += "Codigo: " + codigo + "\n";
        resposta += "Nome: " + nome + "\n";
        return resposta;
    }

}