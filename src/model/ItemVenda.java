package model;

// TODO: Auto-generated Javadoc
/**
 * The Class ItensVenda.
 */
public class ItemVenda {
	 
 	/** The produto. */
 	/* private int  codigo;*/
	  private Produto produto;
	  
  	/** The pedido. */
  	private Venda venda;
	  
  	/** The quantidade. */
  	private double quantidade;
  	
 	/** The preco. */
  	private double precoUnitario;
	  
  	/** The subtotal. */
  	private double subtotal;
	  
	  
  	
	  
	  
	public ItemVenda() {
		super();
	}



	/**
	 * Instantiates a new itens venda.
	 *
	 * @param produto the produto
	 * @param venda the pedido
	 * @param quantidade the quantidade
	 * @param subtotal the subtotal
	 */
	public ItemVenda(/*int codigo,*/ Produto produto, Venda venda, double quantidade,double precoUnitario, double subtotal) {
		/*this.codigo = codigo;*/
		this.produto = produto;
		this.venda = venda;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
		this.subtotal = subtotal;
	}

	
	
	/**
	 * Gets the produto.
	 *
	 * @return the produto
	 */
	public Produto getProduto() {
		return produto;
	}
	
	/**
	 * Sets the produto.
	 *
	 * @param produto the new produto
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
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
	 * Gets the pedido.
	 *
	 * @return the pedido
	 */
	public Venda getPedido() {
		return venda;
	}
	
	/**
	 * Sets the pedido.
	 *
	 * @param venda the new pedido
	 */
	public void setPedido(Venda venda) {
		this.venda = venda;
	}
	
	/**
	 * Gets the quantidade.
	 *
	 * @return the quantidade
	 */
	public double getQuantidade() {
		return quantidade;
	}
	
	/**
	 * Sets the quantidade.
	 *
	 * @param quantidade the new quantidade
	 */
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	
	/**
	 * Gets the subtotal.
	 *
	 * @return the subtotal
	 */
	public double getSubtotal() {
		return subtotal;
	}
	
	/**
	 * Sets the subtotal.
	 *
	 * @param subtotal the new subtotal
	 */
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}



	@Override
	public String toString() {
		return "ItemPedido [produto=" + produto + ", pedido=" + venda + ", quantidade=" + quantidade
				+ ", precoUnitario=" + precoUnitario + ", subtotal=" + subtotal + "]";
	}
	  
	  
	
}
