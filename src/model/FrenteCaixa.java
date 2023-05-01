package model;

public class FrenteCaixa {

	//Dados para tela de Frente de Caixa
	
	private double qtdItens;
	private String codBarras;
	private double precoUnitario;
	private String cpf;
	private double subTotal;
	private Produtos produto;
	
	//Métodos getter and setter para manipulação dos dados.
	
	public double getQtdItens() {
		return qtdItens;
	}
	public void setQtdItens(double qtdItens) {
		this.qtdItens = qtdItens;
	}
	public String getCodBarras() {
		return codBarras;
	}
	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
}
