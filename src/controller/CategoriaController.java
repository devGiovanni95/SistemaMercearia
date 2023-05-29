package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import jdbc.ConnectionDataBase;
import model.Categoria;

// TODO: Auto-generated Javadoc
/**
 * The Class CategoriaController.
 */
public class CategoriaController {

	/** The data base. */
	ConnectionDataBase dataBase = new ConnectionDataBase();

	/**
	 * Método efetua um comando SQL para efetuar a inserção no banco de dados de uma
	 * nova categoria.
	 * 
	 * @param categoria - um objeto do tipo categoria com os atributos
	 *                  correspondentes
	 */
	public void cadastrarCategoria(Categoria categoria) {
		if (dataBase.getConnection()) {
			try {

				String sql = "insert into tb_categoria(nome,descricao) " + " values(?,?)";

				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.preparedStatement.setString(1, categoria.getNomeCategoria());
				dataBase.preparedStatement.setString(2, categoria.getDescricao());

				dataBase.preparedStatement.execute();

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
	 * do categoria no banco de dados.
	 * 
	 * @param categoria - objeto do tipo categoria que identifica o categoria a ser
	 *                  excluido no banco de dados.
	 */
	public void excluirCategoria(Categoria categoria) {
		if (dataBase.getConnection()) {
			try {

				String sql = "delete from tb_categoria where codigo=?";

				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.preparedStatement.setInt(1, categoria.getCodigo());
				dataBase.preparedStatement.execute();
				dataBase.preparedStatement.close();

				JOptionPane.showMessageDialog(null, "Excluido com sucesso");

			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, "Erro: " + erro);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
		}
	}

	/**
	 * Método que efetua a alteração de uma categoria já cadastrada no banco de
	 * dados. A partir do codigo da categoria, por meio de um comando SQL.
	 * 
	 * @param categoria - objeto do tipo categoria que identifica a categoria a ser
	 *                  alterada no banco de dados.
	 */
	public void alterarCategoria(Categoria categoria) {
		if (dataBase.getConnection()) {
			try {

				String sql = "update tb_categoria set nome=?,descricao=? " + " where codigo=?";

				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);

				dataBase.preparedStatement.setString(1, categoria.getNomeCategoria());
				dataBase.preparedStatement.setString(2, categoria.getDescricao());
				dataBase.preparedStatement.setInt(3, categoria.getCodigo());
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
	 * Método que cria um ArrayList do tipo categoria para listar todas as categoria
	 * do banco de dados. A partir de um comando SQL.
	 * 
	 * @return - retona uma lista com todas as categorias.
	 */
	public List<Categoria> consultarCategorias() {
		List<Categoria> lista = new ArrayList<>();
		if (dataBase.getConnection()) {
			try {
				String sql = "select * from tb_categoria";
				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.resultSet = dataBase.preparedStatement.executeQuery();

				while(dataBase.resultSet.next()) {
					Categoria categoria = new Categoria();
					categoria.setCodigo(dataBase.resultSet.getInt("codigo"));
					categoria.setNomeCategoria(dataBase.resultSet.getString("nome"));
					categoria.setDescricao(dataBase.resultSet.getString("descricao"));
					lista.add(categoria);
				}


			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro: " + e);
				//return null;
			} finally {
				dataBase.close();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
		}

		return lista;
	}

	
	

	public Vector<Categoria> consultarCategoriasComboBox() {
		Vector<Categoria> categorias = new Vector<Categoria>();
		if (dataBase.getConnection()) {
			try {


				String sql = "select * from tb_categoria";
				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.resultSet = dataBase.preparedStatement.executeQuery();

				while(dataBase.resultSet.next()) {
					Categoria categoria = new Categoria();
					categoria.setCodigo(dataBase.resultSet.getInt("codigo"));
					categoria.setNomeCategoria(dataBase.resultSet.getString("nome"));
					categoria.setDescricao(dataBase.resultSet.getString("descricao"));	
					categorias.add(categoria);
				}
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro: " + e);

			} finally {
				//dataBase.close();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
		}
//		return null;
		return categorias;

	}
	
	
	/**
	 * Método que cria um ArrayList do tipo categoria para listar as categoria do
	 * banco de dados que corresponde ao nome digitado. A partir de um comando SQL.
	 * 
	 * @param nome - parametro utilizado como base de pesquisa.
	 * @return - retorna uma lista com os resultados encontrados.
	 */
	public List<Categoria> consultarCategoriaPeloNome(String nome) {
		if(dataBase.getConnection()) {
			try {
	
				List<Categoria> lista = new ArrayList<>();
	
				String sql = "select * from tb_categoria where nome codigo = ?";
				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.preparedStatement.setString(1,nome);			
				dataBase.resultSet = dataBase.preparedStatement.executeQuery();
	
				while (dataBase.resultSet.next()) {
					Categoria categoria = new Categoria();
	
					categoria.setCodigo(dataBase.resultSet.getInt("codigo"));
					categoria.setNomeCategoria(dataBase.resultSet.getString("nome"));
					categoria.setDescricao(dataBase.resultSet.getString("descricao"));
	
					lista.add(categoria);
				}
	
				return lista;
	
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro: " + e);
				return null;
			} finally {
				dataBase.close();
			}
		}else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
			return null;
		}
		
	}
	
	
	

	/**
	 * Método busca o nome da categoria através do codigo.
	 *
	 * @param codigo - id da categoria pesquisada
	 * @return - retorna o nome da categoria procurada
	 */
	public Categoria consultarCategoriasPorId(int codigo) {
		if (dataBase.getConnection()) {
			try {			

				String sql = "select nome from tb_categoria where codigo = ?";
 				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
 				dataBase.preparedStatement.setInt(1, codigo);
				dataBase.resultSet = dataBase.preparedStatement.executeQuery();

				Categoria categoria = new Categoria();
				while (dataBase.resultSet.next()) {
					categoria.setNomeCategoria(dataBase.resultSet.getString("nome"));				
				}

				return categoria;

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
}
