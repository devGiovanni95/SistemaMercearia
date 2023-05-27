package controller;

import interfaces.InterfaceProduto;
import jdbc.ConnectionDataBase;
import model.Produto;
import model.SubCategoria;
import javax.swing.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import jdbc.ConnectionDataBase;
import interfaces.InterfaceProduto;
import model.CadastroProdutoFornecedorEstoque;
import model.Produto;
import model.SubCategoria;

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

	public void cadastrarProduto(Produto produto) {
		if (dataBase.getConnection()) {
			try {
				String sql = "insert into tb_produto (descricao, codigo_barras, marca, cod_subcategoria, unidade_medida, quantidade, data_fabricacao, data_validade, "
						+ "lote, ipi, icms, margem_lucro, preco_custo, preco_final) "
						+ "VALUES (?, ?, ?, ?, ?, ?, CONVERT(datetime, ? , 103), CONVERT(datetime, ? , 103), ?, ?, ?, ?, ?, ?)";

				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				// SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy"); // Supondo que
				// a data esteja nesse formato

				dataBase.preparedStatement.setString(1, produto.getDescricao());
				dataBase.preparedStatement.setString(2, produto.getCodigoDeBarras());
				dataBase.preparedStatement.setString(3, produto.getMarca());
				dataBase.preparedStatement.setInt(4, produto.getSubCategoria().getCodigo());
				dataBase.preparedStatement.setString(5, produto.getUnidadeDeMedida());
				dataBase.preparedStatement.setDouble(6, produto.getQuantidade());
				dataBase.preparedStatement.setString(7, produto.getDataFabricacao());
				dataBase.preparedStatement.setString(8, produto.getDataValidade());
				dataBase.preparedStatement.setString(9, produto.getLote());
				dataBase.preparedStatement.setDouble(10, produto.getIpi());
				dataBase.preparedStatement.setDouble(11, produto.getIcms());
				dataBase.preparedStatement.setDouble(12, produto.getMargemLucro());
				dataBase.preparedStatement.setDouble(13, produto.getPrecoCusto());
				dataBase.preparedStatement.setDouble(14, produto.getPrecoFinal());

				dataBase.preparedStatement.execute();

				JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");

			} catch (SQLException | NumberFormatException erro) {
				JOptionPane.showMessageDialog(null, "Erro: " + erro);
			} finally {
				dataBase.close();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
		}
	}

	/**
	 * Método que a partir do código passado, executa o comando SQL para a exclusão
	 * do produto no banco de dados.
	 *
	 * @param produto - objeto do tipo Produtos que identifica o produto a ser
	 *                excluido no banco de dados.
	 */

	public void excluirProduto(Produto produto) {
		if (dataBase.getConnection()) {
			try {

				String sql = "DELETE FROM produto WHERE codigo_barras = ?";
				dataBase.preparedStatement.setString(1, produto.getCodigoDeBarras());
				dataBase.preparedStatement.execute();

				JOptionPane.showMessageDialog(null, "Produto excluído com sucesso");

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro: " + e);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
		}
	}

	/**
	 * Método que efetua a alteração de um produto já cadastrado no banco de dados.A
	 * partir do id do produto, por meio de um comando SQL.
	 *
	 * @param produto - objeto do tipo Produtos que identifica o produto a ser
	 *                alterado no banco de dados.
	 */
	public void alterarProduto(Produto produto) {
		if (dataBase.getConnection()) {
			try {
				String sql = "UPDATE produto SET descricao = ?,  marca = ?, cod_subcategoria = ?, unidade_medida = ?,"
						+ " quantidade = ?, data_fabricacao = CONVERT(datetime, ? , 103), data_validade = CONVERT(datetime, ? , 103), lote = ?, ipi = ?, icms = ?, margem_lucro = ?, preco_custo = ?, preco_final = ? WHERE codigo_barras = ?";

				// SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy"); // Supondo que
				// a data esteja nesse formato

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

				JOptionPane.showMessageDialog(null, "Produto alterado com sucesso");

			} catch (SQLException | NumberFormatException erro) {
				JOptionPane.showMessageDialog(null, "Erro: " + erro);
			} finally {
				dataBase.close();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
		}
	}

	/**
	 * Método que cria um ArrayList do tipo Produtos para listar todos os produtos
	 * do banco de dados. A partir de um comando SQL.
	 *
	 * @return - retorna uma lista com todos os produtos.
	 */

	public List<Produto> consultarProdutos() {
		if (dataBase.getConnection()) {
			try {
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy"); // Cria um objeto formatador

				List<Produto> lista = new ArrayList<>();
				String sql = "select codigo_barras, descricao, marca, cod_subcategoria, unidade_medida, quantidade,"
						+ " data_fabricacao, data_validade, lote, ipi, icms, margem_lucro, preco_custo, preco_final from tb_produto";

				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.resultSet = dataBase.preparedStatement.executeQuery();

				while (dataBase.resultSet.next()) {
					Produto produto = new Produto();
					SubCategoria subCategoria = new SubCategoria();

					produto.setDescricao(dataBase.resultSet.getString("descricao"));
					produto.setCodigoDeBarras(dataBase.resultSet.getString("codigo_barras"));
					produto.setMarca(dataBase.resultSet.getString("marca"));
					subCategoria.setNome(dataBase.resultSet.getString("cod_subcategoria"));
					produto.setSubCategoria(subCategoria);
					produto.setUnidadeDeMedida(dataBase.resultSet.getString("unidade_medida"));
					produto.setQuantidade(dataBase.resultSet.getDouble("quantidade"));

					// Aqui você pega a data do banco e formata para o formato desejado
					String dataFabricacao = format.format(dataBase.resultSet.getDate("data_fabricacao"));
					String dataValidade = format.format(dataBase.resultSet.getDate("data_validade"));
					produto.setDataFabricacao(dataFabricacao);
					produto.setDataValidade(dataValidade);

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
				JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + e);
				return null;
			} finally {
				dataBase.close();
			}
		} else {
			// JOptionPane.showMessageDialog(null, "Falha na conexão");
			System.exit(1);
			return null;
		}
	}

	/**
	 * Método que cria um ArrayList do tipo Produtos para listar os produtos do
	 * banco de dados que corresponde ao nome digitado. A partir de um comando SQL.
	 *
	 * @param nome - parametro utilizado como base de pesquisa.
	 * @return - retorna uma lista com os resultados encontrados.
	 */
	public List<Produto> consultarProdutosPorNome(String nome) {
		if (dataBase.getConnection()) {
			try {
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy"); // Cria um
				// objeto formatador

				List<Produto> lista = new ArrayList<>();
				String sql = "SELECT * FROM produto WHERE descricao LIKE ?";
				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.preparedStatement.setString(1, "%" + nome + "%");
				dataBase.resultSet = dataBase.preparedStatement.executeQuery();

				while (dataBase.resultSet.next()) {
					Produto produto = new Produto();
					produto.setDescricao(dataBase.resultSet.getString("descricao"));
					produto.setCodigoDeBarras(dataBase.resultSet.getString("codigo_barras"));
					produto.setMarca(dataBase.resultSet.getString("marca"));
					produto.setUnidadeDeMedida(dataBase.resultSet.getString("unidade_medida"));
					produto.setQuantidade(dataBase.resultSet.getDouble("quantidade"));

					// Aqui você pega a data do banco e formata para o formato desejado
					String dataFabricacao = format.format(dataBase.resultSet.getString("data_fabricacao"));
					String dataValidade = format.format(dataBase.resultSet.getString("data_validade"));
					produto.setDataFabricacao(dataFabricacao);
					produto.setDataValidade(dataValidade);

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
				JOptionPane.showMessageDialog(null, "Erro ao buscar produto por nome: " + e);
			} finally {
				dataBase.close();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
		}
		return null;
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
					System.exit(0);
					// return null;
					exibiuErro = true;
				}
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataBase.close();
				System.exit(0);
			} finally {
				dataBase.close();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
			// return null;
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
