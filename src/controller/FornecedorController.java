package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import interfaces.InterfaceFornecedor;
import jdbc.ConnectionDataBase;
import model.Fornecedor;

// TODO: Auto-generated Javadoc
/**
 * The Class FornecedorController.
 */
public class FornecedorController implements InterfaceFornecedor {

	/** The data base. */
	ConnectionDataBase dataBase = new ConnectionDataBase();

	/**
	 * Método efetua um comando SQL para efetuar a inserção no banco de dados de um
	 * novo fornecedor.
	 *
	 * @param fornecedor - um objeto do tipo cliente com os atributos
	 *                   correspondentes
	 * @throws Exception - caso ocorra algum erro durante a inserção no banco de
	 *                   dados.
	 */
	public void cadastrarFornecedor(Fornecedor fornecedor) throws Exception {
		if (!dataBase.getConnection()) {
			throw new Exception("Falha na conexão com o banco de dados.");
		}
		try {
			String sql = "INSERT INTO tb_fornecedor (nome, email, endereco, numero, cnpj, bairro, cidade, celular, telefone, cep, complemento, inscricao_estadual, razao_social, uf) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
			dataBase.preparedStatement.setString(1, fornecedor.getNome());
			dataBase.preparedStatement.setString(2, fornecedor.getEmail());
			dataBase.preparedStatement.setString(3, fornecedor.getEndereco());
			dataBase.preparedStatement.setInt(4, fornecedor.getNumero());
			dataBase.preparedStatement.setString(5, fornecedor.getCnpj());
			dataBase.preparedStatement.setString(6, fornecedor.getBairro());
			dataBase.preparedStatement.setString(7, fornecedor.getCidade());
			dataBase.preparedStatement.setString(8, fornecedor.getCelular());
			dataBase.preparedStatement.setString(9, fornecedor.getTelefone());
			dataBase.preparedStatement.setString(10, fornecedor.getCep());
			dataBase.preparedStatement.setString(11, fornecedor.getComplemento());
			dataBase.preparedStatement.setString(12, fornecedor.getInscricaoEstadual());
			dataBase.preparedStatement.setString(13, fornecedor.getRazaoSocial());
			dataBase.preparedStatement.setString(14, fornecedor.getUf());

			dataBase.preparedStatement.execute();
		} catch (SQLException | NumberFormatException erro) {
			throw new Exception("Erro ao cadastrar o fornecedor: " + erro);
		} finally {
			dataBase.close();
		}
	}

	/**
	 * Método que a partir do código passado, executa o comando SQL para a exclusão
	 * do fornecedor no banco de dados.
	 *
	 * @param fornecedor - objeto do tipo fornecedor que identifica o fornecedor a
	 *                   ser excluido no banco de dados.
	 */

	public void excluirFornecedor(Fornecedor fornecedor) throws Exception {
		if (!dataBase.getConnection()) {
			throw new Exception("Falha na conexão com o banco de dados.");
		}
		try {
			String sql = "DELETE FROM tb_fornecedor WHERE cnpj = ?";
			dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
			dataBase.preparedStatement.setString(1, fornecedor.getCnpj());
			dataBase.preparedStatement.execute();
		} catch (SQLException e) {
			throw new Exception("Erro ao excluir o fornecedor: " + e);
		} finally {
			dataBase.close();
		}
	}

	/**
	 * Método que efetua a alteração de um fornecedor já cadastrado no banco de
	 * dados.A partir do cnpj do fornecedor,
	 * por meio de um comando SQL.
	 *
	 * @param fornecedor - objeto do tipo fornecedor que identifica o fornecedor a
	 *                   ser alterado no banco de dados.
	 */

