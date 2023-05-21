package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import jdbc.ConnectionDataBase;
import model.Funcionario;
import model.ItemVenda;
import model.Produto;
import model.Venda;

public class ItemVendaController {
	
	/**
	 * Método que cria uma conexão com banco de dados.
	 */
	ConnectionDataBase dataBase = new ConnectionDataBase();

	/**
	 * Método efetua um comando SQL para efetuar a inserção no banco de dados de um novo itemPedido.
	 * @param itemVenda - um objeto do tipo itemPedido com os atributos correspondentes
	 */
	public void cadastrarItemVenda(ItemVenda itemVenda) {
		if(dataBase.getConnection()) {
			try {
				
				String sql = "insert into tb_item_venda(codigo_produto,codigo_venda,quantidade_produto,preco_unitario,valor_total)"
						+ " values(?,?,?,?,?)";
				
				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.preparedStatement.setString(1, itemVenda.getProduto().getCodigoDeBarras());
				dataBase.preparedStatement.setString(2, itemVenda.getVenda().getCodigo());
				dataBase.preparedStatement.setDouble(3, itemVenda.getQuantidade());
				dataBase.preparedStatement.setDouble(4, itemVenda.getPrecoUnitario());
				dataBase.preparedStatement.setDouble(5, itemVenda.getSubtotal());
				
				
				dataBase.preparedStatement.execute();
				
				//JOptionPane.showMessageDialog(null, "Inserido com sucesso");
							
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, "Erro: " + erro);
			} catch(NumberFormatException erro) {
				JOptionPane.showMessageDialog(null, "Erro: " + erro);
			}finally {
				dataBase.close();			
			} 
		}else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
		}
	}
	
	
	public List<ItemVenda> consultarItensVendaPorCodigo(String codigo) {
		if(dataBase.getConnection()) {
			List<ItemVenda> lista = new ArrayList<>();
			try {
								
				String sql = "select * from tb_item_venda where codigo_venda = ?";
				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.preparedStatement.setString(1,codigo);			
				dataBase.resultSet = dataBase.preparedStatement.executeQuery();
				Produto produto = new Produto();
				ProdutosController produtoController = new ProdutosController();
				VendaController vendaController = new VendaController();
				
				
				while(dataBase.resultSet.next()) {
					Venda venda = new Venda();
					ItemVenda itemVenda = new ItemVenda();
					
					produto = produtoController.consultarProdutosPorCodigoBarras(dataBase.resultSet.getString("codigo_produto"));
					itemVenda.setProduto(produto);
					
					/*venda = vendaController.consultarVendasPorCodigo(dataBase.resultSet.getString("codigo_venda"));
					itemVenda.setVenda(venda);*/
					
					itemVenda.setQuantidade(dataBase.resultSet.getDouble("quantidade_produto"));
					itemVenda.setPrecoUnitario(dataBase.resultSet.getDouble("preco_unitario"));
					itemVenda.setSubtotal(dataBase.resultSet.getDouble("valor_total"));
					itemVenda.setCodigo(dataBase.resultSet.getString("codigo"));
					
					lista.add(itemVenda);
				}			
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro: " + e );		
			}finally {
				dataBase.close();	
			}
			return lista;			
		}else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
		}
		return null;	
	}	
	
	
}


