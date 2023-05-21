package interfaces;

import java.util.List;

import model.Fornecedor;

public interface InterfaceFornecedor{
	
	void cadastrarFornecedor(Fornecedor fornecedor);
	void excluirFornecedor(Fornecedor fornecedor);
	void alterarFornecedor(Fornecedor fornecedor);
	List<Fornecedor> consultarFornecedores();
	List<Fornecedor>  consultarFornecedoresPorNome(String nome);
	
	
}
