package model;

import java.time.LocalDateTime;

// TODO: Auto-generated Javadoc
/**
 * The Class AberturaEFechamentoCaixa.
 */
public class AberturaEFechamentoCaixa {

	/** The codigo. */
	private int codigo;
	
	/** The data abertura. */
	private String dataAbertura;	
	
	/** The data fechamento. */
	private String dataFechamento;
	
	/** The funcionario. */
	private Funcionario funcionario;
	
	/** The troco inicial. */
	private double trocoInicial;
	
	private boolean situacaoCaixa;

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
	 * Gets the data abertura.
	 *
	 * @return the data abertura
	 */
	public String getDataAbertura() {
		return dataAbertura;
	}
	
	/**
	 * Sets the data abertura.
	 *
	 * @param dataAbertura the new data abertura
	 */
	public void setDataAbertura(String dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	/**
	 * Gets the data fechamento.
	 *
	 * @return the data fechamento
	 */
	public String getDataFechamento() {
		return dataFechamento;
	}
	
	/**
	 * Sets the data fechamento.
	 *
	 * @param dataFechamento the new data fechamento
	 */
	public void setDataFechamento(String dataFechamento) {
		this.dataFechamento = dataFechamento;
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
	 * Gets the troco inicial.
	 *
	 * @return the troco inicial
	 */
	public double getTrocoInicial() {
		return trocoInicial;
	}
	
	/**
	 * Sets the troco inicial.
	 *
	 * @param trocoInicial the new troco inicial
	 */
	public void setTrocoInicial(double trocoInicial) {
		this.trocoInicial = trocoInicial;
	}
	
	
	public boolean isSituacaoCaixa() {
		return situacaoCaixa;
	}
	
	public void setSituacaoCaixa(boolean situacaoCaixa) {
		this.situacaoCaixa = situacaoCaixa;
	}
	
}
