package app;

/**
 * Classe que representa uma pessoa física.
 */
public class PessoaFisica {
	
	private String nome, 
	               cpf, 
	               email;

	/**
	 * Construtor da classe PessoaFisica
	 * @param nome Nome da pessoa física
	 * @param cpf CPF da pessoa física
	 * @param email Email da pessoa física
	 */
	public PessoaFisica(String nome, String cpf, String email) {
		this.nome = nome; 
		this.cpf = cpf;
		this.email = email;
	}

	/**
	 * Método que retorna o nome da pessoa física
	 * @return Nome da pessoa física
	 */
	public final String getNome() {
		return nome;
	}

	/**
	 * Método que retorna o CPF da pessoa física
	 * @return CPF da pessoa física
	 */
	public final String getCpf() {
		return cpf;
	}

	/**
	 * Método que retorna o email da pessoa física
	 * @return Email da pessoa física
	 */
	public final String getEmail() {
		return email;
	}

	/**
	 * Método que atribui um nome à pessoa física
	 * @param nome O nome a ser atribuido à pessoa física
	 */
	public final void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Método que atribui um CPF à pessoa física
	 * @param cpf O CPF a ser atribuido à pessoa física
	 */
	public final void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Método que atribui um email à pessoa física
	 * @param email O email a ser atribuido à pessoa física
	 */
	public final void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Método que retorna uma representação em String da pessoa física
	 * @return Representação em String da pessoa física
	 */
	public String toString() {
		String resposta = "Nome: " + nome + '\n';
		resposta += "CPF: " + cpf + '\n'; 
		resposta += "E-mail: " + email + '\n';
		return resposta;
	}

}
