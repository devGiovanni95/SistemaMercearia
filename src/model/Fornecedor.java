package model;

// TODO: Auto-generated Javadoc
/**
 *Classe Fornecedor representa um fornecedor no sistema.
 */

public class Fornecedor {
	
	//Atributos
	
	/** The nome. */
	private String nome;
	
	/** The email. */
	private String email;
	
	/** The endereco. */
	private String endereco;
	
	/** The numero. */
	private int numero;
	
	/** The cnpj. */
	private String cnpj;
	
	/** The bairro. */
	private String bairro;
	
	/** The cidade. */
	private String cidade;
	
	/** The celular. */
	private String celular;
	
	/** The telefone. */
	private String telefone;
	
	/** The cep. */
	private String cep;
	
	/** The complemento. */
	private String complemento;
	
	/** The inscricao estadual. */
	private String inscricaoEstadual;
	
	/** The razao social. */
	private String razaoSocial;
	
	/** The uf. */
	private String uf;
	
	 // Métodos getter e setter para cada atributo
	
	/**
 	 * Gets the nome.
 	 *
 	 * @return the nome
 	 */
 	public String getNome() {
		return nome;
	}
	
	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the endereco.
	 *
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}
	
	/**
	 * Sets the endereco.
	 *
	 * @param endereco the new endereco
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	/**
	 * Gets the numero.
	 *
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}
	
	/**
	 * Sets the numero.
	 *
	 * @param numero the new numero
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	/**
	 * Gets the cnpj.
	 *
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}
	
	/**
	 * Sets the cnpj.
	 *
	 * @param cnpj the new cnpj
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	/**
	 * Gets the bairro.
	 *
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}
	
	/**
	 * Sets the bairro.
	 *
	 * @param bairro the new bairro
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	/**
	 * Gets the cidade.
	 *
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}
	
	/**
	 * Sets the cidade.
	 *
	 * @param cidade the new cidade
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	/**
	 * Gets the celular.
	 *
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}
	
	/**
	 * Sets the celular.
	 *
	 * @param celular the new celular
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	/**
	 * Gets the telefone.
	 *
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}
	
	/**
	 * Sets the telefone.
	 *
	 * @param telefone the new telefone
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	/**
	 * Gets the cep.
	 *
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}
	
	/**
	 * Sets the cep.
	 *
	 * @param cep the new cep
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	/**
	 * Gets the complemento.
	 *
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}
	
	/**
	 * Sets the complemento.
	 *
	 * @param complemento the new complemento
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	/**
	 * Gets the inscricao estadual.
	 *
	 * @return the inscricao estadual
	 */
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	
	/**
	 * Sets the inscricao estadual.
	 *
	 * @param inscricaoEstadual the new inscricao estadual
	 */
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	
	/**
	 * Gets the razao social.
	 *
	 * @return the razao social
	 */
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	/**
	 * Sets the razao social.
	 *
	 * @param razaoSocial the new razao social
	 */
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	/**
	 * Gets the uf.
	 *
	 * @return the uf
	 */
	public String getUf() {
		return uf;
	}
	
	/**
	 * Sets the uf.
	 *
	 * @param uf the new uf
	 */
	public void setUf(String uf) {
		this.uf = uf;
	}
	public Fornecedor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
//		return getNome();
		return getCnpj();
	}
	
	
	
}

