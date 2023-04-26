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
	private String subCategoria;
	
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
	 * Gets the sub categoria.
	 *
	 * @return the sub categoria
	 */
	public String getSubCategoria() {
		return subCategoria;
	}
	
	/**
	 * Sets the sub categoria.
	 *
	 * @param subCategoria the new sub categoria
	 */
	public void setSubCategoria(String subCategoria) {
		this.subCategoria = subCategoria;
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
		return subCategoria ;
	}
	
	
	
}
