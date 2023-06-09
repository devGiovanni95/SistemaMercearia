package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import interfaces.InterfaceCliente;
import jdbc.ConnectionDataBase;
import model.Cliente;

// TODO: Auto-generated Javadoc
/**
 * The Class ClienteController.
 */
public class ClienteController implements InterfaceCliente {

	
	/**
	 * Método que cria uma conexão com banco de dados.
	 */
	ConnectionDataBase dataBase = new ConnectionDataBase();

	/**
	 * Método efetua um comando SQL para efetuar a inserção no banco de dados de um novo cliente.
	 *
	 * @param cliente - um objeto do tipo cliente com os atributos correspondentes
	 */
	public void cadastrarCliente(Cliente cliente) throws Exception {
		if(!dataBase.getConnection()) {
				throw new Exception("Falha na conexão com o banco de dados.");
			}
			try {
				String sql = "insert into tb_cliente(nome,email,cpf,rg,endereco,telefone,celular,numero,cep,data_nascimento,bairro,cidade,uf,complemento,limite) "
						+ " values(?,?,?,?,?,?,?,?,?,CONVERT(datetime, ? , 103),?,?,?,?,?)"; //103 = dd/mm/yyyy irá converter a data para o formato do banco de dados de acordo com o padrão brasileiro, de string para datetime
				
				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.preparedStatement.setString(1, cliente.getNome());
				dataBase.preparedStatement.setString(2, cliente.getEmail());
				dataBase.preparedStatement.setString(3, cliente.getCpf());
				dataBase.preparedStatement.setString(4, cliente.getRg());
				dataBase.preparedStatement.setString(5, cliente.getEndereco());
				dataBase.preparedStatement.setString(6, cliente.getTelefone());
				dataBase.preparedStatement.setString(7, cliente.getCelular());
				dataBase.preparedStatement.setInt(8, cliente.getNumero());
				dataBase.preparedStatement.setString(9, cliente.getCep());
				dataBase.preparedStatement.setString(10, cliente.getDataNascimento());
				dataBase.preparedStatement.setString(11, cliente.getBairro());
				dataBase.preparedStatement.setString(12, cliente.getCidade());
				dataBase.preparedStatement.setString(13, cliente.getUf());
				dataBase.preparedStatement.setString(14, cliente.getComplemento());
				dataBase.preparedStatement.setDouble(15, cliente.getLimite());

				dataBase.preparedStatement.execute();
			} catch (SQLException | NumberFormatException erro) {
				throw new Exception("Erro ao cadastrar o cliente: " + erro);
			} finally {
				dataBase.close();
			}
		}
	
