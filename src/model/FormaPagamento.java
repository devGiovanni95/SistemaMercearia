package model;

import javax.swing.JOptionPane;

// TODO: Auto-generated Javadoc
/**
 * The Class FormaPagamento.
 */
public class FormaPagamento {

	/** The codigo. */
	private String codigo;
	
	/** The dinheiro. */
	private double dinheiro;
	
	/** The cartao credito. */
	private double cartaoCredito;
	
	/** The cartao debito. */
	private double cartaoDebito;
	
	/** The vale alimentacao. */
	private double valeAlimentacao;
	
	/** The vale refeicao. */
	private double valeRefeicao;
	
	/** The pix. */
	private double pix;
	
	/** The troco. */
	private double troco;
		
	/** The total compra. */
	private double totalCompra;
	
	
	
	/**
	 * Instantiates a new forma pagamento.
	 *
	 * @param dinheiro the dinheiro
	 * @param cartaoCredito the cartao credito
	 * @param cartaoDebito the cartao debito
	 * @param valeAlimentacao the vale alimentacao
	 * @param valeRefeicao the vale refeicao
	 * @param pix the pix
	 * @param troco the troco
	 */
	public FormaPagamento(double dinheiro, double cartaoCredito, double cartaoDebito, double valeAlimentacao, double valeRefeicao,
			double pix, double troco) {
		super();
		this.dinheiro = dinheiro;
		this.cartaoCredito = cartaoCredito;
		this.cartaoDebito = cartaoDebito;
		this.valeAlimentacao = valeAlimentacao;
		this.valeRefeicao = valeRefeicao;
		this.pix = pix;
		this.troco = troco;
	}
	
	/**
	 * Gets the total compra.
	 *
	 * @return the total compra
	 */
	public double getTotalCompra() {
		return totalCompra;
	}

	/**
	 * Sets the total compra.
	 *
	 * @param totalCompra the new total compra
	 */
	public void setTotalCompra(double totalCompra) {
		this.totalCompra = totalCompra;
	}

	/**
	 * Instantiates a new forma pagamento.
	 */
	public FormaPagamento() {
		super();
	}
	
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
	 * Gets the dinheiro.
	 *
	 * @return the dinheiro
	 */
	public double getDinheiro() {
		return dinheiro;
	}

	/**
	 * Sets the dinheiro.
	 *
	 * @param dinheiro the new dinheiro
	 */
	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}


	/**
	 * Sets the cartao credito.
	 *
	 * @param cartaoCredito the new cartao credito
	 */
	public void setCartaoCredito(double cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}
	
	/**
	 * Gets the cartao debito.
	 *
	 * @return the cartao debito
	 */
	public double getCartaoCredito() {
		return cartaoCredito;
	}

	/**
	 * Gets the cartao debito.
	 *
	 * @return the cartao debito
	 */
	public double getCartaoDebito() {
		return cartaoDebito;
	}

	/**
	 * Sets the cartao debito.
	 *
	 * @param cartaoDebito the new cartao debito
	 */
	public void setCartaoDebito(double cartaoDebito) {
		this.cartaoDebito= cartaoDebito;
	}

	/**
	 * Gets the vale alimentacao.
	 *
	 * @return the vale alimentacao
	 */
	public double getValeAlimentacao() {
		return valeAlimentacao;
	}

	/**
	 * Sets the vale alimentacao.
	 *
	 * @param valeAlimentacao the new vale alimentacao
	 */
	public void setValeAlimentacao(double valeAlimentacao) {
		this.valeAlimentacao = valeAlimentacao;
	}

	/**
	 * Gets the vale refeicao.
	 *
	 * @return the vale refeicao
	 */
	public double getValeRefeicao() {
		return valeRefeicao;
	}

	/**
	 * Sets the vale refeicao.
	 *
	 * @param valeRefeicao the new vale refeicao
	 */
	public void setValeRefeicao(double valeRefeicao) {
		this.valeRefeicao = valeRefeicao;
	}

	/**
	 * Gets the pix.
	 *
	 * @return the pix
	 */
	public double getPix() {
		return pix;
	}

	/**
	 * Sets the pix.
	 *
	 * @param pix the new pix
	 */
	public void setPix(double pix) {
		this.pix = pix;
	}

	/**
	 * Gets the troco.
	 *
	 * @return the troco
	 */
	public double getTroco() {
		return troco;
	}

	/**
	 * Sets the troco.
	 *
	 * @param troco the new troco
	 */
	public void setTroco(double troco) {
		this.troco = troco;
	}

	}

