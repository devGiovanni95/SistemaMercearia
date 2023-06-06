package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import interfaces.InterfaceFuncionario;
import jdbc.ConnectionDataBase;
import model.Funcionario;
import view.FrmMenuPrincipal;

// TODO: Auto-generated Javadoc
/**
 * The Class FuncionarioController.
 */
public final class FuncionarioController implements InterfaceFuncionario {

	private static final String ERROR_CONNECTION = "Falha na conexão com o banco de dados.";
	private final ConnectionDataBase dataBase = new ConnectionDataBase();


	private void checkDatabaseConnection() throws Exception {
		if (!dataBase.getConnection()) {
			throw new Exception(ERROR_CONNECTION);
		}
	}

	/**
	 * Método efetua um comando SQL para efetuar a inserção no banco de dados de um novo funcionario.
	 *
	 * @param funcionario - objeto do tipo funcionario
	 */
	public void cadastrarFuncionario(Funcionario funcionario) throws Exception {
		String sql = "insert into tb_funcionario (nome, email, cpf, rg, endereco, telefone, celular, numero, cep, data_nascimento, bairro, cidade, uf, complemento, limite, senha, cargo, nivel_acesso, pis_pasep, salario, carteira_trabalho, estado_civil, jornada_trabalho, admissao, demissao, ativo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, CONVERT(datetime, ? , 103), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		executarQueryFuncionario(funcionario, sql);
	}

	/**
	 * Método que efetua a alteração de um funcionário já cadastrado no banco de dados.A partir do id do funcionário,
	 * por meio de um comando SQL.
	 *
	 * @param funcionario - objeto do tipo funcionário que identifica o funcionario a ser alterado no banco de dados.
	 */
	public void alterarFuncionario(Funcionario funcionario) throws Exception {
		String sql = "update tb_funcionario set nome =?, email =?, cpf =?, rg =?, endereco =?, telefone =?, celular =?, numero =?, cep =?, data_nascimento =?, bairro =?, cidade =?, uf =?, complemento =?, limite =?, senha =?, cargo =?, nivel_acesso =?, pis_pasep =?, salario =?, carteira_trabalho =?, estado_civil =?, jornada_trabalho =?, admissao =?, demissao=?, ativo=? where cpf=?";
		executarQueryFuncionario(funcionario, sql);
	}

	private void executarQueryFuncionario(Funcionario funcionario, String sql) throws Exception {
		checkDatabaseConnection();
		try (PreparedStatement stmt = dataBase.con.prepareStatement(sql)) {
			preencherPreparedStatement(funcionario, stmt, sql);
			stmt.execute();
		} catch (SQLException | NumberFormatException erro) {
			throw new Exception("Erro ao executar operação no funcionario: " + erro);
		} finally {
			dataBase.close();
		}
	}

	private void preencherPreparedStatement(Funcionario funcionario, PreparedStatement stmt, String sql) throws SQLException {
		stmt.setString(1, funcionario.getNome());
		stmt.setString(2, funcionario.getEmail());
		stmt.setString(3, funcionario.getCpf());
		stmt.setString(4, funcionario.getRg());
		stmt.setString(5, funcionario.getEndereco());
		stmt.setString(6, funcionario.getTelefone());
		stmt.setString(7, funcionario.getCelular());
		stmt.setInt(8, funcionario.getNumero());
		stmt.setString(9, funcionario.getCep());
		stmt.setString(10, funcionario.getDataNascimento());
		stmt.setString(11, funcionario.getBairro());
		stmt.setString(12, funcionario.getCidade());
		stmt.setString(13, funcionario.getUf());
		stmt.setString(14, funcionario.getComplemento());
		stmt.setDouble(15, funcionario.getLimite());
		//stmt.setString(16, funcionario.getSenha());
		stmt.setString(17, funcionario.getCargo());
		stmt.setString(18, funcionario.getNivelAcesso());
		stmt.setString(19, funcionario.getPisPasep());
		stmt.setDouble(20, funcionario.getSalario());
		stmt.setString(21, funcionario.getCarteiraTrabalho());
		stmt.setString(22, funcionario.getEstadoCivil());
		stmt.setString(23, funcionario.getJornadaTrabalho());
		stmt.setString(24, funcionario.getAdmissao());
		stmt.setString(25, funcionario.getDemissao());
		stmt.setString(26, funcionario.getAtivo());
		if (sql.contains("where cpf=?")) {
			stmt.setString(27, funcionario.getCpf());
		}

		if(!funcionario.getSenha().isEmpty()) {
			stmt.setString(16, funcionario.getSenha());
		} else {
			stmt.setString(16, getCurrentPassword(funcionario.getCpf()));
		}

	}

