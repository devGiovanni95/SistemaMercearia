package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controller.FornecedorController;
import model.Fornecedor;
import util.LimparCampos;

// TODO: Auto-generated Javadoc
/**
 * The Class FrmFornecedor.
 */
public class FrmFornecedor extends JFrame {

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
	private JTextField tfCelular;
	
	/** The tf celular 1. */
	private JTextField tfCelular_1;
	
	/** The tf telefone. */
	private JFormattedTextField tfTelefone;
	
	/** The tf cep. */
	private JFormattedTextField tfCep;
	
	/** The tf complemento. */
	private JTextField tfComplemento;
	
	/** The text field. */
	private JTextField textField;
	
	/** The tabela fornecedores. */
	private JTable tabelaFornecedores;
	
	/** The tf inscricao estadual. */
	private JTextField tfInscricaoEstadual;
	
	/** The tf razao social. */
	private JTextField tfRazaoSocial;
	
	/**
	 * Metodo utilizado para listar todos os fornecedores e adiciona-los numa tabela.
	 */
	public void listarFornecedores() {
		try {
			FornecedorController fornecedorController = new FornecedorController();
			List<Fornecedor> lista = fornecedorController.consultarFornecedores();
			DefaultTableModel dadosTabela = (DefaultTableModel) tabelaFornecedores.getModel();
			dadosTabela.setNumRows(0);
			dadosTabela.setColumnCount(14);
			dadosTabela.addRow(new Object[]{"Nome", "E-mail", "Endereço", "Numero", "CNPJ", "Bairro", "Cidade", "Celular", "Telefone", "CEP", "Complemento", "Inscrição Estadual", "Razão Social", "UF"});

			for (Fornecedor fornecedor : lista) {
				dadosTabela.addRow(new Object[]{
						fornecedor.getNome(),
						fornecedor.getEmail(),
						fornecedor.getEndereco(),
						fornecedor.getNumero(),
						fornecedor.getCnpj(),
						fornecedor.getBairro(),
						fornecedor.getCidade(),
						fornecedor.getCelular(),
						fornecedor.getTelefone(),
						fornecedor.getCep(),
						fornecedor.getComplemento(),
						fornecedor.getInscricaoEstadual(),
						fornecedor.getRazaoSocial(),
						fornecedor.getUf()
				});
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
		setBackground(new Color(202, 240, 248));
		setForeground(new Color(24, 52, 70));
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
		
		JPanel abaDadosPessoais = new JPanel();
		abaDadosPessoais.setBackground(new Color(202, 240, 248));
		abaPrincipal.addTab("Dados Pessoais", null, abaDadosPessoais, null);
		
		JLabel lbCodigo = new JLabel("Código: ");
		lbCodigo.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfCodigo = new JTextField();
		tfCodigo.setEditable(false);
		tfCodigo.setColumns(10);
		
		JLabel lblNomeFantasia = new JLabel("Nome Fantasia:");
		lblNomeFantasia.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfNomeFantasia = new JTextField();
		tfNomeFantasia.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfEndereco = new JTextField();
		tfEndereco.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero: ");
		lblNumero.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfNumero = new JTextField();
		tfNumero.setColumns(10);
		
		JLabel lblCnpj_1_1 = new JLabel("Bairro:");
		lblCnpj_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfBairro = new JTextField();
		tfBairro.setColumns(10);
		
		JLabel lblCnpj_1_2 = new JLabel("Cidade:");
		lblCnpj_1_2.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfCidade = new JTextField();
		tfCidade.setColumns(10);
		
		JLabel lblCnpj = new JLabel("Complemento:");
		lblCnpj.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Arial", Font.BOLD, 14));
		tfCelular_1  = new JFormattedTextField(new MaskFormatter("(##) # ####-####"));
		
		JLabel lbTelefone = new JLabel("Telefone:");
		lbTelefone.setFont(new Font("Arial", Font.BOLD, 14));
		tfTelefone  = new JFormattedTextField(new MaskFormatter("(##) ####-####"));
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Arial", Font.BOLD, 14));
		tfCep = new JFormattedTextField(new MaskFormatter("##.###-###"));
		
		JComboBox cbUf = new JComboBox();
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfComplemento = new JTextField();
		tfComplemento.setColumns(10);
		
		JLabel lblIncricaoEstadual = new JLabel("Inscrição Estadual:");
		lblIncricaoEstadual.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfInscricaoEstadual = new JTextField();
		tfInscricaoEstadual.setColumns(10);
		
		JLabel lblRazaoSocial = new JLabel("Razão Social:");
		lblRazaoSocial.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfRazaoSocial = new JTextField();
		tfRazaoSocial.setColumns(10);
		
		JLabel lblCpf = new JLabel("CNPJ:");
		lblCpf.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfCnpj = new JTextField();
		tfCnpj.setColumns(10);
		GroupLayout gl_abaDadosPessoais = new GroupLayout(abaDadosPessoais);
		gl_abaDadosPessoais.setHorizontalGroup(
			gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaDadosPessoais.createSequentialGroup()
					.addGap(70)
					.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(39)
							.addComponent(lblEndereo)
							.addGap(2)
							.addComponent(tfEndereco, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(66)
							.addComponent(lblCnpj_1_1)
							.addGap(2)
							.addComponent(tfBairro, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblCnpj_1_2, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(12)
							.addComponent(lblCnpj)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfComplemento, GroupLayout.PREFERRED_SIZE, 782, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(51)
							.addComponent(lbCodigo)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tfCodigo, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblEmail)
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNomeFantasia)
										.addComponent(lblRazaoSocial))
									.addGap(4)))
							.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
											.addComponent(tfNomeFantasia, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblIncricaoEstadual))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
											.addComponent(tfRazaoSocial, GroupLayout.PREFERRED_SIZE, 508, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblCpf)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
										.addComponent(tfCnpj, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
										.addComponent(tfInscricaoEstadual, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
											.addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lbTelefone))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
											.addGap(521)
											.addComponent(lblNumero)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
											.addComponent(tfNumero, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblCep)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(tfCep, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
											.addGap(4))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
											.addComponent(tfTelefone, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
											.addGap(10)
											.addComponent(lblCelular)
											.addGap(4)
											.addComponent(tfCelular_1, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
											.addComponent(tfCidade, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblUf)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(cbUf, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
											.addGap(4)))))))
					.addGap(122))
		);
		gl_abaDadosPessoais.setVerticalGroup(
			gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaDadosPessoais.createSequentialGroup()
					.addGap(108)
					.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbCodigo)
						.addComponent(tfCodigo, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRazaoSocial, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfRazaoSocial, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCnpj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfNomeFantasia, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIncricaoEstadual)
						.addComponent(tfInscricaoEstadual, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNomeFantasia))
					.addGap(20)
					.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEmail)
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(1)
							.addComponent(lbTelefone))
						.addComponent(tfTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(1)
							.addComponent(lblCelular))
						.addComponent(tfCelular_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(2)
							.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEndereo)
								.addComponent(tfEndereco, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNumero)))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCep)
								.addComponent(tfCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCnpj_1_1)
								.addComponent(tfBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(2)
							.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCnpj_1_2)
								.addComponent(tfCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblUf)
							.addComponent(cbUf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCnpj)
						.addComponent(tfComplemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(165, Short.MAX_VALUE))
		);
		abaDadosPessoais.setLayout(gl_abaDadosPessoais);
		
		JPanel abaConsultaCliente = new JPanel();
		abaConsultaCliente.setBackground(new Color(202, 240, 248));
		abaPrincipal.addTab("Consulta Fornecedores", null, abaConsultaCliente, null);

		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lbCodigo_1 = new JLabel("Código: ");
		lbCodigo_1.setFont(new Font("Arial", Font.BOLD, 14));
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		tabelaFornecedores = new JTable();
		tabelaFornecedores.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tabelaFornecedores.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		tabelaFornecedores.setFillsViewportHeight(true);
		tabelaFornecedores.setCellSelectionEnabled(true);
		tabelaFornecedores.setColumnSelectionAllowed(true);
		GroupLayout gl_abaConsultaCliente = new GroupLayout(abaConsultaCliente);
		gl_abaConsultaCliente.setHorizontalGroup(
			gl_abaConsultaCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaConsultaCliente.createSequentialGroup()
					.addGap(30)
					.addComponent(lbCodigo_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 483, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addGap(13))
				.addComponent(tabelaFornecedores, GroupLayout.DEFAULT_SIZE, 1329, Short.MAX_VALUE)
		);
		gl_abaConsultaCliente.setVerticalGroup(
			gl_abaConsultaCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaConsultaCliente.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_abaConsultaCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbCodigo_1)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
					.addComponent(tabelaFornecedores, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE))
		);
		abaConsultaCliente.setLayout(gl_abaConsultaCliente);
		
		tfCelular = new JTextField();
		tfCelular.setColumns(10);
		
		tfTelefone = new JFormattedTextField();
		tfTelefone.setColumns(10);
		
		tfCep = new JFormattedTextField();
		tfCep.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Fornecedores");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 40));
		
		JLabel lblNewLabel_1_3 = new JLabel("Voltar");
		lblNewLabel_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmMenuPrincipal menu = new FrmMenuPrincipal();
				menu.setVisible(true);
			}
		});
		lblNewLabel_1_3.setIcon(new ImageIcon(FrmFornecedor.class.getResource("/assets/sair.png")));
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGap(888)
					.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(40))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(22, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(202, 240, 248));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1334, Short.MAX_VALUE)
				.addComponent(abaPrincipal, GroupLayout.DEFAULT_SIZE, 1334, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 1334, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(abaPrincipal, GroupLayout.PREFERRED_SIZE, 518, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
		);
		
		JButton btnNewButton_1 = new JButton("Novo");
		btnNewButton_1.setBackground(new Color(106, 76, 147));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 24));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LimparCampos().Limpar(abaDadosPessoais);
			}
		});
		
		JButton btnNewButton_1_1 = new JButton("Editar");
		btnNewButton_1_1.setBackground(new Color(255, 202, 58));
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//editar
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

				fornecedorController.alterarFornecedor(fornecedor);

				new LimparCampos().Limpar(abaDadosPessoais);
			}
		});
		btnNewButton_1_1.setFont(new Font("Arial", Font.BOLD, 24));
		
		JButton btnNewButton_1_2 = new JButton("Salvar");
		btnNewButton_1_2.setBackground(new Color(138, 201, 38));
		btnNewButton_1_2.setForeground(Color.WHITE);
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				fornecedorController.cadastrarFornecedor(fornecedor);

				new LimparCampos().Limpar(abaDadosPessoais);
			}
		});
		btnNewButton_1_2.setFont(new Font("Arial", Font.BOLD, 24));
		
		JButton btnNewButton_1_3 = new JButton("Excluir");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fornecedor fornecedor= new Fornecedor();

				fornecedor.setCnpj(tfCnpj.getText());

				FornecedorController fornecedorController = new FornecedorController();	

				fornecedorController.excluirFornecedor(fornecedor);

				new LimparCampos().Limpar(abaDadosPessoais);
			}
		});
		btnNewButton_1_3.setBackground(new Color(255, 89, 94));
		btnNewButton_1_3.setForeground(Color.WHITE);
		btnNewButton_1_3.setFont(new Font("Arial", Font.BOLD, 24));
		panel_1.setLayout(new GridLayout(0, 6, 20, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(202, 240, 248));
		panel_1.add(panel_3);
		panel_1.add(btnNewButton_1);
		panel_1.add(btnNewButton_1_1);
		panel_1.add(btnNewButton_1_2);
		panel_1.add(btnNewButton_1_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(202, 240, 248));
		panel_1.add(panel_2);
		contentPane.setLayout(gl_contentPane);
	}
}
