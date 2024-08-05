package app;

public class Turma {

    int numero;
    String horario;

    public Turma(int numero, String horario) {
        this.numero = numero;
        this.horario = horario;
    }

    public final int getNumero() {
        return numero;
    }

    public final String getHorario() {
        return horario;
    }

    public String toString() {
        String resposta = super.toString() + "\n";
        resposta += "Numero: " + numero + "\n";
        resposta += "Horario: " + horario + "\n";
        return resposta;
    }

}
