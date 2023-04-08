package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import jdbc.ConnectionFactory;
import model.Cliente;
import model.Funcionario;
import view.FrmFuncionarios;

public class FuncionarioController {

	private Connection connection;
	
	public FuncionarioController() {
		this.connection =  new ConnectionFactory().getConnection();
	}

	//metodo cadastrar funcionario
	/**
	 * Método efetua um comando SQL para efetuar a inserção no banco de dados de um novo funcionario.
	 * @param cliente - um objeto do tipo cliente com os atributos correspondentes
	 */
	public void cadastrarFuncionario(Funcionario funcionario) {
		try {
			
			//1 - parte criar o comando sql
			String sql = "insert into tb_funcionarios(nome,email,cpf,rg,endereco,telefone,celular,numero,cep,dataNascimento,bairro,cidade,uf,"
					+ "complemento,limite,senha,cargo,nivelAcesso,pisPasep,salario,carteiraTrabalho,estadoCivil,jornadaTrabalho,admissao,demissao,ativo) "
					+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			//2 passo - conectar o banco de dados e organizar o comando do mesmo
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, funcionario.getNome());
			preparedStatement.setString(2, funcionario.getEmail());
			preparedStatement.setString(3, funcionario.getCpf());
			preparedStatement.setString(4, funcionario.getRg());
			preparedStatement.setString(5, funcionario.getEndereco());
			preparedStatement.setString(6, funcionario.getTelefone());
			preparedStatement.setString(7, funcionario.getCelular());
			preparedStatement.setInt(8, funcionario.getNumero());
			preparedStatement.setString(9, funcionario.getCep());
			preparedStatement.setString(10, funcionario.getDataNascimento());
			preparedStatement.setString(11, funcionario.getBairro());
			preparedStatement.setString(12, funcionario.getCidade());
			preparedStatement.setString(13, funcionario.getUf());
			preparedStatement.setString(14, funcionario.getComplemento());
			preparedStatement.setDouble(15, funcionario.getLimite());
			preparedStatement.setString(16, funcionario.getSenha());
			preparedStatement.setString(17, funcionario.getCargo());
			preparedStatement.setString(18, funcionario.getNivelAcesso());
			preparedStatement.setString(19, funcionario.getPisPasep());
			preparedStatement.setDouble(20, funcionario.getSalario());
			preparedStatement.setString(21, funcionario.getCarteiraTrabalho());
			preparedStatement.setString(22, funcionario.getEstadoCivil());
			preparedStatement.setString(23, funcionario.getJornadaTrabalho());
			preparedStatement.setString(24, funcionario.getAdmissao());
			preparedStatement.setString(25, funcionario.getDemissao());
			preparedStatement.setString(26, funcionario.getAtivo());
			
			//3 passo - executar o comando sql
			preparedStatement.execute();
			preparedStatement.close();
			
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
			
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Erro: " + erro);
		} catch(NumberFormatException erro) {
			JOptionPane.showMessageDialog(null, "Erro: " + erro);
		}
	}
	
	//metodo excluir cliente cliente
	public void excluirCliente(Funcionario funcionario) {
		try {
					
					//1 - parte criar o comando sql
					String sql = "delete from tb_funcionarios where cpf=?";
					
					//2 passo - conectar o banco de dados e organizar o comando do mesmo
					PreparedStatement preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1, funcionario.getCpf());
					
					//3 passo - executar o comando sql
					preparedStatement.execute();
					preparedStatement.close();
					
					JOptionPane.showMessageDialog(null, "Excluido com sucesso");

					
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, "Erro: " + erro);
				}
	}

	
	//metodo alterar funcionario
	public void alterarCliente(Funcionario funcionario) {
		try {
				
				//1 - parte criar o comando sql
				String sql = "update tb_funcionarios set nome=?,email=?,cpf=?,rg=?,endereco=?,telefone=?,celular=?,numero=?,cep=?,dataNascimento=?,bairro=?,cidade=?,uf=?,complemento=?,limite=?,"
						+ "senha=?,cargo=?,nivelAcesso=?,pisPasep=?,salario=?,carteiraTrabalho=?,estadoCivil=?,jornadaTrabalho=?,admissao=?,demissao=?,ativo=? "
						+ " where cpf=?";
				
				//2 passo - conectar o banco de dados e organizar o comando do mesmo
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, funcionario.getNome());
				preparedStatement.setString(2, funcionario.getEmail());
				preparedStatement.setString(3, funcionario.getCpf());
				preparedStatement.setString(4, funcionario.getRg());
				preparedStatement.setString(5, funcionario.getEndereco());
				preparedStatement.setString(6, funcionario.getTelefone());
				preparedStatement.setString(7, funcionario.getCelular());
				preparedStatement.setInt(8, funcionario.getNumero());
				preparedStatement.setString(9, funcionario.getCep());
				preparedStatement.setString(10, funcionario.getDataNascimento());
				preparedStatement.setString(11, funcionario.getBairro());
				preparedStatement.setString(12, funcionario.getCidade());
				preparedStatement.setString(13, funcionario.getUf());
				preparedStatement.setString(14, funcionario.getComplemento());
				preparedStatement.setDouble(15, funcionario.getLimite());
				preparedStatement.setString(16, funcionario.getSenha());
				preparedStatement.setString(17, funcionario.getCargo());
				preparedStatement.setString(18, funcionario.getNivelAcesso());
				preparedStatement.setString(19, funcionario.getPisPasep());
				preparedStatement.setDouble(20, funcionario.getSalario());
				preparedStatement.setString(21, funcionario.getCarteiraTrabalho());
				preparedStatement.setString(22, funcionario.getEstadoCivil());
				preparedStatement.setString(23, funcionario.getJornadaTrabalho());
				preparedStatement.setString(24, funcionario.getAdmissao());
				preparedStatement.setString(25, funcionario.getDemissao());
				preparedStatement.setString(26, funcionario.getAtivo());
				preparedStatement.setString(27, funcionario.getCpf());
				
				//3 passo - executar o comando sql
				preparedStatement.execute();
				preparedStatement.close();
				
				JOptionPane.showMessageDialog(null, "Alterado com sucesso");
				
				
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, "Erro: " + erro);
			}
	}
	
	//metodo listar funcionarios
	public List<Funcionario> listarCliente() {
		try {
			
			//Criando a lista
			List<Funcionario> lista = new ArrayList<>();
			
			//criar sql, organizar e executar
			String sql = "select * from tb_funcionarios";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Funcionario funcionario = new Funcionario();
				
				funcionario.setNome(resultSet.getString("nome"));
				funcionario.setEmail(resultSet.getString("email"));
				funcionario.setCpf(resultSet.getString("cpf"));
				funcionario.setRg(resultSet.getString("rg"));
				funcionario.setEndereco(resultSet.getString("endereco"));
				funcionario.setTelefone(resultSet.getString("telefone"));
				funcionario.setCelular(resultSet.getString("celular"));
				funcionario.setNumero(resultSet.getInt("numero"));
				funcionario.setCep(resultSet.getString("cep"));
				funcionario.setDataNascimento(resultSet.getString("dataNascimento"));
				funcionario.setBairro(resultSet.getString("bairro"));
				funcionario.setCidade(resultSet.getString("cidade"));
				funcionario.setUf(resultSet.getString("uf"));
				funcionario.setComplemento(resultSet.getString("complemento"));
				funcionario.setLimite(resultSet.getDouble("limite"));				
				funcionario.setSenha(resultSet.getString("senha"));
				funcionario.setCargo(resultSet.getString("cargo"));
				funcionario.setNivelAcesso(resultSet.getString("nivelAcesso"));
				funcionario.setPisPasep(resultSet.getString("pisPasep"));
				funcionario.setSalario(resultSet.getDouble("salario"));
				funcionario.setCarteiraTrabalho(resultSet.getString("carteiraTrabalho"));
				funcionario.setEstadoCivil (resultSet.getString("estadoCivil"));
				funcionario.setJornadaTrabalho(resultSet.getString("jornadaTrabalho"));
				funcionario.setAdmissao(resultSet.getString("admissao"));
				funcionario.setDemissao(resultSet.getString("demissao"));
				funcionario.setDemissao(resultSet.getString("ativo"));
								
				
				lista.add(funcionario);
			}
			
			return lista;
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e );
			return null;
		}
	}
	
	
	public List<Funcionario> buscarFuncionarioPeloNome(String nome) {
		try {
			
			//Criando a lista
			List<Funcionario> lista = new ArrayList<>();
			
			//criar sql, organizar e executar
			String sql = "select * from tb_funcionarios where nome like ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,nome);			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Funcionario funcionario = new Funcionario();
				
				funcionario.setNome(resultSet.getString("nome"));
				funcionario.setEmail(resultSet.getString("email"));
				funcionario.setCpf(resultSet.getString("cpf"));
				funcionario.setRg(resultSet.getString("rg"));
				funcionario.setEndereco(resultSet.getString("endereco"));
				funcionario.setTelefone(resultSet.getString("telefone"));
				funcionario.setCelular(resultSet.getString("celular"));
				funcionario.setNumero(resultSet.getInt("numero"));
				funcionario.setCep(resultSet.getString("cep"));
				funcionario.setDataNascimento(resultSet.getString("dataNascimento"));
				funcionario.setBairro(resultSet.getString("bairro"));
				funcionario.setCidade(resultSet.getString("cidade"));
				funcionario.setUf(resultSet.getString("uf"));
				funcionario.setComplemento(resultSet.getString("complemento"));
				funcionario.setLimite(resultSet.getDouble("limite"));
				funcionario.setSenha(resultSet.getString("senha"));
				funcionario.setCargo(resultSet.getString("cargo"));
				funcionario.setNivelAcesso(resultSet.getString("nivelAcesso"));
				funcionario.setPisPasep(resultSet.getString("pisPasep"));
				funcionario.setSalario(resultSet.getDouble("salario"));
				funcionario.setCarteiraTrabalho(resultSet.getString("carteiraTrabalho"));
				funcionario.setEstadoCivil (resultSet.getString("estadoCivil"));
				funcionario.setJornadaTrabalho(resultSet.getString("jornadaTrabalho"));
				funcionario.setAdmissao(resultSet.getString("admissao"));
				funcionario.setDemissao(resultSet.getString("demissao"));
				funcionario.setDemissao(resultSet.getString("ativo"));
				
				lista.add(funcionario);
			}
			
			return lista;
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e );
			return null;
		}
	}
	
	public void EfetuarLogin(String email, String senha) {
		try {
			String sql = "select * from tb_funcionarios where email=? and senha=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,email);	
			preparedStatement.setString(1,senha);	
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e );
		}
	}
}