	public void alterarFornecedor(Fornecedor fornecedor) throws Exception {
		if (!dataBase.getConnection()) {
			throw new Exception("Falha na conexão com o banco de dados.");
		}
		try {
			String sql = "UPDATE tb_fornecedor SET nome = ?, email = ?, endereco = ?, numero = ?, bairro = ?, cidade = ?, celular = ?,"
					+ " telefone = ?, cep = ?, complemento = ?, inscricao_estadual = ?, razao_social = ?, uf = ? WHERE cnpj = ?";
			dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
			dataBase.preparedStatement.setString(1, fornecedor.getNome());
			dataBase.preparedStatement.setString(2, fornecedor.getEmail());
			dataBase.preparedStatement.setString(3, fornecedor.getEndereco());
			dataBase.preparedStatement.setInt(4, fornecedor.getNumero());
			dataBase.preparedStatement.setString(5, fornecedor.getBairro());
			dataBase.preparedStatement.setString(6, fornecedor.getCidade());
			dataBase.preparedStatement.setString(7, fornecedor.getCelular());
			dataBase.preparedStatement.setString(8, fornecedor.getTelefone());
			dataBase.preparedStatement.setString(9, fornecedor.getCep());
			dataBase.preparedStatement.setString(10, fornecedor.getComplemento());
			dataBase.preparedStatement.setString(11, fornecedor.getInscricaoEstadual());
			dataBase.preparedStatement.setString(12, fornecedor.getRazaoSocial());
			dataBase.preparedStatement.setString(13, fornecedor.getUf());
			dataBase.preparedStatement.setString(14, fornecedor.getCnpj());

			dataBase.preparedStatement.executeUpdate();
		} catch (SQLException | NumberFormatException erro) {
			throw new Exception("Erro ao alterar o fornecedor: " + erro);
		} finally {
			dataBase.close();
		}
	}

	/**
	 * Método que cria um ArrayList do tipo fornecedor para listar todos os
	 * fornecedores do banco de dados.
	 * A partir de um comando SQL.
	 * 
	 * @return - retorna uma lista com todos os fornecedores.
	 */

