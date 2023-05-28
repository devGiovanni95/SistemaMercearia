package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import jdbc.ConnectionDataBase;
import model.Categoria;
import model.Cliente;
import model.SubCategoria;

// TODO: Auto-generated Javadoc
/**
 * The Class SubCategoriaController.
 */
public class SubCategoriaController {

	/** The data base. */
	ConnectionDataBase dataBase = new ConnectionDataBase();

	/**
	 * Método efetua um comando SQL para efetuar a inserção no banco de dados de uma
	 * nova subCategoria.
	 * 
	 * @param subCategoria - um objeto do tipo subCategoria com os atributos
	 *                     correspondentes
	 */
	public void cadastrarSubCategoria(SubCategoria subCategoria) {
		if (dataBase.getConnection()) {
			try {

				String sql = "insert into tb_subcategoria(codigo,cod_categoria,nome,descricao) "
						+ " values(?,?,?,?)";

				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.preparedStatement.setInt(1, subCategoria.getCodigo());
				dataBase.preparedStatement.setInt(2, subCategoria.getCategoria().getCodigo());// pegando o codigo do
																								// objeto categoria
				dataBase.preparedStatement.setString(3, subCategoria.getNome());
				dataBase.preparedStatement.setString(4, subCategoria.getDescricao());

				dataBase.preparedStatement.execute();
				dataBase.preparedStatement.close();

				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");

			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, "Erro: " + erro);
			} catch (NumberFormatException erro) {
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
	 * do subCategoria no banco de dados.
	 * 
	 * @param subCategoria - objeto do tipo subCategoria que identifica o
	 *                     subCategoria a ser excluido no banco de dados.
	 */
	public void excluirSubCategoria(SubCategoria subCategoria) {
		if (dataBase.getConnection()) {
			try {

				String sql = "delete from tb_subcategoria where codigo=?";

				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.preparedStatement.setInt(1, subCategoria.getCodigo());

				dataBase.preparedStatement.execute();

				JOptionPane.showMessageDialog(null, "Excluido com sucesso");

			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, "Erro: " + erro);
			} finally {
				dataBase.close();
			}

		} else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
		}
	}

