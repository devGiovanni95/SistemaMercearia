package interfaces;

import java.util.List;

import model.Produto;

public interface InterfaceProduto{
	
	void cadastrarProduto(Produto produto);
	void excluirProduto(Produto produto);
	void alterarProduto(Produto produto);
	List<Produto> consultarProdutos();
	List<Produto>  consultarProdutosPorNome(String nome);
	Produto consultarProdutosPorCodigoBarras(String codigoBarras);	
	
}
