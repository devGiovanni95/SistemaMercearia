package controller;

import interfaces.InterfaceProduto;
import jdbc.ConnectionDataBase;
import model.Produto;
import model.SubCategoria;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ProdutosController.
 */
public final class ProdutosController implements InterfaceProduto {

	private static final String ERROR_CONNECTION = "Falha na conexão com o banco de dados.";
	private final SubCategoriaController subCategoriaController = new SubCategoriaController();
	private final ConnectionDataBase dataBase = new ConnectionDataBase();


	private void checkDatabaseConnection() throws Exception {
		if (!dataBase.getConnection()) {
			throw new Exception(ERROR_CONNECTION);
		}
	}
	/**
	 * Método efetua um comando SQL para efetuar a inserção no banco de dados de um
	 * novo produto.
	 *
	 * @param produto - um objeto do tipo Produtos com os atributos correspondentes
	 */
	public void cadastrarProduto(Produto produto) throws Exception {
		String sql = "insert into tb_produto (descricao, codigo_barras, marca, cod_subcategoria, unidade_medida, quantidade, data_fabricacao, data_validade, lote, ipi, icms, margem_lucro, preco_custo, preco_final) VALUES (?, ?, ?, ?, ?, ?, CONVERT(datetime, ? , 103), CONVERT(datetime, ? , 103), ?, ?, ?, ?, ?, ?)";
		executarQueryProduto(produto, sql);
	}

	/**
	 * Método que efetua a alteração de um produto já cadastrado no banco de dados.A
	 * partir do id do produto, por meio de um comando SQL.
	 *
	 * @param produto - objeto do tipo Produtos que identifica o produto a ser
	 *                alterado no banco de dados.
	 */
	public void alterarProduto(Produto produto) throws Exception {
		String sql = "UPDATE tb_produto SET descricao = ?, codigo_barras = ?, marca = ?, cod_subcategoria = ?, unidade_medida = ?, quantidade = ?, data_fabricacao = CONVERT(datetime, ? , 103), data_validade = CONVERT(datetime, ? , 103), lote = ?, ipi = ?, icms = ?, margem_lucro = ?, preco_custo = ?, preco_final = ? WHERE codigo_barras = ?";
		executarQueryProduto(produto, sql);
	}

	private void executarQueryProduto(Produto produto, String sql) throws Exception {
		checkDatabaseConnection();
		try (PreparedStatement stmt = dataBase.con.prepareStatement(sql)) {
			preencherPreparedStatement(produto, stmt, sql);
			stmt.execute();
		} catch (SQLException | NumberFormatException erro) {
			throw new Exception("Erro ao executar operação no produto: " + erro);
		} finally {
			dataBase.close();
		}
	}

	private void preencherPreparedStatement(Produto produto, PreparedStatement stmt, String sql) throws SQLException {
		stmt.setString(1, produto.getDescricao());
		stmt.setString(2, produto.getCodigoDeBarras());
		stmt.setString(3, produto.getMarca());
		stmt.setInt(4, produto.getSubCategoria().getCodigo());
		stmt.setString(5, produto.getUnidadeDeMedida());
		stmt.setDouble(6, produto.getQuantidade());
		stmt.setString(7, produto.getDataFabricacao());
		stmt.setString(8, produto.getDataValidade());
		stmt.setString(9, produto.getLote());
		stmt.setDouble(10, produto.getIpi());
		stmt.setDouble(11, produto.getIcms());
		stmt.setDouble(12, produto.getMargemLucro());
		stmt.setDouble(13, produto.getPrecoCusto());
		stmt.setDouble(14, produto.getPrecoFinal());
	//	if (sql.equals(UPDATE_SQL)) { // não funciona
		if (sql.contains("UPDATE")) {
			stmt.setString(15, produto.getCodigoDeBarras());
		}
	}
	/**
	 * Método que a partir do código passado, executa o comando SQL para a exclusão
	 * do produto no banco de dados.
	 *
	 * @param produto - objeto do tipo Produtos que identifica o produto a ser
	 *                excluido no banco de dados.
	 */
	public void excluirProduto(Produto produto) throws Exception {
		checkDatabaseConnection();
		String sql = "DELETE FROM tb_produto WHERE codigo_barras = ?";
		try {
			PreparedStatement preparedStatement = dataBase.con.prepareStatement(sql);
			preparedStatement.setString(1, produto.getCodigoDeBarras());
			preparedStatement.execute();
		} catch (SQLException e) {
			throw new Exception("Erro ao excluir o produto: " + e);
		} finally {
			dataBase.close();
		}
	}

