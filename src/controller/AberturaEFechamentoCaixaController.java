package controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import jdbc.ConnectionDataBase;
import model.AberturaEFechamentoCaixa;
import model.Funcionario;

// TODO: Auto-generated Javadoc
/**
 * The Class AberturaEFechamentoCaixaController.
 */
public class AberturaEFechamentoCaixaController {

	/**
	 * Método que cria uma conexão com banco de dados.
	 */
	ConnectionDataBase dataBase = new ConnectionDataBase();

	/**
	 * Cadastrar abertura.
	 *
	 * @param caixa the caixa
	 */
	public void cadastrarAbertura(AberturaEFechamentoCaixa caixa) {
		if(dataBase.getConnection()) {
			try {
				
			
				String sql = "insert into tb_abertura_fechamento (data_abertura, funcionario, troco_inicial, caixa_situacao)"				
						+ " values(?,?,?,?)";
				
				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.preparedStatement.setString(1, caixa.getDataAbertura().toString());
				dataBase.preparedStatement.setString(2, caixa.getFuncionario().getCpf());
				dataBase.preparedStatement.setDouble(3, caixa.getTrocoInicial());
				dataBase.preparedStatement.setBoolean(4, caixa.isSituacaoCaixa());
				
						
				dataBase.preparedStatement.execute();
				
				JOptionPane.showMessageDialog(null, "Caixa aberto");
							
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
	 * Cadastrar fechamento.
	 *
	 * @param caixa the caixa
	 */
	public void cadastrarFechamento(AberturaEFechamentoCaixa caixa) {
		if(dataBase.getConnection()) {
		try {
				
				String sql = "update tb_abertura_fechamento set data_fechamento=?, caixa_situacao=? "
						+ " where codigo=?";
				
				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.preparedStatement.setString(1, caixa.getDataFechamento());
				dataBase.preparedStatement.setBoolean(2, caixa.isSituacaoCaixa());
				dataBase.preparedStatement.setInt(3, caixa.getCodigo());
				
				dataBase.preparedStatement.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Caixa fechado com sucesso");
								
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, "Erro: " + erro);
			}finally {
				dataBase.close();
	}
		}else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");	
			}
	}
	
	

	/**
	 * Excluir abertura S.
	 *
	 * @param caixa the caixa
	 */
	public void excluirAbertura(AberturaEFechamentoCaixa caixa) {
		
		if(dataBase.getConnection()) {
				try {
						
						String sql = "delete from tb_abertura_fechamento where codigo=?";
						
						dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
						dataBase.preparedStatement.setInt(1, caixa.getCodigo());
						
						dataBase.preparedStatement.execute();
						
						JOptionPane.showMessageDialog(null, "Abertura excluida com sucesso");
						
					} catch (SQLException erro) {
						JOptionPane.showMessageDialog(null, "Erro: " + erro);
					}finally {
						dataBase.close();						
					}
				}else {
						JOptionPane.showMessageDialog(null, "Falha na conexão");
					}
	}

		
	/**
	 * Consultar abertura em execucao.
	 *
	 * @param codigo the codigo
	 * @return the int
	 */
	
	
	//conferir
	public AberturaEFechamentoCaixa consultarAberturaEmExecucao(int codigo) {
		AberturaEFechamentoCaixa caixa = new AberturaEFechamentoCaixa(); 
		FuncionarioController funcionarioController = new FuncionarioController();
		Funcionario funcionario = new Funcionario();
		//	int idAbertura = 0;
		if(dataBase.getConnection()) {
		try {
			String sql = "select * from tb_abertura_fechamento where codigo = ? ";
			
			dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
			dataBase.preparedStatement.setInt(1,codigo);			
			dataBase.resultSet = dataBase.preparedStatement.executeQuery();
			
			if(dataBase.resultSet.next()) {
				
				caixa.setCodigo(dataBase.resultSet.getInt("codigo"));
				caixa.setDataAbertura(dataBase.resultSet.getString("data_abertura"));
				caixa.setDataFechamento(dataBase.resultSet.getString("data_fechamento"));
				funcionario = funcionarioController.consultarFuncionariosPorCpf(dataBase.resultSet.getString("funcionario"));				
				caixa.setFuncionario(funcionario);
				caixa.setDataFechamento(dataBase.resultSet.getString("data_fechamento"));
				caixa.setTrocoInicial(dataBase.resultSet.getDouble("troco_inicial"));		
				caixa.setSituacaoCaixa(dataBase.resultSet.getBoolean("caixa_situacao"));		
				
			}		
			
			//System.out.println(caixa + "no tri" );
			return caixa;
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro: conferir abertura" + e );
				//System.out.println(caixa + "no catch" );
				System.out.println(caixa);
				return caixa;
			}finally {
				dataBase.close();
			}
		}else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
			
		}
		return null;

		
	}
	
	
	/**
	 * Retornar ultima abertura caixa.
	 *
	 * @return the int
	 */
	public AberturaEFechamentoCaixa retornarUltimaAberturaCaixa() {
		AberturaEFechamentoCaixa aberturaEFechamentoCaixa = new AberturaEFechamentoCaixa(); 
		
//	int idAbertura = 0;
		if(dataBase.getConnection()) {
		try {
			String sql = "select max(codigo) codigo from tb_abertura_fechamento";
			
			dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
			dataBase.resultSet = dataBase.preparedStatement.executeQuery();
			
			if(dataBase.resultSet.next()) {
				
				aberturaEFechamentoCaixa.setCodigo(dataBase.resultSet.getInt("codigo"));
				
				
			}		
			
			//System.out.println(caixa + "no tri" );
			return aberturaEFechamentoCaixa;
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro: " + e );
				//System.out.println(caixa + "no catch" );
				return null;
			}finally {
				dataBase.close();
			}
		}else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
			return null;
		}
	
	}
}
	
