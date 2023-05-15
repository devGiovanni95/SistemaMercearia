package model;

// TODO: Auto-generated Javadoc
/**
 * The Class SubCategoria.
 */
public class SubCategoria {
	
	/** The codigo. */
	private int codigo;
	
	/** The categoria. */
	private Categoria categoria;
	
	/** The sub categoria. */
	private String nome;
	
	/** The Descricao. */
	private String Descricao;
	
	/**
	 * Gets the codigo.
	 *
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}
	
	/**
	 * Sets the codigo.
	 *
	 * @param codigo the new codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Gets the categoria.
	 *
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}
	
	/**
	 * Sets the categoria.
	 *
	 * @param categoria the new categoria
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	/**
	 * Gets the sub nome.
	 *
	 * @return the sub nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Sets the sub nome.
	 *
	 * @param nome the new sub nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Gets the descricao.
	 *
	 * @return the descricao
	 */
	public String getDescricao() {
		return Descricao;
	}
	
	/**
	 * Sets the descricao.
	 *
	 * @param descricao the new descricao
	 */
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return nome ;
	}
	
	
	
}
