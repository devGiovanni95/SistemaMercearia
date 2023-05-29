package controller;

import interfaces.InterfaceProduto;
import jdbc.ConnectionDataBase;
import model.Produto;
import model.SubCategoria;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.CadastroProdutoFornecedorEstoque;

// TODO: Auto-generated Javadoc
/**
 * The Class ProdutosController.
 */
public class ProdutosController implements InterfaceProduto {

	/** The sub categoria controller. */
	private SubCategoriaController subCategoriaController;

	/** The data base. */
	ConnectionDataBase dataBase = new ConnectionDataBase();

	/*
	 * public SubCategoria buscarSubCategoriaPorId(int id) { return
	 * this.subCategoriaController.buscarSubCategoriaPorId(id); }
	 */

	/**
	 * Método efetua um comando SQL para efetuar a inserção no banco de dados de um
	 * novo produto.
	 *
	 * @param produto - um objeto do tipo Produtos com os atributos correspondentes
	 */

	public void cadastrarProduto(Produto produto) throws Exception {
		if (!dataBase.getConnection()) {
			throw new Exception("Falha na conexão com o banco de dados.");
		}

		String sql = "insert into tb_produto (descricao, codigo_barras, marca, cod_subcategoria, unidade_medida, quantidade, data_fabricacao, data_validade, lote, ipi, icms, margem_lucro, preco_custo, preco_final) VALUES (?, ?, ?, ?, ?, ?, CONVERT(datetime, ? , 103), CONVERT(datetime, ? , 103), ?, ?, ?, ?, ?, ?)";

		try {
			dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
			dataBase.preparedStatement.setString(1, produto.getDescricao());
			dataBase.preparedStatement.setString(2, produto.getCodigoDeBarras());
			dataBase.preparedStatement.setString(3, produto.getMarca());
			dataBase.preparedStatement.setInt(4, produto.getSubCategoria().getCodigo());
			dataBase.preparedStatement.setString(5, produto.getUnidadeDeMedida());
			dataBase.preparedStatement.setDouble(6, produto.getQuantidade());
			dataBase.preparedStatement.setString(7, produto.getDataFabricacao());
			dataBase.preparedStatement.setString(8, produto.getDataValidade());
			//dataBase.preparedStatement.setDate(7, new java.sql.Date(format.parse(produto.getDataFabricacao()).getTime()));
			//dataBase.preparedStatement.setDate(8, new java.sql.Date(format.parse(produto.getDataValidade()).getTime()));
			dataBase.preparedStatement.setString(9, produto.getLote());
			dataBase.preparedStatement.setDouble(10, produto.getIpi());
			dataBase.preparedStatement.setDouble(11, produto.getIcms());
			dataBase.preparedStatement.setDouble(12, produto.getMargemLucro());
			dataBase.preparedStatement.setDouble(13, produto.getPrecoCusto());
			dataBase.preparedStatement.setDouble(14, produto.getPrecoFinal());

			dataBase.preparedStatement.execute();

		} catch (SQLException | NumberFormatException erro) {
			throw new Exception("Erro ao cadastrar o produto: " + erro);
		} finally {
			dataBase.close();
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
		if (!dataBase.getConnection()) {
			throw new Exception("Falha na conexão com o banco de dados.");
		}

		String sql = "DELETE FROM tb_produto WHERE codigo_barras = ?";

		try {
			dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
			dataBase.preparedStatement.setString(1, produto.getCodigoDeBarras());
			dataBase.preparedStatement.execute();

		} catch (SQLException e) {
			throw new Exception("Erro ao excluir o produto: " + e);
		} finally {
			dataBase.close();
		}
	}

	/**
	 * Método que efetua a alteração de um produto já cadastrado no banco de dados.A
	 * partir do id do produto, por meio de um comando SQL.
	 *
	 * @param produto - objeto do tipo Produtos que identifica o produto a ser
	 *                alterado no banco de dados.
	 */
	public void alterarProduto(Produto produto) throws Exception {
		if (!dataBase.getConnection()) {
			throw new Exception("Falha na conexão com o banco de dados.");
		}

		try {
			String sql = "UPDATE tb_produto SET descricao = ?,  marca = ?, cod_subcategoria = ?, unidade_medida = ?,"
					+ " quantidade = ?, data_fabricacao = CONVERT(datetime, ? , 103), data_validade = CONVERT(datetime, ? , 103), lote = ?, ipi = ?, icms = ?, margem_lucro = ?, preco_custo = ?, preco_final = ? WHERE codigo_barras = ?";


			dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
			dataBase.preparedStatement.setString(1, produto.getDescricao());
			dataBase.preparedStatement.setString(2, produto.getMarca());
			dataBase.preparedStatement.setInt(3, produto.getSubCategoria().getCodigo());
			dataBase.preparedStatement.setString(4, produto.getUnidadeDeMedida());
			dataBase.preparedStatement.setDouble(5, produto.getQuantidade());
			dataBase.preparedStatement.setString(6, produto.getDataFabricacao());
			dataBase.preparedStatement.setString(7, produto.getDataValidade());
			dataBase.preparedStatement.setString(8, produto.getLote());
			dataBase.preparedStatement.setDouble(9, produto.getIpi());
			dataBase.preparedStatement.setDouble(10, produto.getIcms());
			dataBase.preparedStatement.setDouble(11, produto.getMargemLucro());
			dataBase.preparedStatement.setDouble(12, produto.getPrecoCusto());
			dataBase.preparedStatement.setDouble(13, produto.getPrecoFinal());
			dataBase.preparedStatement.setString(14, produto.getCodigoDeBarras());

			dataBase.preparedStatement.execute();

			//JOptionPane.showMessageDialog(null, "Produto alterado com sucesso");

		} catch (SQLException e) {
			throw new Exception("Erro ao alterar o produto: " + e);
		} finally {
			dataBase.close();
		}
	}

	/**
	 * Método que cria um ArrayList do tipo Produtos para listar todos os produtos
	 * do banco de dados. A partir de um comando SQL.
	 *
	 * @return - retorna uma lista com todos os produtos.
	 */

	public List<Produto> consultarProdutos() throws Exception {
		if (!dataBase.getConnection()) {
			throw new Exception("Falha na conexão com o banco de dados.");
		}

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy"); // Cria um objeto formatador
		List<Produto> lista = new ArrayList<>();
		String sql = "select codigo_barras, descricao, marca, cod_subcategoria, unidade_medida, quantidade,"
				+ " FORMAT(data_fabricacao, 'dd/MM/yyyy')as data_fabricacao, FORMAT(data_validade, 'dd/MM/yyyy')as data_validade, lote, ipi, icms, margem_lucro, preco_custo, preco_final from tb_produto";

		try {
			dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
			dataBase.resultSet = dataBase.preparedStatement.executeQuery();

			while (dataBase.resultSet.next()) {
				Produto produto = new Produto();
				SubCategoria subCategoria = new SubCategoria();
				SubCategoriaController subcategoriaController = new SubCategoriaController();

				produto.setCodigoDeBarras(dataBase.resultSet.getString("codigo_barras"));
				produto.setDescricao(dataBase.resultSet.getString("descricao"));
				produto.setMarca(dataBase.resultSet.getString("marca"));
				subCategoria = subcategoriaController
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

				lista.add(produto);
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
		if (!dataBase.getConnection()) {
			throw new Exception("Falha na conexão com o banco de dados.");
		}

		List<Produto> lista = new ArrayList<>();
		String sql = "select codigo_barras, descricao, marca, cod_subcategoria, unidade_medida, quantidade," +
				" FORMAT(data_fabricacao, 'dd/MM/yyyy')as data_fabricacao, FORMAT(data_validade, 'dd/MM/yyyy')as data_validade, lote, ipi, icms, margem_lucro, preco_custo, preco_final from tb_produto where descricao like ?";

		try {
			dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
			dataBase.preparedStatement.setString(1, "%" + nome + "%");
			dataBase.resultSet = dataBase.preparedStatement.executeQuery();

			while (dataBase.resultSet.next()) {
				Produto produto = new Produto();
				SubCategoria subCategoria = new SubCategoria();
				produto.setDescricao(dataBase.resultSet.getString("descricao"));
				produto.setCodigoDeBarras(dataBase.resultSet.getString("codigo_barras"));
				produto.setMarca(dataBase.resultSet.getString("marca"));
				subCategoria.setCodigo(dataBase.resultSet.getInt("cod_subcategoria"));
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

				lista.add(produto);
			}
			return lista;
		} catch (SQLException e) {
			throw new Exception("Erro ao buscar produto por nome: " + e);
		} finally {
			dataBase.close();
		}
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