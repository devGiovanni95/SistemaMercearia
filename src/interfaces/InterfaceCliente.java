package interfaces;

import java.util.List;

import model.Cliente;

public interface InterfaceCliente{
	
	void cadastrarCliente(Cliente cliente);
	void excluirCliente(Cliente cliente);
	void alterarCliente(Cliente cliente);
	List<Cliente> consultarClientes();
	List<Cliente>  consultarClientesPorNome(String nome);
	Cliente consultarClientesPorCpf(String cpf);	
	
}
