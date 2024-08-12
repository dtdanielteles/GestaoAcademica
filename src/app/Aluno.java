package app;

/**
 * Classe que representa um aluno.
 */
public class Aluno extends PessoaFisica {

	String matricula,
			curso;

	/**
	 * Construtor da classe Aluno
	 * @param nome Nome do aluno
	 * @param cpf CPF do aluno
	 * @param email Email do aluno
	 * @param matricula Matricula do aluno
	 * @param curso Curso do aluno
	 */
	public Aluno(String nome, String cpf, String email, String matricula, String curso) {
		super(nome, cpf, email);
		this.matricula = matricula;
		this.curso = curso;
	}

	/**
	 * Método que retorna a matricula do aluno
	 * @return Matricula do aluno
	 */
	public final String getMatricula() {
		return matricula;
	}

	/**
	 * Método que retorna o curso do aluno
	 * @return Curso do aluno
	 */
	public final String getCurso() {
		return curso;
	}

	/**
	 * Método que atribui uma matricula ao aluno
	 * @param matricula A matricula a ser atribuida ao aluno
	 */
	public final void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * Método que atribui um curso ao aluno
	 * @param curso O curso a ser atribuido ao aluno
	 */
	public final void setCurso(String curso) {
		this.curso = curso;
	}

	/**
	 * Método que retorna uma string contendo os dados do aluno
	 * @return Uma string contendo os dados do aluno
	 */
	public String toString() {
		String resposta = super.toString();
		resposta += "Matrícula: " + matricula + '\n';
		resposta += "Curso: " + curso + '\n';
		return resposta;
	}

}
