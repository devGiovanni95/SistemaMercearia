package model;

import java.io.PrintWriter;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ItensVenda.
 */
public class ItemVenda {

	private String codigo;

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


/*
	public String gravar(List<ItemVenda> lista, Double total,String a ,String b,String c,String d  ) {
		String operacao = "";
		try {
			//List<ItemVenda> lista;
			int i;
			PrintWriter pw = new PrintWriter("Cupom.txt");
			pw.write("                     MERCEARIA                    \n");
			pw.write("        RUA SEM NOME, 1254 - VILA SÃO JOSÉ        \n");
			pw.write("	    	CEP: 13330-050 INDAIATUBA - SP          \n");
			pw.write("CNPJ:00.000.000/0000-00          					\n");
			pw.write("INCRIÇÃO ESTADUAL: 000.000000.0000				\n");
			pw.write("INCRIÇÃO MUNICIPAL: 0.000.000/000-0				\n");
			pw.write("--------------------------------------------------\n");
			pw.write("DATA: "+venda.getDataVenda());
			pw.write("CODIGO DA VENDA:"+venda.getCodigo());
			pw.write("----------------CUPOM NÃO FISCAL------------------\n");
			pw.write("ITEM  CÓDIGO       DESCRIÇÃO           \n");
			pw.write("QUANTIDADE  VALOR UNITARIO       		VALOR ITEM	\n");
			pw.write("--------------------------------------------------\n");
			
			while(lista != null) {
				pw.write(a + " " + b + " " + c + " " + d + " \n" );
				//pw.write(lista.get(4) + " " + lista.get(5) + " " + lista.get(6));
			}
			
			pw.write("Total R$ "+total+"\n");
			pw.write("                  \n");
			pw.close();

		} catch (Exception e) {
			operacao = "Falha de gravação" + e;
		}
		return "Cupom gerado com sucesso";
	}





	public String getCodigo() {
		return codigo;
	}*/



	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	public Venda getVenda() {
		return venda;
	}

	/**
	 * Sets the pedido.
	 *
	 * @param venda the new pedido
	 */
	public void setVenda(Venda venda) {
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
