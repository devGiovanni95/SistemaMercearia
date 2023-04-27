package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Categoria.
 */
public class Categoria {
	
	/** The codigo. */
	private int codigo;
	
	/** The nome categoria. */
	private String nomeCategoria;
	
	/** The descricao. */
	private String descricao;
	
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	//para mostrar somente o nome da categoria na Tela de subCategoria
	@Override
	public String toString() {
		return nomeCategoria ;
	}
	
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
	 * Gets the nome categoria.
	 *
	 * @return the nome categoria
	 */
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	
	/**
	 * Sets the nome categoria.
	 *
	 * @param nomeCategoria the new nome categoria
	 */
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	
	/**
	 * Gets the descricao.
	 *
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	
	/**
	 * Sets the descricao.
	 *
	 * @param descricao the new descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
