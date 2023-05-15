package controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import jdbc.ConnectionDataBase;
import model.ItemPedido;
import model.Pedido;

public class ItemPedidoController {
	
	/**
	 * Método que cria uma conexão com banco de dados.
	 */
	ConnectionDataBase dataBase = new ConnectionDataBase();

	/**
	 * Método efetua um comando SQL para efetuar a inserção no banco de dados de um novo itemPedido.
	 * @param itemPedido - um objeto do tipo itemPedido com os atributos correspondentes
	 */
	public void cadastrarItemPedido(ItemPedido itemPedido) {
		if(dataBase.getConnection()) {
			try {
				
				String sql = "insert into tb_item_pedido(codigo_produto,codigo_pedido,quantidade_produto,preco_unitario,valor_total)"
						+ " values(?,?,?,?,?)";
				
				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.preparedStatement.setInt(1, itemPedido.getProduto().getCodigo());
				dataBase.preparedStatement.setString(2, itemPedido.getPedido().getCodigo());
				dataBase.preparedStatement.setDouble(3, itemPedido.getQuantidade());
				dataBase.preparedStatement.setDouble(4, itemPedido.getPrecoUnitario());
				dataBase.preparedStatement.setDouble(5, itemPedido.getSubtotal());
				
				
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


