package interfaces;

import java.util.List;

import model.Produto;

public interface InterfaceProduto{
	
	void cadastrarProduto(Produto produto) throws Exception;
	void excluirProduto(Produto produto) throws Exception;
	void alterarProduto(Produto produto) throws Exception;
	List<Produto> consultarProdutos() throws Exception;
	List<Produto>  consultarProdutosPorNome(String nome) throws Exception;
	Produto consultarProdutosPorCodigoBarras(String codigoBarras);	
	
}
