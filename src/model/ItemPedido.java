package model;

// TODO: Auto-generated Javadoc
/**
 * The Class ItensVenda.
 */
public class ItemPedido {
	 
 	/** The produto. */
 	/* private int  codigo;*/
	  private Produto produto;
	  
  	/** The pedido. */
  	private Pedido pedido;
	  
  	/** The quantidade. */
  	private double quantidade;
  	
 	/** The preco. */
  	private double precoUnitario;
	  
  	/** The subtotal. */
  	private double subtotal;
	  
	  
  	
	  
	  
	public ItemPedido() {
		super();
	}



	/**
	 * Instantiates a new itens venda.
	 *
	 * @param produto the produto
	 * @param pedido the pedido
	 * @param quantidade the quantidade
	 * @param subtotal the subtotal
	 */
	public ItemPedido(/*int codigo,*/ Produto produto, Pedido pedido, double quantidade,double precoUnitario, double subtotal) {
		/*this.codigo = codigo;*/
		this.produto = produto;
		this.pedido = pedido;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
		this.subtotal = subtotal;
	}

	
	
	/**
	 * Gets the produto.
	 *
	 * @return the produto
	 */
	/*public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}*/
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
	
	
	
	public double getPrecoUnitario() {
		return precoUnitario;
	}



	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}



	/**
	 * Gets the pedido.
	 *
	 * @return the pedido
	 */
	public Pedido getPedido() {
		return pedido;
	}
	
	/**
	 * Sets the pedido.
	 *
	 * @param pedido the new pedido
	 */
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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
		return "ItemPedido [produto=" + produto + ", pedido=" + pedido + ", quantidade=" + quantidade
				+ ", precoUnitario=" + precoUnitario + ", subtotal=" + subtotal + "]";
	}
	  
	  
	
}
