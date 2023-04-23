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
import model.SubCategoria;

public class SubCategoriaController {
	
private Connection connection;
	
	/**
	 * Método que cria uma conexão com banco de dados
	 */
	public SubCategoriaController() {
		this.connection =  new ConnectionFactory().getConnection();
	}

	/**
	 * Método efetua um comando SQL para efetuar a inserção no banco de dados de uma nova subCategoria.
	 * @param subCategoria - um objeto do tipo subCategoria com os atributos correspondentes
	 */
	public void cadastrarSubCategoria(SubCategoria subCategoria) {
		try {
			
			String sql = "insert into tb_subCategorias(codigo,cod_categoria,nome,descricao) "
					+ " values(?,?,?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, subCategoria.getCodigo());
			preparedStatement.setInt(2, subCategoria.getCategoria().getCodigo());//pegando o codigo do objeto categoria			
			preparedStatement.setString(3, subCategoria.getSubCategoria());
			preparedStatement.setString(4, subCategoria.getDescricao());
			
			
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
	 * Método que a partir do código passado, executa o comando SQL para a exclusão do subCategoria no banco de dados.
	 * @param subCategoria - objeto do tipo subCategoria que identifica o subCategoria a ser excluido no banco de dados.
	 */
	public void excluirSubCategoria(SubCategoria subCategoria) {
		try {
					
					String sql = "delete from tb_subCategorias where codigo=?";
					
					PreparedStatement preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setInt(1, subCategoria.getCodigo());
					
					preparedStatement.execute();
					preparedStatement.close();
					
					JOptionPane.showMessageDialog(null, "Excluido com sucesso");
					
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, "Erro: " + erro);
				}
	}

		
	/**
	 * Método que efetua a alteração de uma subCategoria já cadastrada no banco de dados. A partir do id da subCategoria, 
	 * por meio de um comando SQL.
	 * @param subCategoria - objeto do tipo subCategoria que identifica a subCategoria a ser alterada no banco de dados.
	 */
	public void alterarSubCategoria(SubCategoria subCategoria) {
		try {
				
				String sql = "update tb_subCategorias set nome=?,descricao=?,cod_categoria=?  "
						+ " where codigo=?";
				
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
				preparedStatement.setString(1, subCategoria.getSubCategoria());
				preparedStatement.setString(2, subCategoria.getDescricao());
				preparedStatement.setInt(3, subCategoria.getCategoria().getCodigo());				
				preparedStatement.setInt(4, subCategoria.getCodigo());
				
				preparedStatement.execute();
				preparedStatement.close();
				
				JOptionPane.showMessageDialog(null, "Alterado com sucesso");
								
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, "Erro: " + erro);
			}
	}
	
	
	/**
	 * Método que cria um ArrayList do tipo subCategoria para listar todas as subCategorias do banco de dados.
	 * A partir de um comando SQL.
	 * @return - retona uma lista com todas as subCategorias. 
	 */
	public List<SubCategoria> listarSubCategorias() {
		try {
			
			List<SubCategoria> lista = new ArrayList<>();
			
			//String sql = "select * from tb_subCategorias";
			
			String sql = "select sc.codigo, sc.nome, sc.descricao, c.nome "
					+ "from tb_subCategorias as sc join tb_categorias as c"
					+ " on ( sc.cod_categoria =  c.codigo)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				SubCategoria subCategoria = new SubCategoria();
				Categoria categoria = new Categoria();
				
				subCategoria.setCodigo (resultSet.getInt("codigo"));
				subCategoria.setSubCategoria(resultSet.getString("nome"));
				subCategoria.setDescricao(resultSet.getString("descricao"));
				
				//buscando o nome via sql
				categoria.setNomeCategoria(resultSet.getString("c.nome"));
				//adiciona a categoria
				subCategoria.setCategoria(categoria);
				
				
				
				lista.add(subCategoria);
			}
			
			return lista;
						
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e );
			return null;
		}
	}
	
	/**
	 * Método que cria um ArrayList do tipo subCategoria para listar as subCategoria do banco de dados que
	 *  corresponde ao nome digitado. A partir de um comando SQL.
	 * @param nome - parametro utilizado como base de pesquisa. 
	 * @return - retorna uma lista com os resultados encontrados.
	 */
	/*public List<SubCategoria> buscarsubCategoriaPeloNome(String nome) {
		try {

			List<SubCategoria> lista = new ArrayList<>();

			String sql = "select sc.codigo, sc.nome, sc.descricao, c.nome "
					+ "from tb_subCategorias as sc join tb_categorias as c"
					+ " on ( sc.cod_categoria =  c.codigo)  where nome like ?";
			//String sql = "select * from tb_subCategorias where nome like ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,nome);			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				SubCategoria subCategoria = new SubCategoria();
				
				subCategoria.setCodigo (resultSet.getInt("codigo"));
				subCategoria.setCategoria(resultSet.getInt("cod_categoria"));
				subCategoria.setSubCategoria(resultSet.getString("nome"));
				subCategoria.setDescricao(resultSet.getString("descricao"));
			
				lista.add(subCategoria);
			}
			
			return lista;
						
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e );
			return null;
		}
	}*/
	
}
