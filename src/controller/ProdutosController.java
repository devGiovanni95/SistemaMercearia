package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Produto;
import model.Categoria;
import model.SubCategoria;

import javax.swing.JOptionPane;

import jdbc.ConnectionDataBase;

// TODO: Auto-generated Javadoc
/**
 * The Class ProdutosController.
 */
public class ProdutosController {

	/** The sub categoria controller. */
	private SubCategoriaController subCategoriaController;

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
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

				dataBase.preparedStatement.setString(1, produto.getDescricao());
				dataBase.preparedStatement.setString(2, produto.getCodigoDeBarras());
				dataBase.preparedStatement.setString(3, produto.getMarca());
				dataBase.preparedStatement.setInt(4, produto.getSubCategoria().getCodigo());
				dataBase.preparedStatement.setString(5, produto.getUnidadeDeMedida());
				dataBase.preparedStatement.setDouble(6, produto.getQuantidade());
				dataBase.preparedStatement.setDate(7, new java.sql.Date(produto.getDataFabricacao().getTime()));
				dataBase.preparedStatement.setDate(8, new java.sql.Date(produto.getDataValidade().getTime()));
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

				String sql = "DELETE FROM produto WHERE id = ?";
				dataBase.preparedStatement.setInt(1, produto.getCodigo());
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
				String sql = "UPDATE produto SET descricao = ?, codigo_barras = ?, marca = ?, cod_subcategoria = ?, unidade_medida = ?,"
						+ " quantidade = ?, data_fabricacao = ?, data_validade = ?, lote = ?, ipi = ?, icms = ?, margem_lucro = ?, preco_custo = ?, preco_final = ? WHERE id = ?";

				dataBase.preparedStatement.setString(1, produto.getDescricao());
				dataBase.preparedStatement.setString(2, produto.getCodigoDeBarras());
				dataBase.preparedStatement.setString(3, produto.getMarca());
				dataBase.preparedStatement.setInt(4, produto.getSubCategoria().getCodigo());
				dataBase.preparedStatement.setString(5, produto.getUnidadeDeMedida());
				dataBase.preparedStatement.setDouble(6, produto.getQuantidade());
				dataBase.preparedStatement.setDate(7, new java.sql.Date(produto.getDataFabricacao().getTime()));
				dataBase.preparedStatement.setDate(8, new java.sql.Date(produto.getDataValidade().getTime()));
				dataBase.preparedStatement.setString(9, produto.getLote());
				dataBase.preparedStatement.setDouble(10, produto.getIpi());
				dataBase.preparedStatement.setDouble(11, produto.getIcms());
				dataBase.preparedStatement.setDouble(12, produto.getMargemLucro());
				dataBase.preparedStatement.setDouble(13, produto.getPrecoCusto());
				dataBase.preparedStatement.setDouble(14, produto.getPrecoFinal());
				dataBase.preparedStatement.setInt(15, produto.getCodigo());

				dataBase.preparedStatement.executeUpdate();

				JOptionPane.showMessageDialog(null, "Produto alterado com sucesso");

			} catch (SQLException | NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Erro: " + e);
			}finally {
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

				List<Produto> lista = new ArrayList<>();

				String sql = "select p.codigo, p.descricao, p.codigo_barras, p.marca, sc.nome, p.unidade_medida, p.quantidade, p.data_fabricacao, p.data_validade,"
						+ " p.lote, p.ipi, p.icms, p.margem_lucro, p.preco_custo, p.preco_final "
						+ "from tb_produto as p join tb_subcategoria as sc " + "on (p.cod_subcategoria = sc.codigo) ";

				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.resultSet = dataBase.preparedStatement.executeQuery();

				while (dataBase.resultSet.next()) {

					Produto produto = new Produto();
					SubCategoria subCategoria = new SubCategoria();

					produto.setCodigo(dataBase.resultSet.getInt("p.codigo"));
					produto.setDescricao(dataBase.resultSet.getString("p.descricao"));
					produto.setCodigoDeBarras(dataBase.resultSet.getString("p.codigo_barras"));
					produto.setMarca(dataBase.resultSet.getString("p.marca"));
					subCategoria.setSubCategoria(dataBase.resultSet.getString("sc.nome"));
					produto.setSubCategoria(subCategoria);
					produto.setUnidadeDeMedida(dataBase.resultSet.getString("p.unidade_medida"));
					produto.setQuantidade(dataBase.resultSet.getDouble("p.quantidade"));
					produto.setDataFabricacao(dataBase.resultSet.getDate("p.data_fabricacao"));
					produto.setDataValidade(dataBase.resultSet.getDate("p.data_validade"));
					produto.setLote(dataBase.resultSet.getString("p.lote"));
					produto.setIpi(dataBase.resultSet.getDouble("p.ipi"));
					produto.setIcms(dataBase.resultSet.getDouble("p.icms"));
					produto.setMargemLucro(dataBase.resultSet.getDouble("p.margem_lucro"));
					produto.setPrecoCusto(dataBase.resultSet.getDouble("p.preco_custo"));
					produto.setPrecoFinal(dataBase.resultSet.getDouble("p.preco_final"));

					lista.add(produto);
				}

				return lista;

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + e);
				return null;
			}finally {
				dataBase.close();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
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
	public List<Produto> consultarProdutoPorNome(String nome) {
		if (dataBase.getConnection()) {
			try {
				List<Produto> lista = new ArrayList<>();
				String sql = "SELECT * FROM produto WHERE descricao LIKE ?";
				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.preparedStatement.setString(1, "%" + nome + "%");
				dataBase.resultSet = dataBase.preparedStatement.executeQuery();

				while (dataBase.resultSet.next()) {
					Produto produto = new Produto();
					produto.setCodigo(dataBase.resultSet.getInt("codigo"));
					produto.setDescricao(dataBase.resultSet.getString("descricao"));
					produto.setCodigoDeBarras(dataBase.resultSet.getString("codigo_barras"));
					produto.setMarca(dataBase.resultSet.getString("marca"));
					// produto.setSubcategoria(buscarSubCategoriaPorId(dataBase.resultSet.getInt("sub_categoria_id")));
					produto.setUnidadeDeMedida(dataBase.resultSet.getString("unidade_medida"));
					produto.setQuantidade(dataBase.resultSet.getDouble("quantidade"));
					produto.setDataFabricacao(dataBase.resultSet.getDate("data_fabricacao"));
					produto.setDataValidade(dataBase.resultSet.getDate("data_validade"));
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
			}finally {
				dataBase.close();	
			}
		} else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
		}
		return null;
	}

	public Produto consultarProdutosPorCodigoBarras(String codigoDeBarras) {
			if(dataBase.getConnection()) {
				try {
			
					String sql = "select descricao, codigo_barras,unidade_medida, quantidade, data_fabricacao,"
							+ " preco_final " + "from tb_produto where codigo_barras = ?";
		
					dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
					dataBase.preparedStatement.setString(1, codigoDeBarras);
					dataBase.resultSet = dataBase.preparedStatement.executeQuery();
					Produto produto = new Produto();
					SubCategoria subCategoria = new SubCategoria();
		
					if (dataBase.resultSet.next()) {
		
						produto.setDescricao(dataBase.resultSet.getString("descricao"));
						produto.setCodigoDeBarras(dataBase.resultSet.getString("codigo_barras"));
						produto.setUnidadeDeMedida(dataBase.resultSet.getString("unidade_medida"));
						produto.setQuantidade(dataBase.resultSet.getDouble("quantidade"));
						produto.setPrecoFinal(dataBase.resultSet.getDouble("preco_final"));
					}
					return produto;
		
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + e);
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
