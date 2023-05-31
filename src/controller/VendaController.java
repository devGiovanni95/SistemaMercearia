package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import jdbc.ConnectionDataBase;
import model.Venda;
import model.Cliente;
import model.FormaPagamento;
import model.Funcionario;

public class VendaController {

	/**
	 * Método que cria uma conexão com banco de dados.
	 */
	ConnectionDataBase dataBase = new ConnectionDataBase();

	/**
	 * Método efetua um comando SQL para efetuar a inserção no banco de dados de uma
	 * nova venda.
	 * 
	 * @param venda - um objeto do tipo venda com os atributos correspondentes
	 */
	public void cadastrarVenda(Venda venda) {
		if (dataBase.getConnection()) {
			try {

				String sql = "insert into tb_venda(codigo,cod_cliente,cod_funcionario,cod_forma_pagamento,data_venda,valor_venda)"
						+ " values(?,?,?,?,CONVERT(datetime, ? , 103),?)";

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
	 * Método que cria um ArrayList do tipo venda para listar todos as vendas do
	 * banco de dados.
	 * A partir de um comando SQL.
	 * 
	 * @return - retona uma lista com todas as vendas.
	 */
	public List<Venda> consultarVendas() {
		if (dataBase.getConnection()) {
			try {

				List<Venda> lista = new ArrayList<>();
				String sql = "select * from tb_venda";
				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.resultSet = dataBase.preparedStatement.executeQuery();

				while (dataBase.resultSet.next()) {

					Venda venda = new Venda();
					FuncionarioController funcionarioController = new FuncionarioController();
					Funcionario funcionario = new Funcionario();
					Cliente cliente = new Cliente();
					ClienteController clienteController = new ClienteController();
					FormaPagamentoController formaPagamentoController = new FormaPagamentoController();
					FormaPagamento formaPagamento = new FormaPagamento();

					venda.setCodigo(dataBase.resultSet.getString("codigo"));

					cliente = clienteController.consultarClientesPorCpf(dataBase.resultSet.getString("cod_cliente"));
					venda.setCliente(cliente);

					funcionario = funcionarioController
							.consultarFuncionariosPorCpf(dataBase.resultSet.getString("cod_funcionario"));
					venda.setFuncionario(funcionario);

					formaPagamento = formaPagamentoController
							.consultarFormaDePagamentosPorCodigo(dataBase.resultSet.getString("cod_forma_pagamento"));
					venda.setFormaPagamento(formaPagamento);

					venda.setDataVenda(dataBase.resultSet.getString("data_venda"));

					venda.setValorVenda(dataBase.resultSet.getDouble("valor_venda"));

					lista.add(venda);
				}

				return lista;

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro: " + e);
				return null;
			} finally {
				dataBase.close();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
			return null;
		}
	}

	public Venda consultarVendasPorCodigo(String codigo) {
		if (dataBase.getConnection()) {
			try {

				String sql = "select * from tb_venda where codigo = ?";
				dataBase.preparedStatement.setString(1, codigo);
				dataBase.resultSet = dataBase.preparedStatement.executeQuery();
				Venda venda = new Venda();

				if (dataBase.resultSet.next()) {

					FuncionarioController funcionarioController = new FuncionarioController();
					Funcionario funcionario = new Funcionario();
					Cliente cliente = new Cliente();
					ClienteController clienteController = new ClienteController();
					FormaPagamentoController formaPagamentoController = new FormaPagamentoController();
					FormaPagamento formaPagamento = new FormaPagamento();

					venda.setCodigo(dataBase.resultSet.getString("codigo"));

					cliente = clienteController.consultarClientesPorCpf(dataBase.resultSet.getString("cod_cliente"));
					venda.setCliente(cliente);

					funcionario = funcionarioController
							.consultarFuncionariosPorCpf(dataBase.resultSet.getString("cod_funcionario"));
					venda.setFuncionario(funcionario);

					formaPagamento = formaPagamentoController
							.consultarFormaDePagamentosPorCodigo(dataBase.resultSet.getString("cod_forma_pagamento"));
					venda.setFormaPagamento(formaPagamento);

					venda.setDataVenda(dataBase.resultSet.getString("data_venda"));

					venda.setValorVenda(dataBase.resultSet.getDouble("valor_venda"));

				}

				return venda;

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro: " + e);
				return null;
			} finally {
				dataBase.close();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
			return null;
		}
	}

}
