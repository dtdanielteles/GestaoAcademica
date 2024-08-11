package app;

import java.util.LinkedList;
import java.util.List;

public class Turma {

    // int numero;
    public String codigo; // Substitui "horario"
    public Disciplina disciplina;
    public Professor professor;
    private List<Aluno> alunosMatriculados = new LinkedList<>();

    public Turma(String codigo, Disciplina disciplina, Professor professor, List<Aluno> alunos) {
        // this.numero = numero;
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;
        this.alunosMatriculados = alunos;
    }

    // public final int getNumero() {
    //     return this.numero;
    // }

    public final String getCodigo() {
        return this.codigo;
    }

    public final String getDisciplina() {
        return this.disciplina.toString();
    }

    public final String getProfessor() {
        return this.professor.toString();
    }

    public final List<Aluno> getAlunosMatriculados() {
        return this.alunosMatriculados;
    }

    public final void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public final void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public final void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public final void setAlunos(List<Aluno> alunos) {
        this.alunosMatriculados = alunos;
    }

    public String toString() {
        String resposta = super.toString() + "\n";
        // resposta += "Numero: " + numero + "\n";
        resposta += "Código (horário): " + this.codigo + "\n";
        resposta += "Disciplina: " + this.getDisciplina() + "\n";
        return resposta;
    }
}
