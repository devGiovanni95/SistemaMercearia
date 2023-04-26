 package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import model.Categoria;

// TODO: Auto-generated Javadoc
/**
 * The Class CategoriaController.
 */
public class CategoriaController {
	
/** The connection. */
private Connection connection;
	
	/**
	 * Método que cria uma conexão com banco de dados.
	 */
	public CategoriaController() {
		this.connection =  new ConnectionFactory().getConnection();
	}

	/**
	 * Método efetua um comando SQL para efetuar a inserção no banco de dados de uma nova categoria.
	 * @param categoria - um objeto do tipo categoria com os atributos correspondentes
	 */
	public void cadastrarCategoria(Categoria categoria) {
		try {
			
			String sql = "insert into tb_categorias(codigo,nome,descricao) "
					+ " values(?,?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, categoria.getCodigo());
			preparedStatement.setString(2, categoria.getNomeCategoria());
			preparedStatement.setString(3, categoria.getDescricao());
			
			
			preparedStatement.execute();
			preparedStatement.close();
			
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
						
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Erro: " + erro);
		} catch(NumberFormatException erro) {
			JOptionPane.showMessageDialog(null, "Erro: " + erro);
		}
	}
	
	/**
	 * Método que a partir do código passado, executa o comando SQL para a exclusão do categoria no banco de dados.
	 * @param categoria - objeto do tipo categoria que identifica o categoria a ser excluido no banco de dados.
	 */
	public void excluirCategoria(Categoria categoria) {
		try {
					
					String sql = "delete from tb_categorias where cpf=?";
					
					PreparedStatement preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setInt(1, categoria.getCodigo());
					
					preparedStatement.execute();
					preparedStatement.close();
					
					JOptionPane.showMessageDialog(null, "Excluido com sucesso");
					
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, "Erro: " + erro);
				}
	}

		
	/**
	 * Método que efetua a alteração de uma categoria já cadastrada no banco de dados. A partir do id da categoria, 
	 * por meio de um comando SQL.
	 * @param categoria - objeto do tipo categoria que identifica a categoria a ser alterada no banco de dados.
	 */
	public void alterarCategoria(Categoria categoria) {
		try {
				
				String sql = "update tb_categorias set nome=?,descricao=? "
						+ " where codigo=?";
				
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
				preparedStatement.setString(1, categoria.getNomeCategoria());
				preparedStatement.setString(2, categoria.getDescricao());
				preparedStatement.setInt(3, categoria.getCodigo());
				
				preparedStatement.execute();
				preparedStatement.close();
				
				JOptionPane.showMessageDialog(null, "Alterado com sucesso");
								
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, "Erro: " + erro);
			}
	}
	
	
	/**
	 * Método que cria um ArrayList do tipo categoria para listar todas as categoria do banco de dados.
	 * A partir de um comando SQL.
	 * @return - retona uma lista com todas as categorias. 
	 */
	public List<Categoria> listarCategorias() {
		try {
			
			List<Categoria> lista = new ArrayList<>();
			
			String sql = "select * from tb_categorias";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Categoria categoria = new Categoria();
				
				categoria.setCodigo (resultSet.getInt("codigo"));
				categoria.setNomeCategoria(resultSet.getString("nome"));
				categoria.setDescricao(resultSet.getString("descricao"));
				
				
				lista.add(categoria);
			}
			
			return lista;
						
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e );
			return null;
		}
	}
	
	/**
	 * Método que cria um ArrayList do tipo categoria para listar as categoria do banco de dados que
	 *  corresponde ao nome digitado. A partir de um comando SQL.
	 * @param nome - parametro utilizado como base de pesquisa. 
	 * @return - retorna uma lista com os resultados encontrados.
	 */
	public List<Categoria> buscarCategoriaPeloNome(String nome) {
		try {

			List<Categoria> lista = new ArrayList<>();

			String sql = "select * from tb_categorias where nome like ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,nome);			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Categoria categoria = new Categoria();
				
				categoria.setCodigo (resultSet.getInt("codigo"));
				categoria.setNomeCategoria(resultSet.getString("nome"));
				categoria.setDescricao(resultSet.getString("descricao"));
			
				lista.add(categoria);
			}
			
			return lista;
						
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e );
			return null;
		}
	}
}
