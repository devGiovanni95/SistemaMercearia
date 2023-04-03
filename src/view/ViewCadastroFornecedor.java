package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.ListSelectionModel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class ViewCadastroFornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfEmail;
	private JTextField tfEndereco;
	private JTextField tfNumero;
	private JTextField textField_5;
	private JTextField tfCpfCnpj;
	private JTextField tfBairro;
	private JTextField tfCidade;
	private JTextField tfCelular;
	private JTextField tfCelular_1;
	private JFormattedTextField tfTelefone;
	private JFormattedTextField tfTelefone_1;
	private JFormattedTextField tfCep;
	private JFormattedTextField tfCep_1;
	private JTextField tfLimite;
	private JTextField tfComplemento;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField tfRazaoSocial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastroFornecedor frame = new ViewCadastroFornecedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public ViewCadastroFornecedor() throws ParseException {
		setForeground(new Color(24, 52, 70));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1265, 694);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(18, 94, 137));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel abaConsultaCliente = new JPanel();
		tabbedPane.addTab("Consulta Fornecedores", null, abaConsultaCliente, null);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lbCodigo_1 = new JLabel("Código: ");
		lbCodigo_1.setFont(new Font("Arial", Font.BOLD, 14));
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		GroupLayout gl_abaConsultaCliente = new GroupLayout(abaConsultaCliente);
		gl_abaConsultaCliente.setHorizontalGroup(
			gl_abaConsultaCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaConsultaCliente.createSequentialGroup()
					.addGroup(gl_abaConsultaCliente.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaConsultaCliente.createSequentialGroup()
							.addGap(30)
							.addComponent(lbCodigo_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 483, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_abaConsultaCliente.createSequentialGroup()
							.addContainerGap()
							.addComponent(table, GroupLayout.DEFAULT_SIZE, 1219, Short.MAX_VALUE)))
					.addGap(13))
		);
		gl_abaConsultaCliente.setVerticalGroup(
			gl_abaConsultaCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaConsultaCliente.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_abaConsultaCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbCodigo_1)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE))
		);
		abaConsultaCliente.setLayout(gl_abaConsultaCliente);
		
		JPanel abaDadosPessoais = new JPanel();
		tabbedPane.addTab("Dados Pessoais", null, abaDadosPessoais, null);
		
		JLabel lbCodigo = new JLabel("Código: ");
		lbCodigo.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfCodigo = new JTextField();
		tfCodigo.setColumns(10);
		
		JLabel lblNomeFantasia = new JLabel("Nome Fantasia:");
		lblNomeFantasia.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfEndereco = new JTextField();
		tfEndereco.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Numero: ");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfNumero = new JTextField();
		tfNumero.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JLabel lblCpf = new JLabel("CNPJ :");
		lblCpf.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblCnpj_1_1 = new JLabel("Bairro:");
		lblCnpj_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfBairro = new JTextField();
		tfBairro.setColumns(10);
		
		JLabel lblCnpj_1_2 = new JLabel("Cidade:");
		lblCnpj_1_2.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfCidade = new JTextField();
		tfCidade.setColumns(10);
		
		JLabel lblCnpj_1_3 = new JLabel("CNPJ: ");
		lblCnpj_1_3.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblCnpj_1 = new JLabel("Complemento:");
		lblCnpj_1.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblNewLabel_1_2 = new JLabel("Celular:");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfCelular = new JTextField();
		tfCelular.setColumns(10);
		tfCelular_1  = new JFormattedTextField(new MaskFormatter("(##) # ####-####"));
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Telefone:");
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfTelefone = new JFormattedTextField();
		tfTelefone.setColumns(10);
		tfTelefone_1  = new JFormattedTextField(new MaskFormatter("(##) ####-####"));
		
		JLabel lblNewLabel_1_1 = new JLabel("CEP:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfCep = new JFormattedTextField();
		tfCep.setColumns(10);
		tfCep_1 = new JFormattedTextField(new MaskFormatter("##.###-###"));
		
		JComboBox cbUf = new JComboBox();
		
		JLabel lblNewLabel_1_1_1 = new JLabel("UF:");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblLimite = new JLabel("Limite:");
		lblLimite.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfLimite = new JTextField();
		tfLimite.setColumns(10);
		
		tfComplemento = new JTextField();
		tfComplemento.setColumns(10);
		
		tfCpfCnpj = new JTextField();
		tfCpfCnpj.setColumns(10);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("RG:");
		lblNewLabel_1_2_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblRazaoSocial = new JLabel("Razão Social:");
		lblRazaoSocial.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfRazaoSocial = new JTextField();
		tfRazaoSocial.setColumns(10);
		GroupLayout gl_abaDadosPessoais = new GroupLayout(abaDadosPessoais);
		gl_abaDadosPessoais.setHorizontalGroup(
			gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaDadosPessoais.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(71)
							.addComponent(lblEmail)
							.addGap(4)
							.addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(lblNewLabel_1_2_1)
							.addGap(7)
							.addComponent(tfTelefone_1, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblNewLabel_1_2)
							.addGap(4)
							.addComponent(tfCelular_1, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(45)
							.addComponent(lblEndereo)
							.addGap(4)
							.addComponent(tfEndereco, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblNewLabel_1)
							.addGap(4)
							.addComponent(tfNumero, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(lblNewLabel_1_1)
							.addGap(4)
							.addComponent(tfCep_1, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
							.addGap(1204)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(70)
							.addComponent(lblCnpj_1_1)
							.addGap(6)
							.addComponent(tfBairro, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblCnpj_1_2, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(tfCidade, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
							.addGap(41)
							.addComponent(lblNewLabel_1_1_1)
							.addGap(4)
							.addComponent(cbUf, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(16)
							.addComponent(lblCnpj_1)
							.addGap(6)
							.addComponent(tfComplemento, GroupLayout.PREFERRED_SIZE, 782, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblLimite)
							.addGap(4)
							.addComponent(tfLimite, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblRazaoSocial)
								.addComponent(lblNomeFantasia, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
							.addGap(4)
							.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addComponent(tfNome, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblCpf)
									.addGap(4)
									.addComponent(tfCpfCnpj, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
									.addGap(32)
									.addComponent(lblNewLabel_1_2_1_1)
									.addGap(4)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
								.addComponent(tfRazaoSocial, GroupLayout.PREFERRED_SIZE, 508, GroupLayout.PREFERRED_SIZE)))))
				.addGroup(gl_abaDadosPessoais.createSequentialGroup()
					.addGap(10)
					.addComponent(lblCnpj_1_3))
				.addGroup(gl_abaDadosPessoais.createSequentialGroup()
					.addGap(92)
					.addComponent(lbCodigo)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tfCodigo, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
		);
		gl_abaDadosPessoais.setVerticalGroup(
			gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_abaDadosPessoais.createSequentialGroup()
					.addContainerGap(33, Short.MAX_VALUE)
					.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(146)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(25)
							.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbCodigo)
								.addComponent(tfCodigo, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRazaoSocial, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfRazaoSocial, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(2)
									.addComponent(lblNomeFantasia))
								.addComponent(tfNome, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(2)
									.addComponent(lblCpf))
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(1)
									.addComponent(tfCpfCnpj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(2)
									.addComponent(lblNewLabel_1_2_1_1))
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(1)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(2)
									.addComponent(lblEmail))
								.addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(2)
									.addComponent(lblNewLabel_1_2_1))
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(1)
									.addComponent(tfTelefone_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(2)
									.addComponent(lblNewLabel_1_2))
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(1)
									.addComponent(tfCelular_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(16)
							.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(4)
									.addComponent(lblEndereo))
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(2)
									.addComponent(tfEndereco, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(4)
									.addComponent(lblNewLabel_1))
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(3)
									.addComponent(tfNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(4)
									.addComponent(lblNewLabel_1_1))
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(3)
									.addComponent(tfCep_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(2)
									.addComponent(lblCnpj_1_1))
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(1)
									.addComponent(tfBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(2)
									.addComponent(lblCnpj_1_2))
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(1)
									.addComponent(tfCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(2)
									.addComponent(lblNewLabel_1_1_1))
								.addComponent(cbUf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(1)
									.addComponent(lblCnpj_1))
								.addComponent(tfComplemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(1)
									.addComponent(lblLimite))
								.addComponent(tfLimite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(364)
					.addComponent(lblCnpj_1_3))
		);
		abaDadosPessoais.setLayout(gl_abaDadosPessoais);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Fornecedores");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 30));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addContainerGap(650, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1239, Short.MAX_VALUE)
							.addGap(8))
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 1247, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 1245, Short.MAX_VALUE)
							.addGap(2)))
					.addGap(0))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 498, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
		);
		
		JButton btnNewButton_1 = new JButton("Novo");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_1_1 = new JButton("Editar");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		
		JButton btnNewButton_1_2 = new JButton("Salvar");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_2.setFont(new Font("Arial", Font.BOLD, 18));
		
		JButton btnNewButton_1_3 = new JButton("Excluir");
		btnNewButton_1_3.setFont(new Font("Arial", Font.BOLD, 18));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(154)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1_2, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1_3, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(216, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1_3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
	}
}
