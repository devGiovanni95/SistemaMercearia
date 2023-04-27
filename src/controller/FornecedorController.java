package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


import jdbc.ConnectionFactory;
import model.Fornecedor;

// TODO: Auto-generated Javadoc
/**
 * The Class FornecedorController.
 */
public class FornecedorController {
	
	/** The connection. */
	private Connection connection;
	
	/**
	 * Método que cria uma conexão com banco de dados.
	 */
	public FornecedorController() {
		this.connection =  new ConnectionFactory().getConnection();
	}

	/**
	 * Método efetua um comando SQL para efetuar a inserção no banco de dados de um novo fornecedor.
	 * @param fornecedor - um objeto do tipo cliente com os atributos correspondentes
	 */
	
	public void cadastrarFornecedor(Fornecedor fornecedor) {
	    try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tb_fornecedores (nome, email, endereco, numero, cnpj, bairro, cidade, celular, telefone, cep, complemento, inscricao_estadual, razao_social, uf) "
	            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
	        
	        // Definindo os valores dos placeholders a partir do objeto Fornecedor
	        preparedStatement.setString(1, fornecedor.getNome());
	        preparedStatement.setString(2, fornecedor.getEmail());
	        preparedStatement.setString(3, fornecedor.getEndereco());
	        preparedStatement.setInt(4, fornecedor.getNumero());
	        preparedStatement.setString(5, fornecedor.getCnpj());
	        preparedStatement.setString(6, fornecedor.getBairro());
	        preparedStatement.setString(7, fornecedor.getCidade());
	        preparedStatement.setString(8, fornecedor.getCelular());
	        preparedStatement.setString(9, fornecedor.getTelefone());
	        preparedStatement.setString(10, fornecedor.getCep());
	        preparedStatement.setString(11, fornecedor.getComplemento());
	        preparedStatement.setString(12, fornecedor.getInscricaoEstadual());
	        preparedStatement.setString(13, fornecedor.getRazaoSocial());
	        preparedStatement.setString(14, fornecedor.getUf());
	        
	        preparedStatement.execute();
	        
	        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
	                    
	    } catch (SQLException | NumberFormatException erro) {
	        JOptionPane.showMessageDialog(null, "Erro: " + erro);
	    }
	}


	
	/**
	 * Método que a partir do código passado, executa o comando SQL para a exclusão do fornecedor no banco de dados.
	 * @param fornecedor - objeto do tipo fornecedor que identifica o fornecedor a ser excluido no banco de dados.
	 */
	
	public void excluirFornecedor(Fornecedor fornecedor) {
		try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM tb_fornecedores WHERE cnpj = ?")) {
			preparedStatement.setString(1, fornecedor.getCnpj());
			preparedStatement.execute();
			
			JOptionPane.showMessageDialog(null, "Excluído com sucesso");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e);
		}
	}


		
	/**
	 * Método que efetua a alteração de um fornecedor já cadastrado no banco de dados.A partir do cnpj do fornecedor, 
	 * por meio de um comando SQL.
	 * @param fornecedor - objeto do tipo fornecedor que identifica o fornecedor a ser alterado no banco de dados.
	 */
	public void alterarFornecedor(Fornecedor fornecedor) {
	    try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE tb_fornecedores SET nome = ?, email = ?, endereco = ?, numero = ?, bairro = ?, cidade = ?, celular = ?, telefone = ?, cep = ?, complemento = ?, inscricaoEstadual = ?, razao_social = ?, uf = ? WHERE cnpj = ?")) {
	       
	        preparedStatement.setString(1, fornecedor.getNome());
	        preparedStatement.setString(2, fornecedor.getEmail());
	        preparedStatement.setString(3, fornecedor.getEndereco());
	        preparedStatement.setInt(4, fornecedor.getNumero());
	        preparedStatement.setString(5, fornecedor.getBairro());
	        preparedStatement.setString(6, fornecedor.getCidade());
	        preparedStatement.setString(7, fornecedor.getCelular());
	        preparedStatement.setString(8, fornecedor.getTelefone());
	        preparedStatement.setString(9, fornecedor.getCep());
	        preparedStatement.setString(10, fornecedor.getComplemento()); 
	        preparedStatement.setString(11, fornecedor.getInscricaoEstadual()); 
	        preparedStatement.setString(12, fornecedor.getRazaoSocial()); 
	        preparedStatement.setString(13, fornecedor.getUf()); 
	        preparedStatement.setString(14, fornecedor.getCnpj()); 
	        
	        preparedStatement.executeUpdate();
	        
	        JOptionPane.showMessageDialog(null, "Alterado com sucesso");
	    } catch (SQLException | NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Erro: " + e);
	    }
	}


	
	
	/**
	 * Método que cria um ArrayList do tipo fornecedor para listar todos os fornecedores do banco de dados.
	 * A partir de um comando SQL.
	 * @return - retorna uma lista com todos os fornecedores. 
	 */
	public List<Fornecedor> consultarFornecedores() {
	    List<Fornecedor> lista = new ArrayList<>();
	    String sql = "SELECT * FROM tb_fornecedores";
	    
	    try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
	         ResultSet resultSet = preparedStatement.executeQuery()) {
	        
	        while (resultSet.next()) {
	            Fornecedor fornecedor = new Fornecedor();
	            fornecedor.setNome(resultSet.getString("nome"));
	            fornecedor.setEmail(resultSet.getString("email"));
	            fornecedor.setEndereco(resultSet.getString("endereco"));
	            fornecedor.setNumero(resultSet.getInt("numero"));
	            fornecedor.setCnpj(resultSet.getString("cnpj"));
	            fornecedor.setBairro(resultSet.getString("bairro"));
	            fornecedor.setCidade(resultSet.getString("cidade"));
	            fornecedor.setCelular(resultSet.getString("celular"));
	            fornecedor.setTelefone(resultSet.getString("telefone"));
	            fornecedor.setCep(resultSet.getString("cep"));
	            fornecedor.setComplemento(resultSet.getString("complemento"));
	            fornecedor.setInscricaoEstadual(resultSet.getString("inscricaoEstadual"));
	            fornecedor.setRazaoSocial(resultSet.getString("razao_social"));
	            fornecedor.setUf(resultSet.getString("uf"));

	            lista.add(fornecedor);
	        }
	        
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Erro ao listar fornecedores: " + e);
	    }
	    
	    return lista;
	}

	
	/**
	 * Método que cria um ArrayList do tipo fornecedor para listar os fornecedores do banco de dados que
	 *  corresponde ao nome digitado. A partir de um comando SQL.
	 * @param nome - parametro utilizado como base de pesquisa. 
	 * @return - retorna uma lista com os resultados encontrados.
	 */
	public List<Fornecedor> consultarFornecedorPorNome(String nome) {
	    List<Fornecedor> lista = new ArrayList<>();
	    String sql = "SELECT * FROM tb_fornecedores WHERE nome LIKE ?";
	    
	    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	        preparedStatement.setString(1, "%" + nome + "%");
	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	        while (resultSet.next()) {
	            Fornecedor fornecedor = new Fornecedor();
	            fornecedor.setNome(resultSet.getString("nome"));
	            fornecedor.setEmail(resultSet.getString("email"));
	            fornecedor.setEndereco(resultSet.getString("endereco"));
	            fornecedor.setNumero(resultSet.getInt("numero"));
	            fornecedor.setCnpj(resultSet.getString("cnpj"));
	            fornecedor.setBairro(resultSet.getString("bairro"));
	            fornecedor.setCidade(resultSet.getString("cidade"));
	            fornecedor.setCelular(resultSet.getString("celular"));
	            fornecedor.setTelefone(resultSet.getString("telefone"));
	            fornecedor.setCep(resultSet.getString("cep"));
	            fornecedor.setComplemento(resultSet.getString("complemento"));
	            fornecedor.setInscricaoEstadual(resultSet.getString("inscricaoEstadual"));
	            fornecedor.setRazaoSocial(resultSet.getString("razao_social"));
	            fornecedor.setUf(resultSet.getString("uf"));

	            lista.add(fornecedor);
	        }
	        
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Erro ao buscar fornecedor por nome: " + e);
	    }
	    
	    return lista;
	}

}
