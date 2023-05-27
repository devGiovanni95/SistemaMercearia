package interfaces;

import java.util.List;

import model.Cliente;

public interface InterfaceCliente{
	
	void cadastrarCliente(Cliente cliente) throws Exception;
	void excluirCliente(Cliente cliente) throws Exception;
	void alterarCliente(Cliente cliente) throws Exception;
	List<Cliente> consultarClientes() throws Exception;
	List<Cliente>  consultarClientesPorNome(String nome) throws Exception;
	Cliente consultarClientesPorCpf(String cpf);	
	
}
