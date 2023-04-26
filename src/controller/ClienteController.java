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

// TODO: Auto-generated Javadoc
/**
 * The Class ClienteController.
 */
public class ClienteController {
	
	/** The connection. */
	private Connection connection;
	
	/**
	 * Método que cria uma conexão com banco de dados.
	 */
	public ClienteController() {
		this.connection =  new ConnectionFactory().getConnection();
	}

	/**
	 * Método efetua um comando SQL para efetuar a inserção no banco de dados de um novo cliente.
	 * @param cliente - um objeto do tipo cliente com os atributos correspondentes
	 */
	public void cadastrarCliente(Cliente cliente) {
		try {
			
			String sql = "insert into tb_clientes(nome,email,cpf,rg,endereco,telefone,celular,numero,cep,dataNascimento,bairro,cidade,uf,complemento,limite) "
					+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
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
			
			preparedStatement.execute();
			preparedStatement.close();
			
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
						
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Erro: " + erro);
		} catch(NumberFormatException erro) {
			JOptionPane.showMessageDialog(null, "Erro: " + erro);
		}
	}
	
	/**
	 * Método que a partir do código passado, executa o comando SQL para a exclusão do cliente no banco de dados.
	 * @param cliente - objeto do tipo cliente que identifica o cliente a ser excluido no banco de dados.
	 */
	public void excluirCliente(Cliente cliente) {
		try {
					
					String sql = "delete from tb_clientes where cpf=?";
					
					PreparedStatement preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1, cliente.getCpf());
					
					preparedStatement.execute();
					preparedStatement.close();
					
					JOptionPane.showMessageDialog(null, "Excluido com sucesso");
					
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, "Erro: " + erro);
				}
	}

		
	/**
	 * Método que efetua a alteração de um cliente já cadastrado no banco de dados.A partir do id do cliente, 
	 * por meio de um comando SQL.
	 * @param cliente - objeto do tipo cliente que identifica o cliente a ser alterado no banco de dados.
	 */
	public void alterarCliente(Cliente cliente) {
		try {
				
				String sql = "update tb_clientes set nome=?,email=?,cpf=?,rg=?,endereco=?,telefone=?,celular=?,numero=?,cep=?,dataNascimento=?,bairro=?,cidade=?,uf=?,complemento=?,limite=? "
						+ " where cpf=?";
				
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
				
				preparedStatement.execute();
				preparedStatement.close();
				
				JOptionPane.showMessageDialog(null, "Alterado com sucesso");
								
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, "Erro: " + erro);
			}
	}
	
	
	/**
	 * Método que cria um ArrayList do tipo cliente para listar todos os cliente do banco de dados.
	 * A partir de um comando SQL.
	 * @return - retona uma lista com todos de cliente. 
	 */
	public List<Cliente> consultarCliente() {
		try {
			
			List<Cliente> lista = new ArrayList<>();
			
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
	
	/**
	 * Método que cria um ArrayList do tipo cliente para listar os cliente do banco de dados que
	 *  corresponde ao nome digitado. A partir de um comando SQL.
	 *
	 * @param nome - parametro utilizado como base de pesquisa.
	 * @return the list
	 */
	public List<Cliente> consultarClientesPorNome(String nome) {
		try {

			List<Cliente> lista = new ArrayList<>();

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
