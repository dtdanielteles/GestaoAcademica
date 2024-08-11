package app;

public class Disciplina {

    private String codigo, nome;

    public Disciplina(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public final String getNome() {
        return nome;
    }

    public final String getCodigo() {
        return codigo;
    }

    public final void setNome(String nome) {
        this.nome = nome;
    }

    public final void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String toString() {
        String resposta = super.toString() + "\n";
        resposta += "Codigo: " + codigo + "\n";
        resposta += "Nome: " + nome + "\n";
        return resposta;
    }

}