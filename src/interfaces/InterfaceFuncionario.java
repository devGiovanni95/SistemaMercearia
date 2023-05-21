package interfaces;

import java.util.List;

import model.Funcionario;

public interface InterfaceFuncionario{
	
	void cadastrarFuncionario(Funcionario funcionario);
	void excluirFuncionario(Funcionario funcionario);
	void alterarFuncionario(Funcionario funcionario);
	List<Funcionario> consultarFuncionarios();
	List<Funcionario>  consultarFuncionariosPorNome(String nome);
	Funcionario  consultarFuncionariosPorCpf(String nome);
	
}
