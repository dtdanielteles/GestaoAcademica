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

}