	/**
	 * Método que a partir do código passado, executa o comando SQL para a exclusão do cliente no banco de dados.
	 *
	 * @param cliente - objeto do tipo cliente que identifica o cliente a ser excluido no banco de dados.
	 */
	public void excluirCliente(Cliente cliente) throws Exception {
		if (cliente == null) {
			throw new Exception("O cliente não pode ser nulo.");
		}

		if (!dataBase.getConnection()) {
			throw new Exception("Falha na conexão com o banco de dados.");
		}

		String sql = "DELETE FROM tb_cliente WHERE cpf=?";

		try {
			dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
			dataBase.preparedStatement.setString(1, cliente.getCpf());
			dataBase.preparedStatement.execute();
		} catch (SQLException erro) {
			throw new Exception("Erro ao excluir o cliente: " + erro);
		} finally {
			dataBase.close();
		}
	}


		
	/**
	 * Método que efetua a alteração de um cliente já cadastrado no banco de dados.A partir do id do cliente,
	 * por meio de um comando SQL.
	 *
	 * @param cliente - objeto do tipo cliente que identifica o cliente a ser alterado no banco de dados.
	 */
	public void alterarCliente(Cliente cliente) throws Exception {
		if (cliente == null) {
			throw new Exception("O cliente não pode ser nulo.");
		}

		if (!dataBase.getConnection()) {
			throw new Exception("Falha na conexão com o banco de dados.");
		}

			String sql = "update tb_cliente set nome=?,email=?,cpf=?,rg=?,endereco=?,telefone=?,celular=?,numero=?,cep=?,data_nascimento=?,bairro=?,cidade=?,uf=?,complemento=?,limite=? "
					+ " where cpf=?";

		try {
				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.preparedStatement.setString(1, cliente.getNome());
				dataBase.preparedStatement.setString(2, cliente.getEmail());
				dataBase.preparedStatement.setString(3, cliente.getCpf());
				dataBase.preparedStatement.setString(4, cliente.getRg());
				dataBase.preparedStatement.setString(5, cliente.getEndereco());
				dataBase.preparedStatement.setString(6, cliente.getTelefone());
				dataBase.preparedStatement.setString(7, cliente.getCelular());
				dataBase.preparedStatement.setInt(8, cliente.getNumero());
				dataBase.preparedStatement.setString(9, cliente.getCep());
				dataBase.preparedStatement.setString(10, cliente.getDataNascimento());
				dataBase.preparedStatement.setString(11, cliente.getBairro());
				dataBase.preparedStatement.setString(12, cliente.getCidade());
				dataBase.preparedStatement.setString(13, cliente.getUf());
				dataBase.preparedStatement.setString(14, cliente.getComplemento());
				dataBase.preparedStatement.setDouble(15, cliente.getLimite());
				dataBase.preparedStatement.setString(16, cliente.getCpf());

			dataBase.preparedStatement.execute();
		} catch (SQLException erro) {
			throw new Exception("Erro ao alterar o cliente: " + erro);
		} finally {
			dataBase.close();
		}
	}
	
	
	/**
	 * Método que cria um ArrayList do tipo cliente para listar todos os cliente do banco de dados.
	 * A partir de um comando SQL.
	 * @return - retona uma lista com todos de cliente. 
	 */
	public List<Cliente> consultarClientes() throws Exception {
		if (!dataBase.getConnection()) {
			throw new Exception("Falha na conexão com o banco de dados.");
		}

		List<Cliente> lista = new ArrayList<>();
		String sql = "select nome,email,cpf,rg,endereco,telefone,celular,numero,cep,FORMAT(data_nascimento, 'dd/MM/yyyy')as data_nascimento,bairro,cidade,uf,complemento,limite from tb_cliente";

		try {
			dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
			dataBase.resultSet = dataBase.preparedStatement.executeQuery();
				
				while(dataBase.resultSet.next()) {
					Cliente cliente = new Cliente();
					
					cliente.setNome(dataBase.resultSet.getString("nome"));
					cliente.setEmail(dataBase.resultSet.getString("email"));
					cliente.setCpf(dataBase.resultSet.getString("cpf"));
					cliente.setRg(dataBase.resultSet.getString("rg"));
					cliente.setEndereco(dataBase.resultSet.getString("endereco"));
					cliente.setTelefone(dataBase.resultSet.getString("telefone"));
					cliente.setCelular(dataBase.resultSet.getString("celular"));
					cliente.setNumero(dataBase.resultSet.getInt("numero"));
					cliente.setCep(dataBase.resultSet.getString("cep"));
					cliente.setDataNascimento(dataBase.resultSet.getString("data_nascimento"));
					cliente.setBairro(dataBase.resultSet.getString("bairro"));
					cliente.setCidade(dataBase.resultSet.getString("cidade"));
					cliente.setUf(dataBase.resultSet.getString("uf"));
					cliente.setComplemento(dataBase.resultSet.getString("complemento"));
					cliente.setLimite(dataBase.resultSet.getDouble("limite"));

					lista.add(cliente);
				}
		} catch (SQLException e) {
			throw new Exception("Erro ao consultar os clientes: " + e);
		} finally {
			dataBase.close();
		}
		return lista;
	}
	
