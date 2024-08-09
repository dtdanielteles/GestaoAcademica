package app;

public class Disciplina {

    String codigo;
    String nome;

    public Disciplina(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String toString() {
        String resposta = super.toString() + "\n";
        resposta += "Codigo: " + codigo + "\n";
        resposta += "Nome: " + nome + "\n";
        return resposta;
    }

}