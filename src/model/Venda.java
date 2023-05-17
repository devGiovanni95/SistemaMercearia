package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Pedido.
 */
public class Venda {

	/** The codigo. */
	private String codigo;
	
	/** The cliente. */
	private Cliente cliente;
	
	/** The funcionario. */
	private Funcionario funcionario;
	
	/** The forma pagamento. */
	private FormaPagamento formaPagamento;
	
	/** The data venda. */
	private String dataVenda;
	
	/** The valor venda. */
	private double valorVenda;
		
	
	/**
	 * Gets the codigo.
	 *
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	
	/**
	 * Sets the codigo.
	 *
	 * @param codigo the new codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Gets the cliente.
	 *
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}
	
	/**
	 * Sets the cliente.
	 *
	 * @param cliente the new cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	/**
	 * Gets the funcionario.
	 *
	 * @return the funcionario
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	/**
	 * Sets the funcionario.
	 *
	 * @param funcionario the new funcionario
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	/**
	 * Gets the forma pagamento.
	 *
	 * @return the forma pagamento
	 */
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	
	/**
	 * Sets the forma pagamento.
	 *
	 * @param formaPagamento the new forma pagamento
	 */
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	/**
	 * Gets the data venda.
	 *
	 * @return the data venda
	 */
	public String getDataVenda() {
		return dataVenda;
	}
	
	/**
	 * Sets the data venda.
	 *
	 * @param dataVenda the new data venda
	 */
	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	/**
	 * Gets the valor venda.
	 *
	 * @return the valor venda
	 */
	public double getValorVenda() {
		return valorVenda;
	}
	
	/**
	 * Sets the valor venda.
	 *
	 * @param valorVenda the new valor venda
	 */
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	@Override
	public String toString() {
		return "Pedido [codigo=" + codigo + ", cliente=" + cliente + ", funcionario=" + funcionario
				+ ", formaPagamento=" + formaPagamento + ", dataVenda=" + dataVenda + ", valorVenda=" + valorVenda
				+ "]";
	}
	
	

}
