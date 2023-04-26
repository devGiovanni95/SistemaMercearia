package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import model.Funcionario;
import view.FrmMenuPrincipal;

// TODO: Auto-generated Javadoc
/**
 * The Class FuncionarioController.
 */
public class FuncionarioController {

	/** The connection. */
	private Connection connection;
	
	/**
	 * Método que cria uma conexão com banco de dados.
	 */
	public FuncionarioController() {
		this.connection =  new ConnectionFactory().getConnection();
	}


	/**
	 * Método efetua um comando SQL para efetuar a inserção no banco de dados de um novo funcionario.
	 *
	 * @param funcionario the funcionario
	 */
	public void cadastrarFuncionario(Funcionario funcionario) {
		try {
				
			String sql = "insert into tb_funcionarios(nome,email,cpf,rg,endereco,telefone,celular,numero,cep,dataNascimento,bairro,cidade,uf,"
					+ "complemento,limite,senha,cargo,nivelAcesso,pisPasep,salario,carteiraTrabalho,estadoCivil,jornadaTrabalho,admissao,demissao,ativo) "
					+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, funcionario.getNome());
			preparedStatement.setString(2, funcionario.getEmail());
			preparedStatement.setString(3, funcionario.getCpf());
			preparedStatement.setString(4, funcionario.getRg());
			preparedStatement.setString(5, funcionario.getEndereco());
			preparedStatement.setString(6, funcionario.getTelefone());
			preparedStatement.setString(7, funcionario.getCelular());
			preparedStatement.setInt(8, funcionario.getNumero());
			preparedStatement.setString(9, funcionario.getCep());
			preparedStatement.setString(10, funcionario.getDataNascimento());
			preparedStatement.setString(11, funcionario.getBairro());
			preparedStatement.setString(12, funcionario.getCidade());
			preparedStatement.setString(13, funcionario.getUf());
			preparedStatement.setString(14, funcionario.getComplemento());
			preparedStatement.setDouble(15, funcionario.getLimite());
			preparedStatement.setString(16, funcionario.getSenha());
			preparedStatement.setString(17, funcionario.getCargo());
			preparedStatement.setString(18, funcionario.getNivelAcesso());
			preparedStatement.setString(19, funcionario.getPisPasep());
			preparedStatement.setDouble(20, funcionario.getSalario());
			preparedStatement.setString(21, funcionario.getCarteiraTrabalho());
			preparedStatement.setString(22, funcionario.getEstadoCivil());
			preparedStatement.setString(23, funcionario.getJornadaTrabalho());
			preparedStatement.setString(24, funcionario.getAdmissao());
			preparedStatement.setString(25, funcionario.getDemissao());
			preparedStatement.setString(26, funcionario.getAtivo());
			
			preparedStatement.execute();
			preparedStatement.close();
			
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
					
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Erro: " + erro);
		} catch(NumberFormatException erro) {
			JOptionPane.showMessageDialog(null, "Erro: " + erro);
		}
	}
	
	
	/**
	 * Método que a partir do código passado, executa o comando SQL para a exclusão do funcionario no banco de dados.
	 * @param funcionario - objeto do tipo funcionario que identifica o funcionario a ser excluido no banco de dados.
	 */
	public void excluirCliente(Funcionario funcionario) {
		try {					
					String sql = "delete from tb_funcionarios where cpf=?";
					
					PreparedStatement preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1, funcionario.getCpf());					
					preparedStatement.execute();
					preparedStatement.close();
					
					JOptionPane.showMessageDialog(null, "Excluido com sucesso");
			
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, "Erro: " + erro);
				}
	}

	
	/**
	 * Método que efetua a alteração de um funcionário já cadastrado no banco de dados.A partir do id do funcionário, 
	 * por meio de um comando SQL.
	 * @param funcionario - objeto do tipo funcionário que identifica o funcionario a ser alterado no banco de dados.
	 */
	public void alterarCliente(Funcionario funcionario) {
		try {
				
				String sql = "update tb_funcionarios set nome=?,email=?,cpf=?,rg=?,endereco=?,telefone=?,celular=?,numero=?,cep=?,dataNascimento=?,bairro=?,cidade=?,uf=?,complemento=?,limite=?,"
						+ "senha=?,cargo=?,nivelAcesso=?,pisPasep=?,salario=?,carteiraTrabalho=?,estadoCivil=?,jornadaTrabalho=?,admissao=?,demissao=?,ativo=? "
						+ " where cpf=?";

				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, funcionario.getNome());
				preparedStatement.setString(2, funcionario.getEmail());
				preparedStatement.setString(3, funcionario.getCpf());
				preparedStatement.setString(4, funcionario.getRg());
				preparedStatement.setString(5, funcionario.getEndereco());
				preparedStatement.setString(6, funcionario.getTelefone());
				preparedStatement.setString(7, funcionario.getCelular());
				preparedStatement.setInt(8, funcionario.getNumero());
				preparedStatement.setString(9, funcionario.getCep());
				preparedStatement.setString(10, funcionario.getDataNascimento());
				preparedStatement.setString(11, funcionario.getBairro());
				preparedStatement.setString(12, funcionario.getCidade());
				preparedStatement.setString(13, funcionario.getUf());
				preparedStatement.setString(14, funcionario.getComplemento());
				preparedStatement.setDouble(15, funcionario.getLimite());
				preparedStatement.setString(16, funcionario.getSenha());
				preparedStatement.setString(17, funcionario.getCargo());
				preparedStatement.setString(18, funcionario.getNivelAcesso());
				preparedStatement.setString(19, funcionario.getPisPasep());
				preparedStatement.setDouble(20, funcionario.getSalario());
				preparedStatement.setString(21, funcionario.getCarteiraTrabalho());
				preparedStatement.setString(22, funcionario.getEstadoCivil());
				preparedStatement.setString(23, funcionario.getJornadaTrabalho());
				preparedStatement.setString(24, funcionario.getAdmissao());
				preparedStatement.setString(25, funcionario.getDemissao());
				preparedStatement.setString(26, funcionario.getAtivo());
				preparedStatement.setString(27, funcionario.getCpf());
				
				preparedStatement.execute();
				preparedStatement.close();
				
				JOptionPane.showMessageDialog(null, "Alterado com sucesso");
								
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, "Erro: " + erro);
			}
	}
	
	
	/**
	 * Método que cria um ArrayList do tipo funcionário para listar todos os funcionários do banco de dados.
	 * A partir de um comando SQL.
	 * @return - retona uma lista com todos de funcionários 
	 */
	public List<Funcionario> listarFuncionario() {
		try {

			List<Funcionario> lista = new ArrayList<>();

			String sql = "select * from tb_funcionarios";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Funcionario funcionario = new Funcionario();
				
				funcionario.setNome(resultSet.getString("nome"));
				funcionario.setEmail(resultSet.getString("email"));
				funcionario.setCpf(resultSet.getString("cpf"));
				funcionario.setRg(resultSet.getString("rg"));
				funcionario.setEndereco(resultSet.getString("endereco"));
				funcionario.setTelefone(resultSet.getString("telefone"));
				funcionario.setCelular(resultSet.getString("celular"));
				funcionario.setNumero(resultSet.getInt("numero"));
				funcionario.setCep(resultSet.getString("cep"));
				funcionario.setDataNascimento(resultSet.getString("dataNascimento"));
				funcionario.setBairro(resultSet.getString("bairro"));
				funcionario.setCidade(resultSet.getString("cidade"));
				funcionario.setUf(resultSet.getString("uf"));
				funcionario.setComplemento(resultSet.getString("complemento"));
				funcionario.setLimite(resultSet.getDouble("limite"));				
				funcionario.setSenha(resultSet.getString("senha"));
				funcionario.setCargo(resultSet.getString("cargo"));
				funcionario.setNivelAcesso(resultSet.getString("nivelAcesso"));
				funcionario.setPisPasep(resultSet.getString("pisPasep"));
				funcionario.setSalario(resultSet.getDouble("salario"));
				funcionario.setCarteiraTrabalho(resultSet.getString("carteiraTrabalho"));
				funcionario.setEstadoCivil (resultSet.getString("estadoCivil"));
				funcionario.setJornadaTrabalho(resultSet.getString("jornadaTrabalho"));
				funcionario.setAdmissao(resultSet.getString("admissao"));
				funcionario.setDemissao(resultSet.getString("demissao"));
				funcionario.setDemissao(resultSet.getString("ativo"));
										
				lista.add(funcionario);
			}
			
			return lista;
						
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e );
			return null;
		}
	}
	
	
	/**
	 * Método que cria um ArrayList do tipo funcionário para listar os funcionários do banco de dados que
	 *  corresponde ao nome digitado. A partir de um comando SQL.
	 *
	 * @param nome - parametro utilizado como base de pesquisa.
	 * @return the list
	 */
	public List<Funcionario> buscarFuncionarioPeloNome(String nome) {
		try {
			
			List<Funcionario> lista = new ArrayList<>();
			
			String sql = "select * from tb_funcionarios where nome like ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,nome);			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Funcionario funcionario = new Funcionario();
				
				funcionario.setNome(resultSet.getString("nome"));
				funcionario.setEmail(resultSet.getString("email"));
				funcionario.setCpf(resultSet.getString("cpf"));
				funcionario.setRg(resultSet.getString("rg"));
				funcionario.setEndereco(resultSet.getString("endereco"));
				funcionario.setTelefone(resultSet.getString("telefone"));
				funcionario.setCelular(resultSet.getString("celular"));
				funcionario.setNumero(resultSet.getInt("numero"));
				funcionario.setCep(resultSet.getString("cep"));
				funcionario.setDataNascimento(resultSet.getString("dataNascimento"));
				funcionario.setBairro(resultSet.getString("bairro"));
				funcionario.setCidade(resultSet.getString("cidade"));
				funcionario.setUf(resultSet.getString("uf"));
				funcionario.setComplemento(resultSet.getString("complemento"));
				funcionario.setLimite(resultSet.getDouble("limite"));
				funcionario.setSenha(resultSet.getString("senha"));
				funcionario.setCargo(resultSet.getString("cargo"));
				funcionario.setNivelAcesso(resultSet.getString("nivelAcesso"));
				funcionario.setPisPasep(resultSet.getString("pisPasep"));
				funcionario.setSalario(resultSet.getDouble("salario"));
				funcionario.setCarteiraTrabalho(resultSet.getString("carteiraTrabalho"));
				funcionario.setEstadoCivil (resultSet.getString("estadoCivil"));
				funcionario.setJornadaTrabalho(resultSet.getString("jornadaTrabalho"));
				funcionario.setAdmissao(resultSet.getString("admissao"));
				funcionario.setDemissao(resultSet.getString("demissao"));
				funcionario.setDemissao(resultSet.getString("ativo"));
				
				lista.add(funcionario);
			}
			
			return lista;
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e );
			return null;
		}
	}
	
	
	/**
	 * Método que a partir de um comando de pesquisa do SQL, efetua uma verificação para
	 *  conferir se há um funcionário cadastrado com permissão de uso no sistema.
	 * @param email - parametro a ser conferido como nome de usuário.
	 * @param senha - parametro a ser conferido como nome de senha.
	 */
	public void efetuarLogin(String email, String senha) {
		
		try {
			String sql = "select * from tb_funcionarios where email=? and senha=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,email);	
			preparedStatement.setString(2,senha);	
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				JOptionPane.showMessageDialog(null, "Seja bem vindo ao Sistema ");	
				FrmMenuPrincipal frmMenuPrincipal = new FrmMenuPrincipal();
				frmMenuPrincipal.usuarioLogado = resultSet.getString("nome");
				frmMenuPrincipal.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "Dados incorretos");
			}
						
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e );
		}
	}
	
}
