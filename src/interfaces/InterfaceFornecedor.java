package interfaces;

import java.util.List;

import model.Fornecedor;

public interface InterfaceFornecedor{
	
	void cadastrarFornecedor(Fornecedor fornecedor) throws Exception;
	void excluirFornecedor(Fornecedor fornecedor) throws Exception;
	void alterarFornecedor(Fornecedor fornecedor) throws Exception;
	List<Fornecedor> consultarFornecedores() throws Exception;
	List<Fornecedor>  consultarFornecedoresPorNome(String nome) throws Exception;
	
	
}
