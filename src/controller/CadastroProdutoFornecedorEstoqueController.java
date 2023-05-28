package controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import jdbc.ConnectionDataBase;
import model.CadastroProdutoFornecedorEstoque;

public class CadastroProdutoFornecedorEstoqueController {

	/**
	 * Método que cria uma conexão com banco de dados.
	 */
	ConnectionDataBase dataBase = new ConnectionDataBase();

	public void cadastrarProdutoEstoque(CadastroProdutoFornecedorEstoque cadastroProdutoFornecedorEstoque) {
		if (dataBase.getConnection()) {
			try {

				String sql = "insert into tb_produto_fornecedor(codigo,cod_produto,cod_fornecedor,data_entrada,quantidade,preco_unitario,subtotal)"
						+ " values(?,?,?,CONVERT(datetime, ? , 103),?,?,?)";

				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);

				dataBase.preparedStatement.setInt(1, cadastroProdutoFornecedorEstoque.getCodigo());
				dataBase.preparedStatement.setString(2,
						cadastroProdutoFornecedorEstoque.getProduto().getCodigoDeBarras());
				dataBase.preparedStatement.setString(3, cadastroProdutoFornecedorEstoque.getFornecedor().getCnpj());
				dataBase.preparedStatement.setString(4, cadastroProdutoFornecedorEstoque.getDataEntrada());
				dataBase.preparedStatement.setDouble(5, cadastroProdutoFornecedorEstoque.getQuantidade());
				dataBase.preparedStatement.setDouble(6, cadastroProdutoFornecedorEstoque.getPrecoUnitario());
				dataBase.preparedStatement.setDouble(6, cadastroProdutoFornecedorEstoque.getSubTotal());

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

	public void cadastrarProdutoFornecedor(CadastroProdutoFornecedorEstoque cadastroProdutoFornecedorEstoque) {
		if (dataBase.getConnection()) {
			try {
				String sql = "insert into tb_produto_fornecedor (cod_produto, cod_fornecedor, data_entrada, quantidade, preco_unitario, subtotal) "
						+ "VALUES (?, ?, CONVERT(datetime, ? , 103), ?, ?, ?)";
				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.preparedStatement.setString(1,
						cadastroProdutoFornecedorEstoque.getProduto().getCodigoDeBarras());
				dataBase.preparedStatement.setString(2, cadastroProdutoFornecedorEstoque.getFornecedor().getCnpj());
				dataBase.preparedStatement.setString(3, cadastroProdutoFornecedorEstoque.getDataEntrada());
				dataBase.preparedStatement.setDouble(4, cadastroProdutoFornecedorEstoque.getQuantidade());
				dataBase.preparedStatement.setDouble(5, cadastroProdutoFornecedorEstoque.getPrecoUnitario());
				dataBase.preparedStatement.setDouble(6, cadastroProdutoFornecedorEstoque.getSubTotal());
				dataBase.preparedStatement.execute();

				JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");

			} catch (SQLException | NumberFormatException erro) {
				JOptionPane.showMessageDialog(null, "Erro: " + erro);
			} finally {
				dataBase.close();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
		}
	}

}
