package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import jdbc.ConnectionDataBase;
import model.FormaPagamento;


// TODO: Auto-generated Javadoc
/**
 * The Class FormaPagamentoController.
 */
public class FormaPagamentoController  {
	
	/**
	 * Método que cria uma conexão com banco de dados.
	 */
	ConnectionDataBase dataBase = new ConnectionDataBase();
	
	

	
	/**
	 * Método efetua um comando SQL para efetuar a inserção no banco de dados de um pagamento efetuado.
	 * @param formaPagamento - objeto do tipo formaPagamento
	 */
	public void cadastrarFormaPagamento(FormaPagamento formaPagamento) {
		
		if(dataBase.getConnection()) {
		try {
				
			String sql = "insert into tb_forma_pagamento (codigo,dinheiro,cartao_credito,cartao_debito,"
					+ "vale_alimentacao,vale_refeicao,pix,troco,total_compra) "
					+ " values(?,?,?,?,?,?,?,?,?)";			
			
			dataBase.preparedStatement  = dataBase.con.prepareStatement(sql);
			dataBase.preparedStatement.setString(1, formaPagamento.getCodigo());
			dataBase.preparedStatement.setDouble(2, formaPagamento.getDinheiro());
			dataBase.preparedStatement.setDouble(3, formaPagamento.getCartaoCredito());
			dataBase.preparedStatement.setDouble(4, formaPagamento.getCartaoDebito());
			dataBase.preparedStatement.setDouble(5, formaPagamento.getValeAlimentacao());
			dataBase.preparedStatement.setDouble(6, formaPagamento.getValeRefeicao());
			dataBase.preparedStatement.setDouble(7, formaPagamento.getPix());
			dataBase.preparedStatement.setDouble(8, formaPagamento.getTroco());
			dataBase.preparedStatement.setDouble(9, formaPagamento.getTotalCompra());
			dataBase.preparedStatement.execute();			
			JOptionPane.showMessageDialog(null, "Pagamento efetuado com sucesso");
					
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
	
	

	/**
	 * Consultar forma de pagamentos.
	 *
	 * @return the list
	 */
	public List<FormaPagamento> consultarFormaDePagamentos() {
		if(dataBase.getConnection()) {
			try {
				
				List<FormaPagamento> lista = new ArrayList<>();
				
				String sql = "select * from tb_forma_pagamento";
				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.resultSet = dataBase.preparedStatement.executeQuery();
				
				while(dataBase.resultSet.next()) {
					FormaPagamento formaPagamento = new FormaPagamento();
					
				/*	formaPagamento.setCodigo(dataBase.resultSet.getInt("codigo"));
					formaPagamento.setNome(dataBase.resultSet.getString("nome"));*/
						
					lista.add(formaPagamento);
				}
				
				return lista;
							
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro: " + e );
				return null;
			}finally {
				dataBase.close();
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
			return null;
		}
	}
	
	/**
	 * Consultar forma de pagamentos cod.
	 *
	 * @param codigo the codigo
	 * @return the forma pagamento
	 */
	public FormaPagamento consultarFormaDePagamentosCod(int codigo) {
		if(dataBase.getConnection()) {
			try {
				
							
				String sql = "select * from tb_forma_pagamento where codigo = ?";
				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.preparedStatement.setInt(1,codigo);			
				dataBase.resultSet = dataBase.preparedStatement.executeQuery();
				
				FormaPagamento formaPagamento = new FormaPagamento();
			
					while(dataBase.resultSet.next()) {
					
					/*formaPagamento.setCodigo(dataBase.resultSet.getInt("codigo"));
					formaPagamento.setNome(dataBase.resultSet.getString("nome"));	*/					
					}
			
				
					return formaPagamento;
							
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro: " + e );
				return null;
			}finally {
				dataBase.close();
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
			return null;
		}
	}
}
