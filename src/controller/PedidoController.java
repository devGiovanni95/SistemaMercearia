package controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import jdbc.ConnectionDataBase;
import model.Pedido;

public class PedidoController {
	
	/**
	 * Método que cria uma conexão com banco de dados.
	 */
	ConnectionDataBase dataBase = new ConnectionDataBase();

	/**
	 * Método efetua um comando SQL para efetuar a inserção no banco de dados de um novo pedido.
	 * @param pedido - um objeto do tipo pedido com os atributos correspondentes
	 */
	public void cadastrarPedido(Pedido pedido) {
		if(dataBase.getConnection()) {
			try {
				
				String sql = "insert into tb_pedido(codigo,cod_cliente,cod_funcionario,cod_forma_pagamento,data_venda,valor_venda)"
						+ " values(?,?,?,?,?,?)";
				
				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.preparedStatement.setString(1, pedido.getCodigo());
				dataBase.preparedStatement.setString(2, pedido.getCliente().getCpf());
				dataBase.preparedStatement.setString(3, pedido.getFuncionario().getCpf());
				dataBase.preparedStatement.setString(4, pedido.getFormaPagamento().getCodigo());
				dataBase.preparedStatement.setString(5, pedido.getDataVenda());
				dataBase.preparedStatement.setDouble(6, pedido.getValorVenda());
				
				dataBase.preparedStatement.execute();
				
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
							
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


