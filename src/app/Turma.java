package app;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe que representa uma turma.
 */
public class Turma {

    private String codigo; // Substitui "horario"
    private Disciplina disciplina;
    private Professor professor;
    private List<Aluno> alunosMatriculados = new LinkedList<>();

    /**
     * Construtor da classe Turma
     * @param codigo Código da turma
     * @param disciplina Disciplina da turma
     * @param professor Professor da turma
     * @param alunos Lista de alunos matriculados na turma
     */
    public Turma(String codigo, Disciplina disciplina, Professor professor, List<Aluno> alunos) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;
        this.alunosMatriculados = alunos;
    }

    /**
     * Método que retorna o código da turma
     * @return Código da turma
     */
    public final String getCodigo() {
        return this.codigo;
    }

    /**
     * Método que retorna a disciplina da turma
     * @return Disciplina
     */
    public final Disciplina getDisciplina() {
        return this.disciplina;
    }

    /**
     * Método que retorna a disciplina da turma em formato de String
     * @return Disciplina em formato de String
     */
    public final String getDisciplinaStr() {
        return this.disciplina.toString();
    }

    /**
     * Método que retorna o professor da turma
     * @return Professor
     */
    public final Professor getProfessor() {
        return this.professor;
    }

    /**
     * Método que retorna o professor da turma em formato de String
     * @return Professor em formato de String
     */
    public final String getProfessorStr() {
        return this.professor.toString();
    }

    /**
     * Método que retorna a lista de alunos matriculados na turma
     * @return Lista de alunos matriculados na turma
     */
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

    /**
     * Método que atribui um código à turma
     * @param codigo O código a ser atribuido à turma
     */
    public final void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Método que atribui uma disciplina à turma
     * @param disciplina A disciplina a ser atribuida à turma
     */
    public final void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * Método que atribui um professor à turma
     * @param professor O professor a ser atribuido à turma
     */
    public final void setProfessor(Professor professor) {
        this.professor = professor;
    }

    /**
     * Método que atribui uma lista de alunos à turma
     * @param alunos A lista de alunos a ser atribuida à turma
     */
    public final void setAlunos(List<Aluno> alunos) {
        this.alunosMatriculados = alunos;
    }

    /**
     * Método que retorna uma representação em String da turma
     * @return Representação em String da turma
     */
    public String toString() {
        String resposta = "Código (horário): " + this.codigo + "\n";
        resposta += "Disciplina: " + this.getDisciplina() + "\n";
        return resposta;
    }
}
