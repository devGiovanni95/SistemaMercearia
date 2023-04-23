package model;

public class Categoria {
	
	private int codigo;
	private String nomeCategoria;
	private String descricao;
	
	
	//para mostrar somente o nome da categoria na Tela de subCategoria
	@Override
	public String toString() {
		return nomeCategoria ;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
