package app;

public class Turma {

    int numero;
    String horario;
    Disciplina disciplina;

    public Turma(int numero, String horario, Disciplina disciplina) {
        this.numero = numero;
        this.horario = horario;
        this.disciplina = disciplina;
    }

    public final int getNumero() {
        return numero;
    }

    public final String getHorario() {
        return horario;
    }

    // public final String getDisciplina() {
    //     return disciplina;
    // }

    public String toString() {
        String resposta = super.toString() + "\n";
        resposta += "Numero: " + numero + "\n";
        resposta += "Horario: " + horario + "\n";
        resposta += "Disciplina: " + disciplina + "\n";
        return resposta;
    }

}
