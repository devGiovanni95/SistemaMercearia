package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Produtos;
import model.Categoria;
import model.SubCategoria;


import javax.swing.JOptionPane;


import jdbc.ConnectionFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class ProdutosController.
 */
public class ProdutosController {

	
	/** The sub categoria controller. */
	private SubCategoriaController subCategoriaController;

	/** The connection. */
	private Connection connection;

	/**
	 * Método que cria uma conexão com banco de dados.
	 */
	public ProdutosController() {
		this.connection =  new ConnectionFactory().getConnection();
		this.subCategoriaController = new SubCategoriaController();
	}
	
	/*public SubCategoria buscarSubCategoriaPorId(int id) {
	    return this.subCategoriaController.buscarSubCategoriaPorId(id);
	}*/

	/**
	 * Método efetua um comando SQL para efetuar a inserção no banco de dados de um novo produto.
	 * @param produto - um objeto do tipo Produtos com os atributos correspondentes
	 */

	public void cadastrarProduto(Produtos produto) {

		try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tb_produtos (descricao, codigo_de_barras, marca, sub_categoria_id, unidade_de_medida, quantidade, data_fabricacao, data_validade, lote, ipi, icms, margem_lucro, preco_custo, preco_final) "

				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

			preparedStatement.setString(1, produto.getDescricao());
			preparedStatement.setString(2, produto.getCodigoDeBarras());
			preparedStatement.setString(3, produto.getMarca());
			preparedStatement.setInt(4, produto.getSubCategoria().getCodigo());
			preparedStatement.setString(5, produto.getUnidadeDeMedida());
			preparedStatement.setInt(6, produto.getQuantidade());
			preparedStatement.setDate(7, new java.sql.Date(produto.getDataFabricacao().getTime()));
			preparedStatement.setDate(8, new java.sql.Date(produto.getDataValidade().getTime()));
			preparedStatement.setString(9, produto.getLote());
			preparedStatement.setDouble(10, produto.getIpi());
			preparedStatement.setDouble(11, produto.getIcms());
			preparedStatement.setDouble(12, produto.getMargemLucro());
			preparedStatement.setDouble(13, produto.getPrecoCusto());
			preparedStatement.setDouble(14, produto.getPrecoFinal());

			preparedStatement.execute();

			JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");

		} catch (SQLException | NumberFormatException erro) {
			JOptionPane.showMessageDialog(null, "Erro: " + erro);
		}
	}



	/**
	 * Método que a partir do código passado, executa o comando SQL para a exclusão do produto no banco de dados.
	 * @param produto - objeto do tipo Produtos que identifica o produto a ser excluido no banco de dados.
	 */

	public void excluirProduto(Produtos produto) {
		try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM produtos WHERE id = ?")) {
			preparedStatement.setInt(1, produto.getCodigo());
			preparedStatement.execute();

			JOptionPane.showMessageDialog(null, "Produto excluído com sucesso");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e);
		}
	}



	/**
	 * Método que efetua a alteração de um produto já cadastrado no banco de dados.A partir do id do produto, 
	 * por meio de um comando SQL.
	 * @param produto - objeto do tipo Produtos que identifica o produto a ser alterado no banco de dados.
	 */
	public void alterarProduto(Produtos produto) {
		try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE produtos SET descricao = ?, codigo_de_barras = ?, marca = ?, sub_categoria_id = ?, unidade_de_medida = ?, quantidade = ?, data_fabricacao = ?, data_validade = ?, lote = ?, ipi = ?, icms = ?, margem_lucro = ?, preco_custo = ?, preco_final = ? WHERE id = ?")) {

			preparedStatement.setString(1, produto.getDescricao());
			preparedStatement.setString(2, produto.getCodigoDeBarras());
			preparedStatement.setString(3, produto.getMarca());
			preparedStatement.setInt(4, produto.getSubCategoria().getCodigo());
			preparedStatement.setString(5, produto.getUnidadeDeMedida());
			preparedStatement.setInt(6, produto.getQuantidade());
			preparedStatement.setDate(7, new java.sql.Date(produto.getDataFabricacao().getTime()));
			preparedStatement.setDate(8, new java.sql.Date(produto.getDataValidade().getTime()));
			preparedStatement.setString(9, produto.getLote());
			preparedStatement.setDouble(10, produto.getIpi());
			preparedStatement.setDouble(11, produto.getIcms());
			preparedStatement.setDouble(12, produto.getMargemLucro());
			preparedStatement.setDouble(13, produto.getPrecoCusto());
			preparedStatement.setDouble(14, produto.getPrecoFinal());
			preparedStatement.setInt(15, produto.getCodigo());

			preparedStatement.executeUpdate();

			JOptionPane.showMessageDialog(null, "Produto alterado com sucesso");

		} catch (SQLException | NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e);
		}
	}




	/**
	 * Método que cria um ArrayList do tipo Produtos para listar todos os produtos do banco de dados.
	 * A partir de um comando SQL.
	 * @return - retorna uma lista com todos os produtos. 
	 */
	public List<Produtos> consultargitProdutos() {
		

		try {
				
				List<Produtos> lista = new ArrayList<>();
				
				String sql = "select p.id, p.descricao, p.codigo_de_barras, p.marca, sc.nome, p.unidade_de_medida, p.quantidade, p.data_fabricacao, p.data_validade,"
						+ " p.lote, p.ipi, p.icms, p.margem_lucro, p.preco_custo, p.preco_final "
						+ "from tb_produtos as p join tb_subCategorias as sc "
						+ "on (p.sub_categoria_id = sc.codigo) ";
				
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				Produtos produto = new Produtos();
				SubCategoria subCategoria = new SubCategoria();
				
				produto.setCodigo(resultSet.getInt("p.id"));
				produto.setDescricao(resultSet.getString("p.descricao"));
				produto.setCodigoDeBarras(resultSet.getString("p.codigo_de_barras"));
				produto.setMarca(resultSet.getString("p.marca"));
				
				subCategoria.setSubCategoria(resultSet.getString("sc.nome"));
				produto.setSubCategoria(subCategoria);			
				
				produto.setUnidadeDeMedida(resultSet.getString("p.unidade_de_medida"));
				produto.setQuantidade(resultSet.getInt("p.quantidade"));
				produto.setDataFabricacao(resultSet.getDate("p.data_fabricacao"));
				produto.setDataValidade(resultSet.getDate("p.data_validade"));
				produto.setLote(resultSet.getString("p.lote"));
				produto.setIpi(resultSet.getDouble("p.ipi"));
				produto.setIcms(resultSet.getDouble("p.icms"));
				produto.setMargemLucro(resultSet.getDouble("p.margem_lucro"));
				produto.setPrecoCusto(resultSet.getDouble("p.preco_custo"));
				produto.setPrecoFinal(resultSet.getDouble("p.preco_final"));

				lista.add(produto);
			}
			
			return lista;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + e);
			return null;
		}
	}



	/**
	 * Método que cria um ArrayList do tipo Produtos para listar os produtos do banco de dados que
	 *  corresponde ao nome digitado. A partir de um comando SQL.
	 * @param nome - parametro utilizado como base de pesquisa. 
	 * @return - retorna uma lista com os resultados encontrados.
	 */
	public List<Produtos> consultarProdutoPorNome(String nome) {
		List<Produtos> lista = new ArrayList<>();
		String sql = "SELECT * FROM produtos WHERE descricao LIKE ?";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, "%" + nome + "%");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Produtos produto = new Produtos();
				produto.setCodigo(resultSet.getInt("id"));
				produto.setDescricao(resultSet.getString("descricao"));
				produto.setCodigoDeBarras(resultSet.getString("codigo_de_barras"));
				produto.setMarca(resultSet.getString("marca"));
				//produto.setSubcategoria(buscarSubCategoriaPorId(resultSet.getInt("sub_categoria_id")));
				produto.setUnidadeDeMedida(resultSet.getString("unidade_de_medida"));
				produto.setQuantidade(resultSet.getInt("quantidade"));
				produto.setDataFabricacao(resultSet.getDate("data_fabricacao"));
				produto.setDataValidade(resultSet.getDate("data_validade"));
				produto.setLote(resultSet.getString("lote"));
				produto.setIpi(resultSet.getDouble("ipi"));
				produto.setIcms(resultSet.getDouble("icms"));
				produto.setMargemLucro(resultSet.getDouble("margem_lucro"));
				produto.setPrecoCusto(resultSet.getDouble("preco_custo"));
				produto.setPrecoFinal(resultSet.getDouble("preco_final"));

				lista.add(produto);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar produto por nome: " + e);
		}

		return lista;
	}

}