	/**
	 * Método que efetua a alteração de uma subCategoria já cadastrada no banco de
	 * dados. A partir do id da subCategoria,
	 * por meio de um comando SQL.
	 * 
	 * @param subCategoria - objeto do tipo subCategoria que identifica a
	 *                     subCategoria a ser alterada no banco de dados.
	 */
	public void alterarSubCategoria(SubCategoria subCategoria) {
		if (dataBase.getConnection()) {
			try {

				String sql = "update tb_subcategoria set nome=?,descricao=?,cod_categoria=?  "
						+ " where codigo=?";

				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);

				dataBase.preparedStatement.setString(1, subCategoria.getNome());
				dataBase.preparedStatement.setString(2, subCategoria.getDescricao());
				dataBase.preparedStatement.setInt(3, subCategoria.getCategoria().getCodigo());
				dataBase.preparedStatement.setInt(4, subCategoria.getCodigo());

				dataBase.preparedStatement.execute();

				JOptionPane.showMessageDialog(null, "Alterado com sucesso");

			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, "Erro: " + erro);
			} finally {
				dataBase.close();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
		}

	}

	/**
	 * Método que cria um ArrayList do tipo subCategoria para listar todas as
	 * subCategorias do banco de dados.
	 * A partir de um comando SQL.
	 * 
	 * @return - retona uma lista com todas as subCategorias.
	 */
	public List<SubCategoria> consultarSubCategorias() {
		if (dataBase.getConnection()) {
			try {

				List<SubCategoria> lista = new ArrayList<>();

				// String sql = "select * from tb_subCategorias";

				/*
				 * String sql = "select sc.codigo, sc.nome, sc.descricao, c.codigo "
				 * + "from tb_subcategoria as sc inner join tb_categoria as c"
				 * + " on ( sc.cod_categoria =  c.codigo)";
				 */

				String sql = "select codigo, nome, descricao, cod_categoria from tb_subcategoria ";

				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.resultSet = dataBase.preparedStatement.executeQuery();

				while (dataBase.resultSet.next()) {
					SubCategoria subCategoria = new SubCategoria();
					Categoria categoria = new Categoria();

					subCategoria.setCodigo(dataBase.resultSet.getInt("codigo"));
					subCategoria.setNome(dataBase.resultSet.getString("nome"));
					subCategoria.setDescricao(dataBase.resultSet.getString("descricao"));

					/*
					 * //buscando o nome via sql
					 * categoria.setNomeCategoria(dataBase.resultSet.getString("c.nome"));
					 * //adiciona a categoria
					 * subCategoria.setCategoria(categoria);
					 */

					// buscando o nome via sql
					categoria.setCodigo(dataBase.resultSet.getInt("cod_categoria"));
					// adiciona a categoria
					subCategoria.setCategoria(categoria);

					lista.add(subCategoria);
				}

				return lista;

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro: " + e);
			} finally {
				dataBase.close();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
		}
		return null;
	}

	/**
	 * Consultar sub categoria por nome.
	 *
	 * @param nome the nome
	 * @return the list
	 */
	public List<SubCategoria> consultarSubCategoriaPorNomes(String nome) {
		if (dataBase.getConnection()) {
			try {
				List<SubCategoria> lista = new ArrayList<>();

				String sql = "select * from tb_subcategoria where nome like ?";

				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.preparedStatement.setString(1, nome);
				dataBase.resultSet = dataBase.preparedStatement.executeQuery();

				while (dataBase.resultSet.next()) {
					SubCategoria subCategoria = new SubCategoria();
					Categoria categoria = new Categoria();

					subCategoria.setCodigo(dataBase.resultSet.getInt("codigo"));
					categoria.setCodigo(dataBase.resultSet.getInt("cod_categoria"));
					subCategoria.setCategoria(categoria);
					subCategoria.setNome(dataBase.resultSet.getString("nome"));
					subCategoria.setDescricao(dataBase.resultSet.getString("descricao"));

					lista.add(subCategoria);
				}
				return lista;

			} catch (SQLException e) {
				System.out.println("Erro ao buscar subcategoria por Nome: " + e.getMessage());
				return null;
			} finally {
				dataBase.close();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
			return null;
		}

	}
	
	/**
	 * Consultar sub categoria por nome.
	 *
	 * @param nome the nome
	 * @return the list
	 */
	public SubCategoria consultarSubCategoriaPorNome(String nome) {
		SubCategoria subCategoria = null;
		if (dataBase.getConnection()) {
			try {			

				String sql = "select * from tb_subcategoria where nome = ?";

				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.preparedStatement.setString(1, nome);
				dataBase.resultSet = dataBase.preparedStatement.executeQuery();

				if (dataBase.resultSet.next()) {
					subCategoria = new SubCategoria();
					Categoria categoria = new Categoria();

					subCategoria.setCodigo(dataBase.resultSet.getInt("codigo"));
					categoria.setCodigo(dataBase.resultSet.getInt("cod_categoria"));
					subCategoria.setCategoria(categoria);
					subCategoria.setNome(dataBase.resultSet.getString("nome"));
					subCategoria.setDescricao(dataBase.resultSet.getString("descricao"));
				}

			} catch (SQLException e) {
				System.out.println("Erro ao buscar subcategoria por Nome: " + e.getMessage());
			} finally {
				dataBase.close();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");		
		}
		return subCategoria;
	

	}

	/**
	 * Método busca o nome da categoria através do codigo.
	 *
	 * @param codigo - id da categoria pesquisada
	 * @return - retorna o nome da categoria procurada
	 */
	public SubCategoria consultarSubCategoriasPorId(int codigo) {
		if (dataBase.getConnection()) {
			try {

				String sql = "select * from tb_subcategoria where codigo = ?";
				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.preparedStatement.setInt(1, codigo);
				dataBase.resultSet = dataBase.preparedStatement.executeQuery();

				SubCategoria subCategoria = new SubCategoria();
				while (dataBase.resultSet.next()) {
					Categoria categoria = new Categoria();
					subCategoria.setCodigo(dataBase.resultSet.getInt("codigo"));
					categoria.setCodigo(dataBase.resultSet.getInt("cod_categoria"));
					subCategoria.setCategoria(categoria);
					subCategoria.setNome(dataBase.resultSet.getString("nome"));
					subCategoria.setDescricao(dataBase.resultSet.getString("descricao"));

				}

				return subCategoria;

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro: " + e);
				return null;
			} finally {
				dataBase.close();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
		}
		return null;
	}

	/*
	 * Método que cria um ArrayList do tipo subCategoria para listar todos os
	 * fornecedores do banco de dados em um ComboBox.
	 * 
	 * @return - retorna uma lista com todas as subcategorias.
	 */
	public Vector<SubCategoria> consultarSubcategoriasComboBox() {
		Vector<SubCategoria> subCategorias = new Vector<SubCategoria>();
		if (dataBase.getConnection()) {
			try {
				String sql = "SELECT * FROM tb_subcategoria";
				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.resultSet = dataBase.preparedStatement.executeQuery();

				while (dataBase.resultSet.next()) {
					Categoria categoria = new Categoria();
					SubCategoria subCategoria = new SubCategoria();
					subCategoria.setCodigo(dataBase.resultSet.getInt("codigo"));
					categoria.setCodigo(dataBase.resultSet.getInt("cod_categoria"));
					subCategoria.setCategoria(categoria);
					subCategoria.setNome(dataBase.resultSet.getString("nome"));
					subCategoria.setDescricao(dataBase.resultSet.getString("descricao"));

					subCategorias.add(subCategoria);
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
		return subCategorias;
	}
}
