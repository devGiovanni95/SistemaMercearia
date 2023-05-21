package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import interfaces.InterfaceFuncionario;
import jdbc.ConnectionDataBase;
import model.Funcionario;
import view.FrmMenuPrincipal;

// TODO: Auto-generated Javadoc
/**
 * The Class FuncionarioController.
 */
public class FuncionarioController implements InterfaceFuncionario {
	
	/*/**
	 * Método que cria uma conexão com banco de dados.
	 */
	/*public FuncionarioController() {
		this.connection =  new ConnectionDataBase().getConnection();
	}*/
	
	/** The data base. */
	ConnectionDataBase dataBase = new ConnectionDataBase();


	/**
	 * Método efetua um comando SQL para efetuar a inserção no banco de dados de um novo funcionario.
	 * @param funcionario - objeto do tipo funcionario
	 */
	public void cadastrarFuncionario(Funcionario funcionario) {
		
		if(dataBase.getConnection()) {
		try {
				
			String sql = "insert into tb_funcionario (nome,email,cpf,rg,endereco,telefone,celular,numero,cep,data_nascimento,bairro,cidade,uf,complemento,limite,senha,cargo,nivel_acesso,"
					+ "pis_pasep,salario,carteira_trabalho,estado_civil,jornada_trabalho,admissao,demissao,ativo) "
					+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			
			dataBase.preparedStatement  = dataBase.con.prepareStatement(sql);
			dataBase.preparedStatement.setString(1, funcionario.getNome());
			dataBase.preparedStatement.setString(2, funcionario.getEmail());
			dataBase.preparedStatement.setString(3, funcionario.getCpf());
			dataBase.preparedStatement.setString(4, funcionario.getRg());
			dataBase.preparedStatement.setString(5, funcionario.getEndereco());
			dataBase.preparedStatement.setString(6, funcionario.getTelefone());
			dataBase.preparedStatement.setString(7, funcionario.getCelular());
			dataBase.preparedStatement.setInt(8, funcionario.getNumero());
			dataBase.preparedStatement.setString(9, funcionario.getCep());
			dataBase.preparedStatement.setString(10, funcionario.getDataNascimento());
			dataBase.preparedStatement.setString(11, funcionario.getBairro());
			dataBase.preparedStatement.setString(12, funcionario.getCidade());
			dataBase.preparedStatement.setString(13, funcionario.getUf());
			dataBase.preparedStatement.setString(14, funcionario.getComplemento());
			dataBase.preparedStatement.setDouble(15, funcionario.getLimite());
			dataBase.preparedStatement.setString(16, funcionario.getSenha());
			dataBase.preparedStatement.setString(17, funcionario.getCargo());
			dataBase.preparedStatement.setString(18, funcionario.getNivelAcesso());
			dataBase.preparedStatement.setString(19, funcionario.getPisPasep());
			dataBase.preparedStatement.setDouble(20, funcionario.getSalario());
			dataBase.preparedStatement.setString(21, funcionario.getCarteiraTrabalho());
			dataBase.preparedStatement.setString(22, funcionario.getEstadoCivil());
			dataBase.preparedStatement.setString(23, funcionario.getJornadaTrabalho());
			dataBase.preparedStatement.setString(24, funcionario.getAdmissao());
			dataBase.preparedStatement.setString(25, funcionario.getDemissao());
			dataBase.preparedStatement.setString(26, funcionario.getAtivo());
			
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
	
	
	/**
	 * Método que a partir do código passado, executa o comando SQL para a exclusão do funcionário no banco de dados.
	 * @param funcionario - objeto do tipo funcionário que identifica o funcionário a ser excluido no banco de dados.
	 */
	public void excluirFuncionario(Funcionario funcionario) {
		if(dataBase.getConnection()) {
				try {					
					String sql = "delete from tb_funcionario where cpf=?";
					
					dataBase.preparedStatement  = dataBase.con.prepareStatement(sql);
					dataBase.preparedStatement.setString(1, funcionario.getCpf());					
					dataBase.preparedStatement.execute();
					
					JOptionPane.showMessageDialog(null, "Excluido com sucesso");
			
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, "Erro: " + erro);
				}finally {
					dataBase.close();					
				}
				
		}	else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
		}
	}

	
	/**
	 * Método que efetua a alteração de um funcionário já cadastrado no banco de dados.A partir do id do funcionário, 
	 * por meio de um comando SQL.
	 * @param funcionario - objeto do tipo funcionário que identifica o funcionario a ser alterado no banco de dados.
	 */
	public void alterarFuncionario(Funcionario funcionario) {
		if (dataBase.getConnection()) {

			try {
					
					String sql = "update tb_funcionario set nome =?, email =?, cpf =?, rg =?, endereco =?, telefone =?, celular =?, numero =?, cep =?, data_nascimento =?, bairro =?, cidade =?,"
							+ "  uf =?, complemento =?, limite =?, senha =?, cargo =?, nivel_acesso =?, pis_pasep =?, salario =?, carteira_trabalho =?, estado_civil =?, jornada_trabalho =?, admissao =?,"
							+ " demissao=?, ativo=?  where cpf=?";
				
					dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
					dataBase.preparedStatement.setString(1, funcionario.getNome());
					dataBase.preparedStatement.setString(2, funcionario.getEmail());
					dataBase.preparedStatement.setString(3, funcionario.getCpf());
					dataBase.preparedStatement.setString(4, funcionario.getRg());
					dataBase.preparedStatement.setString(5, funcionario.getEndereco());
					dataBase.preparedStatement.setString(6, funcionario.getTelefone());
					dataBase.preparedStatement.setString(7, funcionario.getCelular());
					dataBase.preparedStatement.setInt(8, funcionario.getNumero());
					dataBase.preparedStatement.setString(9, funcionario.getCep());
					dataBase.preparedStatement.setString(10, funcionario.getDataNascimento());
					dataBase.preparedStatement.setString(11, funcionario.getBairro());
					dataBase.preparedStatement.setString(12, funcionario.getCidade());
					dataBase.preparedStatement.setString(13, funcionario.getUf());
					dataBase.preparedStatement.setString(14, funcionario.getComplemento());
					dataBase.preparedStatement.setDouble(15, funcionario.getLimite());
					dataBase.preparedStatement.setString(16, funcionario.getSenha());
					dataBase.preparedStatement.setString(17, funcionario.getCargo());
					dataBase.preparedStatement.setString(18, funcionario.getNivelAcesso());
					dataBase.preparedStatement.setString(19, funcionario.getPisPasep());
					dataBase.preparedStatement.setDouble(20, funcionario.getSalario());
					dataBase.preparedStatement.setString(21, funcionario.getCarteiraTrabalho());
					dataBase.preparedStatement.setString(22, funcionario.getEstadoCivil());
					dataBase.preparedStatement.setString(23, funcionario.getJornadaTrabalho());
					dataBase.preparedStatement.setString(24, funcionario.getAdmissao());
					dataBase.preparedStatement.setString(25, funcionario.getDemissao());
					dataBase.preparedStatement.setString(26, funcionario.getAtivo());
					dataBase.preparedStatement.setString(27, funcionario.getCpf());
					
					dataBase.preparedStatement.execute();				
					JOptionPane.showMessageDialog(null, "Alterado com sucesso");
									
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, "Erro: " + erro);
				}finally {
					dataBase.close();				
				}
		}	else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
		}
	}
	
	
	/**
	 * Método que cria um ArrayList do tipo funcionário para listar todos os funcionários do banco de dados.
	 * A partir de um comando SQL.
	 * @return - retona uma lista com todos de funcionários 
	 */
	public List<Funcionario> consultarFuncionarios() {
		
		if (dataBase.getConnection()) {
			try {
	
				List<Funcionario> lista = new ArrayList<>();
	
				String sql = "select * from tb_funcionario";
				
				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.resultSet = dataBase.preparedStatement.executeQuery();
				
				while(dataBase.resultSet.next()) {
					Funcionario funcionario = new Funcionario();
					
					funcionario.setNome(dataBase.resultSet.getString("nome"));
					funcionario.setEmail(dataBase.resultSet.getString("email"));
					funcionario.setCpf(dataBase.resultSet.getString("cpf"));
					funcionario.setRg(dataBase.resultSet.getString("rg"));
					funcionario.setEndereco(dataBase.resultSet.getString("endereco"));
					funcionario.setTelefone(dataBase.resultSet.getString("telefone"));
					funcionario.setCelular(dataBase.resultSet.getString("celular"));
					funcionario.setNumero(dataBase.resultSet.getInt("numero"));
					funcionario.setCep(dataBase.resultSet.getString("cep"));
					funcionario.setDataNascimento(dataBase.resultSet.getString("data_nascimento"));
					funcionario.setBairro(dataBase.resultSet.getString("bairro"));
					funcionario.setCidade(dataBase.resultSet.getString("cidade"));
					funcionario.setUf(dataBase.resultSet.getString("uf"));
					funcionario.setComplemento(dataBase.resultSet.getString("complemento"));
					funcionario.setLimite(dataBase.resultSet.getDouble("limite"));				
					funcionario.setSenha(dataBase.resultSet.getString("senha"));
					funcionario.setCargo(dataBase.resultSet.getString("cargo"));
					funcionario.setNivelAcesso(dataBase.resultSet.getString("nivel_acesso"));
					funcionario.setPisPasep(dataBase.resultSet.getString("pis_pasep"));
					funcionario.setSalario(dataBase.resultSet.getDouble("salario"));
					funcionario.setCarteiraTrabalho(dataBase.resultSet.getString("carteira_trabalho"));
					funcionario.setEstadoCivil (dataBase.resultSet.getString("estado_civil"));
					funcionario.setJornadaTrabalho(dataBase.resultSet.getString("jornada_trabalho"));
					funcionario.setAdmissao(dataBase.resultSet.getString("admissao"));
					funcionario.setDemissao(dataBase.resultSet.getString("demissao"));
					funcionario.setDemissao(dataBase.resultSet.getString("ativo"));
											
					lista.add(funcionario);
				}
				
				return lista;							
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro: " + e );
				return null;
			}finally {
				dataBase.close();	
			} 
		}else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
		}
		return null;
	
	}
	
	/**
	 * Consultar funcionarios por cpf.
	 *
	 * @param cpf the cpf
	 * @return the funcionario
	 */
	public Funcionario consultarFuncionariosPorCpf(String cpf) {
	    if (dataBase.getConnection()) {
	        try {
	            String sql = "SELECT * FROM tb_funcionario WHERE cpf = ?";
	            dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
	            dataBase.preparedStatement.setString(1, cpf);
	            dataBase.resultSet = dataBase.preparedStatement.executeQuery();
	            Funcionario funcionario = new Funcionario();

	            
	            if (dataBase.resultSet.next()) {
	                funcionario.setNome(dataBase.resultSet.getString("nome"));
	                funcionario.setEmail(dataBase.resultSet.getString("email"));
	                funcionario.setCpf(dataBase.resultSet.getString("cpf"));
	                funcionario.setRg(dataBase.resultSet.getString("rg"));
	                funcionario.setEndereco(dataBase.resultSet.getString("endereco"));
	                funcionario.setTelefone(dataBase.resultSet.getString("telefone"));
	                funcionario.setCelular(dataBase.resultSet.getString("celular"));
	                funcionario.setNumero(dataBase.resultSet.getInt("numero"));
	                funcionario.setCep(dataBase.resultSet.getString("cep"));
	                funcionario.setDataNascimento(dataBase.resultSet.getString("data_nascimento"));
	                funcionario.setBairro(dataBase.resultSet.getString("bairro"));
	                funcionario.setCidade(dataBase.resultSet.getString("cidade"));
	                funcionario.setUf(dataBase.resultSet.getString("uf"));
	                funcionario.setComplemento(dataBase.resultSet.getString("complemento"));
	                funcionario.setLimite(dataBase.resultSet.getDouble("limite"));
	                funcionario.setSenha(dataBase.resultSet.getString("senha"));
	                funcionario.setCargo(dataBase.resultSet.getString("cargo"));
	                funcionario.setNivelAcesso(dataBase.resultSet.getString("nivel_acesso"));
	                funcionario.setPisPasep(dataBase.resultSet.getString("pis_pasep"));
	                funcionario.setSalario(dataBase.resultSet.getDouble("salario"));
	                funcionario.setCarteiraTrabalho(dataBase.resultSet.getString("carteira_trabalho"));
	                funcionario.setEstadoCivil(dataBase.resultSet.getString("estado_civil"));
	                funcionario.setJornadaTrabalho(dataBase.resultSet.getString("jornada_trabalho"));
	                funcionario.setAdmissao(dataBase.resultSet.getString("admissao"));
	                funcionario.setDemissao(dataBase.resultSet.getString("demissao"));
	                funcionario.setAtivo(dataBase.resultSet.getString("ativo"));

	            }

	            return funcionario;

	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, "Erro: " + e);
	        } finally {
	            dataBase.close();
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Falha na conexão");
	    }
	    return null;
	}

	
	/**
	 * Método que cria um ArrayList do tipo funcionário para listar os funcionários do banco de dados que
	 *  corresponde ao nome digitado. A partir de um comando SQL.
	 *
	 * @param nome - parametro utilizado como base de pesquisa.
	 * @return lista - retorna uma lista de funcionários.
	 */
	public List<Funcionario> consultarFuncionariosPorNome(String nome) {
		if(dataBase.getConnection()) {
			try {
				
				List<Funcionario> lista = new ArrayList<>();
				
				String sql = "select * from tb_funcionario where nome like ?";
				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.preparedStatement.setString(1,nome);			
				dataBase.resultSet = dataBase.preparedStatement.executeQuery();
				
				
				while(dataBase.resultSet.next()) {
					Funcionario funcionario = new Funcionario();
					
					funcionario.setNome(dataBase.resultSet.getString("nome"));
					funcionario.setEmail(dataBase.resultSet.getString("email"));
					funcionario.setCpf(dataBase.resultSet.getString("cpf"));
					funcionario.setRg(dataBase.resultSet.getString("rg"));
					funcionario.setEndereco(dataBase.resultSet.getString("endereco"));
					funcionario.setTelefone(dataBase.resultSet.getString("telefone"));
					funcionario.setCelular(dataBase.resultSet.getString("celular"));
					funcionario.setNumero(dataBase.resultSet.getInt("numero"));
					funcionario.setCep(dataBase.resultSet.getString("cep"));
					funcionario.setDataNascimento(dataBase.resultSet.getString("data_nascimento"));
					funcionario.setBairro(dataBase.resultSet.getString("bairro"));
					funcionario.setCidade(dataBase.resultSet.getString("cidade"));
					funcionario.setUf(dataBase.resultSet.getString("uf"));
					funcionario.setComplemento(dataBase.resultSet.getString("complemento"));
					funcionario.setLimite(dataBase.resultSet.getDouble("limite"));
					funcionario.setSenha(dataBase.resultSet.getString("senha"));
					funcionario.setCargo(dataBase.resultSet.getString("cargo"));
					funcionario.setNivelAcesso(dataBase.resultSet.getString("nivel_acesso"));
					funcionario.setPisPasep(dataBase.resultSet.getString("pis_pasep"));
					funcionario.setSalario(dataBase.resultSet.getDouble("salario"));
					funcionario.setCarteiraTrabalho(dataBase.resultSet.getString("carteira_trabalho"));
					funcionario.setEstadoCivil (dataBase.resultSet.getString("estado_civil"));
					funcionario.setJornadaTrabalho(dataBase.resultSet.getString("jornada_trabalho"));
					funcionario.setAdmissao(dataBase.resultSet.getString("admissao"));
					funcionario.setDemissao(dataBase.resultSet.getString("demissao"));
					funcionario.setDemissao(dataBase.resultSet.getString("ativo"));
					
					lista.add(funcionario);
				}			
				return lista;			
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro: " + e );		
			}finally {
				dataBase.close();	
			}
		}else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
		}
		return null;	
	}	
	
	



	
	
	
	/**
	 * Método que a partir de um comando de pesquisa do SQL, efetua uma verificação para
	 *  conferir se há um funcionário cadastrado com permissão de uso no sistema.
	 * @param email - parametro a ser conferido como nome de usuário.
	 * @param senha - parametro a ser conferido como nome de senha.
	 */
	public void autenticar(String email, String senha) {
		
		if(dataBase.getConnection()) {
		
		try {
			String sql = "select * from tb_funcionario where email=? and senha=?";
			
			dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
			dataBase.preparedStatement.setString(1,email);	
			dataBase.preparedStatement.setString(2,senha);	
			

			dataBase.resultSet = dataBase.preparedStatement.executeQuery();
			
			if(dataBase.resultSet.next()) {
				
				if(dataBase.resultSet.getString("nivel_acesso").equals("Gerente")) {
					
					JOptionPane.showMessageDialog(null, "Seja bem vindo ao Sistema ");	
					FrmMenuPrincipal frmMenuPrincipal = new FrmMenuPrincipal();
					frmMenuPrincipal.setCpfFuncionario(dataBase.resultSet.getString("cpf"));
					frmMenuPrincipal.setVisible(true);
					frmMenuPrincipal.setSituacaoCaixa(false);
					
					
				}else if (dataBase.resultSet.getString("nivel_acesso").equals("Caixa")) {
					JOptionPane.showMessageDialog(null, "Seja bem vindo ao Sistema ");	
					FrmMenuPrincipal frmMenuPrincipal = new FrmMenuPrincipal();
					frmMenuPrincipal.setCpfFuncionario(dataBase.resultSet.getString("cpf"));
					frmMenuPrincipal.setVisible(true);
					frmMenuPrincipal.setSituacaoCaixa(false);	
					frmMenuPrincipal.mnCategoria.setVisible(false);
					frmMenuPrincipal.mnClientes.setVisible(false);
					frmMenuPrincipal.mnEstoque.setVisible(false);
					frmMenuPrincipal.mnFornecedores.setVisible(false);
					frmMenuPrincipal.mnFuncionarios.setVisible(false);

					
				}else if (dataBase.resultSet.getString("nivel_acesso").equals("Estoquista")) {
					JOptionPane.showMessageDialog(null, "Seja bem vindo ao Sistema ");	
					FrmMenuPrincipal frmMenuPrincipal = new FrmMenuPrincipal();
					frmMenuPrincipal.setCpfFuncionario(dataBase.resultSet.getString("cpf"));
					frmMenuPrincipal.setVisible(true);
					frmMenuPrincipal.setSituacaoCaixa(false);	
					frmMenuPrincipal.mnClientes.setVisible(false);
					frmMenuPrincipal.mnVendas.setVisible(false);
					frmMenuPrincipal.mnFuncionarios.setVisible(false);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Dados incorretos");
			}
						
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e );
		}finally {
			dataBase.close();
		}
		
		}else {
			JOptionPane.showMessageDialog(null, "Falha na conexão");
		}
		
	}
	
}
