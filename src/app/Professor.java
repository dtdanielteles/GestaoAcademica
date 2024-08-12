package app;

/**
 * Classe que representa um professor.
 */
public class Professor extends PessoaFisica{
	
	String areaFormacao, 
	       matriculaFUB;

	/**
	 * Construtor da classe Professor.
	 * @param nome Nome do professor.
	 * @param cpf CPF do professor.
	 * @param email Email do professor.
	 * @param areaFormacao Área de formação do professor.
	 * @param matriculaFUB Matrícula FUB do professor.
	 */
	public Professor(String nome, String cpf, String email, String areaFormacao, String matriculaFUB) {
		super(nome, cpf, email);
		this.areaFormacao = areaFormacao;
		this.matriculaFUB = matriculaFUB;
	}

	/**
	 * Método que retorna a área de formação do professor.
	 * @return Área de formação do professor.
	 */
	public final String getAreaFormacao() {
		return areaFormacao;
	}

	/**
	 * Método que retorna a matrícula FUB do professor.
	 * @return Matrícula FUB do professor.
	 */
	public final String getMatriculaFUB() {
		return matriculaFUB;
	}

	/**
	 * Método que recebe a área de formação do professor.
	 * @param areaFormacao Área de formação do professor.
	 */
	public final void setAreaFormacao(String areaFormacao) {
		this.areaFormacao = areaFormacao;
	}

	/**
	 * Método que recebe a matrícula FUB do professor.
	 * @param matriculaFUB Matrícula FUB do professor.
	 */
	public final void setMatriculaFUB(String matriculaFUB) {
		this.matriculaFUB = matriculaFUB;
	}

	/**
	 * Método que retorna uma string com as informações do professor.
	 * @return String com as informações do professor.
	 */
	public String toString() {
		String resposta = super.toString();
		resposta += "MATRICULA FUB: " + this.matriculaFUB + '\n';
		resposta += "ÁREA DE FORMAÇÃO: " + this.areaFormacao + '\n';
		return resposta;
	}

}
