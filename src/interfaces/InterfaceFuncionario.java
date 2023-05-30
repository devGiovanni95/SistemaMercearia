package interfaces;

import java.util.List;

import model.Funcionario;

public interface InterfaceFuncionario{
	
	void cadastrarFuncionario(Funcionario funcionario) throws Exception;
	void excluirFuncionario(Funcionario funcionario) throws Exception;
	void alterarFuncionario(Funcionario funcionario) throws Exception;
	List<Funcionario> consultarFuncionarios() throws Exception;
	List<Funcionario>  consultarFuncionariosPorNome(String nome) throws Exception;
	Funcionario  consultarFuncionariosPorCpf(String nome);
	
}
