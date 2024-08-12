package app;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Turma {

    private String codigo; // Substitui "horario"
    private Disciplina disciplina;
    private Professor professor;
    private List<Aluno> alunosMatriculados = new LinkedList<>();

    public Turma(String codigo, Disciplina disciplina, Professor professor, List<Aluno> alunos) {
        
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;
        this.alunosMatriculados = alunos;
    }

    public final String getCodigo() {
        return this.codigo;
    }

    public final Disciplina getDisciplina() {
        return this.disciplina;
    }

    public final String getDisciplinaStr() {
        return this.disciplina.toString();
    }

    public final Professor getProfessor() {
        return this.professor;
    }

    public final String getProfessorStr() {
        return this.professor.toString();
    }

    public final String getAlunosMatriculados() {
        String listaDeAlunos = "";
        Iterator<Aluno> itAluno = alunosMatriculados.iterator();
        while (itAluno.hasNext()) {
            Aluno a = itAluno.next();
            listaDeAlunos += "Nome: "+a.getNome()+"\n"
                        +"Matricula: "+a.getMatricula()+"\n\n";
        }
        return listaDeAlunos;
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