	public List<Fornecedor> consultarFornecedores() throws Exception {
		if (!dataBase.getConnection()) {
			throw new Exception("Falha na conexão com o banco de dados.");
		}
		try {
			List<Fornecedor> lista = new ArrayList<>();
			String sql = "SELECT * FROM tb_fornecedor";
			dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
			dataBase.resultSet = dataBase.preparedStatement.executeQuery();

			while (dataBase.resultSet.next()) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setNome(dataBase.resultSet.getString("nome"));
				fornecedor.setEmail(dataBase.resultSet.getString("email"));
				fornecedor.setEndereco(dataBase.resultSet.getString("endereco"));
				fornecedor.setNumero(dataBase.resultSet.getInt("numero"));
				fornecedor.setCnpj(dataBase.resultSet.getString("cnpj"));
				fornecedor.setBairro(dataBase.resultSet.getString("bairro"));
				fornecedor.setCidade(dataBase.resultSet.getString("cidade"));
				fornecedor.setCelular(dataBase.resultSet.getString("celular"));
				fornecedor.setTelefone(dataBase.resultSet.getString("telefone"));
				fornecedor.setCep(dataBase.resultSet.getString("cep"));
				fornecedor.setComplemento(dataBase.resultSet.getString("complemento"));
				fornecedor.setInscricaoEstadual(dataBase.resultSet.getString("inscricao_estadual"));
				fornecedor.setRazaoSocial(dataBase.resultSet.getString("razao_social"));
				fornecedor.setUf(dataBase.resultSet.getString("uf"));

				lista.add(fornecedor);
			}
			return lista;
		} catch (SQLException e) {
			throw new Exception("Erro ao listar fornecedores: " + e);
		} finally {
			dataBase.close();
		}
	}

	/*
	 * Método que cria um ArrayList do tipo fornecedor para listar todos os
	 * fornecedores do banco de dados em um ComboBox.
	 * 
	 * @return - retorna uma lista com todos os fornecedores.
	 */
	public Vector<Fornecedor> consultarFornecedoresComboBox() {
		Vector<Fornecedor> fornecedores = new Vector<Fornecedor>();
		if (dataBase.getConnection()) {
			try {
				String sql = "SELECT * FROM tb_fornecedor";
				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.resultSet = dataBase.preparedStatement.executeQuery();

				while (dataBase.resultSet.next()) {
					Fornecedor fornecedor = new Fornecedor();
					fornecedor.setNome(dataBase.resultSet.getString("nome"));
					fornecedor.setEmail(dataBase.resultSet.getString("email"));
					fornecedor.setEndereco(dataBase.resultSet.getString("endereco"));
					fornecedor.setNumero(dataBase.resultSet.getInt("numero"));
					fornecedor.setCnpj(dataBase.resultSet.getString("cnpj"));
					fornecedor.setBairro(dataBase.resultSet.getString("bairro"));
					fornecedor.setCidade(dataBase.resultSet.getString("cidade"));
					fornecedor.setCelular(dataBase.resultSet.getString("celular"));
					fornecedor.setTelefone(dataBase.resultSet.getString("telefone"));
					fornecedor.setCep(dataBase.resultSet.getString("cep"));
					fornecedor.setComplemento(dataBase.resultSet.getString("complemento"));
					fornecedor.setInscricaoEstadual(dataBase.resultSet.getString("inscricao_estadual"));
					fornecedor.setRazaoSocial(dataBase.resultSet.getString("razao_social"));
					fornecedor.setUf(dataBase.resultSet.getString("uf"));

					fornecedores.add(fornecedor);
				}

				// return lista;
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao listar fornecedores: " + e);
			} finally {
				dataBase.close();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
		}
		return fornecedores;
	}

	/**
	 * Método que cria um ArrayList do tipo fornecedor para listar os fornecedores
	 * do banco de dados que
	 * corresponde ao nome digitado. A partir de um comando SQL.
	 * 
	 * @param nome - parametro utilizado como base de pesquisa.
	 * @return - retorna uma lista com os resultados encontrados.
	 */
	public List<Fornecedor> consultarFornecedoresPorNome(String nome) throws Exception {
		if (!dataBase.getConnection()) {
			throw new Exception("Falha na conexão com o banco de dados.");
		}

		try {
			List<Fornecedor> lista = new ArrayList<>();
			String sql = "SELECT * FROM tb_fornecedor WHERE nome LIKE ?";
			dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
			dataBase.preparedStatement.setString(1, "%" + nome + "%");
			dataBase.resultSet = dataBase.preparedStatement.executeQuery();

			while (dataBase.resultSet.next()) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setNome(dataBase.resultSet.getString("nome"));
				fornecedor.setEmail(dataBase.resultSet.getString("email"));
				fornecedor.setEndereco(dataBase.resultSet.getString("endereco"));
				fornecedor.setNumero(dataBase.resultSet.getInt("numero"));
				fornecedor.setCnpj(dataBase.resultSet.getString("cnpj"));
				fornecedor.setBairro(dataBase.resultSet.getString("bairro"));
				fornecedor.setCidade(dataBase.resultSet.getString("cidade"));
				fornecedor.setCelular(dataBase.resultSet.getString("celular"));
				fornecedor.setTelefone(dataBase.resultSet.getString("telefone"));
				fornecedor.setCep(dataBase.resultSet.getString("cep"));
				fornecedor.setComplemento(dataBase.resultSet.getString("complemento"));
				fornecedor.setInscricaoEstadual(dataBase.resultSet.getString("inscricao_estadual"));
				fornecedor.setRazaoSocial(dataBase.resultSet.getString("razao_social"));
				fornecedor.setUf(dataBase.resultSet.getString("uf"));

				lista.add(fornecedor);
			}
			return lista;
		} catch (SQLException e) {
			throw new Exception("Erro ao buscar fornecedor por nome: " + e);
		} finally {
			dataBase.close();
		}
	}

	public List<Fornecedor> consultarFornecedoresPorCnpj(String cnpj) throws Exception {
		List<Fornecedor> lista = new ArrayList<>();
		if (dataBase.getConnection()) {
			try {
				String sql = "SELECT * FROM tb_fornecedor WHERE nome cnpj ?";
				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.preparedStatement.setString(1, "%" + cnpj + "%");
				dataBase.resultSet = dataBase.preparedStatement.executeQuery();

				while (dataBase.resultSet.next()) {
					Fornecedor fornecedor = new Fornecedor();
					fornecedor.setNome(dataBase.resultSet.getString("nome"));
					fornecedor.setEmail(dataBase.resultSet.getString("email"));
					fornecedor.setEndereco(dataBase.resultSet.getString("endereco"));
					fornecedor.setNumero(dataBase.resultSet.getInt("numero"));
					fornecedor.setCnpj(dataBase.resultSet.getString("cnpj"));
					fornecedor.setBairro(dataBase.resultSet.getString("bairro"));
					fornecedor.setCidade(dataBase.resultSet.getString("cidade"));
					fornecedor.setCelular(dataBase.resultSet.getString("celular"));
					fornecedor.setTelefone(dataBase.resultSet.getString("telefone"));
					fornecedor.setCep(dataBase.resultSet.getString("cep"));
					fornecedor.setComplemento(dataBase.resultSet.getString("complemento"));
					fornecedor.setInscricaoEstadual(dataBase.resultSet.getString("inscricao_estadual"));
					fornecedor.setRazaoSocial(dataBase.resultSet.getString("razao_social"));
					fornecedor.setUf(dataBase.resultSet.getString("uf"));

					lista.add(fornecedor);
				}

				return lista;
			} catch (SQLException e) {
				throw new Exception("Erro ao buscar fornecedor por nome: " + e);
			} finally {
				dataBase.close();
			}
		}
		return lista;
	}
}