	/**
	 * Método que cria um ArrayList do tipo cliente para listar os cliente do banco de dados que
	 *  corresponde ao nome digitado. A partir de um comando SQL.
	 *
	 * @param nome - parametro utilizado como base de pesquisa.
	 * @return the list
	 */
	public List<Cliente> consultarClientesPorNome(String nome) throws Exception {
		if (!dataBase.getConnection()) {
			throw new Exception("Falha na conexão com o banco de dados.");
		}

		List<Cliente> lista = new ArrayList<>();
		String sql = "select nome,email,cpf,rg,endereco,telefone,celular,numero,cep,FORMAT(data_nascimento, 'dd/MM/yyyy')as data_nascimento,bairro,cidade,uf,complemento,limite from tb_cliente where nome like ?";

		try {
			dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
			dataBase.preparedStatement.setString(1, "%" + nome + "%");
			dataBase.resultSet = dataBase.preparedStatement.executeQuery();

			while (dataBase.resultSet.next()) {
				Cliente cliente = new Cliente();
						
				cliente.setNome(dataBase.resultSet.getString("nome"));
				cliente.setEmail(dataBase.resultSet.getString("email"));
				cliente.setCpf(dataBase.resultSet.getString("cpf"));
				cliente.setRg(dataBase.resultSet.getString("rg"));
				cliente.setEndereco(dataBase.resultSet.getString("endereco"));
				cliente.setTelefone(dataBase.resultSet.getString("telefone"));
				cliente.setCelular(dataBase.resultSet.getString("celular"));
				cliente.setNumero(dataBase.resultSet.getInt("numero"));
				cliente.setCep(dataBase.resultSet.getString("cep"));
				cliente.setDataNascimento(dataBase.resultSet.getString("data_nascimento"));
				cliente.setBairro(dataBase.resultSet.getString("bairro"));
				cliente.setCidade(dataBase.resultSet.getString("cidade"));
				cliente.setUf(dataBase.resultSet.getString("uf"));
				cliente.setComplemento(dataBase.resultSet.getString("complemento"));
				cliente.setLimite(dataBase.resultSet.getDouble("limite"));
						
				lista.add(cliente);
			}
		} catch (SQLException e) {
			throw new Exception("Erro ao consultar os clientes por nome: " + e);
		} finally {
			dataBase.close();
		}
		return lista;
	}
	

	/**
	 * Método que cria um ArrayList do tipo cliente para listar os cliente do banco de dados que
	 *  corresponde ao nome digitado. A partir de um comando SQL.
	 *
	 * @param cpf the cpf
	 * @return the list
	 */
	public Cliente consultarClientesPorCpf(String cpf) {
		if(dataBase.getConnection()) {
				try {
		
					Cliente lista ;
		
					String sql = "select nome,email,cpf,rg,endereco,telefone,celular,numero,cep,FORMAT(data_nascimento, 'dd/MM/yyyy')as data_nascimento,bairro,cidade,uf,complemento,limite from tb_cliente where cpf like ?";
					dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
					dataBase.preparedStatement.setString(1,cpf);			
					dataBase.resultSet = dataBase.preparedStatement.executeQuery();
					Cliente cliente = new Cliente();
					
					while(dataBase.resultSet.next()) {
						
						cliente.setNome(dataBase.resultSet.getString("nome"));
						cliente.setEmail(dataBase.resultSet.getString("email"));
						cliente.setCpf(dataBase.resultSet.getString("cpf"));
						cliente.setRg(dataBase.resultSet.getString("rg"));
						cliente.setEndereco(dataBase.resultSet.getString("endereco"));
						cliente.setTelefone(dataBase.resultSet.getString("telefone"));
						cliente.setCelular(dataBase.resultSet.getString("celular"));
						cliente.setNumero(dataBase.resultSet.getInt("numero"));
						cliente.setCep(dataBase.resultSet.getString("cep"));
						cliente.setDataNascimento(dataBase.resultSet.getString("data_nascimento"));
						cliente.setBairro(dataBase.resultSet.getString("bairro"));
						cliente.setCidade(dataBase.resultSet.getString("cidade"));
						cliente.setUf(dataBase.resultSet.getString("uf"));
						cliente.setComplemento(dataBase.resultSet.getString("complemento"));
						cliente.setLimite(dataBase.resultSet.getDouble("limite"));
						
					}
					
					return cliente;
								
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Erro: " + e );
					return null;
				}finally {
					dataBase.close();
				}
			}else {
				JOptionPane.showMessageDialog(null, "Falha na conexão");
				return null;
			}
	}
}
