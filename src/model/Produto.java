package model;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Produtos.
 */
//Atributos
public class Produto {
	
	/** The codigo. */
	//private int codigo;
	
	/** The descricao. */
	private String descricao;
	
	/** The codigo de barras. */
	private String codigoDeBarras;
	
	/** The marca. */
	private String marca;
	
	/** The sub categoria. */
	private SubCategoria subCategoria;
	
	/** The unidade de medida. */
	private String unidadeDeMedida;
	
	/** The quantidade. */
	private double quantidade;
	
	/** The data fabricacao. */
	private Date dataFabricacao;
	
	/** The data validade. */
	private Date dataValidade;
	
	/** The lote. */
	private String lote;
	
	/** The ipi. */
	private double ipi;
	
	/** The icms. */
	private double icms;
	
	/** The margem lucro. */
	private double margemLucro;
	
	/** The preco custo. */
	private double precoCusto;
	
	/** The preco final. */
	private double precoFinal;
	
	    /**
    	 * Calcular preco final.
    	 */
    	public void calcularPrecoFinal() {
	        double valorLucro = this.precoCusto * (this.margemLucro / 100);
	        double valorIpi = this.precoCusto * (this.ipi / 100);
	        double valorIcms = this.precoCusto * (this.icms / 100);

	        this.precoFinal = this.precoCusto + valorLucro + valorIpi + valorIcms;
	    }

	/**
	 * Gets the codigo.
	 *
	 * @return the codigo
	 */
	/*public int getCodigo() {
			return codigo;
		}

		/**
		 * Sets the codigo.
		 *
		 * @param codigo the new codigo
		 */
	/*	public void setCodigo(int codigo) {
			this.codigo = codigo;
		}*/

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
	
	/**
	 * Gets the codigo de barras.
	 *
	 * @return the codigo de barras
	 */
	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}
	
	/**
	 * Sets the codigo de barras.
	 *
	 * @param codigoDeBarras the new codigo de barras
	 */
	public void setCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}
	
	/**
	 * Gets the marca.
	 *
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}
	
	/**
	 * Sets the marca.
	 *
	 * @param marca the new marca
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	/**
	 * Gets the sub categoria.
	 *
	 * @return the sub categoria
	 */
	public SubCategoria getSubCategoria() {
		return subCategoria;
	}
	
	/**
	 * Sets the sub categoria.
	 *
	 * @param subCategoria the new sub categoria
	 */
	public void setSubCategoria(SubCategoria subCategoria) {
		this.subCategoria = subCategoria;
	}
	
	/**
	 * Gets the unidade de medida.
	 *
	 * @return the unidade de medida
	 */
	public String getUnidadeDeMedida() {
		return unidadeDeMedida;
	}
	
	/**
	 * Sets the unidade de medida.
	 *
	 * @param unidadeDeMedida the new unidade de medida
	 */
	public void setUnidadeDeMedida(String unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida;
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
	 * Gets the data fabricacao.
	 *
	 * @return the data fabricacao
	 */
	public Date getDataFabricacao() {
		return dataFabricacao;
	}
	
	/**
	 * Sets the data fabricacao.
	 *
	 * @param dataFabricacao the new data fabricacao
	 */
	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	
	/**
	 * Gets the data validade.
	 *
	 * @return the data validade
	 */
	public Date getDataValidade() {
		return dataValidade;
	}
	
	/**
	 * Sets the data validade.
	 *
	 * @param dataValidade the new data validade
	 */
	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	/**
	 * Gets the lote.
	 *
	 * @return the lote
	 */
	public String getLote() {
		return lote;
	}
	
	/**
	 * Sets the lote.
	 *
	 * @param lote the new lote
	 */
	public void setLote(String lote) {
		this.lote = lote;
	}
	
	/**
	 * Gets the ipi.
	 *
	 * @return the ipi
	 */
	public double getIpi() {
		return ipi;
	}
	
	/**
	 * Sets the ipi.
	 *
	 * @param ipi the new ipi
	 */
	public void setIpi(double ipi) {
		this.ipi = ipi;
	}
	
	/**
	 * Gets the icms.
	 *
	 * @return the icms
	 */
	public double getIcms() {
		return icms;
	}
	
	/**
	 * Sets the icms.
	 *
	 * @param icms the new icms
	 */
	public void setIcms(double icms) {
		this.icms = icms;
	}
	
	/**
	 * Gets the margem lucro.
	 *
	 * @return the margem lucro
	 */
	public double getMargemLucro() {
		return margemLucro;
	}
	
	/**
	 * Sets the margem lucro.
	 *
	 * @param margemLucro the new margem lucro
	 */
	public void setMargemLucro(double margemLucro) {
		this.margemLucro = margemLucro;
	}
	
	/**
	 * Gets the preco custo.
	 *
	 * @return the preco custo
	 */
	public double getPrecoCusto() {
		return precoCusto;
	}
	
	/**
	 * Sets the preco custo.
	 *
	 * @param precoCusto the new preco custo
	 */
	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}
	
	/**
	 * Gets the preco final.
	 *
	 * @return the preco final
	 */
	public double getPrecoFinal() {
		return precoFinal;
	}
	
	/**
	 * Sets the preco final.
	 *
	 * @param precoFinal the new preco final
	 */
	public void setPrecoFinal(double precoFinal) {
		this.precoFinal = precoFinal;
	}

	@Override
	public String toString() {
		return "Produto [descricao=" + descricao + ", codigoDeBarras=" + codigoDeBarras
				+ ", marca=" + marca + ", subCategoria=" + subCategoria + ", unidadeDeMedida=" + unidadeDeMedida
				+ ", quantidade=" + quantidade + ", dataFabricacao=" + dataFabricacao + ", dataValidade=" + dataValidade
				+ ", lote=" + lote + ", ipi=" + ipi + ", icms=" + icms + ", margemLucro=" + margemLucro
				+ ", precoCusto=" + precoCusto + ", precoFinal=" + precoFinal + "]";
	}

	
}

