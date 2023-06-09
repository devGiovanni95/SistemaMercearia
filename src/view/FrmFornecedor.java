package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.*;
import java.text.ParseException;
import java.util.List;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controller.FornecedorController;
import model.Fornecedor;
import util.LimparCampos;

import util.TextFieldLimit;

// TODO: Auto-generated Javadoc
/**
 * The Class FrmFornecedor.
 */
public class FrmFornecedor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The content pane. */
	private JPanel contentPane;

	/** The tf codigo. */
	private JTextField tfCodigo;

	/** The tf nome fantasia. */
	private JTextField tfNomeFantasia;

	/** The tf email. */
	private JTextField tfEmail;

	/** The tf endereco. */
	private JTextField tfEndereco;

	/** The tf numero. */
	private JTextField tfNumero;

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

	/** The tf complemento. */
	private JTextField tfComplemento;

	/** The text field. */
	private JTextField tfPesquisar;

	/** The tabela fornecedores. */
	private JTable tabelaFornecedores;

	/** The text field inscricao estadual. */
	private JTextField tfInscricaoEstadual;

	/** The text field razao social. */
	private JTextField tfRazaoSocial;

	/** the combo box uf. */
	private JComboBox<String> cbUf;

	/** The aba dados pessoais. */
	private JPanel abaCadastrarFornecedor;

	/**
	 * Método responsavel por limpar a tela referenciada. *
	 * 
	 * @param tela the tela
	 *             Caso de Uso (USC-003)
	 */
	private void limparTela(JPanel tela) {
		LimparCampos limpar = new LimparCampos();
		limpar.Limpar(tela);
	}

	/**
	 * Método responsável por alterar os dados do fornecedor.
	 * Caso de Uso (USC-003)
	 */
	private void alterarFornecedor() {
		Fornecedor fornecedor = new Fornecedor();

		fornecedor.setNome(tfNomeFantasia.getText());
		fornecedor.setEmail(tfEmail.getText());
		fornecedor.setEndereco(tfEndereco.getText());
		fornecedor.setNumero(Integer.parseInt(tfNumero.getText()));
		fornecedor.setCnpj(tfCnpj.getText());
		fornecedor.setBairro(tfBairro.getText());
		fornecedor.setCidade(tfCidade.getText());
		fornecedor.setCelular(tfCelular.getText());
		fornecedor.setTelefone(tfTelefone.getText());
		fornecedor.setCep(tfCep.getText());
		fornecedor.setComplemento(tfComplemento.getText());
		fornecedor.setRazaoSocial(tfRazaoSocial.getText());
		fornecedor.setUf(cbUf.getSelectedItem().toString());
		fornecedor.setInscricaoEstadual(tfInscricaoEstadual.getText());

		FornecedorController fornecedorController = new FornecedorController();
		try {
			fornecedorController.alterarFornecedor(fornecedor);
			limparTela(abaCadastrarFornecedor);
			JOptionPane.showMessageDialog(null, "Fornecedor alterado com sucesso!");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

	/*
	 * Metodo para cadastrar novos fornecedores.
	 * Caso de Uso (USC-003)
	 */
	private void cadastrarFornecedor() {
		Fornecedor fornecedor = new Fornecedor();

		fornecedor.setNome(tfNomeFantasia.getText());
		fornecedor.setEmail(tfEmail.getText());
		fornecedor.setCnpj(tfCnpj.getText());
		fornecedor.setInscricaoEstadual(tfInscricaoEstadual.getText());
		fornecedor.setEndereco(tfEndereco.getText());
		fornecedor.setTelefone(tfTelefone.getText());
		fornecedor.setCelular(tfCelular.getText());
		fornecedor.setNumero(Integer.parseInt(tfNumero.getText()));
		fornecedor.setCep(tfCep.getText());
		fornecedor.setBairro(tfBairro.getText());
		fornecedor.setCidade(tfCidade.getText());
		fornecedor.setUf(cbUf.getSelectedItem().toString());
		fornecedor.setComplemento(tfComplemento.getText());
		fornecedor.setRazaoSocial(tfRazaoSocial.getText());

		FornecedorController fornecedorController = new FornecedorController();
		try {
			fornecedorController.cadastrarFornecedor(fornecedor);
			limparTela(abaCadastrarFornecedor);
			JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso!");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

	/*
	 * Método responsável por realizar a exclusão de um fornecedor.
	 * Caso de Uso (USC-003)
	 */
	private void excluirFornecedor() {
		Fornecedor fornecedor = new Fornecedor();

		fornecedor.setCnpj(tfCnpj.getText());

		FornecedorController fornecedorController = new FornecedorController();

		try {
			fornecedorController.excluirFornecedor(fornecedor);
			limparTela(abaCadastrarFornecedor);
			JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso!");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

	/*
	 * Método para preencher os campos da tela com os dados do fornecedor
	 * selecionado na tabela.
	 * Caso de Uso (USC-003)
	 */
	private void preencherDadosFornecedor() {
		abaPrincipal.setSelectedIndex(0);

		tfNomeFantasia.setText(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 0).toString());
		tfEmail.setText(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 1).toString());
		tfEndereco.setText(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 2).toString());
		tfNumero.setText(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 3).toString());
		tfCnpj.setText(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 4).toString());
		tfBairro.setText(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 5).toString());
		tfCidade.setText(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 6).toString());
		tfCelular.setText(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 7).toString());
		tfTelefone.setText(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 8).toString());
		tfCep.setText(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 9).toString());
		tfComplemento.setText(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 10).toString());
		tfInscricaoEstadual.setText(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 11).toString());
		tfRazaoSocial.setText(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 12).toString());
		cbUf.setSelectedItem(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 13).toString());
		tfCodigo.setText(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 4).toString());
	}

	/**
	 * Método utilizado para consultar fornecedores pelo nome ou parte do nome para
	 * exibir na tabela. O texto pesquisado é obtido a partir do texto digitado pelo
	 * usuario.
	 * Caso de Uso (USC-003)
	 */
	public void consultarFornecedoresPorNome() {
		try {
			String nomePesquisado = tfPesquisar.getText();
			FornecedorController fornecedorController = new FornecedorController();
			List<Fornecedor> lista = fornecedorController.consultarFornecedoresPorNome(nomePesquisado);
			DefaultTableModel dadosTabela = (DefaultTableModel) tabelaFornecedores.getModel();
			dadosTabela.setNumRows(0);
			dadosTabela.setColumnCount(14);
			dadosTabela.addRow(new Object[] { "Nome", "E-mail", "Endereço", "Numero", "CNPJ", "Bairro", "Cidade",
					"Celular", "Telefone", "CEP", "Complemento", "Inscrição Estadual", "Razão Social", "UF" });

			for (Fornecedor fornecedor : lista) {
				dadosTabela.addRow(new Object[] { fornecedor.getNome(), fornecedor.getEmail(), fornecedor.getEndereco(),
						fornecedor.getNumero(), fornecedor.getCnpj(), fornecedor.getBairro(), fornecedor.getCidade(),
						fornecedor.getCelular(), fornecedor.getTelefone(), fornecedor.getCep(),
						fornecedor.getComplemento(), fornecedor.getInscricaoEstadual(), fornecedor.getRazaoSocial(),
						fornecedor.getUf() });
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Ops, aconteceu o erro: " + erro);
		}
	}

	/**
	 * Método utilizado para consultar fornecedores para
	 * exibir na tabela.
	 * Caso de Uso (USC-003)
	 */
	private void consultarFornecedores() {
		try {
			FornecedorController fornecedorController = new FornecedorController();
			List<Fornecedor> lista = fornecedorController.consultarFornecedores();
			DefaultTableModel dadosTabela = (DefaultTableModel) tabelaFornecedores.getModel();
			dadosTabela.setNumRows(0);
			dadosTabela.setColumnCount(14);
			dadosTabela.addRow(new Object[] { "Nome", "E-mail", "Endereço", "Numero", "CNPJ", "Bairro", "Cidade",
					"Celular", "Telefone", "CEP", "Complemento", "Inscrição Estadual", "Razão Social", "UF" });

			for (Fornecedor fornecedor : lista) {
				dadosTabela.addRow(new Object[] { fornecedor.getNome(), fornecedor.getEmail(), fornecedor.getEndereco(),
						fornecedor.getNumero(), fornecedor.getCnpj(), fornecedor.getBairro(), fornecedor.getCidade(),
						fornecedor.getCelular(), fornecedor.getTelefone(), fornecedor.getCep(),
						fornecedor.getComplemento(), fornecedor.getInscricaoEstadual(), fornecedor.getRazaoSocial(),
						fornecedor.getUf() });
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Ops, aconteceu o erro: " + erro);
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
					FrmFornecedor frame = new FrmFornecedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/** The aba principal. */
	public JTabbedPane abaPrincipal;

	/** The tf cnpj. */
	private JTextField tfCnpj;

	/**
	 * Create the frame.
	 *
	 * @throws ParseException the parse exception
	 */
	public FrmFornecedor() throws ParseException {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				consultarFornecedores();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmCategoria.class.getResource("/assets/produto.png")));
		setBackground(new Color(202, 240, 248));
		setForeground(new Color(24, 52, 70));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1360, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(202, 240, 248));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);

		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(22, 138, 173));

		abaPrincipal = new JTabbedPane(JTabbedPane.TOP);
		abaPrincipal.setBackground(new Color(202, 240, 248));

		abaCadastrarFornecedor = new JPanel();
		abaCadastrarFornecedor.setBackground(new Color(202, 240, 248));
		abaPrincipal.addTab("Cadastrar Fornecedor", null, abaCadastrarFornecedor, null);

		JLabel lbCodigo = new JLabel("Código do fornecedor: ");
		lbCodigo.setFont(new Font("Arial", Font.BOLD, 14));

		tfCodigo = new JTextField();
		tfCodigo.setEditable(false);
		tfCodigo.setColumns(10);

		JLabel lblNomeFantasia = new JLabel("Nome Fantasia:");
		lblNomeFantasia.setFont(new Font("Arial", Font.BOLD, 14));

		tfNomeFantasia = new JTextField();
		tfNomeFantasia = new TextFieldLimit(100, new TextFieldLimit.ValidadorString());
		tfNomeFantasia.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 14));

		tfEmail = new JTextField();
		tfEmail = new TextFieldLimit(50, new TextFieldLimit.ValidadorString());
		tfEmail.setColumns(10);

		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setFont(new Font("Arial", Font.BOLD, 14));

		tfEndereco = new JTextField();
		tfEndereco = new TextFieldLimit(100, new TextFieldLimit.ValidadorString());
		tfEndereco.setColumns(10);

		JLabel lblNumero = new JLabel("Numero: ");
		lblNumero.setFont(new Font("Arial", Font.BOLD, 14));

		tfNumero = new JTextField();
		tfNumero = new TextFieldLimit(9, new TextFieldLimit.ValidadorInteiro());
		tfNumero.setColumns(10);

		JLabel lblCnpj_1_1 = new JLabel("Bairro:");
		lblCnpj_1_1.setFont(new Font("Arial", Font.BOLD, 14));

		tfBairro = new JTextField();
		tfBairro = new TextFieldLimit(50, new TextFieldLimit.ValidadorString());
		tfBairro.setColumns(10);

		JLabel lblCnpj_1_2 = new JLabel("Cidade:");
		lblCnpj_1_2.setFont(new Font("Arial", Font.BOLD, 14));

		tfCidade = new JTextField();
		tfCidade = new TextFieldLimit(50, new TextFieldLimit.ValidadorString());
		tfCidade.setColumns(10);

		JLabel lblCnpj = new JLabel("Complemento:");
		lblCnpj.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblCelular = new JLabel("Celular:");
		tfCelular = new JFormattedTextField(new MaskFormatter("(##)# ####-####"));
		lblCelular.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lbTelefone = new JLabel("Telefone:");
		tfTelefone = new JFormattedTextField(new MaskFormatter("(##) ####-####"));
		lbTelefone.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblCep = new JLabel("CEP:");
		tfCep = new JFormattedTextField(new MaskFormatter("##.###-###"));
		lblCep.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblIncricaoEstadual = new JLabel("Inscrição Estadual:");
		lblIncricaoEstadual.setFont(new Font("Arial", Font.BOLD, 14));

		tfInscricaoEstadual = new JFormattedTextField(new MaskFormatter("###.###.###.###"));
		tfInscricaoEstadual.setColumns(10);

		JLabel lblCpf = new JLabel("CNPJ:");
		lblCpf.setFont(new Font("Arial", Font.BOLD, 14));

		tfCnpj = new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
		tfCnpj.setColumns(10);

		cbUf = new JComboBox<String>();
		cbUf.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
						"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cbUf.setBackground(Color.WHITE);
		cbUf.setForeground(Color.BLACK);
		cbUf.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblUf = new JLabel("UF:");
		lblUf.setFont(new Font("Arial", Font.BOLD, 14));

		tfComplemento = new JTextField();
		tfComplemento = new TextFieldLimit(50, new TextFieldLimit.ValidadorString());
		tfComplemento.setColumns(10);

		JLabel lblRazaoSocial = new JLabel("Razão Social:");
		lblRazaoSocial.setFont(new Font("Arial", Font.BOLD, 14));

		tfRazaoSocial = new JTextField();
		tfRazaoSocial = new TextFieldLimit(100, new TextFieldLimit.ValidadorString());
		tfRazaoSocial.setColumns(10);

		GroupLayout gl_abaCadastrarFornecedor = new GroupLayout(abaCadastrarFornecedor);
		gl_abaCadastrarFornecedor.setHorizontalGroup(gl_abaCadastrarFornecedor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaCadastrarFornecedor.createSequentialGroup().addGap(70)
						.addGroup(gl_abaCadastrarFornecedor.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_abaCadastrarFornecedor.createSequentialGroup().addGap(39)
										.addComponent(lblEndereo).addGap(2).addComponent(tfEndereco,
												GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_abaCadastrarFornecedor.createSequentialGroup().addGap(66)
										.addComponent(lblCnpj_1_1).addGap(2)
										.addComponent(tfBairro, GroupLayout.PREFERRED_SIZE, 509,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(lblCnpj_1_2, GroupLayout.PREFERRED_SIZE, 64,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_abaCadastrarFornecedor.createSequentialGroup().addGap(12)
										.addComponent(lblCnpj).addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(tfComplemento, GroupLayout.PREFERRED_SIZE, 782,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_abaCadastrarFornecedor.createSequentialGroup().addGap(51)
										.addComponent(lbCodigo).addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(tfCodigo, GroupLayout.PREFERRED_SIZE, 190,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_abaCadastrarFornecedor.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_abaCadastrarFornecedor.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblEmail)
												.addGroup(gl_abaCadastrarFornecedor.createSequentialGroup()
														.addGroup(gl_abaCadastrarFornecedor
																.createParallelGroup(Alignment.TRAILING)
																.addComponent(lblNomeFantasia)
																.addComponent(lblRazaoSocial))
														.addGap(4)))
										.addGroup(gl_abaCadastrarFornecedor.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_abaCadastrarFornecedor.createSequentialGroup()
														.addGroup(gl_abaCadastrarFornecedor
																.createParallelGroup(Alignment.LEADING, false)
																.addGroup(gl_abaCadastrarFornecedor
																		.createSequentialGroup()
																		.addComponent(tfNomeFantasia,
																				GroupLayout.PREFERRED_SIZE, 509,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(lblIncricaoEstadual))
																.addGroup(gl_abaCadastrarFornecedor
																		.createSequentialGroup()
																		.addComponent(tfRazaoSocial,
																				GroupLayout.PREFERRED_SIZE, 508,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(lblCpf)))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_abaCadastrarFornecedor
																.createParallelGroup(Alignment.LEADING)
																.addComponent(tfCnpj, GroupLayout.PREFERRED_SIZE, 377,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(tfInscricaoEstadual,
																		GroupLayout.PREFERRED_SIZE, 377,
																		GroupLayout.PREFERRED_SIZE)))
												.addGroup(gl_abaCadastrarFornecedor.createSequentialGroup()
														.addGroup(gl_abaCadastrarFornecedor
																.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_abaCadastrarFornecedor
																		.createSequentialGroup()
																		.addComponent(tfEmail,
																				GroupLayout.PREFERRED_SIZE, 509,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(lbTelefone))
																.addGroup(gl_abaCadastrarFornecedor
																		.createSequentialGroup().addGap(521)
																		.addComponent(lblNumero)))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_abaCadastrarFornecedor
																.createParallelGroup(Alignment.LEADING, false)
																.addGroup(gl_abaCadastrarFornecedor
																		.createSequentialGroup()
																		.addComponent(tfNumero,
																				GroupLayout.PREFERRED_SIZE, 198,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(lblCep)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(tfCep, GroupLayout.PREFERRED_SIZE,
																				174, GroupLayout.PREFERRED_SIZE)
																		.addGap(4))
																.addGroup(gl_abaCadastrarFornecedor
																		.createSequentialGroup()
																		.addComponent(tfTelefone,
																				GroupLayout.PREFERRED_SIZE, 198,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(10).addComponent(lblCelular).addGap(4)
																		.addComponent(tfCelular,
																				GroupLayout.PREFERRED_SIZE, 174,
																				GroupLayout.PREFERRED_SIZE))
																.addGroup(gl_abaCadastrarFornecedor
																		.createSequentialGroup()
																		.addComponent(tfCidade,
																				GroupLayout.PREFERRED_SIZE, 198,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(lblUf)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(cbUf, GroupLayout.PREFERRED_SIZE,
																				174, GroupLayout.PREFERRED_SIZE)
																		.addGap(4)))))))
						.addGap(122)));
		gl_abaCadastrarFornecedor.setVerticalGroup(gl_abaCadastrarFornecedor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaCadastrarFornecedor.createSequentialGroup().addGap(108)
						.addGroup(gl_abaCadastrarFornecedor.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbCodigo)
								.addComponent(tfCodigo, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_abaCadastrarFornecedor.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRazaoSocial, GroupLayout.PREFERRED_SIZE, 24,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(tfRazaoSocial, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfCnpj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_abaCadastrarFornecedor.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfNomeFantasia, GroupLayout.PREFERRED_SIZE, 22,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIncricaoEstadual)
								.addComponent(tfInscricaoEstadual, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNomeFantasia))
						.addGap(20)
						.addGroup(
								gl_abaCadastrarFornecedor.createParallelGroup(Alignment.LEADING).addComponent(lblEmail)
										.addGroup(gl_abaCadastrarFornecedor.createSequentialGroup().addGap(1)
												.addComponent(lbTelefone))
										.addComponent(tfTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_abaCadastrarFornecedor.createSequentialGroup().addGap(1)
												.addComponent(lblCelular))
										.addComponent(tfCelular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE))
						.addGap(17)
						.addGroup(gl_abaCadastrarFornecedor.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_abaCadastrarFornecedor.createSequentialGroup().addGap(2)
										.addGroup(gl_abaCadastrarFornecedor.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblEndereo).addComponent(tfEndereco,
														GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_abaCadastrarFornecedor.createSequentialGroup().addGap(4)
										.addGroup(gl_abaCadastrarFornecedor.createParallelGroup(Alignment.BASELINE)
												.addComponent(tfNumero, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNumero)))
								.addGroup(gl_abaCadastrarFornecedor.createSequentialGroup().addGap(3)
										.addGroup(gl_abaCadastrarFornecedor.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblCep).addComponent(tfCep, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGap(18)
						.addGroup(gl_abaCadastrarFornecedor.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_abaCadastrarFornecedor.createSequentialGroup().addGap(1)
										.addGroup(gl_abaCadastrarFornecedor.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblCnpj_1_1).addComponent(tfBairro,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_abaCadastrarFornecedor.createSequentialGroup().addGap(2)
										.addGroup(gl_abaCadastrarFornecedor.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblCnpj_1_2)
												.addComponent(tfCidade, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_abaCadastrarFornecedor.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblUf).addComponent(cbUf, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGap(18)
						.addGroup(gl_abaCadastrarFornecedor.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCnpj).addComponent(tfComplemento, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(165, Short.MAX_VALUE)));
		abaCadastrarFornecedor.setLayout(gl_abaCadastrarFornecedor);

		JPanel abaConsultarFornecedores = new JPanel();
		abaConsultarFornecedores.setBackground(new Color(202, 240, 248));
		abaPrincipal.addTab("Consultar Fornecedores", null, abaConsultarFornecedores, null);

		tfPesquisar = new JTextField();
		tfPesquisar.setColumns(10);

		JLabel lblCodigoPesquisa = new JLabel("Nome Fantasia: ");
		lblCodigoPesquisa.setFont(new Font("Arial", Font.BOLD, 14));

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarFornecedoresPorNome();
			}
		});
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 14));

		tabelaFornecedores = new JTable();

		tabelaFornecedores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				preencherDadosFornecedor();
			}

		});
		tabelaFornecedores.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		tabelaFornecedores.setFont(new java.awt.Font("Arial", 0, 14));
		tabelaFornecedores.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));

		tabelaFornecedores.setFillsViewportHeight(true);
		tabelaFornecedores.setCellSelectionEnabled(true);
		tabelaFornecedores.setColumnSelectionAllowed(true);
		GroupLayout gl_abaConsultarFornecedores = new GroupLayout(abaConsultarFornecedores);
		gl_abaConsultarFornecedores.setHorizontalGroup(gl_abaConsultarFornecedores
				.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaConsultarFornecedores.createSequentialGroup().addGap(30).addComponent(lblCodigoPesquisa)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(tfPesquisar, GroupLayout.PREFERRED_SIZE, 483, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnPesquisar, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
						.addGap(13))
				.addComponent(tabelaFornecedores, GroupLayout.DEFAULT_SIZE, 1329, Short.MAX_VALUE));
		gl_abaConsultarFornecedores.setVerticalGroup(gl_abaConsultarFornecedores.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaConsultarFornecedores.createSequentialGroup().addGap(22)
						.addGroup(gl_abaConsultarFornecedores.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfPesquisar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCodigoPesquisa).addComponent(btnPesquisar))
						.addPreferredGap(ComponentPlacement.RELATED, 92, Short.MAX_VALUE).addComponent(
								tabelaFornecedores, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE)));
		abaConsultarFornecedores.setLayout(gl_abaConsultarFornecedores);

		tfCelular.setColumns(10);
		tfTelefone.setColumns(10);
		tfCep.setColumns(10);

		JLabel lblFornecedores = new JLabel("Fornecedores");
		lblFornecedores.setForeground(Color.WHITE);
		lblFornecedores.setFont(new Font("Arial Black", Font.BOLD, 40));

		JLabel lblVoltar = new JLabel("Voltar");
		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Fechar a janela atual
				// SwingUtilities.getWindowAncestor(lblVoltar).dispose();

				// Abrir a janela principal
				/*
				 * FrmMenuPrincipal menu = new FrmMenuPrincipal();
				 * menu.setVisible(true);
				 */
				dispose();
			}
		});
		lblVoltar.setIcon(new ImageIcon(FrmFornecedor.class.getResource("/assets/sair.png")));
		lblVoltar.setForeground(Color.WHITE);
		lblVoltar.setFont(new Font("Arial", Font.BOLD, 18));
		GroupLayout gl_panelSuperior = new GroupLayout(panelSuperior);
		gl_panelSuperior.setHorizontalGroup(gl_panelSuperior.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSuperior.createSequentialGroup().addComponent(lblFornecedores).addGap(888)
						.addComponent(lblVoltar, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addGap(40)));
		gl_panelSuperior.setVerticalGroup(gl_panelSuperior.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_panelSuperior.createSequentialGroup().addContainerGap(22, Short.MAX_VALUE)
						.addGroup(gl_panelSuperior.createParallelGroup(Alignment.LEADING)
								.addComponent(lblVoltar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFornecedores))));
		panelSuperior.setLayout(gl_panelSuperior);

		JPanel panelInferior = new JPanel();
		panelInferior.setBackground(new Color(202, 240, 248));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panelSuperior, GroupLayout.DEFAULT_SIZE, 1334, Short.MAX_VALUE)
				.addComponent(abaPrincipal, GroupLayout.DEFAULT_SIZE, 1334, Short.MAX_VALUE)
				.addComponent(panelInferior, GroupLayout.DEFAULT_SIZE, 1334, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panelSuperior, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(abaPrincipal, GroupLayout.PREFERRED_SIZE, 518, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelInferior, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)));

		JButton btnNovo = new JButton("Novo");
		btnNovo.setBackground(new Color(106, 76, 147));
		btnNovo.setForeground(Color.WHITE);
		btnNovo.setFont(new Font("Arial", Font.BOLD, 24));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abaPrincipal.setSelectedIndex(0);
				limparTela(abaCadastrarFornecedor);
			}
		});

		JButton btnAlterar = new JButton("Editar");
		btnAlterar.setBackground(new Color(255, 202, 58));
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarFornecedor();
			}
		});
		btnAlterar.setFont(new Font("Arial", Font.BOLD, 24));

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(new Color(138, 201, 38));
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarFornecedor();
			}
		});
		btnSalvar.setFont(new Font("Arial", Font.BOLD, 24));

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirFornecedor();
			}
		});
		btnExcluir.setBackground(new Color(255, 89, 94));
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setFont(new Font("Arial", Font.BOLD, 24));
		panelInferior.setLayout(new GridLayout(0, 6, 20, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(202, 240, 248));
		panelInferior.add(panel_3);
		panelInferior.add(btnNovo);
		panelInferior.add(btnAlterar);
		panelInferior.add(btnSalvar);
		panelInferior.add(btnExcluir);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(202, 240, 248));
		panelInferior.add(panel_2);
		contentPane.setLayout(gl_contentPane);
	}
}
