package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import controller.FuncionarioController;
import model.Funcionario;
import util.LengthRestrictedDocument;
import util.LimparCampos;
import util.TextFieldLimit;
import util.DataUtils;

import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.border.LineBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class FrmFuncionario.
 */
public class FrmFuncionario extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The content pane. */
	private JPanel contentPane;

	/** The tf codigo. */
	private JTextField tfCodigo;

	/** The tf nome. */
	private JTextField tfNome;

	/** The tf email. */
	private JTextField tfEmail;

	/** The tf numero. */
	private JTextField tfNumero;

	/** The tf cpf. */
	private JFormattedTextField tfCpf;

	/** The tf bairro. */
	private JTextField tfBairro;

	/** The tf cidade. */
	private JTextField tfCidade;

	/** The tf celular. */
	private JFormattedTextField tfCelular;

	/** The tf telefone. */
	private JFormattedTextField tfTelefone;

	/** The tf cep. */
	private JFormattedTextField tfCep;

	/** The tf limite. */
	private JTextField tfLimite;

	/** The tf complemento. */
	private JTextField tfComplemento;

	/** The tf nome pesquisa. */
	private JTextField tfNomePesquisa;

	/** The tabela funcionarios. */
	private JTable tabelaFuncionarios;

	/** The tf rg. */
	private JFormattedTextField tfRg;

	/** The tf senha. */
	private JTextField tfSenha;

	/** The tf cargo. */
	private JTextField tfCargo;

	/** The tf pis pasep. */
	private JTextField tfPisPasep;

	/** The tf salario. */
	private JTextField tfSalario;

	/** The tf carteira trabalho. */
	private JTextField tfCarteiraTrabalho;

	/** The cb estado civil. */
	private JComboBox<String> cbEstadoCivil;

	/** The tf jornada trabalho. */
	private JTextField tfJornadaTrabalho;

	/** The tf admissao. */
	private JTextField tfAdmissao;

	/** The tf endereco. */
	private JTextField tfEndereco;

	/** The cb nivel acesso 1. */
	private JComboBox<String> cbNivelAcesso;

	/** The cb ativo 1. */
	private JComboBox<String> cbAtivo;

	/** The cb uf. */
	private JComboBox<String> cbUf;

	/** The aba dados pessoais. */
	private JPanel abaDadosPessoais;

	/** The tf data nascimento. */
	private JFormattedTextField tfDataNascimento;

	private DefaultTableModel dadosTabela;

	private FuncionarioController funcionarioController = new FuncionarioController();

	private JFormattedTextField tfDemissao;

	private static int currentYear;

	private DataUtils dataUtils;

	/**
	 * Método responsavel por limpar a tela referenciada. *
	 * 
	 * @param tela -a tela para ser limpada.
	 *             Caso de Uso (USC-007)
	 */
	private void limparTela(JPanel tela) {
		LimparCampos limpar = new LimparCampos();
		limpar.Limpar(tela);
	}

	/**
	 * Método utilizado para cadastrar um novo funcionario com as informações
	 * preenchidas nos campos do formulário.
	 * Caso de Uso (USC-007)
	 */
	private void cadastrarFuncionario() {
		try {
			Funcionario funcionario = criarFuncionario(true);
			funcionarioController.cadastrarFuncionario(funcionario);

			limparTela(abaDadosPessoais);

			JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Método responsável por alterar os dados de um funcionário cadastrado.
	 * Os dados são obtidos dos campos de texto na interface gráfica e armazenados
	 * em um objeto do tipo Funcionario,
	 * Caso de Uso (USC-007)
	 */
	private void alterarFuncionario() {
		try {
			Funcionario funcionario = criarFuncionario(false);
			funcionarioController.alterarFuncionario(funcionario);

			limparTela(abaDadosPessoais);

			JOptionPane.showMessageDialog(null, "Funcionário alterado com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Método responsável por criar um novo funcionário e fazer as validações
	 * necessarias
	 * 
	 * @param novoFuncionario - parametro do tipo booleano, responsável por validar
	 *                        se está sendo criado um novo funcionario.
	 * @return funcionario - Retorna um objeto instanciado do tipo funcionario.
	 * @throws Exception - Gera uma excessão caso ocorra de um erro na criação do
	 *                   funcionario.
	 *                   Caso de Uso (USC-007)
	 */
	private Funcionario criarFuncionario(boolean novoFuncionario) throws Exception {
		Funcionario funcionario = new Funcionario();

		// Validação dos campos de entrada.
		if (tfNome.getText().trim().isEmpty()) {
			throw new Exception("O nome do funcionário é obrigatório.");
		}
		if (tfEmail.getText().trim().isEmpty()) {
			throw new Exception("O e-mail do funcionário é obrigatório.");
		}
		if (tfCpf.getText().trim().isEmpty()) {
			throw new Exception("O CPF do funcionário é obrigatório.");
		}
		if (novoFuncionario && tfSenha.getText().trim().isEmpty()) {
			throw new Exception("A senha é obrigatória para um novo funcionário.");
		}

		funcionario.setNome(tfNome.getText());
		funcionario.setEmail(tfEmail.getText());
		funcionario.setCpf(tfCpf.getText());
		funcionario.setRg(tfRg.getText());
		funcionario.setEndereco(tfEndereco.getText());
		funcionario.setTelefone(tfTelefone.getText());
		funcionario.setCelular(tfCelular.getText());
		funcionario.setNumero(Integer.parseInt(tfNumero.getText()));
		funcionario.setCep(tfCep.getText());
		funcionario.setDataNascimento(tfDataNascimento.getText());
		funcionario.setBairro(tfBairro.getText());
		funcionario.setCidade(tfCidade.getText());
		funcionario.setUf(cbUf.getSelectedItem().toString());
		funcionario.setComplemento(tfComplemento.getText());
		funcionario.setLimite(Double.parseDouble(tfLimite.getText()));
		funcionario.setSenha(tfSenha.getText());
		funcionario.setCargo(tfCargo.getText());
		funcionario.setNivelAcesso(cbNivelAcesso.getSelectedItem().toString());
		funcionario.setPisPasep(tfPisPasep.getText());
		funcionario.setSalario(Double.parseDouble(tfSalario.getText()));
		funcionario.setCarteiraTrabalho(tfCarteiraTrabalho.getText());
		funcionario.setEstadoCivil(cbEstadoCivil.getSelectedItem().toString());
		funcionario.setJornadaTrabalho(tfJornadaTrabalho.getText());
		funcionario.setAdmissao(tfAdmissao.getText());
		funcionario.setDemissao(tfDemissao.getText());
		funcionario.setAtivo(cbAtivo.getSelectedItem().toString());

		return funcionario;
	}

	/**
	 * Metodo utilizado para listar todos os funcionários e adiciona-los na tabela.
	 * Caso de Uso (USC-007)
	 */
	private void consultarFuncionarios() {
		try {
			List<Funcionario> lista = funcionarioController.consultarFuncionarios();
			configurarTabelaFuncionarios();

			for (Funcionario funcionario : lista) {
				adicionarFuncionarioNaTabela(funcionario);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Método utilizado para consultar funcionários pelo nome ou parte do nome para
	 * exibir na tabela.
	 * O texto pesquisado é obtido a partir do texto digitado pelo usuário.
	 * Caso de Uso (USC-007)
	 */
	private void consultarFuncionariosPorNome() {
		try {
			String nomePesquisado = "%" + tfNomePesquisa.getText() + "%";
			List<Funcionario> lista = funcionarioController.consultarFuncionariosPorNome(nomePesquisado);
			configurarTabelaFuncionarios();

			for (Funcionario funcionario : lista) {
				adicionarFuncionarioNaTabela(funcionario);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Método utilizado para configurar a tabela de funcionários.
	 * Caso de Uso (USC-007)
	 */
	private void configurarTabelaFuncionarios() {
		dadosTabela = (DefaultTableModel) tabelaFuncionarios.getModel();
		dadosTabela.setNumRows(0);
		dadosTabela.setColumnCount(25);
		// dadosTabela.addRow(new
		// Object[]{"Nome","E-mail","CPF","RG","Endereço","Telefone","Celular","Numero","CEP","Data
		// Nascimento", "Bairro",
		// "Cidade","UF","Complemento","Limite","Senha","Cargo","Nivel Acesso","Pis
		// Pasep","Salário","Carteira de Trabalho","Estado Civil","Jornada
		// Trabalho","Admissão","Demissão","Ativo"});

		dadosTabela.addRow(new Object[] { "Nome", "E-mail", "CPF", "RG", "Endereço", "Telefone", "Celular", "Numero",
				"CEP", "Data Nascimento", "Bairro",
				"Cidade", "UF", "Complemento", "Limite", "Cargo", "Nivel Acesso", "Pis Pasep", "Salário",
				"Carteira de Trabalho", "Estado Civil", "Jornada Trabalho", "Admissão", "Demissão", "Ativo" });
	}

	/**
	 * Adicionar funcionário na tabela: método utilizado para adicionar um
	 * funcionário na tabela.
	 * 
	 * @param funcionario objeto do tipo Funcionario: funcionário a ser adicionado
	 *                    na tabela.
	 *                    Caso de Uso (USC-007)
	 */
	private void adicionarFuncionarioNaTabela(Funcionario funcionario) {
		dadosTabela.addRow(new Object[] {
				funcionario.getNome(),
				funcionario.getEmail(),
				funcionario.getCpf(),
				funcionario.getRg(),
				funcionario.getEndereco(),
				funcionario.getTelefone(),
				funcionario.getCelular(),
				funcionario.getNumero(),
				funcionario.getCep(),
				funcionario.getDataNascimento(),
				funcionario.getBairro(),
				funcionario.getCidade(),
				funcionario.getUf(),
				funcionario.getComplemento(),
				funcionario.getLimite(),
				// funcionario.getSenha(),
				funcionario.getCargo(),
				funcionario.getNivelAcesso(),
				funcionario.getPisPasep(),
				funcionario.getSalario(),
				funcionario.getCarteiraTrabalho(),
				funcionario.getEstadoCivil(),
				funcionario.getJornadaTrabalho(),
				funcionario.getAdmissao(),
				funcionario.getDemissao(),
				funcionario.getAtivo()
		});
	}

	/**
	 * Exclui o funcionário selecionado na tabela de funcionários.
	 * Obtém o CPF do funcionário a partir do campo de texto correspondente na tela.
	 * Em seguida, os campos de texto na interface gráfica são limpos após a
	 * exclusão.
	 * Caso de Uso (USC-007)
	 */
	private void excluirFuncionario() {
		Funcionario funcionario = new Funcionario();

		try {
			funcionario = funcionarioController.consultarFuncionariosPorCpf(tfCpf.getText());
			funcionarioController.excluirFuncionario(funcionario);
			JOptionPane.showMessageDialog(null, "Funcionário excluído com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		limparTela(abaDadosPessoais);
	}

	/**
	 * Método responsável por preencher os campos da tela principal com os dados do
	 * funcionários selecionado na tabela para que possam ser alterados.
	 * A partir da linha selecionada na tabela
	 * Caso de Uso (USC-007)
	 */
	private void preencherDadosFuncionario() {
		abaPrincipal.setSelectedIndex(0);
		tfNome.setText(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 0).toString());
		tfEmail.setText(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 1).toString());
		tfCpf.setText(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 2).toString());
		tfCodigo.setText(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 2).toString());
		tfRg.setText(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 3).toString());
		tfEndereco.setText(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 4).toString());
		tfTelefone.setText(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 5).toString());
		tfCelular.setText(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 6).toString());
		tfNumero.setText(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 7).toString());
		tfCep.setText(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 8).toString());
		tfDataNascimento.setText(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 9).toString());
		tfBairro.setText(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 10).toString());
		tfCidade.setText(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 11).toString());
		cbUf.setSelectedItem(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 12).toString());
		tfComplemento.setText(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 13).toString());
		tfCargo.setText(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 15).toString());
		cbNivelAcesso
				.setSelectedItem(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 16).toString());
		tfPisPasep.setText(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 17).toString());
		tfCarteiraTrabalho.setText(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 19).toString());
		cbEstadoCivil
				.setSelectedItem(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 20).toString());
		tfJornadaTrabalho.setText(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 21).toString());
		tfAdmissao.setText(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 22).toString());
		tfDemissao.setText(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 23).toString());
		cbAtivo.setSelectedItem(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 24).toString());

		JTextField[] numericFields = { tfLimite, tfSalario };
		int[] numericColumns = { 14, 18 };

		for (int i = 0; i < numericFields.length; i++) {
			try {
				numericFields[i].setText(Integer.toString((int) Double
						.parseDouble(tabelaFuncionarios
								.getValueAt(tabelaFuncionarios.getSelectedRow(), numericColumns[i]).toString())));
			} catch (NumberFormatException e) {
				numericFields[i].setText("0"); // Valor padrão em caso de erro
				JOptionPane.showMessageDialog(null,
						"Erro ao converter valor numérico do campo " + numericFields[i].getName() + "!", "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Método responsável por conferir se a data inserida está correta ou nao;
	 * 
	 * @throws ParseException - Se acontecer algum erro em tempo de execução é
	 *                        lançado um erro
	 *                        Caso de Uso (USC-007)
	 */
	public void setupDemissaoField() throws ParseException {

		MaskFormatter maskFormatter = new MaskFormatter("##/##/####");
		maskFormatter.setAllowsInvalid(true);

		tfDemissao = new JFormattedTextField(maskFormatter);
		tfDemissao.setFont(new Font("Arial", Font.BOLD, 14));
		tfDemissao.setColumns(10);

		dataUtils.addDateVerifier(tfDemissao, currentYear - 100, currentYear + 100);
	}

	/**
	 * Método responsável por realizar a conferencia e a validação de uma data no
	 * campo TfDemissão
	 * Caso de Uso (USC-007)
	 */
	public void saveData() {

		String demissaoDate = tfDemissao.getText().trim();

		// Agora estamos usando o método isDateValid da classe DateUtils
		if (!demissaoDate.isEmpty() && !dataUtils.isDateValid(demissaoDate)) {
			JOptionPane.showMessageDialog(null, "A data de demissão inserida não é válida.", "Erro",
					JOptionPane.ERROR_MESSAGE);
			return; // Interrompe a operação de salvamento
		}
	}

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmFuncionario frame = new FrmFuncionario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	static {
		currentYear = Calendar.getInstance().get(Calendar.YEAR);
	}

	/** The aba principal. */
	public JTabbedPane abaPrincipal;

	/**
	 * Create the frame.
	 *
	 * @throws ParseException the parse exception
	 */
	public FrmFuncionario() throws ParseException {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				consultarFuncionarios();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmCategoria.class.getResource("/assets/produto.png")));
		setBackground(new Color(202, 240, 248));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1360, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(202, 240, 248));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);

		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(22, 138, 173));

		abaPrincipal = new JTabbedPane(JTabbedPane.TOP);
		abaPrincipal.setBackground(new Color(202, 240, 248));

		abaDadosPessoais = new JPanel();
		abaDadosPessoais.setBackground(new Color(202, 240, 248));
		abaPrincipal.addTab("Dados Pessoais", null, abaDadosPessoais, null);

		dataUtils = new DataUtils();

		JLabel lbCodigo = new JLabel("Código: ");
		lbCodigo.setFont(new Font("Arial", Font.BOLD, 14));

		tfCodigo = new JTextField();
		tfCodigo.setEditable(false);
		tfCodigo.setFont(new Font("Arial", Font.BOLD, 14));
		tfCodigo.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.BOLD, 14));

		tfNome = new JTextField();
		tfNome = new TextFieldLimit(70, new TextFieldLimit.ValidadorString());
		tfNome.setFont(new Font("Arial", Font.BOLD, 14));
		tfNome.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 14));

		tfEmail = new JTextField();
		tfEmail = new TextFieldLimit(50, new TextFieldLimit.ValidadorString());
		tfEmail.setFont(new Font("Arial", Font.BOLD, 14));
		tfEmail.setColumns(10);

		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblNumero = new JLabel("Numero: ");
		lblNumero.setFont(new Font("Arial", Font.BOLD, 14));

		tfNumero = new JTextField();
		tfNumero = new TextFieldLimit(9, new TextFieldLimit.ValidadorInteiro());
		tfNumero.setFont(new Font("Arial", Font.BOLD, 14));
		tfNumero.setColumns(10);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Arial", Font.BOLD, 14));

		tfBairro = new JTextField();
		tfBairro = new TextFieldLimit(50, new TextFieldLimit.ValidadorString());
		tfBairro.setFont(new Font("Arial", Font.BOLD, 14));
		tfBairro.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Arial", Font.BOLD, 14));

		tfCidade = new JTextField();
		tfCidade = new TextFieldLimit(50, new TextFieldLimit.ValidadorString());
		tfCidade.setFont(new Font("Arial", Font.BOLD, 14));
		tfCidade.setColumns(10);

		JLabel lblCnpj_1_3 = new JLabel("CNPJ: ");
		lblCnpj_1_3.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Arial", Font.BOLD, 14));

		tfCelular = new JFormattedTextField(new MaskFormatter("(##) ####-####"));
		tfCelular.setFont(new Font("Arial", Font.BOLD, 14));
		tfCelular.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Arial", Font.BOLD, 14));

		tfTelefone = new JFormattedTextField(new MaskFormatter("(##) # ####-####"));
		tfTelefone.setFont(new Font("Arial", Font.BOLD, 14));
		tfTelefone.setColumns(10);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Arial", Font.BOLD, 14));

		tfCep = new JFormattedTextField(new MaskFormatter("##.###-###"));
		tfCep.setFont(new Font("Arial", Font.BOLD, 14));
		tfCep.setColumns(10);

		cbUf = new JComboBox<String>();
		cbUf.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
						"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cbUf.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblUf = new JLabel("UF:");
		lblUf.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblLimite = new JLabel("Limite:");
		lblLimite.setFont(new Font("Arial", Font.BOLD, 14));

		tfLimite = new JTextField();
		tfLimite = new TextFieldLimit(7, new TextFieldLimit.ValidadorDecimal());
		tfLimite.setFont(new Font("Arial", Font.BOLD, 14));
		tfLimite.setColumns(10);

		tfComplemento = new JTextField();
		tfComplemento = new TextFieldLimit(30, new TextFieldLimit.ValidadorString());
		tfComplemento.setFont(new Font("Arial", Font.BOLD, 14));
		tfComplemento.setColumns(10);

		tfCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		tfCpf.setFont(new Font("Arial", Font.BOLD, 14));
		tfCpf.setColumns(10);

		JLabel lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Arial", Font.BOLD, 14));

		tfRg = new JFormattedTextField(new MaskFormatter("##.###.###-#"));
		tfRg.setFont(new Font("Arial", Font.BOLD, 14));
		tfRg.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Arial", Font.BOLD, 14));

		// tfSenha = new JTextField();
		// tfSenha = new TextFieldLimit(30, new TextFieldLimit.ValidadorString());
		// tfSenha.setColumns(10);
		// JPasswordField tfSenha = new JPasswordField();
		tfSenha = new JPasswordField();
		tfSenha.setFont(new Font("Arial", Font.BOLD, 14));
		tfSenha.setDocument(new LengthRestrictedDocument(30));

		JLabel lblNivelDeAcesso = new JLabel("Nível de Acesso:");
		lblNivelDeAcesso.setFont(new Font("Arial", Font.BOLD, 14));
		cbNivelAcesso = new JComboBox<String>();
		cbNivelAcesso.setFont(new Font("Arial", Font.PLAIN, 14));
		cbNivelAcesso.setModel(
				new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Gerente", "Estoquista", "Caixa" }));

		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Arial", Font.BOLD, 14));

		tfCargo = new JTextField();
		tfCargo = new TextFieldLimit(30, new TextFieldLimit.ValidadorString());
		tfCargo.setFont(new Font("Arial", Font.BOLD, 14));
		tfCargo.setColumns(10);

		JLabel lblPisPasep = new JLabel("PIS / PASEP:");
		lblPisPasep.setFont(new Font("Arial", Font.BOLD, 14));

		tfPisPasep = new JTextField();
		// tfPisPasep = new TextFieldLimit(11, new TextFieldLimit.ValidadorString());
		tfPisPasep = new JFormattedTextField(new MaskFormatter("###.#####.##-#"));
		tfPisPasep.setFont(new Font("Arial", Font.BOLD, 14));
		tfPisPasep.setColumns(10);

		tfSalario = new JTextField();
		tfSalario = new TextFieldLimit(7, new TextFieldLimit.ValidadorDecimal());
		tfSalario.setFont(new Font("Arial", Font.BOLD, 14));
		tfSalario.setColumns(10);

		JLabel lblSalario = new JLabel("Salário:");
		lblSalario.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblCtps = new JLabel("CTPS:");
		lblCtps.setFont(new Font("Arial", Font.BOLD, 14));

		tfCarteiraTrabalho = new JFormattedTextField(new MaskFormatter("#######-####"));
		tfCarteiraTrabalho.setFont(new Font("Arial", Font.BOLD, 14));
		tfCarteiraTrabalho.setColumns(10);

		JLabel lblCtps_1 = new JLabel("Estado Civil:");
		lblCtps_1.setFont(new Font("Arial", Font.BOLD, 14));

		cbEstadoCivil = new JComboBox<String>();
		cbEstadoCivil.setFont(new Font("Arial", Font.BOLD, 14));
		cbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "", "Solteiro(a)", "Casado(a)", "Divorciado(a)" }));

		JLabel lblJornada = new JLabel("Jornada:");
		lblJornada.setFont(new Font("Arial", Font.BOLD, 14));

		tfJornadaTrabalho = new JTextField();
		tfJornadaTrabalho = new TextFieldLimit(40, new TextFieldLimit.ValidadorString());
		tfJornadaTrabalho.setFont(new Font("Arial", Font.BOLD, 14));
		tfJornadaTrabalho.setColumns(10);

		JLabel lblAdmissao = new JLabel("Admissão:");
		lblAdmissao.setFont(new Font("Arial", Font.BOLD, 14));

		tfAdmissao = new JFormattedTextField(new MaskFormatter("##/##/####"));
		dataUtils.addDateVerifier((JFormattedTextField) tfAdmissao, currentYear - 100, currentYear + 5);
		tfAdmissao.setFont(new Font("Arial", Font.BOLD, 14));
		tfAdmissao.setColumns(10);

		JLabel lblAtivo = new JLabel("Ativo:");
		lblAtivo.setFont(new Font("Arial", Font.BOLD, 14));
		cbAtivo = new JComboBox<String>();
		cbAtivo.setFont(new Font("Arial", Font.PLAIN, 14));
		cbAtivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Ativo", "Inativo" }));

		tfEndereco = new JTextField();
		tfEndereco = new TextFieldLimit(60, new TextFieldLimit.ValidadorString());
		tfEndereco.setFont(new Font("Arial", Font.BOLD, 14));
		tfEndereco.setColumns(10);

		JLabel lblDemisso = new JLabel("Demissão:");
		lblDemisso.setFont(new Font("Arial", Font.BOLD, 14));

		/*
		 * tfDemissao = new JFormattedTextField(new MaskFormatter("##/##/####"));
		 * dataUtils.addDateVerifier((JFormattedTextField) tfDemissao, currentYear -
		 * 100, currentYear + 100);
		 * tfDemissao.setFont(new Font("Arial", Font.BOLD, 14));
		 * tfDemissao.setColumns(10);
		 */

		try {
			setupDemissaoField(); // Configura o campo tfDemissao
		} catch (ParseException e) {
			e.printStackTrace();
		}

		JLabel lblDataNascimento = new JLabel("Data Nascimento: ");
		lblDataNascimento.setFont(new Font("Arial", Font.BOLD, 14));

		tfDataNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
		dataUtils.addDateVerifier((JFormattedTextField) tfDataNascimento, currentYear - 150, currentYear);
		tfDataNascimento.setFont(new Font("Arial", Font.BOLD, 14));
		tfDataNascimento.setColumns(10);

		GroupLayout gl_abaDadosPessoais = new GroupLayout(abaDadosPessoais);
		gl_abaDadosPessoais.setHorizontalGroup(
				gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
								.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(91)
												.addComponent(lbCodigo)
												.addGap(14)
												.addComponent(tfCodigo, GroupLayout.PREFERRED_SIZE, 190,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(115)
												.addComponent(lblNome)
												.addGap(4)
												.addComponent(tfNome, GroupLayout.PREFERRED_SIZE, 509,
														GroupLayout.PREFERRED_SIZE)
												.addGap(30)
												.addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 33,
														GroupLayout.PREFERRED_SIZE)
												.addGap(4)
												.addComponent(tfCpf, GroupLayout.PREFERRED_SIZE, 217,
														GroupLayout.PREFERRED_SIZE)
												.addGap(39)
												.addComponent(lblRg)
												.addGap(4)
												.addComponent(tfRg, GroupLayout.PREFERRED_SIZE, 174,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(113)
												.addComponent(lblEmail)
												.addGap(4)
												.addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, 509,
														GroupLayout.PREFERRED_SIZE)
												.addGap(4)
												.addComponent(lblTelefone)
												.addGap(14)
												.addComponent(tfTelefone, GroupLayout.PREFERRED_SIZE, 198,
														GroupLayout.PREFERRED_SIZE)
												.addGap(10)
												.addComponent(lblCelular)
												.addGap(6)
												.addComponent(tfCelular, GroupLayout.PREFERRED_SIZE, 174,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(58)
												.addComponent(lblComplemento)
												.addGap(4)
												.addComponent(tfComplemento, GroupLayout.PREFERRED_SIZE, 784,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addComponent(lblLimite)
												.addGap(13)
												.addComponent(tfLimite, GroupLayout.PREFERRED_SIZE, 174,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(111)
												.addComponent(lblSenha)
												.addGap(4)
												.addComponent(tfSenha, GroupLayout.PREFERRED_SIZE, 174,
														GroupLayout.PREFERRED_SIZE)
												.addGap(31)
												.addComponent(lblNivelDeAcesso)
												.addGap(4)
												.addComponent(cbNivelAcesso, GroupLayout.PREFERRED_SIZE, 174,
														GroupLayout.PREFERRED_SIZE)
												.addGap(33)
												.addComponent(lblCargo)
												.addGap(4)
												.addComponent(tfCargo, GroupLayout.PREFERRED_SIZE, 201,
														GroupLayout.PREFERRED_SIZE)
												.addGap(10)
												.addComponent(lblSalario)
												.addGap(13)
												.addComponent(tfSalario, GroupLayout.PREFERRED_SIZE, 176,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(76)
												.addComponent(lblPisPasep)
												.addGap(4)
												.addComponent(tfPisPasep, GroupLayout.PREFERRED_SIZE, 174,
														GroupLayout.PREFERRED_SIZE)
												.addGap(31)
												.addComponent(lblCtps)
												.addGap(4)
												.addComponent(tfCarteiraTrabalho, GroupLayout.PREFERRED_SIZE, 199,
														GroupLayout.PREFERRED_SIZE)
												.addGap(46)
												.addComponent(lblCtps_1)
												.addGap(4)
												.addComponent(cbEstadoCivil, GroupLayout.PREFERRED_SIZE, 199,
														GroupLayout.PREFERRED_SIZE)
												.addGap(10)
												.addComponent(lblJornada)
												.addGap(4)
												.addComponent(tfJornadaTrabalho, GroupLayout.PREFERRED_SIZE, 176,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(88)
												.addComponent(lblAdmissao)
												.addGap(4)
												.addComponent(tfAdmissao, GroupLayout.PREFERRED_SIZE, 174,
														GroupLayout.PREFERRED_SIZE)
												.addGap(31)
												.addComponent(lblAtivo)
												.addGap(4)
												.addComponent(cbAtivo, GroupLayout.PREFERRED_SIZE, 88,
														GroupLayout.PREFERRED_SIZE)
												.addGap(27)
												.addComponent(lblDemisso)
												.addGap(4)
												.addComponent(tfDemissao, GroupLayout.PREFERRED_SIZE, 174,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(10)
												.addComponent(lblCnpj_1_3))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGroup(gl_abaDadosPessoais
														.createParallelGroup(Alignment.TRAILING, false)
														.addGroup(Alignment.LEADING, gl_abaDadosPessoais
																.createSequentialGroup()
																.addGap(87)
																.addComponent(lblEndereo)
																.addGap(4)
																.addComponent(tfEndereco, GroupLayout.PREFERRED_SIZE,
																		509, GroupLayout.PREFERRED_SIZE)
																.addGap(10)
																.addComponent(lblNumero)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(tfNumero, GroupLayout.PREFERRED_SIZE, 63,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(lblCep)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(tfCep, 0, 0, Short.MAX_VALUE))
														.addGroup(Alignment.LEADING, gl_abaDadosPessoais
																.createSequentialGroup()
																.addGap(112)
																.addComponent(lblBairro)
																.addGap(4)
																.addComponent(tfBairro, GroupLayout.PREFERRED_SIZE, 509,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(21)
																.addGroup(gl_abaDadosPessoais
																		.createParallelGroup(Alignment.LEADING)
																		.addGroup(gl_abaDadosPessoais
																				.createSequentialGroup()
																				.addGap(63)
																				.addComponent(tfCidade,
																						GroupLayout.PREFERRED_SIZE, 198,
																						GroupLayout.PREFERRED_SIZE))
																		.addComponent(lblCidade,
																				GroupLayout.PREFERRED_SIZE, 64,
																				GroupLayout.PREFERRED_SIZE))))
												.addGroup(gl_abaDadosPessoais
														.createParallelGroup(Alignment.LEADING, false)
														.addGroup(gl_abaDadosPessoais.createSequentialGroup()
																.addGap(41)
																.addComponent(lblUf)
																.addGap(6)
																.addComponent(cbUf, GroupLayout.PREFERRED_SIZE, 174,
																		GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_abaDadosPessoais.createSequentialGroup()
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(lblDataNascimento)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(tfDataNascimento)))))
								.addGap(41)));
		gl_abaDadosPessoais.setVerticalGroup(
				gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
								.addGap(53)
								.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(2)
												.addComponent(lbCodigo))
										.addComponent(tfCodigo, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE))
								.addGap(43)
								.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(2)
												.addComponent(lblNome))
										.addComponent(tfNome, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(2)
												.addComponent(lblCpf))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(1)
												.addComponent(tfCpf, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(2)
												.addComponent(lblRg))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(1)
												.addComponent(tfRg, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGap(18)
								.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(2)
												.addComponent(lblEmail))
										.addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(2)
												.addComponent(lblTelefone))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(1)
												.addComponent(tfTelefone, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(2)
												.addComponent(lblCelular))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(1)
												.addComponent(tfCelular, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGap(18)
								.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(3)
												.addComponent(lblEndereo))
										.addComponent(tfEndereco, GroupLayout.PREFERRED_SIZE, 25,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(3)
												.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblNumero)
														.addComponent(tfNumero, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblCep)
														.addComponent(tfCep, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblDataNascimento)
														.addComponent(tfDataNascimento, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addGap(18)
								.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(2)
												.addComponent(lblBairro))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(1)
												.addComponent(tfBairro, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(1)
												.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
														.addComponent(tfCidade, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_abaDadosPessoais.createSequentialGroup()
																.addGap(1)
																.addComponent(lblCidade))))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(2)
												.addComponent(lblUf))
										.addComponent(cbUf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(1)
												.addComponent(lblComplemento))
										.addComponent(tfComplemento, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(1)
												.addComponent(lblLimite))
										.addComponent(tfLimite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(2)
												.addComponent(lblSenha))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(1)
												.addComponent(tfSenha, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(2)
												.addComponent(lblNivelDeAcesso))
										.addComponent(cbNivelAcesso, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(2)
												.addComponent(lblCargo))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(1)
												.addComponent(tfCargo, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(2)
												.addComponent(lblSalario))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(1)
												.addComponent(tfSalario, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGap(18)
								.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(1)
												.addComponent(lblPisPasep))
										.addComponent(tfPisPasep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(1)
												.addComponent(lblCtps))
										.addComponent(tfCarteiraTrabalho, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(1)
												.addComponent(lblCtps_1))
										.addComponent(cbEstadoCivil, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(1)
												.addComponent(lblJornada))
										.addComponent(tfJornadaTrabalho, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(2)
												.addComponent(lblAdmissao))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(1)
												.addComponent(tfAdmissao, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(2)
												.addComponent(lblAtivo))
										.addComponent(cbAtivo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(2)
												.addComponent(lblDemisso))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
												.addGap(1)
												.addComponent(tfDemissao, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGap(837)
								.addComponent(lblCnpj_1_3)));
		abaDadosPessoais.setLayout(gl_abaDadosPessoais);

		JPanel abaConsultaCliente = new JPanel();
		abaConsultaCliente.setBackground(new Color(202, 240, 248));
		abaPrincipal.addTab("Consulta Funcionário", null, abaConsultaCliente, null);

		tfNomePesquisa = new JTextField();
		tfNomePesquisa = new TextFieldLimit(100, new TextFieldLimit.ValidadorString());
		tfNomePesquisa.setColumns(10);

		JLabel lbCodigo_1 = new JLabel("Código: ");
		lbCodigo_1.setFont(new Font("Arial", Font.BOLD, 14));

		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarFuncionariosPorNome();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));

		tabelaFuncionarios = new JTable();
		tabelaFuncionarios.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabelaFuncionarios.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tabelaFuncionarios.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
				}));
		tabelaFuncionarios.setFillsViewportHeight(true);
		tabelaFuncionarios.setCellSelectionEnabled(true);
		tabelaFuncionarios.setColumnSelectionAllowed(true);
		tabelaFuncionarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				preencherDadosFuncionario();
			}

		});
		GroupLayout gl_abaConsultaCliente = new GroupLayout(abaConsultaCliente);
		gl_abaConsultaCliente.setHorizontalGroup(
				gl_abaConsultaCliente.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaConsultaCliente.createSequentialGroup()
								.addGap(30)
								.addComponent(lbCodigo_1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(tfNomePesquisa, GroupLayout.PREFERRED_SIZE, 483,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(625, Short.MAX_VALUE))
						.addComponent(tabelaFuncionarios, GroupLayout.DEFAULT_SIZE, 1337, Short.MAX_VALUE));
		gl_abaConsultaCliente.setVerticalGroup(
				gl_abaConsultaCliente.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaConsultaCliente.createSequentialGroup()
								.addGap(22)
								.addGroup(gl_abaConsultaCliente.createParallelGroup(Alignment.BASELINE)
										.addComponent(tfNomePesquisa, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lbCodigo_1)
										.addComponent(btnNewButton))
								.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
								.addComponent(tabelaFuncionarios, GroupLayout.PREFERRED_SIZE, 399,
										GroupLayout.PREFERRED_SIZE)));
		abaConsultaCliente.setLayout(gl_abaConsultaCliente);

		JComboBox<String> cbNivelAcesso = new JComboBox<String>();
		cbNivelAcesso.setFont(new Font("Arial", Font.BOLD, 14));

		JComboBox<String> cbAtivo = new JComboBox<String>();
		cbAtivo.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblNewLabel = new JLabel("Funcionários");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 40));

		JLabel lblNewLabel_1 = new JLabel("Voltar");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Fechar a janela atual
				// SwingUtilities.getWindowAncestor(lblNewLabel_1).dispose();

				// Abrir a janela principal
				/*
				 * FrmMenuPrincipal menu = new FrmMenuPrincipal();
				 * menu.setVisible(true);
				 */
				dispose();
			}
		});

		lblNewLabel_1.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/assets/sair.png")));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblNewLabel)
								.addPreferredGap(ComponentPlacement.RELATED, 821, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addGap(36)));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
								.addContainerGap(13, Short.MAX_VALUE)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 32,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel))));
		panel.setLayout(gl_panel);

		JPanel panelBotoes = new JPanel();
		panelBotoes.setBackground(new Color(202, 240, 248));

		JButton btnNovo = new JButton("Novo");
		btnNovo.setBackground(new Color(106, 76, 147));
		btnNovo.setForeground(new Color(255, 255, 255));
		btnNovo.setFont(new Font("Arial", Font.BOLD, 24));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTela(abaDadosPessoais);
			}
		});

		JButton btnEditar = new JButton("Editar");
		btnEditar.setBackground(new Color(255, 202, 58));
		btnEditar.setForeground(new Color(255, 255, 255));
		btnEditar.setFont(new Font("Arial", Font.BOLD, 24));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarFuncionario();
			}
		});

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(new Color(138, 201, 38));
		btnSalvar.setForeground(new Color(255, 255, 255));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarFuncionario();
			}
		});
		btnSalvar.setFont(new Font("Arial", Font.BOLD, 24));

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(new Color(255, 89, 94));
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.setFont(new Font("Arial", Font.BOLD, 24));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirFuncionario();
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(panelBotoes, GroupLayout.DEFAULT_SIZE, 1342, Short.MAX_VALUE)
								.addContainerGap())
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1352, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(abaPrincipal, GroupLayout.PREFERRED_SIZE, 1342,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(abaPrincipal, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
								.addComponent(panelBotoes, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		panelBotoes.setLayout(new GridLayout(0, 6, 20, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(202, 240, 248));
		panelBotoes.add(panel_2);
		panelBotoes.add(btnNovo);
		panelBotoes.add(btnEditar);
		panelBotoes.add(btnSalvar);
		panelBotoes.add(btnExcluir);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(202, 240, 248));
		panelBotoes.add(panel_1);
		contentPane.setLayout(gl_contentPane);
	}
}