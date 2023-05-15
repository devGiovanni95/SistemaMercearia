package model;

// TODO: Auto-generated Javadoc
/**
 * The Class FrenteCaixa.
 */
public class FrenteCaixa {

	//Dados para tela de Frente de Caixa
	
	/** The qtd itens. */
	private double qtdItens;
	
	/** The cod barras. */
	private String codBarras;
	
	/** The preco unitario. */
	private double precoUnitario;
	
	/** The cpf. */
	private String cpf;
	
	/** The sub total. */
	private double subTotal;
	
	/** The produto. */
	private Produto produto;
	
	//Métodos getter and setter para manipulação dos dados.
	
	/**
	 * Gets the qtd itens.
	 *
	 * @return the qtd itens
	 */
	public double getQtdItens() {
		return qtdItens;
	}
	
	/**
	 * Sets the qtd itens.
	 *
	 * @param qtdItens the new qtd itens
	 */
	public void setQtdItens(double qtdItens) {
		this.qtdItens = qtdItens;
	}
	
	/**
	 * Gets the cod barras.
	 *
	 * @return the cod barras
	 */
	public String getCodBarras() {
		return codBarras;
	}
	
	/**
	 * Sets the cod barras.
	 *
	 * @param codBarras the new cod barras
	 */
	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}
	
	/**
	 * Gets the preco unitario.
	 *
	 * @return the preco unitario
	 */
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	
	/**
	 * Sets the preco unitario.
	 *
	 * @param precoUnitario the new preco unitario
	 */
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	
	/**
	 * Gets the cpf.
	 *
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}
	
	/**
	 * Sets the cpf.
	 *
	 * @param cpf the new cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	/**
	 * Gets the sub total.
	 *
	 * @return the sub total
	 */
	public double getSubTotal() {
		return subTotal;
	}
	
	/**
	 * Sets the sub total.
	 *
	 * @param subTotal the new sub total
	 */
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
}
