package controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import jdbc.ConnectionDataBase;
import model.Venda;

public class VendaController {
	
	/**
	 * Método que cria uma conexão com banco de dados.
	 */
	ConnectionDataBase dataBase = new ConnectionDataBase();

	/**
	 * Método efetua um comando SQL para efetuar a inserção no banco de dados de um novo pedido.
	 * @param venda - um objeto do tipo pedido com os atributos correspondentes
	 */
	public void cadastrarVenda(Venda venda) {
		if(dataBase.getConnection()) {
			try {
				
				String sql = "insert into tb_venda(codigo,cod_cliente,cod_funcionario,cod_forma_pagamento,data_venda,valor_venda)"
						+ " values(?,?,?,?,?,?)";
				
				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.preparedStatement.setString(1, venda.getCodigo());
				dataBase.preparedStatement.setString(2, venda.getCliente().getCpf());
				dataBase.preparedStatement.setString(3, venda.getFuncionario().getCpf());
				dataBase.preparedStatement.setString(4, venda.getFormaPagamento().getCodigo());
				dataBase.preparedStatement.setString(5, venda.getDataVenda());
				dataBase.preparedStatement.setDouble(6, venda.getValorVenda());
				
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


