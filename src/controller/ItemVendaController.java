package controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import jdbc.ConnectionDataBase;
import model.ItemVenda;
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
				dataBase.preparedStatement.setInt(1, itemVenda.getProduto().getCodigo());
				dataBase.preparedStatement.setString(2, itemVenda.getPedido().getCodigo());
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
}