	/**
	 * Método que cria um ArrayList do tipo Produtos para listar todos os produtos
	 * do banco de dados. A partir de um comando SQL.
	 *
	 * @return
	 * @throws Exception
	 */
	public List<Produto> consultarProdutos() throws Exception {
		checkDatabaseConnection();
		var lista = new ArrayList<Produto>();
		String sql = "select codigo_barras, descricao, marca, cod_subcategoria, unidade_medida, quantidade, FORMAT(data_fabricacao, 'dd/MM/yyyy')as data_fabricacao, FORMAT(data_validade, 'dd/MM/yyyy')as data_validade, lote, ipi, icms, margem_lucro, preco_custo, preco_final from tb_produto";
		try {
			PreparedStatement preparedStatement = dataBase.con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				lista.add(criarProdutoDoResultSet(resultSet));
			}
			return lista;
		} catch (SQLException e) {
			throw new Exception("Erro ao listar produtos: " + e);
		} finally {
			dataBase.close();
		}
	}

	/**
	 * Método que cria um ArrayList do tipo Produtos para listar os produtos do
	 * banco de dados que corresponde ao nome digitado. A partir de um comando SQL.
	 *
	 * @param nome - parametro utilizado como base de pesquisa.
	 * @return - retorna uma lista com os resultados encontrados.
	 * @throws Exception
	 */
	public List<Produto> consultarProdutosPorNome(String nome) throws Exception {
		checkDatabaseConnection();
		var lista = new ArrayList<Produto>();
		String sql = "select codigo_barras, descricao, marca, cod_subcategoria, unidade_medida, quantidade, FORMAT(data_fabricacao, 'dd/MM/yyyy')as data_fabricacao, FORMAT(data_validade, 'dd/MM/yyyy')as data_validade, lote, ipi, icms, margem_lucro, preco_custo, preco_final from tb_produto where descricao like ?";
		try {
			PreparedStatement preparedStatement = dataBase.con.prepareStatement(sql);
			preparedStatement.setString(1, "%" + nome + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				lista.add(criarProdutoDoResultSet(resultSet));
			}
			return lista;
		} catch (SQLException e) {
			throw new Exception("Erro ao buscar produto por nome: " + e);
		} finally {
			dataBase.close();
		}
	}

	private Produto criarProdutoDoResultSet(ResultSet resultSet) throws SQLException, Exception {
		var produto = new Produto();
		var subCategoria = subCategoriaController.consultarSubCategoriasPorId(resultSet.getInt("cod_subcategoria"));
		produto.setCodigoDeBarras(resultSet.getString("codigo_barras"));
		produto.setDescricao(resultSet.getString("descricao"));
		produto.setMarca(resultSet.getString("marca"));
		produto.setSubCategoria(subCategoria);
		produto.setUnidadeDeMedida(resultSet.getString("unidade_medida"));
		produto.setQuantidade(resultSet.getDouble("quantidade"));
		produto.setDataFabricacao(resultSet.getString("data_fabricacao"));
		produto.setDataValidade(resultSet.getString("data_validade"));
		produto.setLote(resultSet.getString("lote"));
		produto.setIpi(resultSet.getDouble("ipi"));
		produto.setIcms(resultSet.getDouble("icms"));
		produto.setMargemLucro(resultSet.getDouble("margem_lucro"));
		produto.setPrecoCusto(resultSet.getDouble("preco_custo"));
		produto.setPrecoFinal(resultSet.getDouble("preco_final"));
		return produto;
	}

	/**
	 * Consultar produtos por codigo barras.
	 *
	 * @param codigoDeBarras the codigo de barras
	 * @return the produto
	 */
	public Produto consultarProdutosPorCodigoBarras(String codigoDeBarras) {
		Produto produto = new Produto();
		boolean exibiuErro = false;
		if (dataBase.getConnection()) {
			try {

				String sql = "select descricao, codigo_barras,unidade_medida, quantidade, data_fabricacao,"
						+ " preco_final " + "from tb_produto where codigo_barras = ?";

				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.preparedStatement.setString(1, codigoDeBarras);
				dataBase.resultSet = dataBase.preparedStatement.executeQuery();
				SubCategoria subCategoria = new SubCategoria();

				if (dataBase.resultSet.next()) {

					// produto.setCodigo(dataBase.resultSet.getInt("codigo"));
					produto.setDescricao(dataBase.resultSet.getString("descricao"));
					produto.setCodigoDeBarras(dataBase.resultSet.getString("codigo_barras"));
					produto.setUnidadeDeMedida(dataBase.resultSet.getString("unidade_medida"));
					produto.setQuantidade(dataBase.resultSet.getDouble("quantidade"));
					produto.setPrecoFinal(dataBase.resultSet.getDouble("preco_final"));
				}

			} catch (SQLException e) {
				if (!exibiuErro) {
					JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + e);
					// return null;
					exibiuErro = true;
				}
			} catch (NullPointerException e) {
				dataBase.close();
			} finally {
				dataBase.close();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
		}
		return produto;
	}


	public Produto consultarProdutosPorCodigoBarrasCompleto(String codigoDeBarras) {
		Produto produto = new Produto();
		boolean exibiuErro = false;
		if (dataBase.getConnection()) {
			try {

				String sql = "select * from tb_produto where codigo_barras = ?";

				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.preparedStatement.setString(1, codigoDeBarras);
				dataBase.resultSet = dataBase.preparedStatement.executeQuery();
				SubCategoria subCategoria = new SubCategoria();
				// SubCategoria subCategoria = new SubCategoria();
				SubCategoriaController subCategoriaController = new SubCategoriaController();

				if (dataBase.resultSet.next()) {
					produto.setDescricao(dataBase.resultSet.getString("descricao"));
					produto.setCodigoDeBarras(dataBase.resultSet.getString("codigo_barras"));
					produto.setMarca(dataBase.resultSet.getString("marca"));
					subCategoria = subCategoriaController
							.consultarSubCategoriasPorId(dataBase.resultSet.getInt("cod_subcategoria"));
					produto.setSubCategoria(subCategoria);
					produto.setUnidadeDeMedida(dataBase.resultSet.getString("unidade_medida"));
					produto.setQuantidade(dataBase.resultSet.getDouble("quantidade"));
					produto.setDataFabricacao(dataBase.resultSet.getString("data_fabricacao"));
					produto.setDataValidade(dataBase.resultSet.getString("data_validade"));
					produto.setLote(dataBase.resultSet.getString("lote"));
					produto.setIpi(dataBase.resultSet.getDouble("ipi"));
					produto.setIcms(dataBase.resultSet.getDouble("icms"));
					produto.setMargemLucro(dataBase.resultSet.getDouble("margem_lucro"));
					produto.setPrecoCusto(dataBase.resultSet.getDouble("preco_custo"));
					produto.setPrecoFinal(dataBase.resultSet.getDouble("preco_final"));
				}

			} catch (SQLException e) {
				if (!exibiuErro) {
					JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + e);
					// return null;
					exibiuErro = true;
				}
			} catch (NullPointerException e) {
				dataBase.close();
			} finally {
				dataBase.close();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
		}
		return produto;
	}

	public void alterarQuantidade(Produto produto) {
		if (dataBase.getConnection()) {
			try {
				String sql = "UPDATE tb_produto SET quantidade = ? WHERE codigo_barras = ?";

				dataBase.preparedStatement.setDouble(1, produto.getQuantidade());
				dataBase.preparedStatement.setString(2, produto.getCodigoDeBarras());

				dataBase.preparedStatement.executeUpdate();

				JOptionPane.showMessageDialog(null, "Produto alterado com sucesso");

			} catch (SQLException | NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Erro: " + e);
			} finally {
				dataBase.close();
			}

		} else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
		}
	}

}