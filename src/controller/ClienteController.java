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

public class ClienteController {
	
	private Connection connection;
	
	public ClienteController() {
		this.connection =  new ConnectionFactory().getConnection();
	}

	//metodo cadastrar cliente
	/**
	 * Método efetua um comando SQL para efetuar a inserção no banco de dados de um novo cliente.
	 * @param cliente - um objeto do tipo cliente com os atributos correspondentes
	 */
	public void cadastrarCliente(Cliente cliente) {
		try {
			
			//1 - parte criar o comando sql
			String sql = "insert into tb_clientes(nome,email,cpf,rg,endereco,telefone,celular,numero,cep,dataNascimento,bairro,cidade,uf,complemento,limite) "
					+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			//2 passo - conectar o banco de dados e organizar o comando do mesmo
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getEmail());
			preparedStatement.setString(3, cliente.getCpf());
			preparedStatement.setString(4, cliente.getRg());
			preparedStatement.setString(5, cliente.getEndereco());
			preparedStatement.setString(6, cliente.getTelefone());
			preparedStatement.setString(7, cliente.getCelular());
			preparedStatement.setInt(8, cliente.getNumero());
			preparedStatement.setString(9, cliente.getCep());
			preparedStatement.setString(10, cliente.getDataNascimento());
			preparedStatement.setString(11, cliente.getBairro());
			preparedStatement.setString(12, cliente.getCidade());
			preparedStatement.setString(13, cliente.getUf());
			preparedStatement.setString(14, cliente.getComplemento());
			preparedStatement.setDouble(15, cliente.getLimite());
			
			//3 passo - executar o comando sql
			preparedStatement.execute();
			preparedStatement.close();
			
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
			
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Erro: " + erro);
		}
	}
	
	//metodo excluir cliente cliente
	public void excluirCliente(Cliente cliente) {
		try {
					
					//1 - parte criar o comando sql
					String sql = "delete from tb_clientes where cpf=?";
					
					//2 passo - conectar o banco de dados e organizar o comando do mesmo
					PreparedStatement preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1, cliente.getCpf());
					
					//3 passo - executar o comando sql
					preparedStatement.execute();
					preparedStatement.close();
					
					JOptionPane.showMessageDialog(null, "Excluido com sucesso");

					
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, "Erro: " + erro);
				}
	}

	
	//metodo alterar cliente
	public void alterarCliente(Cliente cliente) {
		try {
				
				//1 - parte criar o comando sql
				String sql = "update tb_clientes set nome=?,email=?,cpf=?,rg=?,endereco=?,telefone=?,celular=?,numero=?,cep=?,dataNascimento=?,bairro=?,cidade=?,uf=?,complemento=?,limite=? "
						+ " where cpf=?";
				
				//2 passo - conectar o banco de dados e organizar o comando do mesmo
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, cliente.getNome());
				preparedStatement.setString(2, cliente.getEmail());
				preparedStatement.setString(3, cliente.getCpf());
				preparedStatement.setString(4, cliente.getRg());
				preparedStatement.setString(5, cliente.getEndereco());
				preparedStatement.setString(6, cliente.getTelefone());
				preparedStatement.setString(7, cliente.getCelular());
				preparedStatement.setInt(8, cliente.getNumero());
				preparedStatement.setString(9, cliente.getCep());
				preparedStatement.setString(10, cliente.getDataNascimento());
				preparedStatement.setString(11, cliente.getBairro());
				preparedStatement.setString(12, cliente.getCidade());
				preparedStatement.setString(13, cliente.getUf());
				preparedStatement.setString(14, cliente.getComplemento());
				preparedStatement.setDouble(15, cliente.getLimite());
				preparedStatement.setString(16, cliente.getCpf());
				
				//3 passo - executar o comando sql
				preparedStatement.execute();
				preparedStatement.close();
				
				JOptionPane.showMessageDialog(null, "Alterado com sucesso");
				
				
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, "Erro: " + erro);
			}
	}
	
	//metodo listar cliente
	public List<Cliente> listarCliente() {
		try {
			
			//Criando a lista
			List<Cliente> lista = new ArrayList<>();
			
			//criar sql, organizar e executar
			String sql = "select * from tb_clientes";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setNome(resultSet.getString("nome"));
				cliente.setEmail(resultSet.getString("email"));
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setRg(resultSet.getString("rg"));
				cliente.setEndereco(resultSet.getString("endereco"));
				cliente.setTelefone(resultSet.getString("telefone"));
				cliente.setCelular(resultSet.getString("celular"));
				cliente.setNumero(resultSet.getInt("numero"));
				cliente.setCep(resultSet.getString("cep"));
				cliente.setDataNascimento(resultSet.getString("dataNascimento"));
				cliente.setBairro(resultSet.getString("bairro"));
				cliente.setCidade(resultSet.getString("cidade"));
				cliente.setUf(resultSet.getString("uf"));
				cliente.setComplemento(resultSet.getString("complemento"));
				cliente.setLimite(resultSet.getDouble("limite"));
				
				lista.add(cliente);
			}
			
			return lista;
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e );
			return null;
		}
	}
	
	
	public List<Cliente> buscarClientePeloNome(String nome) {
		try {
			
			//Criando a lista
			List<Cliente> lista = new ArrayList<>();
			
			//criar sql, organizar e executar
			String sql = "select * from tb_clientes where nome like ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,nome);			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setNome(resultSet.getString("nome"));
				cliente.setEmail(resultSet.getString("email"));
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setRg(resultSet.getString("rg"));
				cliente.setEndereco(resultSet.getString("endereco"));
				cliente.setTelefone(resultSet.getString("telefone"));
				cliente.setCelular(resultSet.getString("celular"));
				cliente.setNumero(resultSet.getInt("numero"));
				cliente.setCep(resultSet.getString("cep"));
				cliente.setDataNascimento(resultSet.getString("dataNascimento"));
				cliente.setBairro(resultSet.getString("bairro"));
				cliente.setCidade(resultSet.getString("cidade"));
				cliente.setUf(resultSet.getString("uf"));
				cliente.setComplemento(resultSet.getString("complemento"));
				cliente.setLimite(resultSet.getDouble("limite"));
				
				lista.add(cliente);
			}
			
			return lista;
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e );
			return null;
		}
	}
}