	/*
	 * Método que retorna a senha atual do funcionário no banco de dados.
	 * @param cpf - cpf do funcionário que identifica o funcionário no banco de dados.
	 * @return - retorna a senha atual do funcionário no banco de dados.
	 */
	private String getCurrentPassword(String cpf) {
		String password = "";
		try {
			checkDatabaseConnection();
			String sql = "SELECT senha FROM tb_funcionario WHERE cpf = ?";
			PreparedStatement stmt = dataBase.con.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				password = rs.getString("senha");
			}
		} catch (Exception e) {
			// Tratar erro
		} finally {
			dataBase.close();
		}
		return password;
	}


	/**
	 * Método que a partir do código passado, executa o comando SQL para a exclusão do funcionário no banco de dados.
	 * @param funcionario - objeto do tipo funcionário que identifica o funcionário a ser excluído no banco de dados.
	 */
	public void excluirFuncionario(Funcionario funcionario) throws Exception {
		checkDatabaseConnection();
		String sql = "DELETE FROM tb_funcionario WHERE cpf = ?";
		try {
			PreparedStatement preparedStatement = dataBase.con.prepareStatement(sql);
			preparedStatement.setString(1, funcionario.getCpf());
			preparedStatement.execute();
		} catch (SQLException e) {
			throw new Exception("Erro ao excluir o funcionário: " + e);
		} finally {
			dataBase.close();
		}
	}

	/**
	 * Método que cria um ArrayList do tipo Funcionario para listar todos os funcionários do banco de dados.
	 * A partir de um comando SQL.
	 *
	 * @return
	 * @throws Exception
	 */
	public List<Funcionario> consultarFuncionarios() throws Exception {
		checkDatabaseConnection();
		var lista = new ArrayList<Funcionario>();
		String sql = "select nome,email,cpf,rg,endereco,telefone,celular,numero,cep,FORMAT(data_nascimento, 'dd/MM/yyyy')as data_nascimento,bairro,cidade,uf,complemento,"
				+ "limite, senha , cargo , nivel_acesso , pis_pasep , salario , carteira_trabalho , estado_civil , jornada_trabalho ,FORMAT(admissao, 'dd/MM/yyyy')as admissao ,"
				+ " FORMAT(demissao, 'dd/MM/yyyy')as demissao, ativo from tb_funcionario";

		try {
			PreparedStatement preparedStatement = dataBase.con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				lista.add(criarFuncionarioDoResultSet(resultSet));
			}
			return lista;
		} catch (SQLException e) {
			throw new Exception("Erro ao listar funcionários: " + e);
		} finally {
			dataBase.close();
		}
	}

	/**
	 * Método que cria um ArrayList do tipo Funcionario para listar os funcionários do banco de dados que
	 * corresponde ao nome digitado. A partir de um comando SQL.
	 *
	 * @param nome - parametro utilizado como base de pesquisa.
	 * @return - retorna uma lista com os resultados encontrados.
	 * @throws Exception
	 */
	public List<Funcionario> consultarFuncionariosPorNome(String nome) throws Exception {
		checkDatabaseConnection();
		var lista = new ArrayList<Funcionario>();
		String sql = "select nome,email,cpf,rg,endereco,telefone,celular,numero,cep,FORMAT(data_nascimento, 'dd/MM/yyyy')as data_nascimento,bairro,cidade,uf,complemento,"
				+ "limite, senha , cargo , nivel_acesso , pis_pasep , salario , carteira_trabalho , estado_civil , jornada_trabalho ,FORMAT(admissao, 'dd/MM/yyyy')as admissao ,"
				+ " FORMAT(demissao, 'dd/MM/yyyy')as demissao, ativo from tb_funcionario where nome like ?";
		try {
			PreparedStatement preparedStatement = dataBase.con.prepareStatement(sql);
			preparedStatement.setString(1, "%" + nome + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				lista.add(criarFuncionarioDoResultSet(resultSet));
			}
			return lista;
		} catch (SQLException e) {
			throw new Exception("Erro ao buscar funcionário por nome: " + e);
		} finally {
			dataBase.close();
		}
	}

	private Funcionario criarFuncionarioDoResultSet(ResultSet resultSet) throws SQLException {
		var funcionario = new Funcionario();

		funcionario.setNome(resultSet.getString("nome"));
		funcionario.setEmail(resultSet.getString("email"));
		funcionario.setCpf(resultSet.getString("cpf"));
		funcionario.setRg(resultSet.getString("rg"));
		funcionario.setEndereco(resultSet.getString("endereco"));
		funcionario.setTelefone(resultSet.getString("telefone"));
		funcionario.setCelular(resultSet.getString("celular"));
		funcionario.setNumero(resultSet.getInt("numero"));
		funcionario.setCep(resultSet.getString("cep"));
		funcionario.setDataNascimento(resultSet.getString("data_nascimento"));
		funcionario.setBairro(resultSet.getString("bairro"));
		funcionario.setCidade(resultSet.getString("cidade"));
		funcionario.setUf(resultSet.getString("uf"));
		funcionario.setComplemento(resultSet.getString("complemento"));
		funcionario.setLimite(resultSet.getDouble("limite"));
		//funcionario.setSenha(resultSet.getString("senha"));
		funcionario.setCargo(resultSet.getString("cargo"));
		funcionario.setNivelAcesso(resultSet.getString("nivel_acesso"));
		funcionario.setPisPasep(resultSet.getString("pis_pasep"));
		funcionario.setSalario(resultSet.getDouble("salario"));
		funcionario.setCarteiraTrabalho(resultSet.getString("carteira_trabalho"));
		funcionario.setEstadoCivil(resultSet.getString("estado_civil"));
		funcionario.setJornadaTrabalho(resultSet.getString("jornada_trabalho"));
		funcionario.setAdmissao(resultSet.getString("admissao"));
		funcionario.setDemissao(resultSet.getString("demissao"));
		funcionario.setAtivo(resultSet.getString("ativo"));

		return funcionario;
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
					String sql = "select nome,email,cpf,rg,endereco,telefone,celular,numero,cep,FORMAT(data_nascimento, 'dd/MM/yyyy')as data_nascimento,bairro,cidade,uf,complemento,"
							+ "limite, senha , cargo , nivel_acesso , pis_pasep , salario , carteira_trabalho , estado_civil , jornada_trabalho , admissao ,"
							+ "demissao, ativo from tb_funcionario WHERE cpf = ?";
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
		 * Método que a partir de um comando de pesquisa do SQL, efetua uma verificação para
		 *  conferir se há um funcionário cadastrado com permissão de uso no sistema.
		 * @param email - parametro a ser conferido como nome de usuário.
		 * @param senha - parametro a ser conferido como nome de senha.
		 */
		public boolean autenticar(String email, String senha) {
			boolean status = false;

			if(dataBase.getConnection()) {

			try {
				String sql = "select * from tb_funcionario where email=? and senha=?";

				dataBase.preparedStatement = dataBase.con.prepareStatement(sql);
				dataBase.preparedStatement.setString(1,email);
				dataBase.preparedStatement.setString(2,senha);


				dataBase.resultSet = dataBase.preparedStatement.executeQuery();

				if(dataBase.resultSet.next()) {

					if(dataBase.resultSet.getString("nivel_acesso").equals("Gerente")) {

						JOptionPane.showMessageDialog(null, "Seja bem vindo ao Sistema " + dataBase.resultSet.getString("Nome"));
						FrmMenuPrincipal frmMenuPrincipal = new FrmMenuPrincipal();
						frmMenuPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
						frmMenuPrincipal.setCpfFuncionario(dataBase.resultSet.getString("cpf"));
						frmMenuPrincipal.setVisible(true);
						frmMenuPrincipal.setSituacaoCaixa(false);
						status = true;

					}else if (dataBase.resultSet.getString("nivel_acesso").equals("Caixa")) {
						JOptionPane.showMessageDialog(null, "Seja bem vindo ao Sistema " + dataBase.resultSet.getString("Nome"));
						FrmMenuPrincipal frmMenuPrincipal = new FrmMenuPrincipal();
						frmMenuPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
						frmMenuPrincipal.setCpfFuncionario(dataBase.resultSet.getString("cpf"));
						frmMenuPrincipal.setVisible(true);
						frmMenuPrincipal.setSituacaoCaixa(false);
						frmMenuPrincipal.mnCategoria.setVisible(false);
						frmMenuPrincipal.mnClientes.setVisible(false);
						frmMenuPrincipal.mnEstoque.setVisible(false);
						frmMenuPrincipal.mnFornecedores.setVisible(false);
						frmMenuPrincipal.mnFuncionarios.setVisible(false);
						status = true;


					}else if (dataBase.resultSet.getString("nivel_acesso").equals("Estoquista")) {
						JOptionPane.showMessageDialog(null, "Seja bem vindo ao Sistema " + dataBase.resultSet.getString("Nome"));
						FrmMenuPrincipal frmMenuPrincipal = new FrmMenuPrincipal();
						frmMenuPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
						frmMenuPrincipal.setCpfFuncionario(dataBase.resultSet.getString("cpf"));
						frmMenuPrincipal.setVisible(true);
						frmMenuPrincipal.setSituacaoCaixa(false);
						frmMenuPrincipal.mnClientes.setVisible(false);
						frmMenuPrincipal.mnVendas.setVisible(false);
						frmMenuPrincipal.mnFuncionarios.setVisible(false);
						status = true;
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
			return status;

		}

	}
